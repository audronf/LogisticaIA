package com.ia.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Clientes")
public class ClienteEntity {

	@Id
	private String identificador;
	private String nombre;
	private String email;
	
	public ClienteEntity(){}

	public ClienteEntity(String identificador, String nombre, String email) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.email = email;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
