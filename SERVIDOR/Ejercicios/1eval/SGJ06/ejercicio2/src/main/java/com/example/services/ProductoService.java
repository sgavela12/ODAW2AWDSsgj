package com.example.services;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.domain.Producto;


@Service
public class ProductoService {
    ArrayList<Producto> listaProductos = new ArrayList<>(Arrays.asList(new Producto(1,"Mochila",false,19.95),new Producto(2,"Estuche",false,5.95)));

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void borrarProducto(Integer id){
        for(Producto producto: listaProductos){
            if (producto.getId() == id) {
                listaProductos.remove(producto);
            }

        }
    }

    
    
}
