package com.example.demo.exception;

public class CuentaExistenteException extends RuntimeException{
    public CuentaExistenteException(String iban) {
        super("La cuenta con el iban: "+ iban+" ya existe.");
}
}