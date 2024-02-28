package com.example.myshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myshop.domain.Categoria;
import com.example.myshop.services.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    public CategoriaService categoriaService;

    @GetMapping({ "/", "/list", "" })
    public List<Categoria> getAllCategories() {
        return categoriaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Categoria getCategoryById(@PathVariable long id) {
        return categoriaService.obtenerPorId(id);
    }

    @PostMapping
    public Categoria createCategory(@Valid @RequestBody Categoria nuevaCategoria,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Handle validation errors if needed
        }
        categoriaService.añadir(nuevaCategoria);
        return nuevaCategoria;
    }

    @PutMapping("/{id}")
    public Categoria updateCategory(@PathVariable long id,
                                    @Valid @RequestBody Categoria categoria,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        }
        categoria.setId(id);
        categoriaService.editar(categoria);
        return categoria;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id) {
        categoriaService.borrar(id);
    }
}
