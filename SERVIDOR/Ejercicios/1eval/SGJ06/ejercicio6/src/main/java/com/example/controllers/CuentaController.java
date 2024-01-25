package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.domain.Cuenta;
import com.example.domain.Movimiento;
import com.example.services.CuentaService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.validation.Valid;

@Controller
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @GetMapping("")
    public String showCuentas(Model model) {

        model.addAttribute("listaCuentas", cuentaService.getListaCuentas());

        return "cuentasView";
    }

    @GetMapping("/nuevaCuenta")
    public String shownuevaCuenta(Model model) {

        model.addAttribute("cuenta", new Cuenta());

        return "nuevaCuentaView";
    }

    @PostMapping("/nuevaCuenta/submit")
    public String shownuevaCuentaForm(@Valid Cuenta cuenta, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "errorView";
        }
        String iban = cuenta.getIban();
        String nombre = cuenta.getNombre();
        cuentaService.altaCuenta(new Cuenta(iban, nombre));
        return "redirect:/";
    }

    @GetMapping("/editar/{iban}")
    public String editarCuenta(@PathVariable String iban, Model model) {
        model.addAttribute("mensajeEditar", "Editar cuenta: " + iban);

        Cuenta cuenta = cuentaService.obtenerPorIban(iban);
        if (cuenta != null) {
            model.addAttribute("editarForm", cuenta);
            return "editarView";
        } else {
            System.out.println("----------------------aqui------------");
            return "redirect:/errorView";

        }

    }

    @PostMapping("/editar/submit")
    public String showEditarCuentaForm(@Valid @ModelAttribute("editarForm") Cuenta cuenta,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "errorView";
        } else {
            cuentaService.editarCuenta(cuenta);

            return "redirect:/";
        }

    }

    @GetMapping("/borrar/{iban}")
    public String borrarCuenta(@PathVariable String iban, Model model) {

        Cuenta cuenta = cuentaService.obtenerPorIban(iban);
        if (cuenta != null) {
            cuentaService.borrarCuenta(cuenta);
            return "redirect:/";
        } else {

            return "redirect:/errorView";

        }

    }

    @GetMapping("/nuevoMovimiento")
    public String shownuevoMovimiento(Model model) {

        model.addAttribute("movimiento", new Movimiento());

        return "nuevoMovimientoView";
    }


    @PostMapping("/nuevoMovimiento/submit")
    public String shownuevoMovimientoForm(@Valid Movimiento movimiento, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "errorView";
        }
    
        String iban = movimiento.getIban();
        float importe = movimiento.getImporte();
    
        Cuenta cuenta = cuentaService.obtenerPorIban(iban);
        Movimiento nuevoMovimiento = new Movimiento(iban, importe);
        cuenta.addMovimiento(nuevoMovimiento);
    
        return "redirect:/";
    }
    

    @GetMapping("/movimientos/{iban}")
    public String showMovimientos(@PathVariable String iban, Model model) {
        model.addAttribute("mensajeEditar", "Movimientos: " + iban);

        Cuenta cuenta = cuentaService.obtenerPorIban(iban);
        if (cuenta != null) {
            model.addAttribute("listaMovimientos", cuenta.getHistorico());
            return "listarMovimientosView";
        } else {
            System.out.println("----------------------aqui------------");
            return "redirect:/errorView";

        }

    }


    
}