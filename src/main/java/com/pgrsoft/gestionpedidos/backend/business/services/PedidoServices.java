package com.pgrsoft.gestionpedidos.backend.business.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;

public interface PedidoServices {

	public PedidoDTO getById(Long id) throws Exception;
	
	public List<PedidoDTO> getAll() throws Exception;
	
	//Coming soon
	
	// listados paginados, create, filtros, orden, etc...
	
}
