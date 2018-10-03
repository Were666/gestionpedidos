package com.pgrsoft.gestionpedidos.backend.presentation.model;

import java.io.Serializable;

public class CamareroVO implements Serializable {
	private static final long serialVersionUID = -89385743L;
	
	private Long id;
	private String nombre;
	
	public CamareroVO() {
		
	}
	
	public CamareroVO(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Camarero [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
