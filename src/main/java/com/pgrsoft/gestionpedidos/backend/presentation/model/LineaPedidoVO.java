package com.pgrsoft.gestionpedidos.backend.presentation.model;

import java.io.Serializable;

public class LineaPedidoVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private ProductoVO producto;
	private int cantidad;
	private double precio;
	
	public LineaPedidoVO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductoVO getProducto() {
		return producto;
	}

	public void setProducto(ProductoVO producto) {
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
		return "LineaPedidoVO [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio
				+ "]";
	}
	
}
