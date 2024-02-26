package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Categoria;
import com.example.domain.Producto;
import com.example.services.CategoriaServiceImpl;
import com.example.services.ProductoServiceIplm;

@Controller
public class ProductController {
    @Autowired ProductoServiceIplm productoService;
    @Autowired CategoriaServiceImpl categoriaService;

   

    @GetMapping("/productos")
    public String showProductos(Model model){
        model.addAttribute("productos", productoService.getListaProductos());
        model.addAttribute("listaCategorias", categoriaService.verCategorias());
        model.addAttribute("categoriaSeleccionada", new Categoria (0L,"Todas"));
        model.addAttribute("producto", new Producto());
        return "productos/productoView";

    }

    @PostMapping("/productos/submit")
    public String showAltaProductoSubmit(Producto producto, Model model){
        productoService.nuevoProducto(producto);
        return "redirect:/productos";

    }

    @GetMapping("/porCateg/{idCat}")
    public String showListInCategory(@PathVariable Long idCat, Model model) {
        model.addAttribute("productos", productoService.findByCategory(idCat));
        model.addAttribute("listaCategorias", categoriaService.verCategorias());
        model.addAttribute("categoriaSeleccionada", categoriaService.obtenerCategoriaPorId(idCat));
        model.addAttribute("producto", new Producto());
        return "productos/productoView";
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

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        if (productoService.findByCategory(id).size() == 0)
        categoriaService.borrarCategoria(id);
        return "redirect:/categorias/";
    }


    
}
