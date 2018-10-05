package com.pgrsoft.gestionpedidos.backend.presentation.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PedidoPostVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Date fecha;
	private int mesa;
	private int idCamarero;

	private List<LineaPedidoPostVO> lineasPedido;
	
	public PedidoPostVO() {
		
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

	public int getIdCamarero() {
		return idCamarero;
	}

	public void setIdCamarero(int idCamarero) {
		this.idCamarero = idCamarero;
	}

	public List<LineaPedidoPostVO> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedidoPostVO> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	@Override
	public String toString() {
		return "PedidoPostVO [fecha=" + fecha + ", mesa=" + mesa + ", idCamarero=" + idCamarero + ", lineasPedido="
				+ lineasPedido + "]";
	}
		
}
