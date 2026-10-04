package com.inventrack.inventrack.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import com.inventrack.inventrack.dto.VentaRequest;
import com.inventrack.inventrack.entity.DetalleVenta;
import com.inventrack.inventrack.entity.Inventario;
import com.inventrack.inventrack.entity.MovimientoInventario;
import com.inventrack.inventrack.entity.Producto;
import com.inventrack.inventrack.entity.Venta;
import com.inventrack.inventrack.repository.ClienteRepository;
import com.inventrack.inventrack.repository.DetalleVentaRepository;
import com.inventrack.inventrack.repository.InventarioRepository;
import com.inventrack.inventrack.repository.MetodoPagoRepository;
import com.inventrack.inventrack.repository.MovimientoInventarioRepository;
import com.inventrack.inventrack.repository.ProductoRepository;
import com.inventrack.inventrack.repository.SucursalRepository;
import com.inventrack.inventrack.repository.UsuarioRepository;
import com.inventrack.inventrack.repository.VentaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepo;
    private final DetalleVentaRepository detalleRepo;
    private final ClienteRepository clienteRepo;
    private final MetodoPagoRepository metodoRepo;
    private final SucursalRepository sucursalRepo;
    private final UsuarioRepository usuarioRepo;
    private final ProductoRepository productoRepo;
    private final InventarioRepository inventarioRepo;
    private final MovimientoInventarioRepository movimientoRepo;

    @Transactional
    public Venta registrar(VentaRequest r) {
        Venta v = new Venta();
        v.setCliente(clienteRepo.findById(r.idCliente()).orElseThrow(() -> bad("Cliente no existe")));
        v.setSucursal(sucursalRepo.findById(r.idSucursal()).orElseThrow(() -> bad("Sucursal no existe")));
        v.setUsuario(usuarioRepo.findById(r.idUsuario()).orElseThrow(() -> bad("Usuario no existe")));
        v.setMetodoPago(metodoRepo.findById(r.idMetodoPago()).orElseThrow(() -> bad("Método de pago no existe")));
        v.setFechaVenta(LocalDateTime.now());
        v.setEstado("Registrada");
        v.setObservacion(r.observacion());
        v.setTotal(BigDecimal.ZERO);
        ventaRepo.save(v);

        BigDecimal total = BigDecimal.ZERO;
        for (VentaRequest.Item it : r.detalle()) {
            Producto p = productoRepo.findById(it.idProducto()).orElseThrow(() -> bad("Producto no existe"));
            Inventario inv = inventarioRepo
                .findBySucursal_IdAndProducto_Id(r.idSucursal(), p.getId())
                .orElseThrow(() -> bad("Stock insuficiente para el producto " + p.getId() + ". Disponible: 0"));
            if (inv.getCantidadDisponible() < it.cantidad()) {
                throw bad("Stock insuficiente para el producto " + p.getId()
                          + ". Disponible: " + inv.getCantidadDisponible());
            }

            BigDecimal precio = it.precioUnitario() != null ? it.precioUnitario() : p.getPrecioVenta();
            BigDecimal desc = it.descuento() != null ? it.descuento() : BigDecimal.ZERO;
            BigDecimal sub = precio.multiply(BigDecimal.valueOf(it.cantidad())).subtract(desc);

            DetalleVenta d = new DetalleVenta();
            d.setVenta(v);
            d.setProducto(p);
            d.setCantidad(it.cantidad());
            d.setPrecioUnitario(precio);
            d.setDescuento(desc);
            d.setSubtotal(sub);
            detalleRepo.save(d);

            inv.setCantidadDisponible(inv.getCantidadDisponible() - it.cantidad());
            inv.setActualizacion(LocalDateTime.now());
            inventarioRepo.save(inv);

            MovimientoInventario m = new MovimientoInventario();
            m.setProducto(p);
            m.setUsuario(v.getUsuario());
            m.setSucursal(v.getSucursal());
            m.setDetalleVenta(d);
            m.setTipoMovimiento("Salida");
            m.setCantidad(it.cantidad());
            m.setMotivo("Venta");
            m.setFecha(LocalDateTime.now());
            movimientoRepo.save(m);

            total = total.add(sub);
        }
        v.setTotal(total);
        return ventaRepo.save(v);
    }

    public Map<String, Object> buscarConDetalle(Integer idVenta) {
        return Map.of("venta", buscar(idVenta), "detalle", detalleRepo.findByVenta_Id(idVenta));
    }

    public List<Venta> listar(Integer idSucursal, LocalDate desde, LocalDate hasta) {
        return ventaRepo.findAll().stream()
            .filter(v -> idSucursal == null || v.getSucursal().getId().equals(idSucursal))
            .filter(v -> desde == null || !v.getFechaVenta().toLocalDate().isBefore(desde))
            .filter(v -> hasta == null || !v.getFechaVenta().toLocalDate().isAfter(hasta))
            .toList();
    }

    @Transactional
    public void anular(Integer idVenta) {
        Venta v = buscar(idVenta);
        if (!"Registrada".equals(v.getEstado())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "La venta ya está anulada");
        }
        v.setEstado("Anulada");
        ventaRepo.save(v);

        for (DetalleVenta d : detalleRepo.findByVenta_Id(idVenta)) {
            Inventario inv = inventarioRepo
                .findBySucursal_IdAndProducto_Id(v.getSucursal().getId(), d.getProducto().getId())
                .orElseThrow(() -> bad("No existe el inventario para reponer el stock"));
            inv.setCantidadDisponible(inv.getCantidadDisponible() + d.getCantidad());
            inv.setActualizacion(LocalDateTime.now());
            inventarioRepo.save(inv);

            MovimientoInventario m = new MovimientoInventario();
            m.setProducto(d.getProducto());
            m.setUsuario(v.getUsuario());
            m.setSucursal(v.getSucursal());
            m.setDetalleVenta(d);
            m.setTipoMovimiento("Entrada");
            m.setCantidad(d.getCantidad());
            m.setMotivo("Anulación Venta");
            m.setFecha(LocalDateTime.now());
            movimientoRepo.save(m);
        }
    }

    public Venta buscar(Integer id) {
        return ventaRepo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Venta no encontrada"));
    }

    private ResponseStatusException bad(String msg) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
    }
}