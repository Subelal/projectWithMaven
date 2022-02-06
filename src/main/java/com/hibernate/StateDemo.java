package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("com/hibernate/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student st = new Student();
		st.setId(1212);
		st.setName("sube");
		st.setCity("Mumbai");
		st.setCerti(new Certificate("Hibernate ... ","2 weeks"));
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		
		st.setName("anchal");
		
		tx.commit();
		session.close();
		st.setName("SONI");
		System.out.println(st);
		factory.close();
	}

}
