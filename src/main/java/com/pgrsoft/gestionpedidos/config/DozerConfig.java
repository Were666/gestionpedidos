package com.pgrsoft.gestionpedidos.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
