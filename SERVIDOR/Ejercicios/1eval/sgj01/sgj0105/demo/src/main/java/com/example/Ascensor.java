package com.example;

import java.time.LocalDate;

public class Ascensor implements Elemento{
    private int planta ;
    private LocalDate revision;

    public Ascensor() {
        revision = LocalDate.now();
        planta = 0;

    }


    public boolean subir(){

        if(planta<8 && planta>=0){
              this.planta += 1;
              System.out.println("Planta ascendida correctamente.");
              return true;
        }else{
            System.out.println("Se ha alcanzado la planta maxima");
            return false;
        }
    }


    public boolean bajar(){

        if(planta<=8 && planta>0){
              this.planta -= 1;
               System.out.println("Planta descendida correctamente.");
              return true;
        }else{
            System.out.println("Se ha alcanzado la planta minima");
            return false;
        }
    }


    public void reset(){
        planta =0;
    }

    public String verEstado(){
        return "El Ascensor se encuentra en la planta "+ planta + " y su fecha de revision es "+ revision;
    }

    public void revisar(){
        revision = LocalDate.now();
    }


    //GETTER 

    public int getPlanta() {
        return planta;
    }



    public LocalDate getRevision() {
        return revision;
    }
}
