package com.inventrack.inventrack.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.inventrack.inventrack.dto.UbicacionRequest;
import com.inventrack.inventrack.entity.Inventario;
import com.inventrack.inventrack.service.ReporteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventario")
@RequiredArgsConstructor
public class InventarioController {

    private final ReporteService service;

    @GetMapping("/listar")
    public List<Inventario> listar(@RequestParam Integer idSucursal) {
        return service.inventarioPorSucursal(idSucursal);
    }

    @GetMapping("/buscar")
    public Inventario buscar(
            @RequestParam Integer idSucursal,
            @RequestParam Integer idProducto) {

        return service.inventarioDeProducto(idSucursal, idProducto);
    }

    @PutMapping("/actualizar-ubicacion")
    public Inventario actualizarUbicacion(
            @Valid @RequestBody UbicacionRequest r) {

        return service.actualizarUbicacion(
                r.idInventario(),
                r.ubicacion());
    }
}