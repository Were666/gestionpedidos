package com.pgrsoft.gestionpedidos.backend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="LINEAS_PEDIDO")
public class LineaPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @TableGenerator(name = "LINEAS_PEDIDO_GENERATOR",
					table = "SECUENCIAS",
					pkColumnName = "SEQ_NAME",
					pkColumnValue = "LINEAS_PEDIDO_SEQ",
					valueColumnName = "SEQ_NUMBER",
					allocationSize = 1)

    @GeneratedValue(strategy=GenerationType.TABLE, 
					generator = "LINEAS_PEDIDO_GENERATOR")
	
	
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO")
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
