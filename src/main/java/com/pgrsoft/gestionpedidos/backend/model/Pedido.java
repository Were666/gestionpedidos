package com.pgrsoft.gestionpedidos.backend.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="PEDIDOS")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private Date fecha;
	private int mesa;
	
	@ManyToOne
	@JoinColumn(name="ID_CAMARERO")
	private Camarero camarero;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PEDIDO")
	@OrderBy(value="INDICE")		//TODAVIA NO SE HA COMPROBADO!!!!!
	private List<LineaPedido> lineasPedido;
	
	public Pedido() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public Camarero getCamarero() {
		return camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", mesa=" + mesa + ", camarero=" + camarero + ", lineasPedido="
				+ lineasPedido + "]";
	}
	
}
