package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ProductoPresentationServices;

@RestController
@RequestMapping(value="/productos")
public class ProductoController {

	@Autowired
	private ProductoPresentationServices productoPresentationServices;
	
	@GetMapping(value="")
	public List<ProductoDTO> getAll(){
		return productoPresentationServices.getAll();
	}
	
}
