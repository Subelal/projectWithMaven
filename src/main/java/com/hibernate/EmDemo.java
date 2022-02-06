package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("com/hibernate/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student s1 = new Student();

		s1.setId(101);
		s1.setName("soni");
		s1.setCity("Mumbai");
		
		Certificate c1 = new Certificate();
		c1.setCourse("MCA");
		c1.setDuration("3");
		
		s1.setCerti(c1);
		
		Student s2 = new Student();
		s2.setId(102);
		s2.setName("sube");
		s2.setCity("Bangalore");
		
		Certificate c2 = new Certificate();
		c2.setCourse("M.Comm");
		c2.setDuration("2");
		
		s2.setCerti(c2);
		
		session.beginTransaction();
		
		session.save(s1);
		session.save(s2);
		
		
		session.getTransaction().commit();

		
		session.close();
		factory.close();
	}

}
