package com.example.ejercicio5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;

@Controller
public class MainController {

    @Autowired
    CalculoService calculoService;

    @RequestMapping({ "/calculos", "/" })
    public String showMe() {
        return "index";
    }

    @GetMapping("/calculos/primo/{numero}")
    public String calculoPrimo(@PathVariable Integer numero, Model model) {
        String respuesta = calculoService.esPrimo(numero) ? "El numero es primo" : "El numero no es primo";
        model.addAttribute("respuesta", respuesta);

        return "index";
    }

    @GetMapping("/calculos/primo/")
    public String showError() {
        return "error";

    }

    @GetMapping("/calculos/hipotenusa/{x}/{y}")
    public String calculaHipotenusa(@PathVariable Integer x, @PathVariable Integer y, Model model) {
        
        
        if (x < 0 || y < 0) {
            return "error";
        } else {
            String respuesta = String.valueOf(calculoService.calculaHipotenusa(x, y));
            model.addAttribute("respuesta", "La hipotenusa de " + y + " y " + x + " es " + respuesta);
            return "index";
        }

    }

    @GetMapping("/calculos/sinRepetidos/{x}")
    public String numeroAleatorio(@PathVariable Integer x, Model model) {

        if (x >= 1 && x <= 100) {
            model.addAttribute("numeros", calculoService.generaAleatorios(x));
            System.out.println(calculoService.generaAleatorios(x));
            return "index";
        } else {
            return "error";
        }

    }

    @GetMapping("/calculos/divisores/{x}")
    public String divisores(@PathVariable Integer x, Model model) {
        model.addAttribute("divisores", calculoService.generaDivisores(x));
        return "index";

    }

    @GetMapping("/calculos/divisores")
    public String divisoresQuery(@RequestParam Integer num, Model model) {
        model.addAttribute("divisores", calculoService.generaDivisores(num));
        return "index";

    }
}