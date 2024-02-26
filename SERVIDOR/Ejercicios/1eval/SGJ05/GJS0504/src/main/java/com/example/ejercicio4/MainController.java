package com.example.ejercicio4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    @Autowired Ejercicio4service ejercicio4service;


 @GetMapping("/")
    public String mostrarFormulario(Model model) {
        List<String> nombresPaises = ejercicio4service.getPaises();
        model.addAttribute("nombresPaises", nombresPaises);
        model.addAttribute("paisSeleccionado", new Pais());
        return "form";
    }

    @PostMapping("/")
    public String mostrarInformacion(@ModelAttribute("paisSeleccionado") Pais pais, Model model) {
        Pais paisInfo = ejercicio4service.getPais(pais.getNombre());
        model.addAttribute("paisInfo", paisInfo);
        List<String> nombresPaises = ejercicio4service.getPaises();
        model.addAttribute("nombresPaises", nombresPaises);
        return "form";
    }
}
