package com.example.myshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myshop.domain.Producto;

@Service
public interface ProductoService {
    Producto añadir(Producto producto);

    List<Producto> obtenerTodos();

    Producto obtenerPorId(long id);

    Producto editar(Producto producto);

    Producto borrar(Long id);
    
    public List<Producto> obtenerPorCategoria(Long id);

}
