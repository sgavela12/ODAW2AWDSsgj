package com.example.ejercicio5.calculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculos")
public class MainController {

    @Autowired
    CalculoServiceInterf calculoService;

    @GetMapping("/primo/{numero}")
    public ResponseEntity<?> calculoPrimo(@PathVariable Integer numero) {

        HashMap<Integer, Boolean> resultado = new HashMap<Integer, Boolean>();
        resultado.put(numero, calculoService.esPrimo(numero));
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }

    }

    @GetMapping("/primo/")
    public String showError() {
        return "error";

    }

    @GetMapping("/hipotenusa/{x}/{y}")
    public ResponseEntity<?> calculaHipotenusa(@PathVariable Integer x, @PathVariable Integer y) {

        HashMap<String, Float> resultado = new HashMap<String, Float>();
        resultado.put("Hipotenusa " + x + " " + y, calculoService.calculaHipotenusa(x, y));
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }
    }

    @GetMapping("/sinRepetidos/{x}")
    public ResponseEntity<?> numeroAleatorio(@PathVariable Integer x) {
        HashMap<String, List<Integer>> resultado = new HashMap<String, List<Integer>>();
        List<Integer> listaNumeros =calculoService.generaAleatorios(x);
        resultado.put("Lista Numeros", listaNumeros);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }
    }

    @GetMapping("/divisores/{x}")
    public ResponseEntity<?> divisores(@PathVariable Integer x) {
        

        HashMap<String, List<Integer>> resultado = new HashMap<String, List<Integer>>();
        List<Integer> listaDivisores =calculoService.generaDivisores(x);
        resultado.put("Lista Divisores", listaDivisores);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }

    }

    @GetMapping("/divisores")
    public ResponseEntity<?> divisoresQuery(@RequestParam Integer num) {
        
        HashMap<String, List<Integer>> resultado = new HashMap<String, List<Integer>>();
        List<Integer> listaDivisores =calculoService.generaDivisores(num);
        resultado.put("Lista Divisores", listaDivisores);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }

    }
}
