package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Cuenta;
import com.example.domain.Iban;
import com.example.services.CuentaService;

import jakarta.validation.Valid;

@Controller
public class CuentaController {

    @Autowired
    CuentaService cuentaService;
    
    @GetMapping({"/","/index","/inicio"})
    public String showIndex(Model model){  
        model.addAttribute("cuentas", cuentaService.verCuentas());
        return "index";

    }

    @GetMapping("/nuevaCuenta")
    public String showNuevaCuenta(Model model){
        model.addAttribute("cuenta", new Cuenta());
        return "crearCuenta";
    }

    @PostMapping("/nuevaCuenta/submit")
    public String showSubmitNuevaCuenta(@Valid Cuenta cuenta, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "error";
        cuentaService.nuevaCuenta(cuenta);
        return "redirect:/";
    }

    @GetMapping("/editar/{iban}")
    public String showEditar(@PathVariable String iban, Model model){
        Cuenta cuenta = cuentaService.obtenerPorIban(iban);
        if(cuenta!=null){
            model.addAttribute("cuenta", cuenta);
            return "editarCuenta";
        }
        return "redirect:/";
    }

    @PostMapping("/editarCuenta/submit")
    public String showEditarSubmit(Cuenta cuenta){
        cuentaService.cambiarCuenta(cuenta);
        return "redirect:/";
    }

    @GetMapping("/borrar/{iban}")
    public String showBorrar(@PathVariable String iban){
        cuentaService.borrarCuenta(iban);
        return "redirect:/";
    }
    @GetMapping("/movimientos/{usuario}")
    public String showMovimientos(@PathVariable String usuario, Model model){
        model.addAttribute("movimientos", cuentaService.obtenerMovimientos(usuario));
        return "verMovimientos";
    }

    @GetMapping("/nuevoMovimiento")
    public String showIbanDisponibles(Model model){
        model.addAttribute("listaIbanes", cuentaService.listaIbanes());
        model.addAttribute("ibanElegido", new Iban());
        return "elegirIban";
    }

    @PostMapping("/nuevoMovimiento/submit")
    public String showMovimiento(@Valid Iban ibanElegido, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "errorImporte";
        cuentaService.hacerMovimiento(ibanElegido.getIban(), ibanElegido.getImporte());
        return "redirect:/";
    }


    
}