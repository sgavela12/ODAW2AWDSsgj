package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Producto;
import com.example.domain.TipoIva;
import com.example.services.ProductoServiceIplm;

@SpringBootApplication
public class Ejercicio1Application {

	@Autowired
	ProductoServiceIplm productoService;

	@Bean
	public CommandLineRunner metodo() {
		return args -> {
			productoService.nuevoProducto(new Producto((long)5,"tornillo",false,TipoIva.GENERAL,(double)50));
			productoService.nuevoProducto(new Producto((long)3,"tuerca",true,TipoIva.GENERAL,(double)50));
			productoService.nuevoProducto(new Producto((long)77,"arandela",false,TipoIva.GENERAL,(double)70));

		};
}	

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
	}

}
