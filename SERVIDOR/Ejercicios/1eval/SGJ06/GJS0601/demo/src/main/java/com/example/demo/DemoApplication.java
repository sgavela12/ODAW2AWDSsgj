package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Empleado;
import com.example.demo.domain.Genero;
import com.example.demo.services.EmpleadoServiceImpl;

@SpringBootApplication
public class DemoApplication {
public static void main(String[] args) {
SpringApplication.run(DemoApplication.class, args);
}
@Bean
CommandLineRunner initData(EmpleadoServiceImpl empleadoService) {
return args -> {
empleadoService.añadir(
new Empleado(1L, "Jose", "josillo@gmail.com", 1000d, true, Genero.MASCULINO));
empleadoService.añadir(
new Empleado(2L, "juan", "juan@gmail.com", 2000d, true, Genero.FEMENINO));
};
}
}