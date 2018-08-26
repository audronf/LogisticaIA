package com.ia.controller;

import com.ia.dao.ClienteDAO;
import com.ia.dao.DireccionDAO;
import com.ia.dao.DistribuidorDAO;
import com.ia.dto.ClienteDTO;
import com.ia.dto.DireccionDTO;
import com.ia.dto.DistribuidorDTO;
import com.ia.negocio.Cliente;
import com.ia.negocio.Direccion;
import com.ia.negocio.Distribuidor;
import com.ia.negocio.Localidad;
import com.ia.negocio.Pedido;

public class Controller {
	
	private static Controller instance;
	
	private Controller() {}
	
	public static Controller getInstance() {
		if (instance==null)
			instance = new Controller();
		return instance;
	}

	public void altaPedido(ClienteDTO cliente, DireccionDTO direccion, DistribuidorDTO distribuidor, boolean fragil, String informacion, boolean logistica) {
		Cliente c = buscarCliente(cliente.getIdentificador());
		Direccion d = buscarDireccion(direccion.getLatitud(), direccion.getLongitud());
		Distribuidor dist = buscarDistribuidor(distribuidor.getDni());
		if (c==null) {
			c = new Cliente(cliente.getIdentificador(), cliente.getNombre(), cliente.getEmail());
			c.save();
		}
		if (d==null) {
			Localidad loc = new Localidad(direccion.getLocalidad().getDescripcion());
			d = new Direccion(direccion.getLongitud(), direccion.getLatitud(), direccion.getProvincia(), loc, direccion.getCalle(),
					direccion.getNumero(), direccion.getPiso(), direccion.getUnidad(), direccion.getEntreCalles(), direccion.getCodigoPostal());
			d.setGeolocalizado(direccion.isGeolocalizado());
			d.save();
		}
		Pedido p = new Pedido(c, d, dist, fragil, informacion, logistica);
		p.save();
			
	}

	private Distribuidor buscarDistribuidor(String dni) {
		return DistribuidorDAO.getInstance().findByDNI(dni);
	}

	private Direccion buscarDireccion(String latitud, String longitud) {
		return DireccionDAO.getInstance().findByLatLong(latitud, longitud);
	}

	private Cliente buscarCliente(String identificador) {
		return ClienteDAO.getInstance().findByID(identificador);
	}
}
