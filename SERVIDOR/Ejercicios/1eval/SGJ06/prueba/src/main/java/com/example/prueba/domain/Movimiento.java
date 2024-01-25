package com.example.prueba.domain;



import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class Movimiento {
    private String fechaHora;

    @Min(value = -300) @Max(value = 1000)
    private float importe;
    
}
