package com.ia.negocio;

import java.time.LocalDate;

import com.ia.dao.PedidoDAO;
import com.ia.dto.PedidoDTO;
import com.ia.entities.ClienteEntity;
import com.ia.entities.DireccionEntity;
import com.ia.entities.DistribuidorEntity;
import com.ia.entities.PedidoEntity;

public class Pedido {
	private int codPedido;
	private Cliente cliente;
	private Direccion direccion;
	private Distribuidor distribuidor;
	private boolean fragil;
	private String informacion;
	private LocalDate fechaIngreso;
	private LocalDate fechaSalida;
	private LocalDate fechaEntrega;
	private boolean logistica;
	private String incidencia;
	
	public Pedido(Cliente cliente, Direccion direccion, boolean fragil, String informacion, boolean logistica) {
		super();
		this.cliente = cliente;
		this.direccion = direccion;
		this.fragil = fragil;
		this.informacion = informacion;
		this.fechaIngreso = LocalDate.now();
		this.logistica = logistica;
	}

	public Pedido(PedidoEntity pe) {
		super();
		this.codPedido = pe.getCodPedido();
		this.cliente = new Cliente(pe.getCliente());
		this.direccion = new Direccion(pe.getDireccion());
		if(pe.getDistribuidor()==null)
			this.distribuidor = new Distribuidor("0", "Boca", "0", "0");
		else
			this.distribuidor = new Distribuidor(pe.getDistribuidor());
		this.fragil = pe.isFragil();
		this.fechaEntrega = pe.getFechaEntrega();
		this.fechaSalida = pe.getFechaSalida();
		this.fechaIngreso = pe.getFechaIngreso();
		this.informacion = pe.getInformacion();
		this.logistica = pe.isLogistica();
	}
	
	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
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
		updateFechaSalida();
	}

	private void updateFechaSalida() {
		PedidoDAO.getInstance().updateFechaSalida(this);
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
		updateFechaEntrega();
	}

	private void updateFechaEntrega() {
		PedidoDAO.getInstance().updateFechaEntrega(this);
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
		updateIncidencia();
	}
	
	private void updateIncidencia() {
		PedidoDAO.getInstance().updateIncidencia(this);
	}

	public void save() {
		PedidoDAO.getInstance().saveOrUpdate(this);
	}
	
	public PedidoDTO toDTO() {
		PedidoDTO pedido = new PedidoDTO(codPedido, fragil, informacion, logistica, incidencia);
		pedido.setCliente(cliente.toDTO());
		pedido.setDireccion(direccion.toDTO());
		if (this.fechaIngreso!=null) {
			pedido.setFechaIngreso(this.fechaIngreso);
			pedido.setEstado("En depósito");
		}
		else
			pedido.setFechaIngreso(null);
		if (this.fechaEntrega!=null) {
			pedido.setFechaEntrega(this.fechaEntrega);
			pedido.setEstado("En camino");
		}
		else
			pedido.setFechaEntrega(null);
		if (this.fechaSalida!=null) {
			pedido.setFechaSalida(this.fechaSalida);
			pedido.setEstado("Entregado");
		}
		else
			pedido.setFechaSalida(null);
		return pedido;
	}

	public PedidoEntity toEntity() {
		PedidoEntity pe = new PedidoEntity(cliente.toEntity(), direccion.toEntity(), distribuidor.toEntity(), fragil, informacion, fechaIngreso, fechaSalida,
				fechaEntrega, logistica, incidencia);
		pe.setCodPedido(codPedido);
		return pe;
	}

	public void asignarDistribuidor(Distribuidor d) {
		this.distribuidor = d;
		PedidoDAO.getInstance().saveDistribuidor(this);
	}

	
}
