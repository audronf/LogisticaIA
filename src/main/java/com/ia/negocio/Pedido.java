package com.ia.negocio;

import java.time.LocalDate;

public class Pedido {
	private int codPedido;
	private Cliente cliente;
	private Direccion direccion;
	private Distribuidor distribuidor;
	private boolean fragil;
	private String informacion;
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	private LocalDate fechaEntrega;
	private boolean logistica;
	private String incidencia;
	
	public Pedido(Cliente cliente, Direccion direccion, Distribuidor distribuidor, boolean fragil, String informacion,
			LocalDate fechaIngreso, boolean logistica) {
		super();
		this.cliente = cliente;
		this.direccion = direccion;
		this.distribuidor = distribuidor;
		this.fragil = fragil;
		this.informacion = informacion;
		this.fechaIngreso = fechaIngreso;
		this.logistica = logistica;
	}

	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public boolean isFragil() {
		return fragil;
	}

	public void setFragil(boolean fragil) {
		this.fragil = fragil;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public boolean isLogistica() {
		return logistica;
	}

	public void setLogistica(boolean logistica) {
		this.logistica = logistica;
	}

	public String getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}
	

	
}
