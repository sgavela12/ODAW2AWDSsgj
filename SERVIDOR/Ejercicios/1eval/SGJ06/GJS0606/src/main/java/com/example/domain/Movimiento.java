package com.example.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Movimiento {

    private String iban;
    private LocalDateTime fechaHora;
    private Double importe;
    
}
