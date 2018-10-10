package com.pgrsoft.gestionpedidos.backend.business.model;

import java.util.List;

public class Pagina<T> {

	private List<T> elementos;
	
	private int numeroPagina;
	private int numeroElementos;		// De página
	private int numeroTotalElementos;	// Total en la DB
	
	public Pagina(){
		
	}

	public List<T> getElementos() {
		return elementos;
	}

	public void setElementos(List<T> elementos) {
		this.elementos = elementos;
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public int getNumeroElementos() {
		return numeroElementos;
	}

	public void setNumeroElementos(int numeroElementos) {
		this.numeroElementos = numeroElementos;
	}

	public int getNumeroTotalElementos() {
		return numeroTotalElementos;
	}

	public void setNumeroTotalElementos(int numeroTotalElementos) {
		this.numeroTotalElementos = numeroTotalElementos;
	}
	
	@Override
	public String toString() {
		return "Pagina [elementos=" + elementos + ", numeroPagina=" + numeroPagina + ", numeroElementos="
				+ numeroElementos + "]";
	}
}
