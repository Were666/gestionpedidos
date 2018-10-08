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
import com.pgrsoft.gestionpedidos.backend.integration.model.LineaPedidoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.CamareroRepository;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.PedidoRepository;
import com.pgrsoft.gestionpedidos.backend.integration.repositories.ProductoRepository;

@Service
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


	@Override
	@Transactional
	public Pedido create(Pedido pedido) throws Exception {
		
		final PedidoDTO newPedidoDTO = dozerBeanMapper.map(pedido, PedidoDTO.class);
		
		final PedidoDTO pedidoDTO = new PedidoDTO();
		
		pedidoDTO.setCamarero(camareroRepository.getOne(newPedidoDTO.getCamarero().getId()));
		
		pedidoDTO.setCamarero(newPedidoDTO.getCamarero());
		
		pedidoDTO.setMesa(newPedidoDTO.getMesa());
		pedidoDTO.setFecha(newPedidoDTO.getFecha());

		for (LineaPedidoDTO lp: newPedidoDTO.getLineasPedido()) {
			LineaPedidoDTO lineaPedidoDTO = new LineaPedidoDTO();
			lineaPedidoDTO.setProducto(productoRepository.getOne(lp.getProducto().getCodigo()));
			lineaPedidoDTO.setCantidad(lp.getCantidad());
			lineaPedidoDTO.setPrecio(lp.getPrecio());
			pedidoDTO.addLineaPedido(lineaPedidoDTO);
		}
	
		PedidoDTO createdPedidoDTO = pedidoRepository.saveAndFlush(pedidoDTO);
		
		// Si aquí flush.... el problema desaparece...
	
		createdPedidoDTO = pedidoRepository.getOne((createdPedidoDTO.getId())); // FORZANDO...
		
		final Pedido createdPedido = dozerBeanMapper.map(createdPedidoDTO, Pedido.class);
		
		return createdPedido;
	}

}
