package com.ia.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.ia.dao.HojaDeRutaDAO;
import com.ia.dto.HojaDeRutaDTO;
import com.ia.dto.PedidoDTO;
import com.ia.entities.HojaDeRutaEntity;
import com.ia.entities.PedidoEntity;

public class HojaDeRuta {

	private Integer codHDR;
	private Localidad localidad;
	private Distribuidor distribuidor;
	private LocalDate fechaGeneracion;
	private LocalDate fechaCierre;
	private List<Pedido> pedidos;
	
	public HojaDeRuta(Localidad localidad, Distribuidor distribuidor) {
		super();
		this.localidad = localidad;
		this.distribuidor = distribuidor;
		this.fechaGeneracion = LocalDate.now();
	}

	public HojaDeRuta(HojaDeRutaEntity h) {
		super();
		this.codHDR = h.getCodHDR();
		this.localidad = new Localidad(h.getLocalidad());
		if (this.distribuidor!=null)
			this.distribuidor = new Distribuidor(h.getDistribuidor());
		this.fechaCierre = h.getFechaCierre();
		this.fechaGeneracion = h.getFechaGeneracion();
//		for (PedidoEntity p : h.getPedidos())
//			this.pedidos.add(new Pedido(p));
	}

	public Integer getCodHDR() {
		return codHDR;
	}

	public void setCodHDR(int codHDR) {
		this.codHDR = codHDR;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
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
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public HojaDeRutaDTO toDTO() {
		// Seteo el pedido como null porque no hace falta recuperarlo por ahora
		return new HojaDeRutaDTO(codHDR, localidad.toDTO(), fechaGeneracion, fechaCierre, null);
	}

	public void asignarDistribuidor(Distribuidor d) {
		for (Pedido p : pedidos)
			p.setDistribuidor(d);
		this.distribuidor = d;
		save();
	}
	
	public void save() {
		HojaDeRutaDAO.getInstance().saveOrUpdate(this);
	}
	
	
}
