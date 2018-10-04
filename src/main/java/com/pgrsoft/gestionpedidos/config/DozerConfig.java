package com.pgrsoft.gestionpedidos.config;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig {

	
	/*
	@Bean(name = "genericConverter")
	public DozerBeanMapper getMapper1() {
		return new DozerBeanMapper();
	}
	*/
	
	//@Bean(name = "camareroConverter")
	@Bean
    public DozerBeanMapper getMapper() {
        
		List<String> mappingFiles = Arrays.asList("dozer-configration-mapping.xml");

        DozerBeanMapper dozerBean = new DozerBeanMapper();
        
        dozerBean.setMappingFiles(mappingFiles);
        
        return dozerBean;
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
