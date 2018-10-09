package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.integration.repositories.PedidoRepository;

@RestController
public class BorrameController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@RequestMapping("/lineas")
	public String prueba() {
		
		pedidoRepository.getLineasPedido().stream().forEach(x -> {
			System.out.println(x);
		});
		
		return "funciona!";
	}
	
	@RequestMapping("/lineas/{idProducto}")
	public List<Object[]> prueba2(@PathVariable("idProducto") Long idProducto) {
		List<Object[]> tabla = pedidoRepository.getLineasPedidoByProductoId(idProducto);
		return tabla;
	}
	
	
	
	
}
