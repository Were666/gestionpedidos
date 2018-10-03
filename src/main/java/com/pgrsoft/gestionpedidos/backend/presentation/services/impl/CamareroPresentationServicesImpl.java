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
	public CamareroDTO getById(final Long id) {
		final CamareroDTO camarero = camareroServices.getById(id);
		return camarero;
	}

	@Override
	public List<CamareroDTO> getAll() {
		final List<CamareroDTO> camareros = camareroServices.getAll();
		return camareros;
	}

	@Override
	public CamareroDTO create(final CamareroDTO camarero) {
		final CamareroDTO createdCamarero = camareroServices.create(camarero);
		return createdCamarero;
	}

}
