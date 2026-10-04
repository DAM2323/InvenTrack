package com.inventrack.inventrack.dto;

import java.math.BigDecimal;
import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record VentaRequest(
        @NotNull Integer idCliente,
        @NotNull Integer idSucursal,
        @NotNull Integer idMetodoPago,
        @NotNull Integer idUsuario,
        String observacion,
        @NotEmpty List<@Valid Item> detalle) {

    public record Item(
            @NotNull Integer idProducto,
            @NotNull @Positive Integer cantidad,
            BigDecimal precioUnitario,
            BigDecimal descuento) {
    }
}