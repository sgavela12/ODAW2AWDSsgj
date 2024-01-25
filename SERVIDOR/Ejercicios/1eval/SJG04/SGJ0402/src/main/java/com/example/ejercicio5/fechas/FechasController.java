package com.example.ejercicio5.fechas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fechas")
public class FechasController {

    @Autowired
    FechasServiceInterf fechasService;

    @GetMapping({ "/{fecha}" })
    public String showFechas(@PathVariable String fecha, Model model) {
        model.addAttribute("diferencia", fechasService.muestraDiasTranscurridosPrimeroAño(fecha));
        return "fechas";
    }

    @GetMapping({ "/{fecha1}/{fecha2}" })
    public String showDiferenciaFechas(@PathVariable String fecha1, @PathVariable String fecha2, Model model) {
        model.addAttribute("diferencia", fechasService.muestraDiferenciaDias(fecha1, fecha2));
        return "fechas";
    }

    @GetMapping({ "", "/" })
    public String showDiferenciaFechaHoy(Model model) {
        model.addAttribute("diferencia", fechasService.comparaFechaHoy());
        return "fechas";
    }

    @GetMapping({ "/bisiesto/{fecha}" })
    public String showBisiesto(@PathVariable String fecha, Model model) {
        String mensaje = "";
        if (fechasService.obtenBisiestoEnBaseString(fecha)) {
            mensaje = "En le fecha " + fecha + " el año es bisiesto";
        } else {
            mensaje = "En le fecha " + fecha + " el año no es bisiesto";
        }
        model.addAttribute("diferencia", mensaje);
        return "fechas";
    }

    @GetMapping({ "/bisiesto/{fecha1}/{fecha2}" })
    public String showBisiesto(@PathVariable String fecha1, @PathVariable String fecha2, Model model) {
            String respuesta = "Los años bisiestos entre " + fecha1 + " y " + fecha2 + " son "
                + fechasService.muestraAñosBisiestosEntreDosFechas(fecha1, fecha2);
        model.addAttribute("diferencia", respuesta);
        return "fechas";

    }

}
