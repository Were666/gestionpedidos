package com.pgrsoft.gestionpedidos.backend.pruebas;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebasController {

	@RequestMapping(value="/image-resource",
					method=RequestMethod.GET,
					produces=MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImageAsResource() throws IOException{
		
		ClassPathResource imgFile = new ClassPathResource("fary.jpeg");
		
		byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
		
		return ResponseEntity.ok().body(bytes);
	}
	
	
	
	
}
