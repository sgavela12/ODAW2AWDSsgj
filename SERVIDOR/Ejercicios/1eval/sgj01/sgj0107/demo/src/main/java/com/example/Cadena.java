package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cadena {
    private String cadena;
    private String[] cadenaSeparada; 
    private ArrayList<String> letrasSinRepetir = new  ArrayList<>();


    public void pideCadena(){
        Scanner teclado = new Scanner(System.in);
        

        System.out.println("Introduce una cadena");
        cadena =  teclado.nextLine();
    }


    public void separaCadena(){
        this.cadenaSeparada = this.cadena.split("");
        
    }

    public Map CuentaYElimina(){
        Map<String,Integer>cadenaSinRepetir = new HashMap<String,Integer>();
        for (String letra : this.cadenaSeparada ) {
           if(!cadenaSinRepetir.containsKey(letra)){
                cadenaSinRepetir.put(letra, 1);
                letrasSinRepetir.add(letra);
           }else{
                cadenaSinRepetir.put(letra,cadenaSinRepetir.get(letra)+1);
           }
        
        }
        return cadenaSinRepetir;

    }


    public void imprimeResultados(Map cadenaSinRepetir){
        System.out.print("{ ");
       for (String letra : letrasSinRepetir) {
        System.out.print(letra+" = "+cadenaSinRepetir.get(letra)+ "    ");
        
       }
       System.out.print("} ");

       
    }




    public void ordenaCadena(){
        Arrays.sort(this.cadenaSeparada);
    }

    //GETTERS


    public String getCadena() {
        return cadena;
    }


    public String[] getCadenaSeparada() {
        return cadenaSeparada;
    }

    


}
