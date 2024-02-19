package com.odaw2a.glc1003.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException(String msg){
        super(msg);
    }
    public NotFoundException(){
        super("Elemento no encontrado");
    }
}
