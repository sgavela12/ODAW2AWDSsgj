package com.example.ejercicio5.fechas;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fechas")
public class FechasController {

    @Autowired
    FechasServiceInterf fechasService;

    @GetMapping({ "/{fecha}" })
    public ResponseEntity<?> showFechas(@PathVariable String fecha) {

        HashMap<String, String> resultado = new HashMap<String, String>();

        resultado.put("Dias transcurridos", fechasService.muestraDiasTranscurridosPrimeroAño(fecha));
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }
    }

    @GetMapping({ "/{fecha1}/{fecha2}" })
    public ResponseEntity<?> showDiferenciaFechas(@PathVariable String fecha1, @PathVariable String fecha2) {

        HashMap<String, String> resultado = new HashMap<String, String>();

        resultado.put("Dias transcurridos entre " + fecha1 + " " + fecha2,
                fechasService.muestraDiferenciaDias(fecha1, fecha2));
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }

    }

    @GetMapping({ "", "/" })
    public ResponseEntity<?> showDiferenciaFechaHoy() {
        
        HashMap<String, String> resultado = new HashMap<String, String>();

        resultado.put("Dias transcurridos desde hoy", fechasService.comparaFechaHoy());
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }
    }

    @GetMapping({ "/bisiesto/{fecha}" })
    public ResponseEntity<?> showBisiesto(@PathVariable String fecha) {
      

        HashMap<String, Boolean> resultado = new HashMap<String, Boolean>();

        resultado.put(fecha, fechasService.obtenBisiestoEnBaseString(fecha));
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }



    }

    @GetMapping({ "/bisiesto/{fecha1}/{fecha2}" })
    public ResponseEntity<?> showBisiesto(@PathVariable String fecha1, @PathVariable String fecha2) {
       
        HashMap<String, String> resultado = new HashMap<String, String>();

        resultado.put("bisiestos entre "+fecha1+" y "+fecha2, fechasService.muestraAñosBisiestosEntreDosFechas(fecha1, fecha2));
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resultado);
        }

    }

}
