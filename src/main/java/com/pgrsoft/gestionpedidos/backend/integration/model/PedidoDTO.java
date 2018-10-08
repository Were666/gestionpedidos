package com.pgrsoft.gestionpedidos.backend.integration.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="PEDIDOS")
public class PedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @TableGenerator(name = "PEDIDO_GENERATOR",
					table = "SECUENCIAS",
					pkColumnName = "SEQ_NAME",
					pkColumnValue = "PEDIDO_SEQ",
					valueColumnName = "SEQ_NUMBER",
					allocationSize = 10)

    @GeneratedValue(strategy=GenerationType.TABLE, generator = "PEDIDO_GENERATOR")
	private Long id;
	
	private Date fecha;
	private int mesa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_CAMARERO")
	private CamareroDTO camarero;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	//@OrderBy(value="INDICE")
	private List<LineaPedidoDTO> lineasPedido = new ArrayList<LineaPedidoDTO>();
	
	public PedidoDTO() {
		
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

	public CamareroDTO getCamarero() {
		return camarero;
	}

	public void setCamarero(CamareroDTO camarero) {
		this.camarero = camarero;
	}

	public List<LineaPedidoDTO> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedidoDTO> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}
	
	public void addLineaPedido(LineaPedidoDTO lineaPedido) {
		lineasPedido.add(lineaPedido);
		lineaPedido.setPedido(this);
	}
	
	public void removeLineaPedido(LineaPedidoDTO lineaPedido) {
		lineasPedido.remove(lineaPedido);
		lineaPedido.setProducto(null);
	}
	
	@Override
	public String toString() {
		return "PedidoDTO [id=" + id + ", fecha=" + fecha + ", mesa=" + mesa + ", camarero=" + camarero + ", lineasPedido="
				+ lineasPedido + "]";
	}
	
}
