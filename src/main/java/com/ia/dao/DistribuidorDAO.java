package com.ia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ia.entities.DistribuidorEntity;
import com.ia.hbt.HibernateCore;
import com.ia.negocio.Distribuidor;

public class DistribuidorDAO {

	private static DistribuidorDAO instance;
	
	private DistribuidorDAO() {}
	
	public static DistribuidorDAO getInstance() {
		if (instance==null)
			instance = new DistribuidorDAO();
		return instance;
	}
	
	public Distribuidor findByDNI(String dni) {
		DistribuidorEntity ce;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		ce = (DistribuidorEntity) session.createQuery("from DistribuidorEntity where dni = ?1")
				.setParameter(1, dni)
				.uniqueResult();
		session.close();
		if (ce!=null) {
			Distribuidor c = new Distribuidor(ce);
			return c;
		}
		else
			return null;
	}
}
