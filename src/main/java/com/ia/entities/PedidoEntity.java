package com.ia.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("deprecation")
@Entity
@Table(name="Pedidos")
public class PedidoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codPedido")
	private int codPedido;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idCliente")
	private ClienteEntity cliente;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idDireccion")
	private DireccionEntity direccion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dniDistribuidor")
	private DistribuidorEntity distribuidor;
	private boolean fragil;
	private String informacion;
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	private LocalDate fechaEntrega;
	private boolean logistica;
	private String incidencia;

	public PedidoEntity() {}

	public PedidoEntity(ClienteEntity cliente, DireccionEntity direccion,
			DistribuidorEntity distribuidor, boolean fragil, String informacion, LocalDate fechaIngreso,
			LocalDate fechaSalida, LocalDate fechaEntrega, boolean logistica, String incidencia) {
		super();
		this.cliente = cliente;
		this.direccion = direccion;
		this.distribuidor = distribuidor;
		this.fragil = fragil;
		this.informacion = informacion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.fechaEntrega = fechaEntrega;
		this.logistica = logistica;
		this.incidencia = incidencia;
	}

	public PedidoEntity(ClienteEntity cliente, DireccionEntity direccion, boolean fragil, String informacion,
			LocalDate fechaIngreso, LocalDate fechaSalida, LocalDate fechaEntrega, boolean logistica,
			String incidencia) {
		super();
		this.cliente = cliente;
		this.direccion = direccion;
		this.fragil = fragil;
		this.informacion = informacion;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.fechaEntrega = fechaEntrega;
		this.logistica = logistica;
		this.incidencia = incidencia;
	}

	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public DireccionEntity getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionEntity direccion) {
		this.direccion = direccion;
	}

	public DistribuidorEntity getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(DistribuidorEntity distribuidor) {
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
