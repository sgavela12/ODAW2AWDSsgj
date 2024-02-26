package com.example.ejercicio5.calculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/calculos")
public class MainController {

    @Autowired
    CalculoServiceInterf calculoService;

    @GetMapping({ "", "/" })
    public String showMain() {
        return "calculos";

    }

    @PostMapping("/primo/{numero}")
    public String calculoPrimo(@ModelAttribute CalculoFormInfo calculoFormInfo ,@PathVariable Integer numero, Model model) {
        String respuesta = calculoService.esPrimo(numero) ? "El numero es primo" : "El numero no es primo";
        model.addAttribute("respuesta", respuesta);

        return "calculos";
    }

    @GetMapping("/primo/")
    public String showError() {
        return "error";

    }

    @GetMapping("/hipotenusa/{x}/{y}")
    public String calculaHipotenusa(@PathVariable Integer x, @PathVariable Integer y, Model model) {

        if (x < 0 || y < 0) {
            return "error";
        } else {
            String respuesta = String.valueOf(calculoService.calculaHipotenusa(x, y));
            model.addAttribute("respuesta", "La hipotenusa de " + y + " y " + x + " es " + respuesta);
            return "calculos";
        }

    }

    @GetMapping("/sinRepetidos/{x}")
    public String numeroAleatorio(@PathVariable Integer x, Model model) {

        if (x >= 1 && x <= 100) {
            model.addAttribute("numeros", calculoService.generaAleatorios(x));
            System.out.println(calculoService.generaAleatorios(x));
            return "calculos";
        } else {
            return "error";
        }

    }

    @GetMapping("/divisores/{x}")
    public String divisores(@PathVariable Integer x, Model model) {
        model.addAttribute("divisores", calculoService.generaDivisores(x));
        return "calculos";

    }

    @GetMapping("/divisores")
    public String divisoresQuery(@RequestParam Integer num, Model model) {
        model.addAttribute("divisores", calculoService.generaDivisores(num));
        return "calculos";

    }



}
