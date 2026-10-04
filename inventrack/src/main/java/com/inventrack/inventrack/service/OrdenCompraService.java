package com.inventrack.inventrack.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import com.inventrack.inventrack.dto.CompraRequest;
import com.inventrack.inventrack.entity.DetalleCompra;
import com.inventrack.inventrack.entity.Inventario;
import com.inventrack.inventrack.entity.MovimientoInventario;
import com.inventrack.inventrack.entity.OrdenCompra;
import com.inventrack.inventrack.entity.Producto;
import com.inventrack.inventrack.entity.Proveedor;
import com.inventrack.inventrack.repository.DetalleCompraRepository;
import com.inventrack.inventrack.repository.InventarioRepository;
import com.inventrack.inventrack.repository.MovimientoInventarioRepository;
import com.inventrack.inventrack.repository.OrdenCompraRepository;
import com.inventrack.inventrack.repository.ProductoRepository;
import com.inventrack.inventrack.repository.ProveedorRepository;
import com.inventrack.inventrack.repository.SucursalRepository;
import com.inventrack.inventrack.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {

    private static final String PENDIENTE = "Pendiente";
    private static final String RECIBIDA = "Recibida";

    private final OrdenCompraRepository ordenRepo;
    private final DetalleCompraRepository detalleRepo;
    private final ProveedorRepository proveedorRepo;
    private final SucursalRepository sucursalRepo;
    private final UsuarioRepository usuarioRepo;
    private final ProductoRepository productoRepo;
    private final InventarioRepository inventarioRepo;
    private final MovimientoInventarioRepository movimientoRepo;

    /** EP51: registra la cabecera y el detalle de la orden en estado Pendiente. */
    @Transactional
    public OrdenCompra registrar(CompraRequest r) {
        Proveedor proveedor = proveedorRepo.findById(r.idProveedor())
            .orElseThrow(() -> bad("El proveedor no existe"));
        if (!Boolean.TRUE.equals(proveedor.getActivo())) {
            throw bad("El proveedor especificado no se encuentra habilitado");
        }

        OrdenCompra o = new OrdenCompra();
        o.setProveedor(proveedor);
        o.setSucursal(sucursalRepo.findById(r.idSucursal()).orElseThrow(() -> bad("La sucursal no existe")));
        o.setUsuario(usuarioRepo.findById(r.idUsuario()).orElseThrow(() -> bad("El usuario no existe")));
        o.setFechaCompra(LocalDateTime.now());
        o.setEstado(PENDIENTE);
        o.setObservacion(r.observacion());
        o.setTotal(BigDecimal.ZERO);
        ordenRepo.save(o);

        BigDecimal total = BigDecimal.ZERO;
        for (CompraRequest.Item it : r.detalle()) {
            Producto p = productoRepo.findById(it.idProducto())
                .orElseThrow(() -> bad("El producto " + it.idProducto() + " no existe"));
            BigDecimal precio = it.precioUnitario() != null ? it.precioUnitario() : p.getPrecioCosto();
            if (precio == null) {
                throw bad("El producto " + p.getId() + " no tiene precio de costo; envía precioUnitario");
            }
            BigDecimal subtotal = precio.multiply(BigDecimal.valueOf(it.cantidad()));

            DetalleCompra d = new DetalleCompra();
            d.setOrdenCompra(o);
            d.setProducto(p);
            d.setCantidad(it.cantidad());
            d.setPrecioUnitario(precio);
            d.setSubtotal(subtotal);
            detalleRepo.save(d);

            total = total.add(subtotal);
        }
        o.setTotal(total);
        return ordenRepo.save(o);
    }

    /** EP52: la orden con su detalle. */
    public Map<String, Object> buscarConDetalle(Integer idCompra) {
        OrdenCompra o = buscar(idCompra);
        return Map.of("orden", o, "detalle", detalleRepo.findByOrdenCompra_Id(idCompra));
    }

    /** EP53: lista con filtros opcionales por sucursal y estado. */
    public List<OrdenCompra> listar(Integer idSucursal, String estado) {
        return ordenRepo.findAll().stream()
            .filter(o -> idSucursal == null || o.getSucursal().getId().equals(idSucursal))
            .filter(o -> estado == null || estado.isBlank() || estado.equalsIgnoreCase(o.getEstado()))
            .toList();
    }

    /** EP54: confirma la recepción, sube el stock y registra los movimientos de entrada. */
    @Transactional
    public void recibir(Integer idCompra) {
        OrdenCompra o = buscar(idCompra);
        if (!PENDIENTE.equals(o.getEstado())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "La orden ya ha sido recibida previamente");
        }

        for (DetalleCompra d : detalleRepo.findByOrdenCompra_Id(idCompra)) {
            Inventario inv = inventarioRepo
                .findBySucursal_IdAndProducto_Id(o.getSucursal().getId(), d.getProducto().getId())
                .orElseGet(() -> {
                    Inventario n = new Inventario();
                    n.setSucursal(o.getSucursal());
                    n.setProducto(d.getProducto());
                    n.setCantidadDisponible(0);
                    return n;
                });
            inv.setCantidadDisponible(inv.getCantidadDisponible() + d.getCantidad());
            inv.setActualizacion(LocalDateTime.now());
            inventarioRepo.save(inv);

            MovimientoInventario m = new MovimientoInventario();
            m.setProducto(d.getProducto());
            m.setUsuario(o.getUsuario());
            m.setSucursal(o.getSucursal());
            m.setDetalleCompra(d);
            m.setTipoMovimiento("Entrada");
            m.setCantidad(d.getCantidad());
            m.setMotivo("Compra");
            m.setFecha(LocalDateTime.now());
            movimientoRepo.save(m);
        }
        o.setEstado(RECIBIDA);
        ordenRepo.save(o);
    }

    public OrdenCompra buscar(Integer id) {
        return ordenRepo.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden de compra no encontrada"));
    }

    private ResponseStatusException bad(String msg) {
        return new ResponseStatusException(HttpStatus.BAD_REQUEST, msg);
    }
}
