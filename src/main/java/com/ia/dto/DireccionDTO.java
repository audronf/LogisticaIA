package com.ia.dto;

public class DireccionDTO {

	private String longitud;
	private String latitud;
	private String provincia;
	private LocalidadDTO localidad;
	private String calle;
	private int numero;
	private int piso;
	private String unidad;
	private String entreCalles;
	private String codigoPostal;
	private boolean geolocalizado;

	public DireccionDTO(String longitud, String latitud, String provincia, LocalidadDTO localidad, String calle,
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

	public LocalidadDTO getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadDTO localidad) {
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

}
