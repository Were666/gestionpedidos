package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;

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
		return pedidoRepository.getOne(id);
	}

	@Override
	public List<PedidoDTO> getAll() {
		return pedidoRepository.findAll();
	}

}
