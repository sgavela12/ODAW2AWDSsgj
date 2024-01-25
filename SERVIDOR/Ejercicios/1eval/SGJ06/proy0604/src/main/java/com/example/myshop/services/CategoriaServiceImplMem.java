package com.example.myshop.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myshop.domain.Categoria;

@Service
public class CategoriaServiceImplMem implements CategoriaService {

    @Autowired
    public ProductoService productoService;

    private List<Categoria> repositorio = new ArrayList<>();

    public Categoria añadir(Categoria categoria) {
        repositorio.add(categoria);
        return categoria;
    }

    public List<Categoria> obtenerTodos() {
        return repositorio;
    }

    public Categoria obtenerPorId(long id) {
        for (Categoria categoria : repositorio)
            if (categoria.getId() == id)
                return categoria;
        return null;
    }

    public Categoria editar(Categoria categoria) {
        int pos = repositorio.indexOf(categoria);
        if (pos == -1)
            return null;
        repositorio.set(pos, categoria);
        return categoria;
    }

    public void borrar(Long id) {
        Categoria categoria = this.obtenerPorId(id);
        if (categoria != null) {
             repositorio.remove(categoria);
        }
    }
}
