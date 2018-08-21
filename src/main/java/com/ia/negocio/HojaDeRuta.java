package com.ia.negocio;

import java.time.LocalDate;

public class HojaDeRuta {

	private int codHDR;
	private Localidad localidad;
	private Distribuidor distribuidor;
	private LocalDate fechaGeneracion;
	private LocalDate fechaCierre;
	
	public HojaDeRuta(Localidad localidad, Distribuidor distribuidor, LocalDate fechaGeneracion) {
		super();
		this.localidad = localidad;
		this.distribuidor = distribuidor;
		this.fechaGeneracion = LocalDate.now();;
	}

	public int getCodHDR() {
		return codHDR;
	}

	public void setCodHDR(int codHDR) {
		this.codHDR = codHDR;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
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
