package com.pgrsoft.gestionpedidos.misbeans;

public class BeanCualquiera {

	private int numero;
	private String nombre;
	private boolean booleano;
	
	public BeanCualquiera(String p1, double p2) {
		if (p1.length()<4) {
			booleano = true;
		}
		
		if (p2 < 0.5) {
			nombre = "menos5";
			numero = 100;
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isBooleano() {
		return booleano;
	}

	public void setBooleano(boolean booleano) {
		this.booleano = booleano;
	}

	@Override
	public String toString() {
		return "BeanCualquiera [numero=" + numero + ", nombre=" + nombre + ", booleano=" + booleano + "]";
	}
	
}
