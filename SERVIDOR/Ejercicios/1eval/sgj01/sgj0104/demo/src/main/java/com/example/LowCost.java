package com.example;

public class LowCost extends Habitacion {
    public LowCost(int numero) {
        super(numero);
        this.precioDia = 50;
        this.tipo = "lowCost";
    }

    public void checkOut() {
        if (this.ocupada == true) {
            this.ocupada = false;
            long momentoSalida = System.currentTimeMillis();
            int segundosTranscurridos = ((int) (momentoSalida - momentoEntrada) / 1000);
            System.out.println("El importe por " + segundosTranscurridos + " dias seria de "
                    + this.precioDia * segundosTranscurridos);
        } else {
            System.out.println("La habitacion no se encuentra disponible");
        }

    }
}
