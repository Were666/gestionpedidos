package com.pgrsoft.gestionpedidos.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.model.Producto;
import com.pgrsoft.gestionpedidos.backend.repositories.ProductoRepository;
import com.pgrsoft.gestionpedidos.backend.services.ProductoServices;

@Service
public class ProductoServicesImpl implements ProductoServices {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}

	@Override
	public Producto getById(Long id) {
		return productoRepository.getOne(id);
	}

	@Override
	public Producto create(Producto producto) {
		return productoRepository.save(producto);
	}

}
