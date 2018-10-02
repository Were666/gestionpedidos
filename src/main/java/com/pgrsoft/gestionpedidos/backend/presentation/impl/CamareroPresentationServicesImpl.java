package com.pgrsoft.gestionpedidos.backend.presentation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.model.Camarero;
import com.pgrsoft.gestionpedidos.backend.presentation.CamareroPresentationServices;
import com.pgrsoft.gestionpedidos.backend.services.CamareroServices;

@Service
public class CamareroPresentationServicesImpl implements CamareroPresentationServices {

	//Añadir logs...
	
	@Autowired
	private CamareroServices camareroServices;
	
	@Override
	public Camarero getById(final Long id) {
		final Camarero camarero = camareroServices.getById(id);
		return camarero;
	}

	@Override
	public List<Camarero> getAll() {
		final List<Camarero> camareros = camareroServices.getAll();
		return camareros;
	}

	@Override
	public Camarero create(final Camarero camarero) {
		final Camarero createdCamarero = camareroServices.create(camarero);
		return createdCamarero;
	}

}
