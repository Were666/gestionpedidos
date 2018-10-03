package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;

public interface ProductoPresentationServices {

	public List<ProductoDTO> getAll() throws Exception;
	
	public ProductoDTO getById(Long id) throws Exception;
	
	public ProductoDTO create(ProductoDTO producto) throws Exception;
	
}
