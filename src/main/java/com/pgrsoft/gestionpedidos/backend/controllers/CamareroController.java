package com.pgrsoft.gestionpedidos.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pgrsoft.gestionpedidos.backend.model.Camarero;
import com.pgrsoft.gestionpedidos.backend.presentation.CamareroPresentationServices;

@RestController
public class CamareroController {

	private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CamareroController.class);
	
	@Autowired
	private CamareroPresentationServices camareroPresentationServices;
	
	@RequestMapping(value="/camareros",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Camarero> dameString() {
		
		logger.error("/camareros");
		
		return camareroPresentationServices.getAll();
	}
}
