package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.domain.Cuenta;
import com.example.demo.domain.IbanElegido;
import com.example.demo.domain.Movimiento;
import com.example.demo.domain.dto.NuevaCuentaDto;
import com.example.demo.exception.CuentaNotFoundException;
import com.example.demo.services.BancoServicioImplBD;

@RestController
@RequestMapping("/api")
public class BancoController {

    @Autowired
    BancoServicioImplBD bancoServicio;

    @GetMapping("/cuentas")
    public List<Cuenta> getCuentas() {
        try {
            return bancoServicio.verCuentas();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/cuenta/{iban}")
    public Cuenta getCuentaByIban(@PathVariable String iban) {
        try {
            return bancoServicio.obtenerPorIban(iban);
        } catch (CuentaNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/cuenta")
    public Cuenta createCuenta(@RequestBody NuevaCuentaDto nuevaCuentaDto) {
        try {
            Cuenta nuevaCuenta = bancoServicio.convertDtoToCuenta(nuevaCuentaDto);
            return bancoServicio.nuevaCuenta(nuevaCuenta);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @PostMapping("/movimiento")
    public Movimiento hacerMovimiento(@RequestBody IbanElegido ibanElegido) {
        try {
            return bancoServicio.hacerMovimiento(ibanElegido.getIban(), ibanElegido.getImporte());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @DeleteMapping("/borrar/{iban}")
    public void deleteElement(@PathVariable String iban) {
        try {
            bancoServicio.borrarCuenta(iban);
            
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
           
    }

}
