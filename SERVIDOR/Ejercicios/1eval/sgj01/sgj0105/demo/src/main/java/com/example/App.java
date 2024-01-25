package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Ascensor miAscensor = new Ascensor();
        Radio miRadio = new Radio();
        Termostato miTermostato = new Termostato();
        ArrayList<Elemento> elementos = new ArrayList<>(Arrays.asList(miAscensor, miRadio, miTermostato));
        Menu.start(elementos);

    }

}
