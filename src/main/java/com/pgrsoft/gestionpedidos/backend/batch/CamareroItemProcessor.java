package com.pgrsoft.gestionpedidos.backend.batch;

import org.springframework.batch.item.ItemProcessor;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;

public class CamareroItemProcessor implements ItemProcessor<Camarero,Camarero> {

	@Override
	public Camarero process(final Camarero camarero) throws Exception {
		
		final String nombreMayusculas = camarero.getNombre();
		
		final Camarero transformedCamarero = new Camarero();
		
		transformedCamarero.setId(camarero.getId());
		transformedCamarero.setNombre(nombreMayusculas);
		
		System.out.println("Converting (" + camarero + ") into (" + transformedCamarero + ")");
		
		return transformedCamarero;
	}

}
