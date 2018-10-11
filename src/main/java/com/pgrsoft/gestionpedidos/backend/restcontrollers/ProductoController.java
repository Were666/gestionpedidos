package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.common.Pagina;
import com.pgrsoft.gestionpedidos.backend.presentation.model.ProductoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ProductoPresentationServices;

@RestController
@RequestMapping(value="/productos")
public class ProductoController {
	
	private Logger logger = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private ProductoPresentationServices productoPresentationServices;
	
	
	@GetMapping(value="")
	public Pagina<ProductoVO> getPaginated(@RequestParam("page") Integer numeroPagina,
										   @RequestParam("size") Integer numeroElementos){
		
		
		Pagina<ProductoVO> pagina = null;
		
		try {
			pagina = productoPresentationServices.getPagina(numeroPagina, numeroElementos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pagina;
	}
	
	@GetMapping(value="/{codigo}")
	public ProductoVO getById(@PathVariable ("codigo") Long codigo) {
		
		
		ProductoVO producto = null;
		
		try {
			producto = productoPresentationServices.getById(codigo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			//e.printStackTrace();
		}
		
		return producto;
	
	}

}
