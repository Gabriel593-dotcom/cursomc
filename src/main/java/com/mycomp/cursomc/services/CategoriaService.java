package com.mycomp.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycomp.cursomc.domain.Categoria;
import com.mycomp.cursomc.repositories.CategoriaRepository;
import com.mycomp.cursomc.services.exceptions.DataIntegrityViolationExceptionCustom;
import com.mycomp.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public List<Categoria> findAll() {
		return repo.findAll();
	}

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);

		} catch (Exception e) {
			throw new DataIntegrityViolationExceptionCustom(
					"Não é possível excluir uma Categoria que possui produtos atrelados.");
		}

	}
}
