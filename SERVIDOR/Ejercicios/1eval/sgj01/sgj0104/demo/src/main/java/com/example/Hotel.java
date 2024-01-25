package com.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Hotel {
    protected ArrayList<Habitacion> habitaciones;

    public Hotel() {

        habitaciones = new ArrayList<>();

    }

    public void CreaHabitaciones() {
        // Creacion de LowCost
        for (int i = 0; i < 3; i++) {
            habitaciones.add(new LowCost(i + 1));
        }

        // Creacion de Dobles
        for (int i = 3; i < 13; i++) {
            habitaciones.add(new Doble(i + 1));
        }

        // Creacion de Suite
        for (int i = 13; i < 18; i++) {
            habitaciones.add(new Suite(i + 1));
        }
    }

    public void menu() {
        int respuesta;
        System.out.print("Bienvenido al hotel, ");
        do {
            Scanner teclado = new Scanner(System.in);
            int habitacionSeleccionada;
            System.out.println("que desea hacer? \n [0] Salir \n [1] Check In \n [2] Check Out ");
            respuesta = teclado.nextInt();
            if (respuesta == 1) {
                muestraHabitacionesDisponibles();
                System.out.println("Elija el numero de la habitacion en el que le gustaria hacer check in");
                habitacionSeleccionada = teclado.nextInt();
                if(habitacionSeleccionada>0 && habitacionSeleccionada<18){
                    // hacemos check in de la habitacion seleccionada
                habitaciones.get(habitacionSeleccionada - 1).checkIn();
                }else{
                    System.out.println("Habitacion no disponible");
                }
                
            } else if (respuesta == 2) {
                muestraHabitacionesOcupadas();
                System.out.println("Elija el numero de la habitacion que le gustaria hacer check out ");
                habitacionSeleccionada = teclado.nextInt();
                if(habitacionSeleccionada>0 && habitacionSeleccionada<18){
                    habitaciones.get(habitacionSeleccionada - 1).checkOut();
                }else{
                    System.out.println("Habitacion no disponible");
                }
                

            }else{
                System.out.println("Opcion no disponible");
            }

        } while (respuesta != 0);

    }

    private void muestraHabitacionesOcupadas() {
        System.out.println("Habitaciones Ocupadas: ");
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.ocupada == true) {

                System.out.println("Habitacion " + habitacion.tipo + " numero " + habitacion.numero);
            }
        }
    }

    public void muestraHabitacionesDisponibles() {
        System.out.println("Habitaciones Disponibles: ");
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.ocupada == false) {

                System.out.println("Habitacion " + habitacion.tipo + " numero " + habitacion.numero);
            }

        }
    }

}
