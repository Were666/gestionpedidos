package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;

public interface CamareroPresentationServices {

	public CamareroDTO getById(Long id) throws Exception;
	
	public List<CamareroDTO> getAll() throws Exception;
	
	public CamareroDTO create(CamareroDTO camarero) throws Exception;
	
}
