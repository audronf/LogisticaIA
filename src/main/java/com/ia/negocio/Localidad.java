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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + id;
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
		Localidad other = (Localidad) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
