package com.pgrsoft.gestionpedidos.backend.presentation.services.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgrsoft.gestionpedidos.backend.business.model.Pedido;
import com.pgrsoft.gestionpedidos.backend.business.services.PedidoServices;
import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;
import com.pgrsoft.gestionpedidos.backend.presentation.services.PedidoPresentationServices;

@Service
public class PedidoPresentationServicesImpl implements PedidoPresentationServices{

	@Autowired
	private PedidoServices pedidoServices;
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public PedidoVO getById(Long id) throws Exception {
		
		PedidoVO pedidoVO = null;
		
		try {
			final Pedido pedido = pedidoServices.getById(id);
			pedidoVO = dozerBeanMapper.map(pedido, PedidoVO.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return pedidoVO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PedidoVO> getAll() throws Exception {
		
		List<PedidoVO> pedidosVO = null;
		
		try {
			final List<Pedido> pedidos = pedidoServices.getAll();
			pedidosVO = dozerBeanMapper.map(pedidos, List.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return pedidosVO;
	}

}
