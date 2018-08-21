package com.ia.entities;

//@Entity
//Table(name="Localidades")
public class LocalidadEntity {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTIITY)
	private int id;
	private String descripcion;
	
	public LocalidadEntity(){}

	public LocalidadEntity(int id, String descripcion) {
		super();
		this.id = id;
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
