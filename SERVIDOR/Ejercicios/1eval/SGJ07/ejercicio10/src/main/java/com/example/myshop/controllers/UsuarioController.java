package com.example.myshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myshop.services.UsuarioService;




@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    
    

    @GetMapping({ "", "/" })
    public String showList(Model model) {
        
        return "usuarios/";
    }
}
