package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.business.model.Producto;

public interface ProductoPresentationServices {

	public List<Producto> getAll() throws Exception;
	
	public Producto getById(Long id) throws Exception;
	
	public Producto create(Producto producto) throws Exception;
	
}
