package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.CamareroPresentationServices;

@RestController
public class CamareroController {

	private org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CamareroController.class);
	
	@Autowired
	private CamareroPresentationServices camareroPresentationServices;
	
	@RequestMapping(value="/camareros",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CamareroDTO> dameString() {
		
		logger.error("/camareros");
		
		return camareroPresentationServices.getAll();
	}
}
