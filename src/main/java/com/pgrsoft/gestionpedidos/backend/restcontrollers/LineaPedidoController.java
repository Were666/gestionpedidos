package com.pgrsoft.gestionpedidos.backend.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgrsoft.gestionpedidos.backend.integration.model.LineaPedidoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.PedidoRepository;

//TODO Haría falta mapear LineaPedidoDTO -> LineaPedido -> LineaPedidoVOº

@RestController
public class LineaPedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@RequestMapping("/lineas")
	public List<LineaPedidoDTO> getAll() {
		return pedidoRepository.getLineasPedido();
	}
	
	@RequestMapping("/lineas/{idProducto}")
	public List<Object[]> getFilteredByProductId (@PathVariable("idProducto") Long idProducto) {
		List<Object[]> tabla = pedidoRepository.getLineasPedidoByProductoId(idProducto);
		return tabla;
	}
	

}
