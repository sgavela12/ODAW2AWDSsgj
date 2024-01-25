package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Primitiva {
    private ArrayList<Integer> numeros = new ArrayList<>();

    public Primitiva() {
         numeros =  generaAleatorios();
        
    }


    public int jugada(int numero1, int numero2, int numero3 , int numero4, int numero5, int numero6){
        
        int numeroAciertos = 0;
        ArrayList<Integer> intentos = new ArrayList<>();
        intentos.add(numero1);
        intentos.add(numero2);
        intentos.add(numero3);
        intentos.add(numero4);
        intentos.add(numero5);
        intentos.add(numero6);
        

        for(int i = 0; i< this.numeros.size();i++){
            if(intentos.contains(this.numeros.get(i))){
                numeroAciertos++;
            }
        }
        return numeroAciertos;
    }

    public boolean repetido(ArrayList<Integer> numeros, int numero){
        boolean estaRepetido = false;
        for(int i = 0;i< numeros.size(); i++){
            if(numero == numeros.get(i)){
                estaRepetido = true;
            }
        }
        return estaRepetido;
    
    }

    public ArrayList<Integer> generaAleatorios(){
        int numero;
        ArrayList<Integer> numeros = new ArrayList<>();
        for(int i = 0 ;i <6 ;i++){
           do {
                numero = (int) (Math.random() * 49) + 1;
           } while (repetido(numeros, numero));
           numeros.add(numero);
        }
        return numeros;
    }

    public void preguntarNumeros(){
        Scanner teclado = new Scanner(System.in);
        int numero1,numero2,numero3,numero4,numero5,numero6;

        System.out.println("Introduce un numero entre 1 y 49");
        numero1= teclado.nextInt();
        System.out.println("Introduce un numero entre 1 y 49");
        numero2= teclado.nextInt();
        System.out.println("Introduce un numero entre 1 y 49");
        numero3= teclado.nextInt();
        System.out.println("Introduce un numero entre 1 y 49");
        numero4= teclado.nextInt();
        System.out.println("Introduce un numero entre 1 y 49");
        numero5= teclado.nextInt();
        System.out.println("Introduce un numero entre 1 y 49");
        numero6= teclado.nextInt();

        System.out.println("El numero de aciertos es "+jugada(numero1, numero2, numero3, numero4, numero5, numero6));
        System.out.print("Los numeros premiados son ");
        for(int numero : this.numeros){
            System.out.print(numero+"  ");
        }

    }


    public ArrayList<Integer> getNumeros() {
        return numeros;
    }


    
}
