package com.ia.gui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.ia.controller.Controller;
import com.ia.dao.DireccionDAO;
import com.ia.dao.PedidoDAO;
import com.ia.negocio.HojaDeRuta;
import com.ia.negocio.Localidad;
import com.ia.negocio.Pedido;
import com.ia.task.TaskAsignarPedidos;

public class CrearHojasDeRuta {

	public static void main(String[] args) {
//		Timer timer = new Timer();
//		timer.schedule(new TaskAsignarPedidos(), 0, 5000);
		Controller.getInstance().pedidosDiarios();
		

//		Pedido p1 = PedidoDAO.getInstance().findByCodigo(12);
//		Pedido p2 = PedidoDAO.getInstance().findByCodigo(13);
//		Pedido p3 = PedidoDAO.getInstance().findByCodigo(14);
//		Localidad l = new Localidad(DireccionDAO.getInstance().getLocalidad("Lanús"));
//		HojaDeRuta h = new HojaDeRuta (l, null);
//		List<Pedido> pedidos = new ArrayList<Pedido>();
//		pedidos.add(p1);
//		pedidos.add(p2);
//		pedidos.add(p3);
//		h.setPedidos(pedidos);
//		for (Pedido p : pedidos)
//			p.setFechaSalida(LocalDate.now());
//		h.save();


	}

}
