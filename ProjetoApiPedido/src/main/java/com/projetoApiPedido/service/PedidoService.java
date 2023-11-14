package com.projetoApiPedido.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoApiPedido.entities.Pedido;
import com.projetoApiPedido.repository.PedidoRepository;

@Service
public class PedidoService {
	private final PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	public List<Pedido> buscaTodosPedidos(){
		return pedidoRepository.findAll();
	}
	public Pedido buscaPedidoId(Long id) {
		Optional<Pedido> Pedido = pedidoRepository.findById(id);
		return Pedido.orElse(null);
	}
	public Pedido salvaPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	public Pedido alterarPedido(Long id, Pedido alteraPedido) {
		Optional <Pedido> existePedido= pedidoRepository.findById(id);
		if(existePedido.isPresent()) {
			alteraPedido.setId(id);
			return pedidoRepository.save(alteraPedido);
		}
		return null;
	}
	public boolean apagarPedido(Long id) {
		Optional <Pedido> existePedido = pedidoRepository.findById(id);
		if (existePedido.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
