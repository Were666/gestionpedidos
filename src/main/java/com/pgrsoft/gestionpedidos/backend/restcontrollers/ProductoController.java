package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.business.model.Producto;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ProductoPresentationServices;

@RestController
@RequestMapping(value="/productos")
public class ProductoController {
	
	private Logger logger = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private ProductoPresentationServices productoPresentationServices;
	
	@GetMapping(value="")
	public List<Producto> getAll(){
		
		List<Producto> productos = null;
		
		try {
			productos = productoPresentationServices.getAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			//e.printStackTrace();
		}
		
		return productos;
	}
	
	@GetMapping(value="/{codigo}")
	public Producto getById(@PathVariable ("codigo") Long codigo) {
		
		Producto producto = null;
		
		try {
			producto = productoPresentationServices.getById(codigo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			//e.printStackTrace();
		}
		
		return producto;
	
	}

}
