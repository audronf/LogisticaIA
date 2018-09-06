package com.ia.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Distribuidores")
public class DistribuidorEntity {

	@Id
	private String dni;
	private String nombre;
	private String username;
	private String password;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "Distribuidores_Localidades", joinColumns = {@JoinColumn(name = "dniDistribuidor")}, inverseJoinColumns = @JoinColumn(name="idLocalidad"))
	private List<LocalidadEntity> localidades;
	
	public DistribuidorEntity(){}

	public DistribuidorEntity(String dni, String nombre, String username, String password, List<LocalidadEntity> localidades) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.username = username;
		this.password = password;
		this.localidades = localidades;
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

	public List<LocalidadEntity> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<LocalidadEntity> localidades) {
		this.localidades = localidades;
	}
	
	
}
