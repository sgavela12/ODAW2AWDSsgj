package com.odaw2a.GJS1003;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.odaw2a.GJS1003.domain.Empleado;
import com.odaw2a.GJS1003.domain.Genero;
import com.odaw2a.GJS1003.services.EmpleadoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService) {
		return args -> {
			empleadoService.añadir(
					new Empleado(0L, "Pepe", "pepe@gmail.com", 1000d, false, Genero.Masculino));
			empleadoService.añadir(
					new Empleado(0L, "Ana", "ana@gmail.com", 2000d, true, Genero.Femenino));
			empleadoService.añadir(
					new Empleado(0L, "Ariel", "ari@gmail.com", 1700d, true, Genero.Otro));
		};
	}

}
