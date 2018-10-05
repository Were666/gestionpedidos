package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Pedido;
import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;
import com.pgrsoft.gestionpedidos.backend.business.services.PedidoServices;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.LineaPedidoRepository;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.PedidoRepository;

@Service
public class PedidoServicesImpl implements PedidoServices {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private LineaPedidoRepository lineaPedidoRepository;
	
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


	@Override
	@Transactional
	public Pedido create(Pedido pedido) throws Exception {
		
		final PedidoDTO newPedidoDTO = dozerBeanMapper.map(pedido, PedidoDTO.class);
		
		//System.out.println("newPedidoDTO: " + newPedidoDTO);
		
		final PedidoDTO createdPedidoDTO = pedidoRepository.save(newPedidoDTO);
		
		//System.out.println("createdPedidoDTO: " + createdPedidoDTO);
		
		final Pedido createdPedido = dozerBeanMapper.map(createdPedidoDTO, Pedido.class);
		
		return createdPedido;
	}

}
