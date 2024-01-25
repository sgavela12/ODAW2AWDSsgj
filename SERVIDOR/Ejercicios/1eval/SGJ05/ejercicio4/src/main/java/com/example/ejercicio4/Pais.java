package com.example.ejercicio4;

public class Pais {
    private String nombre;
    private String capital;
    private long poblacion;

    public Pais() {
        // Constructor sin argumentos
    }

    public Pais(String nombre, String capital, long poblacion) {
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCapital() {
        return capital;
    }


    public void setCapital(String capital) {
        this.capital = capital;
    }


    public long getPoblacion() {
        return poblacion;
    }


    public void setPoblacion(long poblacion) {
        this.poblacion = poblacion;
    }

    




}
