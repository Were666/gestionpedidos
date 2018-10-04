package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Pedido;
import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;
import com.pgrsoft.gestionpedidos.backend.business.services.PedidoServices;

import com.pgrsoft.gestionpedidos.backend.integration.repositories.PedidoRepository;

@Service
public class PedidoServicesImpl implements PedidoServices {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier(value="genericConverter")
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> getAll() {
		
		final List<PedidoDTO> pedidosDTO = pedidoRepository.findAll();
		final List<Pedido> pedidos = dozerBeanMapper.map(pedidosDTO, List.class);
		
		return pedidos;
	}

}
