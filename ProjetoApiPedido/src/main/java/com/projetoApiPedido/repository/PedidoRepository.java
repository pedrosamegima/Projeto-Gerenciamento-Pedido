package com.projetoApiPedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoApiPedido.entities.Pedido;

public interface PedidoRepository extends JpaRepository <Pedido,Long> {

}
