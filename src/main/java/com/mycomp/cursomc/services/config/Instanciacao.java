package com.mycomp.cursomc.services.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mycomp.cursomc.domain.Categoria;
import com.mycomp.cursomc.repositories.CategoriaRepository;


@Configuration
public class Instanciacao implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "Eletro-domesticos");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}
	
}
