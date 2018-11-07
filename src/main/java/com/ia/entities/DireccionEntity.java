package com.ia.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Direcciones")
public class DireccionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDireccion;
	private String longitud;
	private String latitud;
	private String provincia;
	@OneToOne()
	@JoinColumn(name="idLocalidad")
	private LocalidadEntity localidad;
	private String calle;
	private int numero;
	private int piso;
	private String unidad;
	private String entreCalles;
	private String codigoPostal;
	private boolean geolocalizado;
	
	public DireccionEntity(){}
	
	public DireccionEntity(String longitud, String latitud, String provincia, LocalidadEntity localidad, String calle,
			int numero, int piso, String unidad, String entreCalles, String codigoPostal, boolean geolocalizado) {
		super();
		this.longitud = longitud;
		this.latitud = latitud;
		this.provincia = provincia;
		this.localidad = localidad;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.unidad = unidad;
		this.entreCalles = entreCalles;
		this.codigoPostal = codigoPostal;
		this.geolocalizado = geolocalizado;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public LocalidadEntity getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadEntity localidad) {
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getEntreCalles() {
		return entreCalles;
	}

	public void setEntreCalles(String entreCalles) {
		this.entreCalles = entreCalles;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public boolean isGeolocalizado() {
		return geolocalizado;
	}

	public void setGeolocalizado(boolean geolocalizado) {
		this.geolocalizado = geolocalizado;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}
	
	
	
}
