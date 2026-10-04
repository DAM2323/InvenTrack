package com.inventrack.inventrack.dto;

import java.math.BigDecimal;
import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record CompraRequest(
        @NotNull(message = "idProveedor es obligatorio") Integer idProveedor,
        @NotNull(message = "idSucursal es obligatorio") Integer idSucursal,
        @NotNull(message = "idUsuario es obligatorio") Integer idUsuario,
        String observacion,
        @NotEmpty(message = "El detalle no puede estar vacío") List<@Valid Item> detalle) {

    public record Item(
            @NotNull(message = "idProducto es obligatorio") Integer idProducto,
            @NotNull @Positive(message = "La cantidad debe ser mayor a 0") Integer cantidad,
            @PositiveOrZero(message = "precioUnitario no puede ser negativo") BigDecimal precioUnitario) {
    }
}
