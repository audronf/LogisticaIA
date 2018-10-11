package com.ia.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Distribuidores_Localidades")
public class DistribuidorLocalidadEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "dniDistribuidor")
	private DistribuidorEntity distribuidor;
	@ManyToOne
	@JoinColumn(name = "idLocalidad")
	private LocalidadEntity localidad;

	public DistribuidorLocalidadEntity() {
	}

	public DistribuidorLocalidadEntity(DistribuidorEntity distribuidor, LocalidadEntity localidad) {
		super();
		this.distribuidor = distribuidor;
		this.localidad = localidad;
	}

	public DistribuidorEntity getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(DistribuidorEntity distribuidor) {
		this.distribuidor = distribuidor;
	}

	public LocalidadEntity getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadEntity localidad) {
		this.localidad = localidad;
	}

}
