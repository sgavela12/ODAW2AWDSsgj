package com.example.services;

import java.util.ArrayList;

import com.example.domain.Producto;

public interface ProductoService {
       public ArrayList<Producto> getListaProductos();
    public void nuevoProducto(Producto producto);
    public String obtano();
    public void borrarProducto(Long id);
    public Producto obtenerPorId(Long id);
    public Producto editar(Producto producto);
}
