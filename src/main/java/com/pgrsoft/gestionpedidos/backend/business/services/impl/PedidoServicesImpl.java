package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Pedido;
import com.pgrsoft.gestionpedidos.backend.business.services.PedidoServices;
import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.CamareroRepository;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.PedidoRepository;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoRepository;

@Service
@Transactional
public class PedidoServicesImpl implements PedidoServices {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CamareroRepository camareroRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public Pedido getById(Long id) {
		
		Optional<PedidoDTO> optional = pedidoRepository.findById(id);
		
		PedidoDTO pedidoDTO = null;
		
		if (optional.isPresent()) {
			pedidoDTO = optional.get();
		}
		
		final Pedido pedido = dozerBeanMapper.map(pedidoDTO, Pedido.class);
		
		return pedido;
	}

	@Override
	public List<Pedido> getAll() {
		
		final List<PedidoDTO> pedidosDTO = pedidoRepository.findAll();
		
		List<Pedido> pedidos = pedidosDTO.stream()
				.map(x -> dozerBeanMapper.map(x, Pedido.class))
				.collect(Collectors.toList());

		return pedidos;
	}

	/*
	 * Implementación definitiva de create...
	 * 
	 * Hemos dado una importancia excesiva a la clase LineaPedidoDTO!
	 * 
	 * La hemos considerado @Entity cuando realmente no es necesario (no se lo merece)
	 * 
	 * LineaPedidoDTO puede ser un @Embeddable (ver ejemplo de ClienteDTO y ContactoDTO)
	 * 
	 * Hay que tener en cuenta que:
	 * 
	 * 1.- Un embedabble puede tener un atributo que sea una @Entity o incluso una colección.
	 *     En nuestro ejemplo eso afectaría al atributo producto de LineaPedidoDTO
	 * 
	 * 2.- Siendo LineaPedidoDTO un embeddable (no siendo una @Entity) también se pueden  
	 * 	   realizar (hay varias alternativas para ello) queries sobre la tabla LINEAS_PEDIDO.
	 * 
	 */
	
	@Override
	public Pedido create(Pedido pedido) throws Exception {
		
		final PedidoDTO pedidoDTO = dozerBeanMapper.map(pedido, PedidoDTO.class);
		final CamareroDTO camareroDTO = camareroRepository.getOne(pedidoDTO.getCamarero().getId());
		
		pedidoDTO.setCamarero(camareroDTO);
	
		pedidoDTO.getLineasPedido().stream()
			.forEach(x -> {
				x.setProducto(productoRepository.getOne(x.getProducto().getCodigo()));
				x.setPedido(pedidoDTO);
			});
		
		PedidoDTO createdPedidoDTO = pedidoRepository.save(pedidoDTO);
	
		return dozerBeanMapper.map(createdPedidoDTO, Pedido.class);
	}
	
}
