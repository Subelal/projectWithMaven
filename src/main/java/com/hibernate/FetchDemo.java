package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com/hibernate/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		Student student = (Student) session.get(Student.class, 103);
		System.out.println(student);

		Address ad = (Address) session.load(Address.class, 2);
		System.out.println(ad.getStreet() + " : " + ad.getCity());
		System.out.println(ad);

		session.close();
		factory.close();
		
	}
}
