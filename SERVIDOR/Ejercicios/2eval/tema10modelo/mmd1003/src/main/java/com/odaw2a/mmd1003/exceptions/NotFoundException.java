package com.odaw2a.mmd1003.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException(String msg){
        super(msg);
    }
    public NotFoundException(){
        super("Elemento no encontrado");
    }
}
