package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.PedidoPresentationServices;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	private Logger logger = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	private PedidoPresentationServices pedidoPresentationServices;
	
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public PedidoDTO getOne(@PathVariable ("id") Long id) {
		
		PedidoDTO pedido = null;
		
		try {
			pedido = pedidoPresentationServices.getById(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			//TODO responder JSON de error y código HTTP adecuado!
		}
		
		return pedido;
	}
	 
	@RequestMapping(value="",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PedidoDTO> getAll(){
		
		List<PedidoDTO> pedidos = null;
		
		try {
			pedidos = pedidoPresentationServices.getAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			//TODO responder JSON de error y código HTTP adecuado!
		}
		
		return pedidos;
	}
	
	
}
