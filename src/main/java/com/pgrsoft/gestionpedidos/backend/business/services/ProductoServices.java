package com.pgrsoft.gestionpedidos.backend.business.services;

import java.util.List;

import com.pgrsoft.gestionpedidos.backend.business.model.Pagina;
import com.pgrsoft.gestionpedidos.backend.business.model.Producto;

public interface ProductoServices {

	public List<Producto> getAll() throws Exception;
	
	public Producto getById(Long id) throws Exception;
	
	public Producto create(Producto producto) throws Exception;
	
	public Pagina<Producto> getPagina(int numeroPagina, int numeroElementos);
	
}
