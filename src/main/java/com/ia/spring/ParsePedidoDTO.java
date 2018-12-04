package com.ia.spring;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParsePedidoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2461237366546785398L;
	private Integer idPedido;		//Para enviar al almacen, null, luego el almacen le enviará una id
	private String nombreAlmacen;	//Nombre String que identifica el almacén de origen/destino.
	private long fecha;				//null o "fecha = new Date()" para enviar
	private String estadoPedido;	//'vacio' para enviar, luego recibe estados de pedido
	private boolean requiereLogistica;
	
	private ParseClienteDTO cliente;
	private ParseDireccionDTO direccion;
	private boolean fragil;
	
	private List<ParseItemPedidoDTO> items;
	
	//Constructor
	public ParsePedidoDTO() {
		this.items = new ArrayList<ParseItemPedidoDTO>();
	}
	
	
	//Constructor
	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	
	public String getNombreAlmacen() {
		return nombreAlmacen;
	}


	public void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public long getFecha() {
		return fecha;
	}

	public void setFecha(long fecha) {
		this.fecha = fecha;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public boolean isRequiereLogistica() {
		return requiereLogistica;
	}

	public void setRequiereLogistica(boolean requiereLogistica) {
		this.requiereLogistica = requiereLogistica;
	}

	public ParseClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ParseClienteDTO cliente) {
		this.cliente = cliente;
	}

	public ParseDireccionDTO getDireccion() {
		return direccion;
	}

	public void setDireccion(ParseDireccionDTO direccion) {
		this.direccion = direccion;
	}

	public boolean isFragil() {
		return fragil;
	}

	public void setFragil(boolean fragil) {
		this.fragil = fragil;
	}

	public List<ParseItemPedidoDTO> getItems() {
		return items;
	}

	public void setItems(List<ParseItemPedidoDTO> items) {
		this.items = items;
	}

}
