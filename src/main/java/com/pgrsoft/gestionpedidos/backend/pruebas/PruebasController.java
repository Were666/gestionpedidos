package com.pgrsoft.gestionpedidos.backend.pruebas;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoPageableRepository;

@RestController
@CrossOrigin
public class PruebasController {

	@Autowired
	private ProductoPageableRepository productoPageableRepository;
	
	
	@RequestMapping(value= "/damepagina",
					produces=MediaType.APPLICATION_JSON_VALUE)
	public Page<ProductoDTO> getPage(@RequestParam ("p1") Integer p1,
									 @RequestParam ("p2") Integer p2){
		
		Pageable pageable = PageRequest.of(p1, p2);
		
		Page<ProductoDTO> pagina = productoPageableRepository.findAll(pageable);
		
		return pagina;
	}
	
	
	@RequestMapping(value="/image-resource",
					method=RequestMethod.GET,
					produces=MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImageAsResource() throws IOException{
		
		ClassPathResource imgFile = new ClassPathResource("fary.jpeg");
		
		byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());
		
		return ResponseEntity.ok().body(bytes);
	}
	
	
	
	
}
