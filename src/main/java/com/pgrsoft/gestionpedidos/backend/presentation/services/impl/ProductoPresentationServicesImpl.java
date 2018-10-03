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
	public List<ProductoDTO> getAll() throws Exception {
		
		List<ProductoDTO> productos =  null;
		
		try {
			 productos = productoServices.getAll(); 
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
		
		return productos;
	}

	@Override
	public ProductoDTO getById(Long id) throws Exception{
		
		ProductoDTO producto = null;
		
		try {
			producto = productoServices.getById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return producto;
	}

	@Override
	public ProductoDTO create(ProductoDTO producto) throws Exception {
		
		ProductoDTO createdProducto = null;
		
		try {
			createdProducto = productoServices.create(producto);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return createdProducto;
	}

}
