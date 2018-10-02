package com.pgrsoft.gestionpedidos.backend.presentation;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.model.Producto;

public interface ProductoPresentationServices {

	public List<Producto> getAll();
	
	public Producto getById(Long id);
	
	public Producto create(Producto producto);
}

