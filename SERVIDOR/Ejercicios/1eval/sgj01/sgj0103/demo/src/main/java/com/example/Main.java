package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        personas.add(new Persona("02553236M", "carlos", 20));
        personas.add(new Persona("02553237M", "pepe", 22));
        personas.add(new Persona("02553238M", "juan", 40));
        personas.add(new Persona("02553239M", "sergio", 76));
        personas.add(new Persona("02553249M", "sara", 66));
        personas.add(new Persona("02553230M", "alex", 4));

        // System.out.println(devuelveMasEdad(personas));
        // System.out.println(devuelveEdadMedia(personas));
        // System.out.println(devuelveNombreMayor(personas));
        //devuelven objetos Personas
        System.out.println(devuelvePersonaMayor(personas));
        System.out.println(devuelveMayoresEdad(personas));
        System.out.println(devuelveMayoreQueMedia(personas));
    }
    public static int devuelveMasEdad(ArrayList<Persona> personas) {
        Persona personaMayor = null;
        for (int i = 0; i < personas.size(); i++) {
            if (personaMayor == null || personaMayor.getEdad() < personas.get(i).getEdad()) {
                personaMayor = personas.get(i);
            }
        }

        return personaMayor.getEdad();
    }

    public static float devuelveEdadMedia(ArrayList<Persona> personas) {
        float sumaEdades = 0;
        for (int i = 0; i < personas.size(); i++) {
            sumaEdades += personas.get(i).getEdad();
            }
            return (sumaEdades/(float)personas.size());

        }
    

    public static String devuelveNombreMayor(ArrayList<Persona> personas) {
        Persona personaMayor = null;
        for (int i = 0; i < personas.size(); i++) {
            if (personaMayor == null || personaMayor.getEdad() < personas.get(i).getEdad()) {
                personaMayor = personas.get(i);
            }
        }
        return personaMayor.getNombre();
    }

    public static Persona devuelvePersonaMayor(ArrayList<Persona> personas) {
        Persona personaMayor = null;
        for (int i = 0; i < personas.size(); i++) {
            if (personaMayor == null || personaMayor.getEdad() < personas.get(i).getEdad()) {
                personaMayor = personas.get(i);
            }
        }
        return personaMayor;
    }

    public static ArrayList<Persona> devuelveMayoresEdad(ArrayList<Persona> personas) {
        ArrayList<Persona> mayoresEdad = new ArrayList<>(personas);
        for (int i = 0; i < personas.size(); i++) {
            if ( (personas.get(i).getEdad())>=18) {
                mayoresEdad.add(personas.get(i));
                
            }
        }
        return mayoresEdad;
    }


    public static ArrayList<Persona> devuelveMayoreQueMedia(ArrayList<Persona> personas) {
        ArrayList<Persona> mayoresQueMedia = new ArrayList<>(personas);
        float media = devuelveEdadMedia(personas);
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getEdad()>media) {
                mayoresQueMedia.add(personas.get(i));
                
            }
        }
        return mayoresQueMedia;
    }


    public static class Persona {
        private String dni;
        private String nombre;
        private int edad;

        public Persona(String dni, String nombre, int edad) {
            this.dni = dni;
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }
    }
}