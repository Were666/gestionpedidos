package com.pgrsoft.gestionpedidos.backend.business.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;

public interface CamareroServices {

	public CamareroDTO getById(Long id) throws Exception;
	
	public CamareroDTO create(CamareroDTO camarero) throws Exception;
	
	public List<CamareroDTO> getAll() throws Exception;
	
}
