package com.pgrsoft.gestionpedidos.backend.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.model.Camarero;

public interface CamareroServices {

	// Operaciones CRUD
	
	public Camarero getById(Long id);
	
	public Camarero create(Camarero camarero);
	
	// Obtención de listas
	
	public List<Camarero> getAll();
	
}
