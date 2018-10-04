package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Pedido;
import com.pgrsoft.gestionpedidos.backend.business.services.PedidoServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.PedidoPresentationServices;

@Service
public class PedidoPresentationServicesImpl implements PedidoPresentationServices{

	@Autowired
	private PedidoServices pedidoServices;
	
	@Override
	public Pedido getById(Long id) throws Exception {
		
		Pedido pedido = null;
		
		try {
			pedido = pedidoServices.getById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		
		
		return pedido;
	}

	@Override
	public List<Pedido> getAll() throws Exception {
		
		List<Pedido> pedidos = null;
		
		try {
			pedidos = pedidoServices.getAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return pedidos;
	}

}
