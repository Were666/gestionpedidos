package com.pgrsoft.gestionpedidos.backend.business.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;

public interface ProductoServices {

	public List<ProductoDTO> getAll();
	
	public ProductoDTO getById(Long id);
	
	public ProductoDTO create(ProductoDTO producto);
	
}
