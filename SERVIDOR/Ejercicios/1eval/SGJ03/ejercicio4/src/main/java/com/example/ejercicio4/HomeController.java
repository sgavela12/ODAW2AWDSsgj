package com.example.ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    Random random = new Random();
    public Set<Integer> lista = new LinkedHashSet<>();

    @GetMapping({"/", "/list"})
    public String showNumber(Model model){
        model.addAttribute("cantidadTotal", lista.size());
        model.addAttribute("listaNumeros", lista);
        return "index";
    }



    @GetMapping("/new")
    public String addNumber(){
        boolean añadido;
        do {
            añadido = lista.add(random.nextInt(100)+1);
            
        } while (!añadido);
        return "redirect:/list";
    }



    @GetMapping("/delete/{id}")
    public String deleteNumber(@PathVariable Integer id){
        lista.remove(id);
        return "redirect:/list";
    }
    
}
