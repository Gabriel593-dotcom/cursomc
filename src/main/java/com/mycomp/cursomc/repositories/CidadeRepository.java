package com.mycomp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycomp.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
