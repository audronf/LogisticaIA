package com.ia.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ia.entities.DistribuidorEntity;
import com.ia.entities.DistribuidorLocalidadEntity;
import com.ia.entities.LocalidadEntity;
import com.ia.entities.PedidoEntity;
import com.ia.hbt.HibernateCore;
import com.ia.negocio.Distribuidor;
import com.ia.negocio.Localidad;
import com.ia.negocio.Pedido;

public class DistribuidorDAO {

	private static DistribuidorDAO instance;

	private DistribuidorDAO() {
	}

	public static DistribuidorDAO getInstance() {
		if (instance == null)
			instance = new DistribuidorDAO();
		return instance;
	}

	public Distribuidor findByDNI(String dni) {
		DistribuidorEntity ce;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		ce = (DistribuidorEntity) session.createQuery("from DistribuidorEntity where dni = ?1").setParameter(1, dni)
				.uniqueResult();
		session.close();
		if (ce != null) {
			Distribuidor c = new Distribuidor(ce);
			return c;
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	public List<Distribuidor> findAll() {
		List<DistribuidorEntity> distribuidores = new ArrayList<DistribuidorEntity>();
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		distribuidores = (ArrayList<DistribuidorEntity>) session.createQuery("from DistribuidorEntity").list();
		List<Distribuidor> ret = new ArrayList<Distribuidor>();

		// Todo esto no hace falta. Lo dejo por si en algún momento se rompe la cascade
		// entre Distribuidores y Distribuidores_Localidades

		// for (DistribuidorEntity de : distribuidores) {
		// List<LocalidadEntity> localidades = (ArrayList<LocalidadEntity>)
		// session.createQuery("from DistribuidorLocalidadEntity where dniDistribuidor =
		// ?1")
		// .setParameter(1, de.getDni())
		// .list();
		// for (LocalidadEntity le : localidades) {
		// de.getLocalidades().add(le);
		// }
		// }
		session.close();
		for (DistribuidorEntity d : distribuidores)
			ret.add(new Distribuidor(d));
		return ret;
	}

	@SuppressWarnings("unchecked")
	public List<Distribuidor> findByLocalidad(String localidad) {
		List<DistribuidorEntity> distribuidores = new ArrayList<DistribuidorEntity>();
		List<Distribuidor> ret = new ArrayList<Distribuidor>();
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		Session session2 = sf.openSession();
		LocalidadEntity l = (LocalidadEntity) session.createQuery("from LocalidadEntity where descripcion = ?1")
				.setParameter(1, localidad).uniqueResult();
		List<DistribuidorLocalidadEntity> dle = (ArrayList<DistribuidorLocalidadEntity>) session
				.createQuery("from DistribuidorLocalidadEntity where idLocalidad = ?1").setParameter(1, l.getId()).list();
//		for (DistribuidorLocalidadEntity s : dle) {
//			DistribuidorEntity de = (DistribuidorEntity) session2.createQuery("from DistribuidorEntity where dni = ?0")
//					.setParameter(0, s.getDistribuidor().getDni())
//					.uniqueResult();
//			ret.add(new Distribuidor(de));
//		}
		for (DistribuidorLocalidadEntity d : dle)
			ret.add(new Distribuidor(d.getDistribuidor()));
		session.close();
		session2.close();
		return ret;
	}

	public Distribuidor findByUsername(String username) {
		DistribuidorEntity ce;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		ce = (DistribuidorEntity) session.createQuery("from DistribuidorEntity where username = ?1").setParameter(1, username)
				.uniqueResult();
		session.close();
		if (ce != null) {
			Distribuidor c = new Distribuidor(ce);
			return c;
		} else
			return null;
	}
	
	public boolean proveedorValido(String usr, String pass) {
		DistribuidorEntity de = null;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		de = (DistribuidorEntity) session.createQuery("from DistribuidorEntity where username = ?0 and password = ?1")
				.setParameter(0, usr)
				.setParameter(1, pass)
				.uniqueResult();
		return (de!=null);
	}
}
