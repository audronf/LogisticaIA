package com.ia.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ia.controller.Controller;
import com.ia.negocio.Cliente;
import com.ia.negocio.Direccion;
import com.ia.negocio.Distribuidor;
import com.ia.negocio.Localidad;
import com.ia.negocio.Pedido;

public class Test {
	public static void main(String[] args) {
		Localidad uno = new Localidad("uno");
		Localidad dos = new Localidad("dos");
		Localidad tres = new Localidad("tres");
		uno.setId(1);
		dos.setId(2);
		tres.setId(3);
		Direccion d1 = new Direccion("asd", "asd", "asd", uno, "asd", 1, 1, "asd", "asd", "asd");
		Direccion d2 = new Direccion("asd", "asd", "asd", dos, "asd", 1, 1, "asd", "asd", "asd");
		Direccion d3 = new Direccion("asd", "asd", "asd", tres, "asd", 1, 1, "asd", "asd", "asd");
		Pedido p1 = new Pedido(null, d1, null, false, "1", true);
		Pedido p2 = new Pedido(null, d2, null, false, "1", true);
		Pedido p3 = new Pedido(null, d3, null, false, "6", true);
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(p1);
		pedidos.add(p2);
		pedidos.add(p3);
		Controller.getInstance().llenarHdr(pedidos);
	}

	
	
}
