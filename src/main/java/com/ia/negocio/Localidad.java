package com.ia.negocio;

import com.ia.dto.LocalidadDTO;
import com.ia.entities.LocalidadEntity;

public class Localidad {

	private int id;
	private String descripcion;
	
	public Localidad(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	public Localidad(LocalidadEntity le) {
		super();
		this.id = le.getId();
		this.descripcion = le.getDescripcion();
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
	
	public LocalidadDTO toDTO() {
		return new LocalidadDTO(id, descripcion);
	}
	
}
