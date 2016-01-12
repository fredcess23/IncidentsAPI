package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	
	private static final SessionFactory sessionFactory;

	//Entry Point
	static {
		try {
			sessionFactory = buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

	private static SessionFactory buildSessionFactory() {
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("com/incidents/mx/hibernate.cfg.xml");
/*
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties())
					.build();
		
			SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
*/
			SessionFactory sf = cfg.buildSessionFactory();
			return sf;

		} catch (Throwable ex) {

			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
}