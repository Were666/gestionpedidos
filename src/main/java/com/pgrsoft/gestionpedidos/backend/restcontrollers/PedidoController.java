package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

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

	@Autowired
	private PedidoPresentationServices pedidoPresentationServices;
	
	@RequestMapping(value="/{id}",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public PedidoDTO getOne(@PathVariable ("id") Long id) {
		return pedidoPresentationServices.getById(id);
	}
	 
	@RequestMapping(value="",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PedidoDTO> getAll(){
		return pedidoPresentationServices.getAll();
	}
	
	
}
