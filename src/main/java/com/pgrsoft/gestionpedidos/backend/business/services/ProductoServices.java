package com.pgrsoft.gestionpedidos.backend.business.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;

public interface ProductoServices {

	public List<ProductoDTO> getAll() throws Exception;
	
	public ProductoDTO getById(Long id) throws Exception;
	
	public ProductoDTO create(ProductoDTO producto) throws Exception;
	
}
