package com.ia.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ia.entities.DistribuidorEntity;
import com.ia.entities.LocalidadEntity;
import com.ia.hbt.HibernateCore;
import com.ia.negocio.Distribuidor;

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
	public List<DistribuidorEntity> findAll() {
		List<DistribuidorEntity> distribuidores = new ArrayList<DistribuidorEntity>();
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		distribuidores = (ArrayList<DistribuidorEntity>) session.createQuery("from DistribuidorEntity").list();

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
		return distribuidores;
	}
}
