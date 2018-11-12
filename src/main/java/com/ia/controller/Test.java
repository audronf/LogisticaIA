package com.ia.controller;

import com.ia.dao.HojaDeRutaDAO;
import com.ia.dao.PedidoDAO;
import com.ia.negocio.Cliente;
import com.ia.negocio.Direccion;
import com.ia.negocio.Distribuidor;
import com.ia.negocio.HojaDeRuta;
import com.ia.negocio.Localidad;
import com.ia.negocio.Pedido;

public class Test {
public static void main(String[] args) {
	Distribuidor di = new Distribuidor("9", "5", "Rep55", "5");
	Cliente c = new Cliente("1","Claudio Godio","federicofasitella@gmail.com");
	Localidad l = new Localidad("Palermo");
    Direccion d = new Direccion("123","123","Buenos aires",l,"Alsina",782,1,"A","asd","1842");
    Pedido p = new Pedido(c,d,false,"cs",false);
    p.save();

//    p.setCodPedido(PedidoDAO.getInstance().findUltimo().getCodPedido());
//    EmailController.getInstance().enviarCorreoNuevoPedido(p);
//    HojaDeRutaDAO.getInstance().saveOrUpdate(new HojaDeRuta(l, di));
    
    
	}
}
