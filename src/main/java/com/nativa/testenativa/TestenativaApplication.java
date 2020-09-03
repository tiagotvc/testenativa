package com.nativa.testenativa;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nativa.testenativa.domain.Marca;
import com.nativa.testenativa.repositories.MarcaRepository;

@SpringBootApplication
public class TestenativaApplication implements CommandLineRunner {

	
	private MarcaRepository marcaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestenativaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		Marca mar1 = new Marca(null, "Informatica");
		Marca mar2 = new Marca(null, "Escritorio");
		
		marcaRepository.saveAll(Arrays.asList(mar1,mar2));
		
	}

}
