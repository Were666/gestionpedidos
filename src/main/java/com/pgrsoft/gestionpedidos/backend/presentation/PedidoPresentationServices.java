package com.pgrsoft.gestionpedidos.backend.presentation;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.model.Pedido;

public interface PedidoPresentationServices {

	public Pedido getById(Long id);
	
	public List<Pedido> getAll();
	
}
