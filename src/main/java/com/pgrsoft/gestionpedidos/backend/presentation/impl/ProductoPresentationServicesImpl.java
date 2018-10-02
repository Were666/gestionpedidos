package com.pgrsoft.gestionpedidos.backend.presentation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.model.Producto;
import com.pgrsoft.gestionpedidos.backend.presentation.ProductoPresentationServices;
import com.pgrsoft.gestionpedidos.backend.services.ProductoServices;

@Service
public class ProductoPresentationServicesImpl implements ProductoPresentationServices {

	@Autowired
	private ProductoServices productoServices;
	
	@Override
	public List<Producto> getAll() {
		return productoServices.getAll();
	}

	@Override
	public Producto getById(Long id) {
		return productoServices.getById(id);
	}

	@Override
	public Producto create(Producto producto) {
		return productoServices.create(producto);
	}

}
