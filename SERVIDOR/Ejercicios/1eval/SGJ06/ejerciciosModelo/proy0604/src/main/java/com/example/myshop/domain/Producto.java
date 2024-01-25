package com.example.myshop.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Producto {

    @Min(value = 0)
    private Long id;

    @NotEmpty
    private String nombre;

    private boolean enOferta;

    private TipoIva tipoIva; // enumeración

    private Double precio;

    private long idCategoria;
}
