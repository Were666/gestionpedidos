package com.pgrsoft.gestionpedidos.backend.integration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//JsonIgnoreProperties en el modelo de presentation!!!!
@JsonIgnoreProperties(value= {"hibernateLazyInitializer","handler"})
@Table(name="PRODUCTOS")
public class ProductoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo;
	
	private String nombre;
	private double precio;
	private String descripcion;
	private Date fechaAlta;
	private boolean descatalogado;
	
	@Enumerated(EnumType.STRING)
	private CategoriaDTO categoria;
	
	public ProductoDTO() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public boolean isDescatalogado() {
		return descatalogado;
	}

	public void setDescatalogado(boolean descatalogado) {
		this.descatalogado = descatalogado;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "ProductoDTO [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", descripcion="
				+ descripcion + ", fechaAlta=" + fechaAlta + ", descatalogado=" + descatalogado + ", categoria="
				+ categoria + "]";
	}
	
}
