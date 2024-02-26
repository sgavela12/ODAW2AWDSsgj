package com.example.services;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.example.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();

    public ArrayList<Categoria> verCategorias(){
        return listaCategorias;
    }

    public void addCategoria(Categoria categoria){
        listaCategorias.add(categoria);
    }

    public Categoria obtenerCategoriaPorId(Long id){
        for(Categoria categoria: listaCategorias){
            if(categoria.getId().equals(id)){
                return categoria;
            }
            else{
               
            }
        }
        return null;
    }

    public void editarCategoria(Categoria categoria){
        
        int posicion = listaCategorias.indexOf(categoria);//Devuelve -1
        listaCategorias.set(posicion,categoria);
    }

    public void borrarCategoria(Long id){
        Iterator<Categoria> iterator = listaCategorias.iterator();
        while(iterator.hasNext()){
            Categoria categoria = iterator.next();
            if(categoria.getId().equals(id)) iterator.remove();
        }
    }
}