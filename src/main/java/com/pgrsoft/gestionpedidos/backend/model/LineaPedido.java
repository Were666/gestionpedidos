package com.pgrsoft.gestionpedidos.backend.model;

import java.io.Serializable;

public class LineaPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Producto producto;
	private int cantidad;
	private double precio;
	
	public LineaPedido() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "LineaPedido [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio
				+ "]";
	}
	
}
