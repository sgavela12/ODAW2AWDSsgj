package com.example.prueba.domain;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;


@Getter   
public class Cuenta {
    @Id
    private String iban;

    private String nombre;

    
    private float saldo;

    private ArrayList<Movimiento> historico;

    

    public Cuenta(String iban, String nombre) {
        this.iban = iban;
        this.nombre = nombre;
        this.saldo = 0;
    }



    public void setSaldo(Movimiento movimiento){
        
    }
}
