package com.example;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Cadena miCadena = new Cadena();
        miCadena.pideCadena();
        miCadena.separaCadena();
        miCadena.ordenaCadena();
        miCadena.imprimeResultados(miCadena.CuentaYElimina());
    }
     



    
}
