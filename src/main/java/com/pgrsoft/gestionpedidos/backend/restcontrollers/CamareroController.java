package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.presentation.model.CamareroVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.CamareroPresentationServices;

@RestController
public class CamareroController {

	private Logger logger = LoggerFactory.getLogger(CamareroController.class);
	
	@Autowired
	private CamareroPresentationServices camareroPresentationServices;
	
	@RequestMapping(value="/camareros/{id}",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public CamareroVO getById(@PathVariable("id") Long id) {
	
		CamareroVO camarero = null;
		try {
			camarero = camareroPresentationServices.getById(id);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return camarero;
	}
	
	@RequestMapping(value="/camareros",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<List<CamareroVO>> dameString() {

		List<CamareroVO> camareros = null;
		try {
			camareros = camareroPresentationServices.getAll();
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
			//return new ResponseEntity<List<CamareroDTO>>(HttpStatus.BAD_REQUEST);
			
		}

		return new ResponseEntity<List<CamareroVO>>(camareros, HttpStatus.OK);
	}
	
}
