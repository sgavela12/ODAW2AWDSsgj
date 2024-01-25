package com.example.ejercicio5;

import java.util.ArrayList;

public class MathController {

  public static boolean esPrimo(int numero) {
    if (numero == 0 || numero == 1 || numero == 4) {
      return false;
    }
    for (int x = 2; x < numero / 2; x++) {
      // Si es divisible por cualquiera de estos números, no
      // es primo
      if (numero % x == 0)
        return false;
    }
    // Si no se pudo dividir por ninguno de los de arriba, sí es primo
    return true;
  }

  public static ArrayList<Integer> generaAleatorios(int numero) {
    ArrayList<Integer> numeros = new ArrayList<>();
    int nuevoNumero;

    for (int i = 0; i < numero; i++) {
      do {
        nuevoNumero = (int) (Math.random() * 100 + 1);
      } while (numeros.contains(nuevoNumero));
      numeros.add(nuevoNumero);
    }
    return numeros;

  }

  public static ArrayList<Integer> generaDivisores( int numero){
    ArrayList<Integer> divisores = new ArrayList<>();
    for(int i = 1 ; i<= numero ; i++){
      if(numero%i==0){
        divisores.add(i);
      }
    }
    return divisores;
  
  
  }
}