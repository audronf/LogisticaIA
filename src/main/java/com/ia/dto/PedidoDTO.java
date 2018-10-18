package com.ia.dto;

import java.time.LocalDate;

public class PedidoDTO {
	private int codPedido;
	private ClienteDTO cliente;
	private DireccionDTO direccion;
	private DistribuidorDTO distribuidor;
	private boolean fragil;
	private String informacion;
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	private LocalDate fechaEntrega;
	private boolean logistica;
	private String incidencia;
	private String estado;
	
	public PedidoDTO(int codPedido/*, ClienteDTO cliente, DireccionDTO direccion*/,
			boolean fragil, String informacion, boolean logistica, String incidencia) {
		super();
		this.codPedido = codPedido;
//		this.cliente = cliente;
//		this.direccion = direccion;
		this.fragil = fragil;
		this.informacion = informacion;
		this.logistica = logistica;
		this.incidencia = incidencia;
		this.estado = verEstado();
	}
	
	private String verEstado() {
		String est;
		if (this.fechaIngreso!=null && this.fechaSalida==null && this.fechaEntrega==null)
			est = "En deposito";
		else if ( this.fechaSalida!=null && this.fechaEntrega==null)
			est = "En camino";
		else if (this.fechaEntrega!=null)
			est = "Entregado";
		else
			est = "No existe";
		return est;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCodPedido() {
		return codPedido;
	}
	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public DireccionDTO getDireccion() {
		return direccion;
	}
	public void setDireccion(DireccionDTO direccion) {
		this.direccion = direccion;
	}
	public DistribuidorDTO getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(DistribuidorDTO distribuidor) {
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

	@Override
	public String toString() {
		return codPedido + " - " + direccion.getCalle() + " " + direccion.getNumero() + ", " + direccion.getLocalidad().getDescripcion() + " - " + informacion;
	}
	
	
	
	
}
