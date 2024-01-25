package com.example.domain;

import java.util.ArrayList;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of ="iban")
public class Cuenta {

    @NotEmpty
    private String iban;

    @NotEmpty
    private String nombre;

    
    private float saldo;

    private ArrayList<Movimiento> historico;



    public Cuenta(String iban, String nombre) {
        this.iban = iban;
        this.nombre = nombre;
        this.saldo = 0;
        this.historico = new ArrayList<>();
    }



    public void setSaldo(Movimiento movimiento){
        
    }


    public void addMovimiento(Movimiento movimiento){
        saldo += movimiento.getImporte();
        historico.add(movimiento);
    }
}
