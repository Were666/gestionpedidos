package com.pgrsoft.gestionpedidos.backend.presentation.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.presentation.model.PedidoVO;

public interface PedidoPresentationServices {

	public PedidoVO getById(Long id) throws Exception;
	
	public List<PedidoVO> getAll() throws Exception;
	
}
