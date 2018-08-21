package com.ia.negocio;

public class Localidad {

	private int id;
	private String descripcion;
	
	public Localidad(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
