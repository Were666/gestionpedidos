package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.business.model.Pedido;

public interface PedidoPresentationServices {

	public Pedido getById(Long id) throws Exception;
	
	public List<Pedido> getAll() throws Exception;
	
}
