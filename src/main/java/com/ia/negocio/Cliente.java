package com.ia.negocio;

import com.ia.dao.ClienteDAO;
import com.ia.dto.ClienteDTO;
import com.ia.entities.ClienteEntity;

public class Cliente {

	private String identificador;
	private String nombre;
	private String email;

	public Cliente(String identificador, String nombre, String email) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.email = email;
	}

	public Cliente(ClienteEntity ce) {
		super();
		this.identificador = ce.getIdentificador();
		this.nombre = ce.getNombre();
		this.email = ce.getEmail();
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
	
	public ClienteDTO toDTO() {
		return new ClienteDTO(identificador, nombre, email);
	}

	public ClienteEntity toEntity() {
		return new ClienteEntity(identificador, nombre, email);
	}

	public void save() {
		ClienteDAO.getInstance().saveOrUpdate(this);
	}
}
