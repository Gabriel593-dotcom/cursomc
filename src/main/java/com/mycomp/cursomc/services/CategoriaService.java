package com.mycomp.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycomp.cursomc.domain.Categoria;
import com.mycomp.cursomc.repositories.CategoriaRepository;
import com.mycomp.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}
	
	public Categoria inserirCategoria(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria alterar(Categoria obj) {
		buscar(obj.getId());
		return repo.save(obj);
	}
	
	public void deletar(Integer id) {
		buscar(id);
		repo.deleteById(id);
	}
}
