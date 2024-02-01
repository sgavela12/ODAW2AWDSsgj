package com.example.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.domain.Cuenta;

import lombok.Getter;

@Service
@Getter
public class CuentaService {
    private ArrayList<Cuenta> listaCuentas = new ArrayList<>();

    public void altaCuenta(Cuenta cuenta) {
        listaCuentas.add(cuenta);
    }

    public boolean borrarCuenta(Cuenta cuentaBorrar) {
        if (listaCuentas.indexOf(cuentaBorrar) != -1) {
            listaCuentas.remove(cuentaBorrar);
            return true;

        }
        
        return false;

    }

    public Cuenta editarCuenta(Cuenta cuenta) {

        int pos = listaCuentas.indexOf(cuenta);
        if (pos == -1)
            return null;
        listaCuentas.set(pos, cuenta);
        return cuenta;
    }

    public Cuenta obtenerPorIban(String iban) {
        for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta;
                
            }
        }
        return null;
    }

}
