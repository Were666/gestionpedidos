package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

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
@RequestMapping("/camareros")
public class CamareroController {

	@Autowired
	private CamareroPresentationServices camareroPresentationServices;
	
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public CamareroVO getById(@PathVariable("id") Long id) {
	
		CamareroVO camarero = null;
		
		try {
			camarero = camareroPresentationServices.getById(id);
		} catch (Exception e) {
			//TODO
		}
		
		return camarero;
	}
	
	@RequestMapping(value="",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CamareroVO>> dameString() {

		List<CamareroVO> camareros = null;
		try {
			camareros = camareroPresentationServices.getAll();
		} catch (Exception e) {
			//TODO
		}

		return new ResponseEntity<List<CamareroVO>>(camareros, HttpStatus.OK);
	}
	
}
