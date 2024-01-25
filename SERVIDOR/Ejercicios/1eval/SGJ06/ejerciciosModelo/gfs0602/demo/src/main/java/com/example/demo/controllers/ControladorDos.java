package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Formulario;
import com.example.demo.services.ProductoService;

@Controller
public class ControladorDos {

    @Autowired
    ProductoService servicioTienda;

    @GetMapping({"/index","/home","/"})
    public String indexView(@RequestParam(name = "cliente",required=false) String usuario, Model model){
        model.addAttribute("customer",usuario);
        model.addAttribute("ayo","© " + servicioTienda.obtAllo());
        return "indexView";
    }
    @GetMapping("/about-us")
    public String quienesSomosView(){
        return "quienes_somosView";
    }
    @GetMapping("/contacta")
    public String contactaView(Model model){
        model.addAttribute("formulario", new Formulario());
        return "contactaView";
    }
    @PostMapping("/contacta/resultado")
    public String contactaSubmitView(Formulario formulario,Model model){
        
        model.addAttribute("nombre", formulario.getNombre());
        model.addAttribute("email", formulario.getEmail());
        model.addAttribute("opcion", formulario.getOpcion());
        model.addAttribute("comentario", formulario.getComentario());
        model.addAttribute("condiciones", formulario.isCondiciones());
        return "contactaSubmit";

    }
}
