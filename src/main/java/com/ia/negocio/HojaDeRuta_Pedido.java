package com.ia.negocio;

public class HojaDeRuta_Pedido {
	private HojaDeRuta hojaDeRuta;
	private Pedido pedido;

	public HojaDeRuta_Pedido(HojaDeRuta hojaDeRuta, Pedido pedido) {
		super();
		this.hojaDeRuta = hojaDeRuta;
		this.pedido = pedido;
	}
	
	public HojaDeRuta getHojaDeRuta() {
		return hojaDeRuta;
	}
	public void setHojaDeRuta(HojaDeRuta hojaDeRuta) {
		this.hojaDeRuta = hojaDeRuta;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
