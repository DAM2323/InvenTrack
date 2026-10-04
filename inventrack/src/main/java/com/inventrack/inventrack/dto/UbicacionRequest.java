package com.inventrack.inventrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UbicacionRequest(

        @NotNull(message = "idInventario es obligatorio")
        Integer idInventario,

        @NotBlank(message = "ubicacion es obligatoria")
        String ubicacion

) {
}