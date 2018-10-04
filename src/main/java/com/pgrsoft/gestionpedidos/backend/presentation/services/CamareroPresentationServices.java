package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;

public interface CamareroPresentationServices {

	public Camarero getById(Long id) throws Exception;
	
	public List<Camarero> getAll() throws Exception;
	
	public Camarero create(Camarero camarero) throws Exception;
	
}
