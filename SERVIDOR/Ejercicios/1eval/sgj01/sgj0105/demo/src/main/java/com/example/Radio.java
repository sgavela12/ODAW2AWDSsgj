package com.example;

import java.time.LocalDate;

public class Radio implements Elemento{
        private float dial ;
        private LocalDate revision;

        public Radio() {
            dial = 88;
            revision = LocalDate.now();
        }


        public boolean subir(){

            if(dial>=88 && dial<104){
                  dial += 0.1;
                  System.out.println("Dial ascendida correctamente.");
                  return true;
            }else{
                System.out.println("Error. Dial maximo alcanzado");
                return false;
            }
        }
    
    
        public boolean bajar(){
    
            if(dial>88 && dial<=104){
                  dial -= 0.1;
                  System.out.println("Dial descendido correctamente.");
                  return true;
            }else{
                System.out.println("Error. Dial minimo alcanzado");
                return false;
            }
        }
    
    
        public void reset(){
            dial =0;
        }
    
        public String verEstado(){
            return "La radio se encuentra en el dial "+ dial + " y su fecha de revision es "+ revision;
        }
    
        public void revisar(){
            revision = LocalDate.now();
        }
    

        

}
