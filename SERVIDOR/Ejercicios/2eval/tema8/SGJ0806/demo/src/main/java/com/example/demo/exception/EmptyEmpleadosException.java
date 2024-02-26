package com.example.demo.exception;

public class EmptyEmpleadosException extends RuntimeException {
    public EmptyEmpleadosException() {
        super("No hay empleados en el sistema");
    }
}
