package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;
import com.pgrsoft.gestionpedidos.backend.business.services.CamareroServices;
import com.pgrsoft.gestionpedidos.backend.presentation.services.CamareroPresentationServices;

@Service
public class CamareroPresentationServicesImpl implements CamareroPresentationServices {

	@Autowired
	private CamareroServices camareroServices;
	
	@Override
	public Camarero getById(final Long id) throws Exception {
			
		Camarero camarero = null;
		
		try {
			camarero = camareroServices.getById(id);
		} catch (Exception e) {
		//  logger.error("fdfd");	
			throw new Exception(e.getMessage());
		}
		
		return camarero;
	}

	@Override
	public List<Camarero> getAll() throws Exception {
		
		List<Camarero> camareros = null;
		
		try {
			camareros = camareroServices.getAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return camareros;
	}

	@Override
	public Camarero create(final Camarero camarero) throws Exception {
		
		Camarero createdCamarero = null;
		
		try {
			createdCamarero = camareroServices.create(camarero);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return createdCamarero;
	}

}
