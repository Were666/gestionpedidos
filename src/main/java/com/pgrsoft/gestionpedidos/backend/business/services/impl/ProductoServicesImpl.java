package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.services.ProductoServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoRepository;

@Service
public class ProductoServicesImpl implements ProductoServices {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<ProductoDTO> getAll() {
		return productoRepository.findAll();
	}

	@Override
	public ProductoDTO getById(Long id) {
		return productoRepository.getOne(id);
	}

	@Override
	public ProductoDTO create(ProductoDTO producto) {
		return productoRepository.save(producto);
	}

}
