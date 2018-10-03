package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;

public interface CamareroPresentationServices {

	public CamareroDTO getById(Long id);
	
	public List<CamareroDTO> getAll();
	
	public CamareroDTO create(CamareroDTO camarero);
	
}
