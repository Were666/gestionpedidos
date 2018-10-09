package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.integration.repositories.PedidoRepository;

@RestController
public class BorrameController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@RequestMapping("/prueba")
	public String prueba() {
		
		pedidoRepository.getLineasPedido().stream().forEach(x -> {
			System.out.println(x);
		});
		
		return "funciona!";
	}
	
}
