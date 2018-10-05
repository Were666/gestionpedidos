package com.pgrsoft.gestionpedidos.backend.business.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Pedido;
import com.pgrsoft.gestionpedidos.backend.integration.model.CamareroDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.LineaPedidoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.PedidoDTO;
import com.pgrsoft.gestionpedidos.backend.integration.model.ProductoDTO;
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
		
		
		PedidoDTO engañador = new PedidoDTO();
		engañador.setId(Long.valueOf((long)(Math.random() * 100000)));
		engañador.setMesa(666);
		engañador.setFecha(new Date());
		CamareroDTO camareroDTO = new CamareroDTO();
		camareroDTO.setId(102L);
		engañador.setCamarero(camareroDTO);
		
		PedidoDTO createdPedidoDTO = pedidoRepository.save(engañador);
		
		System.out.println("HABEMUS CODIGO: " + createdPedidoDTO.getId());
		
		List<LineaPedidoDTO> lineasEngañadoras = new ArrayList<LineaPedidoDTO>();
		
		LineaPedidoDTO l1 = new LineaPedidoDTO();
		LineaPedidoDTO l2 = new LineaPedidoDTO();
		
		ProductoDTO p1 = new ProductoDTO();
		ProductoDTO p2 = new ProductoDTO();
		
		p1.setCodigo(1L);
		p2.setCodigo(2L);
		
		l1.setCantidad(50);
		l1.setPrecio(500.0);
		l1.setProducto(p1);
		
		l2.setCantidad(70);
		l2.setPrecio(700.0);
		l2.setProducto(p2);
		
		lineasEngañadoras.add(l1);
		lineasEngañadoras.add(l2);
		
		engañador.setLineasPedido(lineasEngañadoras);
		
		createdPedidoDTO = pedidoRepository.save(engañador);
		
		//PedidoDTO createdPedidoDTO = pedidoRepository.save(engañador);
		
		
		
		
		
		
	//	final PedidoDTO createdPedidoDTO = pedidoRepository.save(newPedidoDTO);
		
		//System.out.println("createdPedidoDTO: " + createdPedidoDTO);
		
		final Pedido createdPedido = dozerBeanMapper.map(createdPedidoDTO, Pedido.class);
		
		return createdPedido;
	}

}
