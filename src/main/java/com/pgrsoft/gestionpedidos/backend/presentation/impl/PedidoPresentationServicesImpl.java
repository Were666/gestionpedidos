package com.pgrsoft.gestionpedidos.backend.presentation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.model.Pedido;
import com.pgrsoft.gestionpedidos.backend.presentation.PedidoPresentationServices;
import com.pgrsoft.gestionpedidos.backend.services.PedidoServices;

@Service
public class PedidoPresentationServicesImpl implements PedidoPresentationServices{

	@Autowired
	private PedidoServices pedidoServices;
	
	@Override
	public Pedido getById(Long id) {
		return pedidoServices.getById(id);
	}

	@Override
	public List<Pedido> getAll() {
		return pedidoServices.getAll();
	}

}
