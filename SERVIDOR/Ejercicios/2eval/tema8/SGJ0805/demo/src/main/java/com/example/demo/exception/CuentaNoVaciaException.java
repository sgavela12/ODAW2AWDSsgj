package com.example.demo.exception;

public class CuentaNoVaciaException extends RuntimeException {
    public CuentaNoVaciaException() {
        super("La cuenta seleccionada no tiene saldo 0");
        }
}
