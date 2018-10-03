package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.services.CamareroServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.CamareroRepository;

/*
 * El hecho de utilizar @Service implica que Spring en la fase
 * de scaneo "coloque" ese bean en la caja de beans (context)
 */

@Service // Necesario para poder inyectar esta clase en otro sitio
public class CamareroServicesImpl implements CamareroServices {

	@Autowired
	private CamareroRepository camareroRepository;
	
	@Override
	public CamareroDTO getById(Long id) {
		CamareroDTO camarero = camareroRepository.getOne(id);
		return camarero;
	}

	@Override
	public CamareroDTO create(CamareroDTO camarero) {
		CamareroDTO createdCamarero = camareroRepository.save(camarero);
		return createdCamarero;
	}

	@Override
	public List<CamareroDTO> getAll() {
		List<CamareroDTO> camareros = camareroRepository.findAll();
		return camareros;
	}

}
