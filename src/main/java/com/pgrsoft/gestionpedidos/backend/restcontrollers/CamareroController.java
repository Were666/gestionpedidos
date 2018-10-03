package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.CamareroPresentationServices;

@RestController
public class CamareroController {

	private Logger logger = LoggerFactory.getLogger(CamareroController.class);
	
	@Autowired
	private CamareroPresentationServices camareroPresentationServices;
	
	@RequestMapping(value="/camareros",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CamareroDTO> dameString() {
		
		
		List<CamareroDTO> camarerosDTO = null;
		try {
			camarerosDTO = camareroPresentationServices.getAll();
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return camarerosDTO;
	}
}
