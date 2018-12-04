package com.ia.spring;

public class ParseItemPedidoDTO {

	private Integer idPedidoItem;
	private ParseProductoDTO producto;
	private int cantidad;
	
	
	
	
	//Constructor
	public ParseItemPedidoDTO() {
		super();
	}
	
	
	
	//Getters y setters
	public Integer getIdPedidoItem() {
		return idPedidoItem;
	}


	public void setIdPedidoItem(Integer idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}
	

	public ParseProductoDTO getProducto() {
		return producto;
	}


	public void setProducto(ParseProductoDTO producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}
	
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
