package com.pgrsoft.gestionpedidos.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.model.Camarero;
import com.pgrsoft.gestionpedidos.backend.repositories.CamareroRepository;
import com.pgrsoft.gestionpedidos.backend.services.CamareroServices;

/*
 * El hecho de utilizar @Service implica que Spring en la fase
 * de scaneo "coloque" ese bean en la caja de beans (context)
 */

@Service // Necesario para poder inyectar esta clase en otro sitio
public class CamareroServicesImpl implements CamareroServices {

	@Autowired
	private CamareroRepository camareroRepository;
	
	@Override
	public Camarero getById(Long id) {
		Camarero camarero = camareroRepository.getOne(id);
		return camarero;
	}

	@Override
	public Camarero create(Camarero camarero) {
		Camarero createdCamarero = camareroRepository.save(camarero);
		return createdCamarero;
	}

	@Override
	public List<Camarero> getAll() {
		List<Camarero> camareros = camareroRepository.findAll();
		System.out.println("camareros en camarerosServices de business: " + camareros);
		return camareros;
	}

}
