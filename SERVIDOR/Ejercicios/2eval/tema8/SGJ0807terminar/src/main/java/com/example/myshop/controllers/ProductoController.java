package com.example.myshop.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myshop.domain.Producto;
import com.example.myshop.services.CategoriaService;
import com.example.myshop.services.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    public ProductoService productoService;

    @Autowired
    public CategoriaService categoriaService;

    @GetMapping({ "", "/" })
    public List<Producto> showList() {
        return productoService.obtenerTodos();
        
    }

        @GetMapping("/porCateg/{idCat}")
    public List<Producto> showListInCategory(@PathVariable Long idCat) {
        return productoService.obtenerPorCategoria(idCat);
    }

  

    @PostMapping("/new")
    public String showNewSubmit(
            @Valid Producto productoForm,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "product/productNewView";
        productoService.añadir(productoForm);
        return "redirect:/productos/";
    }

    @PutMapping("/edit/{id}")
    public Producto showEditForm(@PathVariable long id) {
        return productoService.obtenerPorId(id);
       
    }

    

    @DeleteMapping("/delete/{id}")
    public Producto showDelete(@PathVariable long id) {
         return productoService.borrar(id);
        
    }


}
