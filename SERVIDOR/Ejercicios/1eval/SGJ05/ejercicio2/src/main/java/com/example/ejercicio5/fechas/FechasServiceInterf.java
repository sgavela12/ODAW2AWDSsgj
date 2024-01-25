package com.example.ejercicio5.fechas;

public interface FechasServiceInterf {

    public String muestraDiasTranscurridosPrimeroAño(String fechas);

    public String muestraDiferenciaDias(String fecha1, String fecha2);

    public String comparaFechaHoy();

    public boolean esBisiesto(int año);

    public boolean  obtenBisiestoEnBaseString(String fecha);

    public String muestraAñosBisiestosEntreDosFechas(String fecha1, String fecha2);
}
