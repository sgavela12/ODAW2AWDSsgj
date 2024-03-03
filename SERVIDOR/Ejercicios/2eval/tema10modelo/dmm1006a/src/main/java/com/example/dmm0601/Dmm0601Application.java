package com.example.dmm0601;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.dmm0601.Domain.Empleado;
import com.example.dmm0601.Domain.Genero;
import com.example.dmm0601.Services.EmpleadoServiceImpl;

@SpringBootApplication
public class Dmm0601Application {

	public static void main(String[] args) {
		SpringApplication.run(Dmm0601Application.class, args);
	}
	@Bean
	CommandLineRunner initData(EmpleadoServiceImpl empleadoService) {
		return args -> {
		empleadoService.añadir(
			new Empleado(1L, "pepe", "pepe@gmail.com", 1000d, true, Genero.MASCULINO));
		empleadoService.añadir(
			new Empleado(2L, "ana", "ana@gmail.com", 2000d, true, Genero.FEMENINO));
		};
	}
}
