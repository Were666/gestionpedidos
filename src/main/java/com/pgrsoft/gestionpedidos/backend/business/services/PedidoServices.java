package com.pgrsoft.gestionpedidos.backend.business.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.business.model.Pedido;

public interface PedidoServices {

	public Pedido getById(Long id) throws Exception;
	
	public List<Pedido> getAll() throws Exception;
	
	public Pedido create(Pedido pedido) throws Exception;
	
}
