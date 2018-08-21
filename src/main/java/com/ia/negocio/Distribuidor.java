package com.ia.negocio;

import java.util.List;

public class Distribuidor {

	private String dni;
	private String nombre;
	private String username;
	private String password;
	private List<Localidad> localidades;
	
	public Distribuidor(String dni, String nombre, String username, String password) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.username = username;
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}
	
	
}
