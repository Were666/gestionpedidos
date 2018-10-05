package com.pgrsoft.gestionpedidos.backend.presentation.model;

import java.io.Serializable;

public class LineaPedidoPostVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idProducto;
	private int cantidad;
	private double precio;
	
	public LineaPedidoPostVO() {
		
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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
		return "LineaPedidoPostVO [idProducto=" + idProducto + ", cantidad=" + cantidad + ", precio=" + precio
				+ "]";
	}
	
}
