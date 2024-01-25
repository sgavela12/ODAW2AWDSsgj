package com.example.myshop.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myshop.domain.Producto;

@Service
public class ProductoServiceImplMem implements ProductoService {
    private List<Producto> repositorio = new ArrayList<>();

    public Producto añadir(Producto producto) {
        repositorio.add(producto);
        return producto;
    }

    public List<Producto> obtenerTodos() {
        return repositorio;
    }

    public Producto obtenerPorId(long id) {
        for (Producto producto : repositorio)
            if (producto.getId() == id)
                return producto;
        return null;
    }

    public Producto editar(Producto producto) {
        int pos = repositorio.indexOf(producto);
        if (pos == -1)
            return null;
        repositorio.set(pos, producto);
        return producto;
    }

    public void delete(Long id) {
        Producto producto = this.obtenerPorId(id);
        if (producto != null) {
            repositorio.remove(producto);
        }
    }

       public List<Producto> obtenerPorCategoria(Long idCategoria){
        List<Producto> productosPorCategoria = new ArrayList<>();
        for(Producto producto : repositorio){
            if (producto.getIdCategoria()==idCategoria) {
                productosPorCategoria.add(producto);
            }
        }
        return productosPorCategoria;

    }


}
