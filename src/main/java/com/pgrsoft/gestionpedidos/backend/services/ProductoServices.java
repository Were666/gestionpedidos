package com.pgrsoft.gestionpedidos.backend.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.model.Producto;

public interface ProductoServices {

	public List<Producto> getAll();
	
	public Producto getById(Long id);
	
	public Producto create(Producto producto);
	
}
