package com.pgrsoft.gestionpedidos.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pgrsoft.gestionpedidos.backend.business.model.Camarero;
import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;

@Configuration
public class DozerConfig {
	
	
	@Bean
	public DozerBeanMapper getMapper() {
		return new DozerBeanMapper();
	}
	
	
			
	/*		
			
	@Bean
	public BeanMappingBuilder getBeanMappingBuilder() {
		return new BeanMappingBuilder() {
			
		    @Override
		    protected void configure() {
		        mapping(CamareroDTO.class, Camarero.class);
		        //  .fields("name", "nom")
		        //  .fields("nickname", "surnom");
		    }
		};
	}
	
	*/
}
