package com.inventrack.inventrack.controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.inventrack.inventrack.dto.CompraRequest;
import com.inventrack.inventrack.entity.OrdenCompra;
import com.inventrack.inventrack.service.OrdenCompraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orden-compra")
@RequiredArgsConstructor
public class OrdenCompraController {

    private final OrdenCompraService service;

    @PostMapping("/registrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> registrar(@Valid @RequestBody CompraRequest r) {
        OrdenCompra o = service.registrar(r);
        return Map.of("idCompra", o.getId(), "estado", o.getEstado(), "total", o.getTotal());
    }

    @GetMapping("/buscar-por-id")
    public Map<String, Object> buscar(@RequestParam Integer idCompra) {
        return service.buscarConDetalle(idCompra);
    }

    @GetMapping("/listar")
    public List<OrdenCompra> listar(@RequestParam(required = false) Integer idSucursal,
                                    @RequestParam(required = false) String estado) {
        return service.listar(idSucursal, estado);
    }

    @PutMapping("/recibir")
    public Map<String, String> recibir(@RequestParam Integer idCompra) {
        service.recibir(idCompra);
        return Map.of("mensaje", "Mercadería recibida con éxito");
    }
}
