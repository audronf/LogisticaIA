package com.ia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ia.entities.ClienteEntity;
import com.ia.hbt.HibernateCore;
import com.ia.negocio.Cliente;

public class ClienteDAO {

	private static ClienteDAO instance;
	
	private ClienteDAO() {}
	
	public static ClienteDAO getInstance() {
		if (instance==null)
			instance = new ClienteDAO();
		return instance;
	}
	
	public Cliente findByID(String identificador) {
		ClienteEntity ce;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		ce = (ClienteEntity) session.createQuery("from ClienteEntity where identificador = ?1")
				.setParameter(1, identificador)
				.uniqueResult();
		session.close();
		if (ce!=null) {
			Cliente c = new Cliente(ce);
			return c;
		}
		else
			return null;
	}

	public void saveOrUpdate(Cliente cliente) {
		ClienteEntity ce = cliente.toEntity();
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(ce);
		session.getTransaction().commit();
		session.close();
	}
}
