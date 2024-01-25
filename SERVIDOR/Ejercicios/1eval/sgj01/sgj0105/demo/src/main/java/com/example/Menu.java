package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void start(ArrayList<Elemento> elementos) {
        Scanner teclado = new Scanner(System.in);
        int respuestaAccion;
            System.out.println("Bienvenido.");
        do {
            System.out.println("=================================");
            System.out.println("Estado de los dispositivos:");
            for (Elemento elemento : elementos) {
                
                System.out.println(elemento.verEstado());
            }
             System.out.println("=================================");
            System.out.println(
                    "Introduce que operacion quiere hacer:\n 0: Salir \n 1: Subir dispositivo \n 2: Bajar dispositivo \n 3: Resetear un dispositivo \n 4: Hacer Revision ");
            respuestaAccion = teclado.nextInt();
            
            try {
                if (respuestaAccion != 0) {
                    System.out.println("Que elemento de los " + elementos.size() + " quieres modificar? [1]Ascensor [2]Radio [3]Termostato");
                    int respuestaIndex = teclado.nextInt();
                    if (respuestaAccion == 1) {
                        elementos.get(respuestaIndex - 1).subir();
                    } else if (respuestaAccion == 2) {
                        elementos.get(respuestaIndex - 1).bajar();
                    } else if (respuestaAccion == 3) {
                        elementos.get(respuestaIndex - 1).reset();
                    }
                    
                }

            } catch (Exception e) {
                System.out.println("Valores no validos. Intentelo de nuevo");
            }

        } while (respuestaAccion != 0);
        System.out.println("Hasta la vista.");

        // list.forEach((n) -> System.out.println(n));

    }

}
