package com.example.demo.exception;

public class EmptyCuentaException extends RuntimeException {
    public EmptyCuentaException() {
        super("No hay Cuentas en el sistema");
        }
}
