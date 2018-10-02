package com.pgrsoft.gestionpedidos.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.model.Producto;
import com.pgrsoft.gestionpedidos.backend.presentation.ProductoPresentationServices;

@RestController
@RequestMapping(value="/productos")
public class ProductoController {

	@Autowired
	private ProductoPresentationServices productoPresentationServices;
	
	@GetMapping(value="")
	public List<Producto> getAll(){
		return productoPresentationServices.getAll();
	}
	
}
