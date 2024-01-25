package com.example.ejercicio4;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class NumeroRandomService implements NumeroRandomInterf {

    Random random = new Random();
    public Set<Integer> lista = new LinkedHashSet<>();

    public Set<Integer> devuelveLista() {
        return lista;
    }

    public void generaNumero() {
        boolean añadido;
        do {
            añadido = lista.add(random.nextInt(100) + 1);

        } while (!añadido);
    }

    public void borraNumero(int id) {
        lista.remove(id);
    }

    public int devuelveTamaño() {
        return lista.size();
    }
}