package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.services.ProductoServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ProductoPresentationServices;

@Service
public class ProductoPresentationServicesImpl implements ProductoPresentationServices {

	@Autowired
	private ProductoServices productoServices;
	
	@Override
	public List<ProductoDTO> getAll() {
		return productoServices.getAll();
	}

	@Override
	public ProductoDTO getById(Long id) {
		return productoServices.getById(id);
	}

	@Override
	public ProductoDTO create(ProductoDTO producto) {
		return productoServices.create(producto);
	}

}
