package com.example.services;

import java.util.ArrayList;

import com.example.domain.Categoria;



public interface CategoriaService {
    
    public ArrayList<Categoria> verCategorias();
    public void addCategoria(Categoria categoria);
    public Categoria obtenerCategoriaPorId(Long id);
    public void editarCategoria(Categoria categoria);
    public void borrarCategoria(Long id);
}
