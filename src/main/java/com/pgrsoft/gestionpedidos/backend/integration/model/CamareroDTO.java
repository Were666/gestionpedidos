package com.pgrsoft.gestionpedidos.backend.integration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAMAREROS")
public class CamareroDTO implements Serializable {
	private static final long serialVersionUID = -89385743L;
	
	@Id
	private Long id;
	
	private String nombre;
	
	public CamareroDTO() {
		
	}
	
	public CamareroDTO(Long id, String nombre) {
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
		return "CamareroDTO [id=" + id + ", nombre=" + nombre + "]";
	}

}
