package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Producto;
import com.example.services.ProductoService;

@Controller
public class ProductController {
    @Autowired ProductoService productoService;

   

    @GetMapping("/productos")
    public String showProductos(Model model){
        model.addAttribute("productos", productoService.getListaProductos());
        model.addAttribute("producto", new Producto());
        return "productos/productoView";

    }

    @PostMapping("/productos/submit")
    public String showAltaProductoSubmit(Producto producto, Model model){
        productoService.nuevoProducto(producto);
        return "redirect:/productos";

    }
    
    @GetMapping("/borrar/{refer}")
    public String showBorrar(@PathVariable Long refer){
        productoService.borrarProducto(refer);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{edit}")
    public String showEdit(@PathVariable Long edit, Model model){
        Producto producto = productoService.obtenerPorId(edit);
        if(producto!=null){
            model.addAttribute("producto",producto);
            return "/productos/editProducto";
        }
        return "redirect:/";
    }
    
    @PostMapping("/editar/submit")
    public String showEditSubmit(Producto producto){
        System.out.println(producto.toString());
        productoService.editar(producto);
        return "redirect:/productos";
    }


    
}
