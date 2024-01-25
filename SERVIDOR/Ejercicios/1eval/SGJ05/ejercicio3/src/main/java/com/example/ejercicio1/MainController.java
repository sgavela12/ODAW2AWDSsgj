package com.example.ejercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // anotación controlador
public class MainController {

    @GetMapping({ "/", "/home", "" }) // ruta a la que responde por GET
    public String showHome(@RequestParam(required = false) String nombre, Model model) {
        LocalDate fecha = LocalDate.now();
        model.addAttribute("ano", fecha.getYear());
        model.addAttribute("nombre", nombre);

        return "indexView"; // vista que devuelve
    }

    @GetMapping("/quienes-somos")
    public String showAboutUs (Model model) {
        ArrayList<String> empleados = new ArrayList<>(Arrays.asList("Pepe", "Eva", "Luis"));
        model.addAttribute("empleados", empleados);
        return "quienes-somosView";

    }

    @GetMapping("/producto")
    public String showProducto(Model model) {
        ArrayList<String> lista = new ArrayList<>(Arrays.asList("Ordenador", "Papelera", "Mochila", "Silla"));

        model.addAttribute("lista", lista);
        return "productoView";

    }


    @GetMapping("/resta/")
    public String showMe(@RequestParam(required = false, defaultValue = "0") Integer numero1,
            @RequestParam(required = false, defaultValue = "0") Integer numero2,
            Model model) {
        Integer resultado = numero1 - numero2;
        model.addAttribute("num1", numero1);
        model.addAttribute("num2", resultado);
        model.addAttribute("resultado", resultado);
        return "resta";
    }

    
    @GetMapping("/contacta")
    public String showContacta(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "contactaView";

    }



    @PostMapping("/contacta/submit")
    public String contactaSubmit(@ModelAttribute Contacto contacto, Model model){
        System.out.println(contacto);
        return"contactaView";
    }

}
