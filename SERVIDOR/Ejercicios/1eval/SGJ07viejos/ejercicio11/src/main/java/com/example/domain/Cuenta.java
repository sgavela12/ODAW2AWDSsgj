package com.example.domain;

import java.util.ArrayList;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.mapping.List;

import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @OnDelete(action=OnDeleteAction.CASCADE)
    private ArrayList<Movimiento> movimientos = new ArrayList<>();


    public Cuenta(String iban, String nombre) {
        this.iban = iban;
        this.nombre = nombre;
        this.saldo = 0;
      
    }



    public void setSaldo(Movimiento movimiento){
        
    }


    public void addMovimiento(Movimiento movimiento){
        saldo += movimiento.getImporte();
        movimientos.add(movimiento);
    }
}
