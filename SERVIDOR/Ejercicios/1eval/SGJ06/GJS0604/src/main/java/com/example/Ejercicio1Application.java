package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Categoria;
import com.example.domain.Producto;
import com.example.domain.TipoIva;
import com.example.services.CategoriaServiceImpl;
import com.example.services.ProductoServiceIplm;

@SpringBootApplication
public class Ejercicio1Application {

	@Autowired
	ProductoServiceIplm productoService;
	@Autowired
	CategoriaServiceImpl categoriaService;

	@Bean
	public CommandLineRunner prueba() {
		return args -> {
			productoService.nuevoProducto(new Producto((long)5,"tornillo",false,TipoIva.GENERAL,(double)50));
			productoService.nuevoProducto(new Producto((long)3,"tuerca",true,TipoIva.GENERAL,(double)50));
			productoService.nuevoProducto(new Producto((long)77,"arandela",false,TipoIva.GENERAL,(double)70));

		};

}	


@Bean
	CommandLineRunner prueba2() {
		return args -> {
			categoriaService.addCategoria(new Categoria((long)4888,"Plasticos"));
			categoriaService.addCategoria(new Categoria((long)6555,"Metales"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application.class, args);
	}

}
