package com.ia.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="HojasDeRuta")
public class HojaDeRutaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codHDR;
	@OneToMany
	@JoinColumn(name="idLocalidad")
	private LocalidadEntity localidad;
	@OneToMany
	@JoinColumn(name="dniDistribuidor")
	private DistribuidorEntity distribuidor;
	private LocalDate fechaGeneracion;
	private LocalDate fechaCierre;
	
	public HojaDeRutaEntity(){}
	
	public HojaDeRutaEntity(int codHDR, LocalidadEntity localidad, DistribuidorEntity distribuidor,
			LocalDate fechaGeneracion, LocalDate fechaCierre) {
		super();
		this.codHDR = codHDR;
		this.localidad = localidad;
		this.distribuidor = distribuidor;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaCierre = fechaCierre;
	}

	public int getCodHDR() {
		return codHDR;
	}

	public void setCodHDR(int codHDR) {
		this.codHDR = codHDR;
	}

	public LocalidadEntity getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadEntity localidad) {
		this.localidad = localidad;
	}

	public DistribuidorEntity getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(DistribuidorEntity distribuidor) {
		this.distribuidor = distribuidor;
	}

	public LocalDate getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(LocalDate fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public LocalDate getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	
	
	

}
