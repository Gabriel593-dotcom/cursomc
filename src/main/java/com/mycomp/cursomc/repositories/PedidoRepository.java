package com.mycomp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycomp.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
