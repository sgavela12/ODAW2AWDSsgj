package com.example.prueba.services;


import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.prueba.domain.Cuenta;




@Service
public class CuentaService {
    private ArrayList<Cuenta> listaCuentas = new ArrayList<>();

    public void altaCuenta(String iban, String nombre){
        listaCuentas.add(new Cuenta(iban, nombre)); 
    }

    public void borrarCuenta(String iban){

    }

    

}
