package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.services.CamareroServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.CamareroPresentationServices;

@Service
public class CamareroPresentationServicesImpl implements CamareroPresentationServices {

	//Añadir logs...
	
	@Autowired
	private CamareroServices camareroServices;
	
	@Override
	public CamareroDTO getById(final Long id) throws Exception {
			
		CamareroDTO camarero = null;
		
		try {
			camarero = camareroServices.getById(id);
		} catch (Exception e) {
		//  logger.error("fdfd");	
			throw new Exception(e.getMessage());
		}
		
		return camarero;
	}

	@Override
	public List<CamareroDTO> getAll() throws Exception {
		
		List<CamareroDTO> camareros = null;
		
		try {
			camareros = camareroServices.getAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return camareros;
	}

	@Override
	public CamareroDTO create(final CamareroDTO camarero) throws Exception {
		
		CamareroDTO createdCamarero = null;
		
		try {
			createdCamarero = camareroServices.create(camarero);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return createdCamarero;
	}

}
