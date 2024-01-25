package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.services.ProductoService;

@Controller
public class ProductController {
    @Autowired ProductoService productoService;

    @GetMapping("/producto/editar/{id}")
    public String showEdit(@PathVariable Integer id){
    
        
        return "productoView";
    }

       @GetMapping("/producto/borrar/{id}")
    public String showBorrar(@PathVariable Integer id){
        
        productoService.borrarProducto(id);
        System.out.println(productoService);
        return "productoView";
    }
}
