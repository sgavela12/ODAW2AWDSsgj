package com.example.GJS1006;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.GJS1006.domain.Empleado;
import com.example.GJS1006.domain.Genero;
import com.example.GJS1006.services.EmpleadoService;

@SpringBootApplication
public class GJS1006Application {

	public static void main(String[] args) {
		SpringApplication.run(GJS1006Application.class, args);
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
