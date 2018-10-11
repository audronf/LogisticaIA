package com.ia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "HojasDeRuta_Pedidos",
uniqueConstraints = {@UniqueConstraint(columnNames = {"codHDR", "codPedido"})}	)
public class HojaDeRutaPedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "codHDR")
	private HojaDeRutaEntity hojaDeRuta;
	@ManyToOne
	@JoinColumn(name = "codPedido")
	private PedidoEntity pedido;

	public HojaDeRutaPedidoEntity() {
	}

	public HojaDeRutaPedidoEntity(HojaDeRutaEntity hojaDeRuta, PedidoEntity pedido) {
		super();
		this.hojaDeRuta = hojaDeRuta;
		this.pedido = pedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public HojaDeRutaEntity getHojaDeRuta() {
		return hojaDeRuta;
	}

	public void setHojaDeRuta(HojaDeRutaEntity hojaDeRuta) {
		this.hojaDeRuta = hojaDeRuta;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hojaDeRuta == null) ? 0 : hojaDeRuta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HojaDeRutaPedidoEntity other = (HojaDeRutaPedidoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}

}
