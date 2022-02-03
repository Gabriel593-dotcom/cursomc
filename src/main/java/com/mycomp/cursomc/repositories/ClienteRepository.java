package com.mycomp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycomp.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
