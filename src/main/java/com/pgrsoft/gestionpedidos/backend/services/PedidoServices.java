package com.pgrsoft.gestionpedidos.backend.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.model.Pedido;

public interface PedidoServices {

	public Pedido getById(Long id);
	
	public List<Pedido> getAll();
	
	//Coming soon
	
	// listados paginados, create, filtros, orden, etc...
	
}
