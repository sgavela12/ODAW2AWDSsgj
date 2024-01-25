package com.example.domain;

public class Producto {
    private long id;
    private String nombre;
    private boolean enOferta;
    private enum TipoIva{
        superreducido, reducido, normal
    }
    private double precio;
    public Producto(long id, String nombre, boolean enOferta, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.enOferta = enOferta;
        this.precio = precio;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isEnOferta() {
        return enOferta;
    }
    public void setEnOferta(boolean enOferta) {
        this.enOferta = enOferta;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    



    
}
