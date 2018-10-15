package com.pgrsoft.gestionpedidos.backend.business.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;
import com.pgrsoft.gestionpedidos.backend.business.services.impl.CamareroServicesImpl;
import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.CamareroRepository;

@RunWith(SpringRunner.class)
public class CamareroServicesTest {

	//TODO Arreglar tema dozer
	
	//Necesitamos configurar algunas cosas...
	@TestConfiguration
	static class CamareroSericeTestContextConfiguration{
		
		@Bean
		public CamareroServices camareroService() {
			return new CamareroServicesImpl();		// Implementación que vamos a testear
		}	
	}
	
	@Autowired
	private CamareroServices camareroServices;
	
	@MockBean
	private CamareroRepository camareroRepository;
	
	@Before
	public void setUp() {
		CamareroDTO camarero = new CamareroDTO();
		camarero.setId(1000L);
		camarero.setNombre("CAMARERO TESTING");
		
		Mockito.when(camareroRepository.findByNombre(camarero.getNombre()))
		       .thenReturn(camarero);
		
		Mockito.when(camareroRepository.getOne(camarero.getId()))
			   .thenReturn(camarero);
	}
	
	@Test
	public void whenValidId_thenCamareroShouldBeFound() throws Exception {
		
		String nombre = "CAMARERO TESTING";
		
		Camarero encontrado = camareroServices.getById(1000L);
		
		assertThat(encontrado.getNombre()).isEqualTo(nombre);
	}
	
	
	
}
