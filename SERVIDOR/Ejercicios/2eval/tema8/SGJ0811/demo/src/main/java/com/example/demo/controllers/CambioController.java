package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.FormInfo;
import com.example.demo.services.CambioService;

import jakarta.validation.Valid;

@Controller
public class CambioController {

    @Autowired
    CambioService cambioService;

    @GetMapping({ "/" })
    public String showList(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "indexView";
    }

    @PostMapping("/cambioMoneda")
    public String showNew(
            @Valid FormInfo formInfo,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/";

        }
        Double importeCambiado = cambioService.calcularImporteCambiado(formInfo.getMonedaOrigen(),
                formInfo.getMonedaDestino(), formInfo.getImporte());
                model.addAttribute("importeCambiado", importeCambiado);
        return "resultView";
    }

}
