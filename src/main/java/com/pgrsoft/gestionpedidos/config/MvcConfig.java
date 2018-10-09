package com.pgrsoft.gestionpedidos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	      .addResourceHandler("/files/**")
	      .addResourceLocations("file:///C:/opt/files/");
	    
	      // localhost:8086/api/files/loquesea.jpg 
	    
	      // funcionará si en c: existe una carpeta opt con una subcarpeta files con loquesea.jpg!  
	 }
}
