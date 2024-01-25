package com.example;

import java.util.Calendar;

public class Doble extends Habitacion {
    public Doble(int numero) {
        super(numero);
        this.precioDia = 100;
        this.tipo = "doble";
    }

    @Override
    protected void checkOut() {
        if (this.ocupada == true) {
            this.ocupada = false;
            long momentoSalida = System.currentTimeMillis();
            int segundosTranscurridos = ((int) (momentoSalida - momentoEntrada) / 1000);
            // funcion que devuelve el mes actual
            int mes = Calendar.getInstance().get(Calendar.MONTH);

            if (mes == 3 || mes == 6 || mes == 7) {
                System.out.println("El importe por " + segundosTranscurridos + " dias seria de "
                        + ((float) (this.precioDia * segundosTranscurridos) * 1.2));

            } else {

                System.out.println("El importe por " + segundosTranscurridos + " dias seria de "+this.precioDia * segundosTranscurridos);
            }

        } else {
            System.out.println("La habitacion no se encuentra disponible");
        }

    }
}
