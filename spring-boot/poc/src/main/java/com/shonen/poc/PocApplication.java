package com.shonen.poc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.shonen.poc.models.Categoria;
import com.shonen.poc.services.repositories.CategoriaRepository;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

	@Bean
	@Profile("test")
	CommandLineRunner initDatabase(CategoriaRepository categoriaRepository) {
		return args -> {
			categoriaRepository.deleteAll();

			final var category1 = new Categoria();
			category1.setNome("Games");

			final var category2 = new Categoria();
			category2.setNome("Lazer");

			final var category3 = new Categoria();
			category3.setNome("Restaurante");

			categoriaRepository.save(category1);
			categoriaRepository.save(category2);
			categoriaRepository.save(category3);
		};
	}

}
