package com.ia.dto;

import java.time.LocalDate;
import java.util.List;

public class HojaDeRutaDTO {

	private int codHDR;
	private LocalidadDTO localidad;
	private DistribuidorDTO distribuidor;
	private LocalDate fechaGeneracion;
	private LocalDate fechaCierre;
	private List<PedidoDTO> pedidos;
	
	public HojaDeRutaDTO(int codHDR, LocalidadDTO localidad, LocalDate fechaGeneracion,
			LocalDate fechaCierre, List<PedidoDTO> pedidos) {
		super();
		this.codHDR = codHDR;
		this.localidad = localidad;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaCierre = fechaCierre;
		this.pedidos = pedidos;
	}
	public int getCodHDR() {
		return codHDR;
	}
	public void setCodHDR(int codHDR) {
		this.codHDR = codHDR;
	}
	public LocalidadDTO getLocalidad() {
		return localidad;
	}
	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}
	public DistribuidorDTO getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(DistribuidorDTO distribuidor) {
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
	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}
	
	@Override
	public String toString() {
		return codHDR + " - " + localidad.getDescripcion() + " - " + fechaGeneracion;
	}
	
	
	
}
