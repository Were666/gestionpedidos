package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.presentation.model.ClienteVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.ClientePresentationServices;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {

	@Autowired
	private ClientePresentationServices clientePresentationServices;
	
	@RequestMapping(value="",
					method=RequestMethod.GET,
					produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteVO> getAll() {
		return this.clientePresentationServices.getAll();
	}
}
