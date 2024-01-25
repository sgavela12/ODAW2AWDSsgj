package com.example;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public Menu() {
        
        showMenu();
    }

    public void showMenu() {
        Scanner teclado = new Scanner(System.in);
        int respuesta;
        System.out.println("Bienvenido.");
        Bd.cargaEmpleados();
        do {
            
            System.out.println("=======================");
            Bd.enseñaEmpleados();
            System.out.println("=======================");
            System.out.println("[1]Alta [2]Baja [3]Modificación [4]Consulta [0]Salir");
            respuesta = Integer.parseInt(teclado.nextLine());

            switch (respuesta) {
                case 1:
                    int id;
                    String nombre;
                    int salario;
                    
                    System.out.println("Introduzca el id del nuevo empleado");
                    id = Integer.parseInt(teclado.nextLine()) ;
                    System.out.println("Introduzca el nombre del nuevo empleado");
                    nombre = teclado.nextLine();
                    System.out.println("Introduzca el salario del nuevo empleado");
                    salario = Integer.parseInt(teclado.nextLine()) ;

                    Bd.altaEmpleado(id, nombre, salario);
                    
                    break;

                case 2:
                    System.out.println("Introduzca el id del empleado que quiera dar de baja");
                    id = Integer.parseInt(teclado.nextLine()) ;
                    Bd.bajaEmpleado(id);
                    
                    break;

                case 3:
                    
                    System.out.println("Introduzca el id del empleado que quiera modificar");
                    id = Integer.parseInt(teclado.nextLine()) ;
                    System.out.println("Introduzca el nuevo nombre");
                    nombre = teclado.nextLine();
                    System.out.println("Introduzca el nuevo salario");
                    salario = Integer.parseInt(teclado.nextLine()) ;

                    Bd.modificarEmpleado(id, nombre, salario);
                    
                    break;
                
                case 4:
                int min,max;
                    System.out.println("Introduzca el salario minimo");
                     min= Integer.parseInt(teclado.nextLine()) ;
                    System.out.println("Introduzca el salario maximo");
                    max = Integer.parseInt(teclado.nextLine()) ;
                    Bd.consulta(min,max);
                    
                    break;



            
                default:
                    break;
            }

        } while (respuesta != 0);
    }

    public void alta(){
        
    }

}
