package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Producto;
import com.pgrsoft.gestionpedidos.backend.business.services.ProductoServices;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ProductoPresentationServices;

@Service
public class ProductoPresentationServicesImpl implements ProductoPresentationServices {

	@Autowired
	private ProductoServices productoServices;
	
	@Override
	public List<Producto> getAll() throws Exception {
		
		List<Producto> productos =  null;
		
		try {
			 productos = productoServices.getAll(); 
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
		
		return productos;
	}

	@Override
	public Producto getById(Long id) throws Exception{
		
		Producto producto = null;
		
		try {
			producto = productoServices.getById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return producto;
	}

	@Override
	public Producto create(Producto producto) throws Exception {
		
		Producto createdProducto = null;
		
		try {
			createdProducto = productoServices.create(producto);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return createdProducto;
	}

}
