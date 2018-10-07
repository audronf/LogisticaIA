package com.ia.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ia.entities.DistribuidorEntity;
import com.ia.entities.PedidoEntity;
import com.ia.hbt.HibernateCore;
import com.ia.negocio.Distribuidor;
import com.ia.negocio.Pedido;

public class PedidoDAO {

	private static PedidoDAO instance;
	
	private PedidoDAO() {}
	
	public static PedidoDAO getInstance() {
		if (instance==null)
			instance = new PedidoDAO();
		return instance;
	}
	
	public Pedido findByCodigo(int codigoPedido) {
		PedidoEntity pe;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		pe = (PedidoEntity) session.createQuery("from PedidoEntity where codPedido = ?1").setParameter(1, codigoPedido)
				.uniqueResult();
		session.close();
		if (pe != null) {
			Pedido p = new Pedido(pe);
			return p;
		} else
			return null;
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
	
	@SuppressWarnings("unchecked")
	public List<Pedido> verPedidosPendientes(String username) {
		List<Pedido> ret = new ArrayList<Pedido>();
		DistribuidorEntity dist = DistribuidorDAO.getInstance().findByUsername(username).toEntity();
		List<PedidoEntity> pedidos = null;
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		pedidos = (List<PedidoEntity>) session.createQuery("from PedidoEntity where dniDistribuidor = ?1 and fechaEntrega = NULL and incidencia = NULL")
				.setParameter(1, dist.getDni())
				.list();
		for (PedidoEntity p : pedidos)
			ret.add(new Pedido(p));
		return ret;
	}

	public void updateFechaEntrega(Pedido p) {
//		Pedido pe = findByCodigo(p.getCodPedido());
//		pe.setFechaEntrega(p.getFechaEntrega());
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
			    "update Pedidos set fechaEntrega = ?1" + " where codPedido = ?2");
			query.setParameter(1, p.getFechaEntrega());
			query.setParameter(2, p.getCodPedido());
			query.executeUpdate();
			session.getTransaction().commit();

		session.close();
	}

	public void updateIncidencia(Pedido p) {
		SessionFactory sf = HibernateCore.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
			    "update Pedidos set incidencia = ?1" + " where codPedido = ?2");
			query.setParameter(1, p.getIncidencia());
			query.setParameter(2, p.getCodPedido());
			query.executeUpdate();
			session.getTransaction().commit();

		session.close();
	}
}
