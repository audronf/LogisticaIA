package com.ia.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.ia.dao.ClienteDAO;
import com.ia.dao.DireccionDAO;
import com.ia.dao.DistribuidorDAO;
import com.ia.dao.HojaDeRutaDAO;
import com.ia.dao.PedidoDAO;
import com.ia.dto.ClienteDTO;
import com.ia.dto.DireccionDTO;
import com.ia.dto.DistribuidorDTO;
import com.ia.dto.HojaDeRutaDTO;
import com.ia.dto.PedidoDTO;
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
		Pedido p = new Pedido(c, d, null, fragil, informacion, logistica);
		p.save();
		EmailController.getInstance().enviarCorreoNuevoPedido(p);
			
	}
	
	public void pedidosDiarios(){
		List <Pedido> pedidos = PedidoDAO.getInstance().pedidosSinAsignar();
		if(!pedidos.isEmpty())
			llenarHojaDeRuta(pedidos);
	}
	
	public void llenarHojaDeRuta(List<Pedido> pedidos){
		Map<Localidad, List<Pedido>> map = new HashMap<Localidad, List<Pedido>>();
		Multimap<Localidad, Pedido> multimap = ArrayListMultimap.create();
//		for (Pedido item : pedidos) {
//			if (map.containsKey(new Localidad(DireccionDAO.getInstance().getLocalidad(item.getDireccion().getLocalidad().getDescripcion()))))
//				map.get(new Localidad(DireccionDAO.getInstance().getLocalidad(item.getDireccion().getLocalidad().getDescripcion()))).add(item);
//			else {
//				map.put(new Localidad(DireccionDAO.getInstance().getLocalidad(item.getDireccion().getLocalidad().getDescripcion())), new ArrayList<Pedido>());
//				map.get(new Localidad(DireccionDAO.getInstance().getLocalidad(item.getDireccion().getLocalidad().getDescripcion()))).add(item);
//			}
		
		for (Pedido p : pedidos) {
			multimap.put(new Localidad(p.getDireccion().getLocalidad().getDescripcion()), p);
		}
		

			
				//		  List<Pedido> list = map.get(new Localidad(DireccionDAO.getInstance().getLocalidad(item.getDireccion().getLocalidad().getDescripcion())));
//		  if (list == null) {
//		    list = new ArrayList<Pedido>();
//		    map.put(new Localidad(DireccionDAO.getInstance().getLocalidad(item.getDireccion().getLocalidad().getDescripcion())), list);
//		  }
//		  list.add(item);
		 /*Todo lo de arriba lo que hace es tomar la lista de pedidos y separarlos por el c�digo de 
		    localidad. Crea una lista de listas donde cada lista es una lista de los pedidos de una sola
		    localidad, esta lista se obtiene haciendo map.valules()*/
		for(Collection<Pedido> lista : multimap.asMap().values())
		{
			asignarHojaDeRuta(lista); //cada lista de pedidos de diferente localidad se va a meter en este m�todo.
		}
}
	

	private void asignarHojaDeRuta(Collection<Pedido> pedidos) {
		List<Pedido> lista = new ArrayList<>(pedidos);
		if(lista.size()<maxPedidos) //Si tiene menos de 30 pedidos, listo, se crea la hdr y se le asigna esa lista de pedidos
		{
			HojaDeRuta hdr = new HojaDeRuta(new Localidad(DireccionDAO.getInstance().getLocalidad(lista.get(0).getDireccion().getLocalidad().getDescripcion())));
			hdr.setPedidos(lista);
			for(Pedido p : pedidos)
			{
				p.setFechaSalida(LocalDate.now());
				hdr.getPedidos().add(p);
			}
			hdr.save();	
		}
		else
		{
			List<Pedido> primera = lista.subList(0, lista.size()/2);
			asignarHojaDeRuta(primera);
			List<Pedido> segunda = lista.subList(lista.size()/2, lista.size());
			asignarHojaDeRuta(segunda);
			// Recursi�n. Divide la lista de pedidos a la mitad y prueba hacer lo mismo con cada mitad.
		}
	
	}
	
	public String getEstadoPedido(int codPedido) {
		String estado;
		Pedido p = PedidoDAO.getInstance().findByCodigo(codPedido);
		if (p.getFechaIngreso()!=null &&p.getFechaSalida()==null && p.getFechaEntrega()==null) //Todavía no salió
			estado = "En depósito";
		else if (p.getFechaIngreso()!=null && p.getFechaSalida()!=null && p.getFechaEntrega()==null) //Todavía no fue entregado
			estado = "En camino";
		else if (p.getFechaEntrega()!=null && p.getFechaIngreso()!=null && p.getFechaSalida()!=null)
			estado = "Entregado";
		else
			estado = "No existe";
		return estado;
	}
	
	public PedidoDTO getPedido(int codPedido) {
		Pedido p = PedidoDAO.getInstance().findByCodigo(codPedido);
		if (p!=null) {		
			p.setDistribuidor(null);
			return p.toDTO();
		}
		else
			return null;
	}
	
	public List<HojaDeRutaDTO> verHojasDeRuta() {
		List<HojaDeRuta> hdrs = HojaDeRutaDAO.getInstance().findAll();
		List<HojaDeRutaDTO> hdto = new ArrayList<HojaDeRutaDTO>();
		for (HojaDeRuta h : hdrs)
			hdto.add(h.toDTO());
		return hdto;
	}
	
	public List<DistribuidorDTO> verDistribuidoresLocalidad(String localidad){
		List<Distribuidor> distribuidores = DistribuidorDAO.getInstance().findByLocalidad(localidad);
		List<DistribuidorDTO> ddto = new ArrayList<DistribuidorDTO>();
		for (Distribuidor d : distribuidores)
			ddto.add(d.toDTO());
		return ddto;
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

	public void asignarHojaDeRuta(int codHDR, String dniDistribuidor) {
		HojaDeRuta hdr = HojaDeRutaDAO.getInstance().findByCodigo(codHDR);
		Distribuidor d = DistribuidorDAO.getInstance().findByDNI(dniDistribuidor);
		System.out.println(hdr + " " + d);
		hdr.asignarDistribuidor(d);
	}

	public boolean verificarCredencialesProveedor(String usr, String pass) {
		return DistribuidorDAO.getInstance().proveedorValido(usr, pass);
	}

	public List<PedidoDTO> verPedidosPendientes(String username) {
		List<Pedido> pedidos = PedidoDAO.getInstance().verPedidosPendientes(username);
		List<PedidoDTO> pdto = new ArrayList<PedidoDTO>();
		for (Pedido p : pedidos)
			pdto.add(p.toDTO());
		return pdto;
	}

	public void pedidoEntregado(String codPedido) {
		Pedido p = PedidoDAO.getInstance().findByCodigo(Integer.parseInt(codPedido));
		p.setFechaEntrega(LocalDate.now());
	}

	public void registrarIncidencia(String codPedido, String text) {
		Pedido p = PedidoDAO.getInstance().findByCodigo(Integer.parseInt(codPedido));
		p.setIncidencia(text);

	}
}
