package com.example;

import java.time.LocalDate;

public class Termostato implements Elemento {
    private LocalDate revision;
    private int temperatura ;


    public Termostato() {
        temperatura = 20;
        this.revision = LocalDate.now();
        
    }

    
    public boolean subir(){

        if(temperatura>=15 && temperatura<80){
              temperatura += 1;
              System.out.println("Termperatura ascendida correctamente.");
              return true;
        }else{
            System.out.println("Error. Maximo de grados alcanzados");
            return false;
        }
    }


    public boolean bajar(){

        if(temperatura>15 && temperatura<=80){
              temperatura -= 1;
              System.out.println("Termperatura descendida correctamente.");
              return true;
        }else{
            System.out.println("Error. Minimo de grados alcanzados");
            return false;
        }
    }


    public void reset(){
        temperatura = 0;
    }

    public String verEstado(){
        return "El Termostato y se encuentra a "+ temperatura + "º y su fecha de revision es "+ revision;
    }

    public void revisar(){
        revision = LocalDate.now();
    }





    //GETTER
    public LocalDate getRevision() {
        return revision;
    }


    public int getTemperatura() {
        return temperatura;
    }




    

    
}
