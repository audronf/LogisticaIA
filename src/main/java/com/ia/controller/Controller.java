package com.ia.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ia.dao.ClienteDAO;
import com.ia.dao.DireccionDAO;
import com.ia.dao.DistribuidorDAO;
import com.ia.dto.ClienteDTO;
import com.ia.dto.DireccionDTO;
import com.ia.dto.DistribuidorDTO;
import com.ia.negocio.Cliente;
import com.ia.negocio.Direccion;
import com.ia.negocio.Distribuidor;
import com.ia.negocio.HojaDeRuta;
import com.ia.negocio.Localidad;
import com.ia.negocio.Pedido;

public class Controller {
	
	private static Controller instance;
	private final int maxPedidos=30;
	
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
	
	public void llenarHdr(List<Pedido> pedidos)
	{
		Map<Localidad, List<Pedido>> map = new HashMap<Localidad, List<Pedido>>();
		for (Pedido item : pedidos) {
		  List<Pedido> list = map.get(item.getDireccion().getLocalidad());
		  if (list == null) {
		    list = new ArrayList<Pedido>();
		    map.put(item.getDireccion().getLocalidad(), list);
		  }
		  list.add(item);
		} /*Todo lo de arriba lo que hace es tomar la lista de pedidos y separarlos por el código de 
		    localidad. Crea una lista de listas donde cada lista es una lista de los pedidos de una sola
		    localidad, esta lista se obtiene haciendo map.valules()*/
		for(List<Pedido> lista : map.values())
		{
			asignarHDR(lista); //cada lista de pedidos de diferente localidad se va a meter en este método.
		}
	}

	private void asignarHDR(List<Pedido> lista) {
		if(lista.size()<maxPedidos) //Si tiene menos de 30 pedidos, listo, se crea la hdr y se le asigna esa lista de pedidos
		{
			HojaDeRuta hdr = new HojaDeRuta(lista.get(0).getDireccion().getLocalidad(),null,LocalDate.now());
			hdr.setPedidos(lista);
			//hdr.save();
		}
		else
		{
			List<Pedido> primera = lista.subList(0, lista.size()/2);
			asignarHDR(primera);
			List<Pedido> segunda = lista.subList(lista.size()/2, lista.size());
			asignarHDR(segunda);
			// Recursión. Divide la lista de pedidos a la mitad y prueba hacer lo mismo con cada mitad.
		}
	
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
