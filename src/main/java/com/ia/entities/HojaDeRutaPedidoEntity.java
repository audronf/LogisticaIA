package com.ia.entities;

//@Entity
//@Table(name="HojasDeRuta_Pedidos")
public class HojaDeRutaPedidoEntity {

	private HojaDeRutaEntity hojaDeRuta;
	private PedidoEntity pedido;

	public HojaDeRutaPedidoEntity() {
	}

	public HojaDeRutaPedidoEntity(HojaDeRutaEntity hojaDeRuta, PedidoEntity pedido) {
		super();
		this.hojaDeRuta = hojaDeRuta;
		this.pedido = pedido;
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
