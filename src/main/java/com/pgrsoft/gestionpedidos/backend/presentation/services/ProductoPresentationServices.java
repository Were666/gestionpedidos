package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;

public interface ProductoPresentationServices {

	public List<ProductoDTO> getAll();
	
	public ProductoDTO getById(Long id);
	
	public ProductoDTO create(ProductoDTO producto);
}

