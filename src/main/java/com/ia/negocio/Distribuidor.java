package com.ia.negocio;

import java.util.ArrayList;
import java.util.List;

import com.ia.dto.DistribuidorDTO;
import com.ia.dto.LocalidadDTO;
import com.ia.entities.DistribuidorEntity;
import com.ia.entities.LocalidadEntity;

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
		this.localidades = new ArrayList<Localidad>();
	}
	
	public Distribuidor(DistribuidorEntity de) {
		super();
		this.dni = de.getDni();
		this.nombre = de.getNombre();
		this.username = de.getUsername();
		this.password = de.getPassword();
		this.localidades = new ArrayList<Localidad>();
		for (LocalidadEntity loc : de.getLocalidades())
			localidades.add(new Localidad(loc));
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
	
	public DistribuidorDTO toDTO() {
		List<LocalidadDTO> locDTO = new ArrayList<LocalidadDTO>();
		for (Localidad loc : localidades)
			locDTO.add(loc.toDTO());
		return new DistribuidorDTO(dni, nombre, username, password, locDTO);
			
	}
	
	public DistribuidorEntity toEntity() {
		DistribuidorEntity de = new DistribuidorEntity();
		de.setDni(dni);
		de.setNombre(nombre);
		de.setPassword(password);
		de.setUsername(username);
//		for (Localidad l : localidades) 
//			de.getLocalidades().add(new LocalidadEntity(l.getDescripcion()));
		return de;
	}
}
