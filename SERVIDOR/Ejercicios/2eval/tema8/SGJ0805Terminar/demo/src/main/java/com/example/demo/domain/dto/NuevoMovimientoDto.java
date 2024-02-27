package com.example.demo.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NuevoMovimientoDto {
    private String iban;
    private Double importe;
}
