package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Producto;
import com.pgrsoft.gestionpedidos.backend.business.services.ProductoServices;
import com.pgrsoft.gestionpedidos.backend.presentation.model.ProductoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ProductoPresentationServices;

@Service
public class ProductoPresentationServicesImpl implements ProductoPresentationServices {

	@Autowired
	private ProductoServices productoServices;
	
	@Autowired
//	@Qualifier(value="genericConverter")
	private DozerBeanMapper dozerBeanMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoVO> getAll() throws Exception {
		
		List<ProductoVO> productosVO =  null;
		
		try {
			final List<Producto> productos = productoServices.getAll(); 
			productosVO = dozerBeanMapper.map(productos, List.class);
		} catch (Exception e) {
			throw new Exception (e.getMessage());
		}
		
		return productosVO;
	}

	@Override
	public ProductoVO getById(Long id) throws Exception{
		
		ProductoVO productoVO = null;
		
		try {
			final Producto producto = productoServices.getById(id);
			productoVO = dozerBeanMapper.map(producto, ProductoVO.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return productoVO;
	}

	@Override
	public ProductoVO create(ProductoVO newProductoVO) throws Exception {
		
		ProductoVO createdProductoVO = null;
		
		try {
			final Producto newProducto = dozerBeanMapper.map(newProductoVO, Producto.class);
			final Producto createdProducto = productoServices.create(newProducto);
			createdProductoVO = dozerBeanMapper.map(createdProducto, ProductoVO.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return createdProductoVO;
	}

}
