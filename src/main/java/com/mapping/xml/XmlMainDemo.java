package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class XmlMainDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Person person = new Person(23, "sonu", "Mumbai", "9594171650");
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		

		session.save(person);
		tx.commit();
		session.close();
		factory.close();

	}
}
