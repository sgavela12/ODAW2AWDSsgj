package com.example.ejercicio4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class Ejercicio4service {
    private String rutaCsv = "paises2019.csv";
    private ArrayList<Pais> paises = new ArrayList<>();

  @PostConstruct
    public void cargarPaisesDesdeFichero() {
        try {
            // Lee el archivo CSV y carga los datos en la lista de países
            Path filePath = Path.of(rutaCsv); // Reemplaza con la ruta correcta al archivo CSV
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String nombre = parts[0].trim();
                    String capital = parts[1].trim();
                    long poblacion = Long.parseLong(parts[2].trim());
                    Pais pais = new Pais(nombre, capital, poblacion);
                    paises.add(pais);
                }
            }
        } catch (IOException e) {
            // Manejo de errores, por ejemplo, imprimir el error
            e.printStackTrace();
        }
    }

    public List<String> getPaises() {
        List<String> nombres = new ArrayList<>();
        for (Pais pais : paises) {
            nombres.add(pais.getNombre());
        }
        return nombres;
    }

    public Pais getPais(String nombre) {
        for (Pais pais : paises) {
            if (pais.getNombre().equals(nombre)) {
                return pais;
            }
        }
        return null; // Manejar el caso si el país no se encuentra.
    }

    

   
}
