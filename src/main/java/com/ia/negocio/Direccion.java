package com.ia.negocio;

import com.ia.dao.DireccionDAO;
import com.ia.dto.DireccionDTO;
import com.ia.entities.DireccionEntity;
import com.ia.entities.LocalidadEntity;

public class Direccion {
	private int idDireccion;
	private String longitud;
	private String latitud;
	private String provincia;
	private Localidad localidad;
	private String calle;
	private int numero;
	private int piso;
	private String unidad;
	private String entreCalles;
	private String codigoPostal;
	private boolean geolocalizado;
	
	public Direccion(String longitud, String latitud, String provincia, Localidad localidad, String calle, int numero,
			int piso, String unidad, String entreCalles, String codigoPostal) {
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
	}

	public Direccion(DireccionEntity de) {
		super();
		this.idDireccion = de.getIdDireccion();
		this.longitud = de.getLongitud();
		this.latitud = de.getLatitud();
		this.provincia = de.getProvincia();
		this.localidad = new Localidad(de.getLocalidad());
		this.calle = de.getCalle();
		this.numero = de.getNumero();
		this.piso = de.getPiso();
		this.unidad = de.getUnidad();
		this.entreCalles = de.getEntreCalles();
		this.codigoPostal = de.getCodigoPostal();
	}
	
	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
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

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
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
	
	public DireccionDTO toDTO() {
		return new DireccionDTO(longitud, latitud, provincia, localidad.toDTO(), calle, numero, piso, unidad, entreCalles, codigoPostal, geolocalizado);
	}
	
	public DireccionEntity toEntity() {
		LocalidadEntity le = DireccionDAO.getInstance().getLocalidad(this.localidad.getDescripcion());
		if (le==null)
			le = new LocalidadEntity(this.localidad.getDescripcion());
		return new DireccionEntity(longitud, latitud, provincia, le, calle, numero, piso, unidad, entreCalles, codigoPostal, geolocalizado);
	}

	public void save() {
		DireccionDAO.getInstance().saveOrUpdate(this);
		
	}
}
