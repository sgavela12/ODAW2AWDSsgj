package com.example.myshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.myshop.domain.Categoria;
import com.example.myshop.domain.Producto;
import com.example.myshop.domain.TipoIva;
import com.example.myshop.services.CategoriaService;
import com.example.myshop.services.ProductoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(ProductoService productoService, CategoriaService categoriaService) {
		return args -> {
			productoService.añadir(new Producto(1L, "Asus ChromeBook", true, TipoIva.REDUCIDO, 1000d,1L));
			productoService.añadir(new Producto(2L, "Lenovo IdeaPad", false, TipoIva.NORMAL, 2000d,1L));

			productoService.añadir(new Producto(3L, "HP ColorTank", true, TipoIva.SUPERREDUCIDO, 500d,2L));
			productoService.añadir(new Producto(4L, "Canon Pixma", false, TipoIva.REDUCIDO, 800d,2L));

			categoriaService.añadir(new Categoria(1L, "Ordenadores"));
			categoriaService.añadir(new Categoria(2L, "Impresoras"));

		};

	}
}
