package com.ia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ia.entities.PedidoEntity;
import com.ia.hbt.HibernateCore;
import com.ia.negocio.Pedido;

public class PedidoDAO {

	private static PedidoDAO instance;
	
	private PedidoDAO() {}
	
	public static PedidoDAO getInstance() {
		if (instance==null)
			instance = new PedidoDAO();
		return instance;
	}
	
	public void saveOrUpdate(Pedido p) {
		PedidoEntity pe = new PedidoEntity(p.getCliente().toEntity(), p.getDireccion().toEntity(), p.getDistribuidor().toEntity(), p.isFragil(), p.getInformacion(), p.getFechaIngreso(), p.getFechaSalida(), p.getFechaEntrega(), p.isLogistica(), p.getIncidencia());
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(pe);
		session.getTransaction().commit();
		session.close();
	}
}
