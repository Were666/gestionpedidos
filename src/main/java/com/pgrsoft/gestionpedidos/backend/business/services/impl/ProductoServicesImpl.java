package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Producto;
import com.pgrsoft.gestionpedidos.backend.business.services.ProductoServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoRepository;

@Service
public class ProductoServicesImpl implements ProductoServices {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	@Qualifier(value="genericConverter")
	private DozerBeanMapper dozerBeanMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> getAll() {
		final List<ProductoDTO> productosDTO = productoRepository.findAll();
		final List<Producto> productos = dozerBeanMapper.map(productosDTO, List.class);
		return productos;
	}

	@Override
	public Producto getById(Long id) {
		final ProductoDTO productoDTO = productoRepository.getOne(id);
		final Producto producto = dozerBeanMapper.map(productoDTO, Producto.class);
		return producto;
	}

	@Override
	public Producto create(Producto producto) {
		final ProductoDTO productoDTO = dozerBeanMapper.map(producto, ProductoDTO.class);
		final ProductoDTO createdProductoDTO = productoRepository.save(productoDTO);
		return dozerBeanMapper.map(createdProductoDTO, Producto.class);
	}

}
