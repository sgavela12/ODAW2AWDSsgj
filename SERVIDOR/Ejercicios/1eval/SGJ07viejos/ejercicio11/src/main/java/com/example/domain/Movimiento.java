package com.example.domain;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Movimiento {

    @Id
    private String iban;

    @NotNull
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
