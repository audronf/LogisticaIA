package com.ia.hbt;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.ia.entities.ClienteEntity;
import com.ia.entities.DireccionEntity;
import com.ia.entities.DistribuidorEntity;
import com.ia.entities.DistribuidorLocalidadEntity;
import com.ia.entities.HojaDeRutaEntity;
import com.ia.entities.HojaDeRutaPedidoEntity;
import com.ia.entities.LocalidadEntity;
import com.ia.entities.PedidoEntity;
import com.ia.negocio.Localidad;

public class HibernateCore {
	
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			
			/** Annotated classes **/
			// Ac� van todas las entities. 
			// Agreguen una por una, sino va a tirar error
			config.addAnnotatedClass(ClienteEntity.class);
			config.addAnnotatedClass(DireccionEntity.class);
			config.addAnnotatedClass(LocalidadEntity.class);
			config.addAnnotatedClass(DistribuidorEntity.class);
			config.addAnnotatedClass(DistribuidorLocalidadEntity.class);
			config.addAnnotatedClass(PedidoEntity.class);
			config.addAnnotatedClass(HojaDeRutaEntity.class);
			config.addAnnotatedClass(HojaDeRutaPedidoEntity.class);
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		}
		catch (Throwable thr){
			System.err.println("Initial SessionFactory creation failed." + thr);
            throw new ExceptionInInitializerError(thr);
			
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
