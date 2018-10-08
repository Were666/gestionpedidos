package com.pgrsoft.gestionpedidos.backend.integration.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = -54661L;

	@Id
	private int id;
	private String nombre;
	
	@ElementCollection
	@CollectionTable(name="CONTACTOS_CLIENTE",joinColumns=@JoinColumn (name="ID_CLIENTE"))
	private List<ContactoDTO> contactos;
	
	public ClienteDTO() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ContactoDTO> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoDTO> contactos) {
		this.contactos = contactos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDTO other = (ClienteDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", nombre=" + nombre + ", contactos=" + contactos + "]";
	}
	
}
