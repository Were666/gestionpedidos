package com.pgrsoft.gestionpedidos.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.model.Pedido;
import com.pgrsoft.gestionpedidos.backend.repositories.PedidoRepository;
import com.pgrsoft.gestionpedidos.backend.services.PedidoServices;

@Service
public class PedidoServicesImpl implements PedidoServices {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido getById(Long id) {
		return pedidoRepository.getOne(id);
	}

	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

}
