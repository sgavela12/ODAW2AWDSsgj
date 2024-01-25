package com.example;


public abstract class Habitacion {
    protected int precioDia;
    protected boolean ocupada;
    protected long momentoEntrada;
    protected int numero;
    protected String tipo;


    protected Habitacion(int numero){
        this.numero = numero;
        this.ocupada = false;
    }


    protected void checkIn(){
        if(this.ocupada == false){
            this.ocupada = true;
            momentoEntrada= System.currentTimeMillis();
            System.out.println("Check In realizado con exito");
        }else{
            System.out.println("Habitacion no disponible ");
        }
         
        
    }

    protected  abstract void checkOut();



    
}
