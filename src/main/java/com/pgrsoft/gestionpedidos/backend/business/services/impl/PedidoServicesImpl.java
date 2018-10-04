package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.services.PedidoServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.PedidoRepository;

@Service
public class PedidoServicesImpl implements PedidoServices {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public PedidoDTO getById(Long id) {
		
		// TODO mirar funcionamiento getOne vs findById
		
		Optional<PedidoDTO> optional = pedidoRepository.findById(id);
		
		PedidoDTO pedido = null;
		
		if (optional.isPresent()) {
			pedido = optional.get();
		}
		
		System.out.println("Pedido fuera de la caja Optional: " + pedido);
		
		return pedido;
	}

	@Override
	public List<PedidoDTO> getAll() {
		return pedidoRepository.findAll();
	}

}
