package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;

public interface PedidoPresentationServices {

	public PedidoDTO getById(Long id) throws Exception;
	
	public List<PedidoDTO> getAll() throws Exception;
	
}
