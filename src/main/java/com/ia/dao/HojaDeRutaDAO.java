package com.ia.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.ia.entities.HojaDeRutaEntity;
import com.ia.entities.LocalidadEntity;
import com.ia.hbt.HibernateCore;
import com.ia.negocio.HojaDeRuta;

public class HojaDeRutaDAO {

	private static HojaDeRutaDAO instance;
	
	private HojaDeRutaDAO() {}
	
	public static HojaDeRutaDAO getInstance() {
		if (instance == null)
			instance = new HojaDeRutaDAO();
		return instance;
	}
	
	public HojaDeRuta findByCodigo(int codHDR) {
		HojaDeRutaEntity hdr = null;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		hdr = (HojaDeRutaEntity)session.createQuery("from HojaDeRutaEntity where codHDR = ?1")
				.setParameter(1, codHDR)
				.uniqueResult();
//		Criteria cr = session.createCriteria(HojaDeRutaEntity.class)
//			    .setProjection(Projections.projectionList()
//			      .add(Projections.property("codHDR"), "codHDR")
//			      .add(Projections.property("localidad"), "localidad")
//			      .add(Projections.property("fechaGeneracion"), "fechaGeneracion")
//			      .add(Projections.property("fechaCierre"), "fechaCierre"))
//			    .setResultTransformer(Transformers.aliasToBean(HojaDeRutaEntity.class));
		session.close();
		return new HojaDeRuta(hdr);
	}
	
	@SuppressWarnings("unchecked")
	public List<HojaDeRuta> findAll(){
		List<HojaDeRutaEntity> hdrs = new ArrayList<HojaDeRutaEntity>();
		List<HojaDeRuta> ret = new ArrayList<HojaDeRuta>();
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		hdrs = (List<HojaDeRutaEntity>)session.createQuery("from HojaDeRutaEntity").list();
		for (HojaDeRutaEntity h : hdrs) 
			ret.add(new HojaDeRuta(h));
		session.close();
		return ret;
	}
	
	public void saveOrUpdate(HojaDeRuta hdr) {
		HojaDeRutaEntity h = new HojaDeRutaEntity(new LocalidadEntity(hdr.getLocalidad().getId(), hdr.getLocalidad().getDescripcion()), null, hdr.getFechaGeneracion());
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(h);
		session.getTransaction().commit();
		session.close();
	}

	public void saveDistribuidor(HojaDeRuta hdr) {
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		@SuppressWarnings("rawtypes")
		Query query = session.createSQLQuery(
			    "update HojasDeRuta set dniDistribuidor = ?1" + " where codHDR = ?2");
			query.setParameter(1, hdr.getDistribuidor().getDni());
			query.setParameter(2, hdr.getCodHDR());
			query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
}
