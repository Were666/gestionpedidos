package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.presentation.model.ProductoVO;

public interface ProductoPresentationServices {

	public List<ProductoVO> getAll() throws Exception;
	
	public ProductoVO getById(Long id) throws Exception;
	
	public ProductoVO create(ProductoVO producto) throws Exception;
	
}
