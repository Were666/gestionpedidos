package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.services.PedidoServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.PedidoPresentationServices;

@Service
public class PedidoPresentationServicesImpl implements PedidoPresentationServices{

	@Autowired
	private PedidoServices pedidoServices;
	
	@Override
	public PedidoDTO getById(Long id) {
		return pedidoServices.getById(id);
	}

	@Override
	public List<PedidoDTO> getAll() {
		return pedidoServices.getAll();
	}

}
