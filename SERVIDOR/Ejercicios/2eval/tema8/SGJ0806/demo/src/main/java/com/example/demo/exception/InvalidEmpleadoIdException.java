package com.example.demo.exception;

public class InvalidEmpleadoIdException extends RuntimeException {
    public InvalidEmpleadoIdException() {
        super("El ID del empleado debe ser un número.");
    }
}
