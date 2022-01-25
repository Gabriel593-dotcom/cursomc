package com.mycomp.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Categoria>> findAll() {
		
		Categoria cat1 = new Categoria(1, "Eletrônicos");
		Categoria cat2 = new Categoria(2, "Eletro-domesticos");
		
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(cat1);
		categorias.add(cat2);
		return ResponseEntity.ok().body(categorias);
	}
}
