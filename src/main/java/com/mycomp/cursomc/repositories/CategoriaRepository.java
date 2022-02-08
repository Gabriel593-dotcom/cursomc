package com.mycomp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycomp.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
}
