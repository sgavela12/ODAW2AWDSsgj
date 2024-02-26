package com.example.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.domain.Cuenta;
import com.example.domain.Movimiento;

import lombok.Getter;

@Service
@Getter
public class CuentaService {
    ArrayList<Cuenta> cuentas = new ArrayList<>();

    public ArrayList<Cuenta> verCuentas(){
        return cuentas;
    }

    public ArrayList<Movimiento> obtenerMovimientos(String iban){
        for(Cuenta cuentaiterada: cuentas){
            if(cuentaiterada.getIban().equals(iban)) return cuentaiterada.getMovimientos();
        }
        return null;
    }
    
    public void nuevaCuenta(Cuenta cuenta){
        cuentas.add(new Cuenta(cuenta.getIban(),cuenta.getNombre(),cuenta.getSaldo()));
    }
    
    public Cuenta obtenerPorIban(String iban){
        for(Cuenta cuentaiterada: cuentas){
            if(cuentaiterada.getIban().equals(iban)) return cuentaiterada;
        }
        return null;
    }

    public void cambiarCuenta(Cuenta cuenta){
        int posicion = cuentas.indexOf(cuenta);
        System.out.println(cuenta.toString());
        for(Cuenta cuentaiterada: cuentas){
            if(cuenta.getIban().equals(cuentaiterada.getIban())){
                cuentas.set(posicion,new Cuenta(cuentaiterada.getIban(),cuenta.getNombre(),cuentaiterada.getSaldo()));
            } 
        }
    }

    public void borrarCuenta(String iban){
        Cuenta cuenta = this.obtenerPorIban(iban);
        if(cuenta!=null) cuentas.remove(cuenta);
    }

    public ArrayList<String> listaIbanes(){
        ArrayList<String> resultado = new ArrayList<>();
        for(Cuenta cuentaiterada: cuentas){
            resultado.add(cuentaiterada.getIban());
        }
        return resultado;
    }

    public void hacerMovimiento(String iban, Double importe){
        for(Cuenta cuentaiterada: cuentas){
            if(cuentaiterada.getIban().equals(iban)){
                ArrayList<Movimiento> operacion = cuentaiterada.getMovimientos();
                operacion.add(new Movimiento(cuentaiterada.getIban(),LocalDateTime.now(),importe));
                cuentaiterada.setSaldo(cuentaiterada.getSaldo() + importe);
            }
        }
    }
}
