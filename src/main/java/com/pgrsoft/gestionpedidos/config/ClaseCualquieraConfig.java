package com.pgrsoft.gestionpedidos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pgrsoft.gestionpedidos.misbeans.BeanCualquiera;

// Esta clase se instancia y se ejecutan todos sus métodos públicos


@Configuration
public class ClaseCualquieraConfig {

	@Bean
	public BeanCualquiera xxxxxx() {
		//System.out.println("xxxxxxx");
		return new BeanCualquiera("ff", 0.4);
	}
	
	
	
}
