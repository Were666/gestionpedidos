package com.pgrsoft.gestionpedidos.backend.integration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

//@JsonIgnoreProperties(value= {"hibernateLazyInitializer","handler"})

@Entity
@Table(name="LINEAS_PEDIDO")
public class LineaPedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @TableGenerator(name = "LINEAS_PEDIDO_GENERATOR",
					table = "SECUENCIAS",
					pkColumnName = "SEQ_NAME",
					pkColumnValue = "LINEAS_PEDIDO_SEQ",
					valueColumnName = "SEQ_NUMBER",
					allocationSize = 10)

    @GeneratedValue(strategy=GenerationType.TABLE, generator = "LINEAS_PEDIDO_GENERATOR")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PRODUCTO")
	private ProductoDTO producto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_PEDIDO")
	private PedidoDTO pedido;
	
	private int cantidad;
	
	private double precio;
	
	public LineaPedidoDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
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
	
	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		LineaPedidoDTO other = (LineaPedidoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LineaPedidoDTO [id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio
				+ "]";
	}

}
