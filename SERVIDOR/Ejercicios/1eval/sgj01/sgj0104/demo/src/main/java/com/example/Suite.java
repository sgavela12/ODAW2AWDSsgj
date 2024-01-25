package com.example;

public class Suite extends Habitacion {

    public Suite(int numero) {
        super(numero);
        this.precioDia = 200;
        this.tipo = "suite";
    }

    @Override
    protected void checkOut() {
        if (this.ocupada = true) {
            this.ocupada = false;
            long momentoSalida = System.currentTimeMillis();
            int segundosTranscurridos = ((int) (momentoSalida - momentoEntrada) / 1000);

            if (segundosTranscurridos >= 10) {

                System.out.println("El importe por " + segundosTranscurridos + " dias seria de "
                        + this.precioDia * segundosTranscurridos + " pero con el 20% de descuento se quedaria en "
                        + this.precioDia * segundosTranscurridos * 0.8);

            } else {

                System.out.println("El importe por " + segundosTranscurridos + " dias seria de "
                        + this.precioDia * segundosTranscurridos);
            }

        } else {
            System.out.println("La habitacion no se encuentra disponible");
        }

    }

}
