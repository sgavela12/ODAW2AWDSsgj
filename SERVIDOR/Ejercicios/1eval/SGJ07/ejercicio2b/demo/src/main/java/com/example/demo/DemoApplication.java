package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Departamento;
import com.example.demo.domain.Empleado;
import com.example.demo.domain.Genero;
import com.example.demo.services.DepartamentoService;
import com.example.demo.services.EmpleadoService;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService,
		DepartamentoService departamentoService) {
	return args -> {
		departamentoService.nuevoDepartamento(new Departamento(0L, "Informática"));
		departamentoService.nuevoDepartamento(new Departamento(0L, "RRHH"));

		empleadoService.añadir(new Empleado(0L, "pepe", "pepe@gmail.com", 
		800d, true, 
		Genero.MASCULINO, departamentoService.obtenerPorNombre("Informática")));

		empleadoService.añadir(new Empleado(2L, "laura", "laura@gmail.com", 
		8000d, false, 
		Genero.FEMENINO, departamentoService.obtenerPorNombre("RRHH")));

		empleadoService.añadir(new Empleado(3L, "paula", "paula@gmail.com", 
		7000d, true, 
		Genero.OTROS, departamentoService.obtenerPorNombre("RRHH")));
		};
	}
}
