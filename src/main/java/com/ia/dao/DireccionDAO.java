package com.ia.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.ia.entities.DireccionEntity;
import com.ia.entities.LocalidadEntity;
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
	
	public boolean existeLaLocalidad(String descripcion) {
		LocalidadEntity le = null;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		le = (LocalidadEntity) session.createQuery("from LocalidadEntity where descripcion = ?1")
				.setParameter(1, descripcion)
				.uniqueResult();
		session.close();
		
		return (le!=null);
	}
	
	public LocalidadEntity getLocalidad(String descripcion) {
		LocalidadEntity le = null;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		le = (LocalidadEntity) session.createQuery("from LocalidadEntity where descripcion = ?1")
				.setParameter(1, descripcion)
				.uniqueResult();
		session.close();
		return le;
	}

	public void saveOrUpdate(Direccion d) {
		DireccionEntity de = d.toEntity();
		de.setLocalidad(getLocalidad(d.getLocalidad().getDescripcion()));
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session2 = sf.openSession();
		// Guardo la localidad primero
		if (!existeLaLocalidad(de.getLocalidad().getDescripcion())) {
			session2.beginTransaction();
			session2.saveOrUpdate(de);
			session2.getTransaction().commit();
			session2.close();
		}
		else {
			de.setLocalidad(getLocalidad(de.getLocalidad().getDescripcion()));
			session2.beginTransaction();
			session2.saveOrUpdate(de);
			session2.getTransaction().commit();
			session2.close();
		}
//		if (!existeLaLocalidad(de.getLocalidad().getDescripcion())) {
//			session2.beginTransaction();
//			LocalidadEntity le = new LocalidadEntity(d.getLocalidad().getDescripcion());
//			de.setLocalidad(le);
//			session2.saveOrUpdate(le); 
//			session2.getTransaction().commit();
//			session2.close();
//		}
//		else {
//			de.setLocalidad(getLocalidad(de.getLocalidad().getDescripcion()));
//		}
//		Session session = sf.openSession();
//		session.beginTransaction();
//		session.saveOrUpdate(de);
//		session.getTransaction().commit();
//		session.close();
	}
}
