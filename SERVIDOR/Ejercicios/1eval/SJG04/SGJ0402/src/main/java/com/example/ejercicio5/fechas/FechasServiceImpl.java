package com.example.ejercicio5.fechas;

import java.time.LocalDate;
import java.time.Year;

import static java.time.temporal.ChronoUnit.DAYS;

import org.springframework.stereotype.Service;

@Service
public class FechasServiceImpl implements FechasServiceInterf {

    public String muestraDiasTranscurridosPrimeroAño(String fechaString) {
        // YYYY-MM-DD
        int año = Integer.parseInt((fechaString.split("-")[0]));

        LocalDate fecha = LocalDate.parse(fechaString);

        LocalDate fechaInicio = LocalDate.of(año, 1, 1);
        return String.valueOf(DAYS.between(fechaInicio, fecha));

    }

    public String muestraDiferenciaDias(String fechaInicioString, String fechaFinalString) {
        LocalDate fechaInicio = LocalDate.parse(fechaInicioString);
        LocalDate fechaFinal = LocalDate.parse(fechaFinalString);

        return String.valueOf(DAYS.between(fechaInicio, fechaFinal));
    }

    public String obtenFechaHoy() {
        LocalDate fecha = LocalDate.now();
        return String.valueOf(fecha);
    }

    public String comparaFechaHoy() {
        return muestraDiasTranscurridosPrimeroAño(obtenFechaHoy());
    }

    public boolean esBisiesto(int año) {
        return Year.isLeap(año);
    }

    public int obtenAño(String fecha) {
        String[] fechaSeparada = fecha.split("-");
        return Integer.parseInt(fechaSeparada[0]);
    }

    public boolean obtenBisiestoEnBaseString(String fecha) {
        return esBisiesto(obtenAño(fecha));
    }

    public String muestraAñosBisiestosEntreDosFechas(String anioInicioString, String anioFinalString) {
        String respuesta = "";
        int anioInicio = obtenAño(anioInicioString);
        int anioFinal = obtenAño(anioFinalString);

        for (; anioInicio < anioFinal; anioInicio++) {
            if (Year.isLeap(anioInicio)) {
                respuesta += " " + anioInicio;
            }
        }
        return respuesta;

    }
}