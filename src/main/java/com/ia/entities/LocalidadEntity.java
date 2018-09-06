package com.ia.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Localidades")
public class LocalidadEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer idLocalidad;
	private String descripcion;
	
	public LocalidadEntity(){}

	public LocalidadEntity(int id, String descripcion) {
		super();
		this.idLocalidad = id;
		this.descripcion = descripcion;
	}
	
	public LocalidadEntity(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public int getId() {
		return idLocalidad;
	}

	public void setId(int id) {
		this.idLocalidad = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
