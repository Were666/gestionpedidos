package com.pgrsoft.gestionpedidos.backend.presentation;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.model.Camarero;

public interface CamareroPresentationServices {

	public Camarero getById(Long id);
	
	public List<Camarero> getAll();
	
	public Camarero create(Camarero camarero);
	
}
