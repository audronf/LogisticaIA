package com.ia.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="HojasDeRuta")
public class HojaDeRutaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codHDR;
	@OneToOne
	@JoinColumn(name="idLocalidad")
	private LocalidadEntity localidad;
	@OneToOne
	@JoinColumn(name="dniDistribuidor")
	private DistribuidorEntity distribuidor;
	private LocalDate fechaGeneracion;
	private LocalDate fechaCierre;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "HojasDeRuta_Pedidos", joinColumns = {@JoinColumn(name = "codHDR")}, inverseJoinColumns = @JoinColumn(name="codPedido"))
	private List<PedidoEntity> pedidos;
	
	
	public HojaDeRutaEntity(){}
	
	public HojaDeRutaEntity(int codHDR, LocalidadEntity localidad, DistribuidorEntity distribuidor,
			LocalDate fechaGeneracion, LocalDate fechaCierre) {
		super();
		this.codHDR = codHDR;
		this.localidad = localidad;
		this.distribuidor = distribuidor;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaCierre = fechaCierre;
		this.pedidos = new ArrayList<PedidoEntity>();
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

	public List<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	

}
