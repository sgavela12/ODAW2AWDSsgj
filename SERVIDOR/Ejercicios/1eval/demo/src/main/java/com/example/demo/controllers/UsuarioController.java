package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {



@GetMapping("/") //ruta a la que responde por GET
public String showHome() {
return "index"; //vista que devuelve
}
}


