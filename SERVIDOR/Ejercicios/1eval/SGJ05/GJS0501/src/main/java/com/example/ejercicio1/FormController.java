package com.example.ejercicio1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuestionario")
public class FormController {

    @GetMapping("")
    public String showCuestionario(Model model){
        model.addAttribute("", new FormInfo());
        return "cuestionario";
    }

    @PostMapping("/enviar")
    public String showEnviar(@ModelAttribute FormInfo formInfo){
        return "cuestionarioEnviar";
    }
}
