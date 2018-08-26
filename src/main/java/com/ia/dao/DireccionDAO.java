package com.ia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ia.entities.DireccionEntity;
import com.ia.hbt.HibernateCore;
import com.ia.negocio.Direccion;

public class DireccionDAO {

	private static DireccionDAO instance;
	
	private DireccionDAO() {}
	
	public static DireccionDAO getInstance() {
		if (instance==null)
			instance = new DireccionDAO();
		return instance;
	}
	
	public Direccion findByLatLong(String latitud, String longitud) {
		DireccionEntity ce;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		ce = (DireccionEntity) session.createQuery("from DireccionEntity where latitud = ?1 and longitud = ?2")
				.setParameter(1, latitud)
				.setParameter(2, longitud)
				.uniqueResult();
		session.close();
		if (ce!=null) {
			Direccion c = new Direccion(ce);
			return c;
		}
		else
			return null;
	}

	public void saveOrUpdate(Direccion d) {
		DireccionEntity de = d.toEntity();
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(de);
		session.getTransaction().commit();
		session.close();
	}
}
