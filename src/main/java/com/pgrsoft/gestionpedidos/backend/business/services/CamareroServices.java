package com.pgrsoft.gestionpedidos.backend.business.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;

public interface CamareroServices {

	// Operaciones CRUD
	
	public CamareroDTO getById(Long id);
	
	public CamareroDTO create(CamareroDTO camarero);
	
	// Obtención de listas
	
	public List<CamareroDTO> getAll();
	
}
