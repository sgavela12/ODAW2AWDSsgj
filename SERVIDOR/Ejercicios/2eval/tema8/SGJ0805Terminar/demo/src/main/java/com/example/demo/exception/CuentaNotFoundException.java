package com.example.demo.exception;

public class CuentaNotFoundException extends RuntimeException{
    public CuentaNotFoundException(String iban){

        super("No se puede encontrar la Cuenta con el Iban: " + iban);
    }
}
