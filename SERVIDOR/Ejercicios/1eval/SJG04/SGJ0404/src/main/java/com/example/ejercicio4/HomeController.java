package com.example.ejercicio4;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    NumeroRandomService numeroRandomService;

    @GetMapping({ "/", "/list" })
    public String showNumber(Model model) {
        model.addAttribute("cantidadTotal", numeroRandomService.devuelveTamaño());
        model.addAttribute("listaNumeros", numeroRandomService.devuelveLista());
        return "index";
    }

    @GetMapping("/new")
    public String addNumber() {
        numeroRandomService.generaNumero();
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteNumber(@PathVariable Integer id) {
        numeroRandomService.borraNumero(id);
        return "redirect:/list";
    }

}
