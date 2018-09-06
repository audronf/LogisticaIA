package com.ia.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HojasDeRuta_Pedidos")
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

	public HojaDeRutaPedidoEntity(Integer id, HojaDeRutaEntity hojaDeRuta, PedidoEntity pedido) {
		super();
		this.id = id;
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

}
