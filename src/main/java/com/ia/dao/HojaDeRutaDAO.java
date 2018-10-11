package com.ia.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.AnnotationException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.ia.entities.HojaDeRutaEntity;
import com.ia.entities.HojaDeRutaPedidoEntity;
import com.ia.entities.LocalidadEntity;
import com.ia.entities.PedidoEntity;
import com.ia.hbt.HibernateCore;
import com.ia.negocio.HojaDeRuta;
import com.ia.negocio.Localidad;
import com.ia.negocio.Pedido;

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
		
//		hdr = (HojaDeRutaEntity) cr.uniqueResult();
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
		SessionFactory sf = HibernateCore.getSessionFactory();
		HojaDeRutaEntity h = new HojaDeRutaEntity(DireccionDAO.getInstance().getLocalidad(hdr.getLocalidad().getDescripcion())/*, null*/, hdr.getFechaGeneracion());
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(h);
		session.getTransaction().commit();
		session.close();
		for (Pedido p : hdr.getPedidos()) {
			HojaDeRutaPedidoEntity hdp = new HojaDeRutaPedidoEntity(h, p.toEntity());
			Session session2 = sf.openSession();
			session2.beginTransaction();
			try {
				session2.saveOrUpdate(hdp);
				session2.flush();
			}catch(Exception e) {
				continue;
			}
			session2.flush();
			session2.getTransaction().commit();
			session2.close();
		}

	}

	public List<Pedido> getPedidos(int codHDR) {
		List<HojaDeRutaPedidoEntity> hdrp = null;
		List<PedidoEntity> pe = new ArrayList<PedidoEntity>();
		List<Pedido> ret = new ArrayList<Pedido>();
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		hdrp = (ArrayList<HojaDeRutaPedidoEntity>)session.createQuery("from HojaDeRutaPedidoEntity where codHDR = ?1")
				.setParameter(1, codHDR)
				.list();
		for (HojaDeRutaPedidoEntity hdp: hdrp)
			for (int i = 0; i<=hdrp.size(); i++) {
				pe.add(hdp.getPedido());
			}
		for (PedidoEntity p : pe)
			ret.add(new Pedido(p));
		return ret;
		
	}
}
