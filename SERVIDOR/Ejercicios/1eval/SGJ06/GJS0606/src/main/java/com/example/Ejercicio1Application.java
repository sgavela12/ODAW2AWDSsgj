package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Cuenta;
import com.example.services.CuentaService;

@SpringBootApplication
public class Ejercicio1Application {
	@Autowired CuentaService cuentaService;



	@Bean
	public CommandLineRunner metodo(){
		return args ->{
			cuentaService.nuevaCuenta(new Cuenta("12345678","Pepe",(double)12000));
			cuentaService.nuevaCuenta(new Cuenta ("87654321","Juan",(double)700));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
	}

}
