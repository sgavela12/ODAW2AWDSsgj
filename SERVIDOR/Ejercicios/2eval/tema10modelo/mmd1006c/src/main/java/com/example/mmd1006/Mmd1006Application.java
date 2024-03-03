package com.example.mmd1006;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.mmd1006.domain.Empleado;
import com.example.mmd1006.domain.Genero;
import com.example.mmd1006.services.EmpleadoService;

@SpringBootApplication
public class Mmd1006Application {

	public static void main(String[] args) {
		SpringApplication.run(Mmd1006Application.class, args);
	}
	
	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService) {
		return args -> {
			empleadoService.añadir(
					new Empleado(0L, "pepe", "pepe@gmail.com", 1000d, true, Genero.MASCULINO));
			empleadoService.añadir(
					new Empleado(0L, "ana", "ana@gmail.com", 2000d, true, Genero.FEMENINO));
		};
	}
}
