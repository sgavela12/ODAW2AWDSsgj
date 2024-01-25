package com.example.domain;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Movimiento {

    private String iban;

    private Date fechaHora;

    @Min(value = -300) @Max(value = 1000)
    private float importe;

    public Movimiento(String iban, float importe){
        this.iban = iban;
        this.importe = importe;
        this.fechaHora = new Date();
        System.out.println("-----------HAS ENTRADO----------");
    }
    
}
