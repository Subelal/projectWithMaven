package com.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project started....!");

		Configuration cfg = new Configuration();
		cfg.configure("com/hibernate/hibernate.cfg.xml");

		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());

//		Student s1 = new Student();
//
//		s1.setId(104);
//		s1.setName("sonu");
//		s1.setCity("Bangalore");
//		Student s2 = new Student();
//
//		s2.setId(101);
//		s2.setName("soni");
//		s2.setCity("Mira RD");
//		
//		Student s3 = new Student();
//
//		s3.setId(103);
//		s3.setName("anchal");
//		s3.setCity("ald");
//
//		Address ad = new Address();
//		ad.setStreet("MG street");
//		ad.setCity("Jaunpur");
//		ad.setOpen(true);
//		ad.setAddedDate(new Date());
//		ad.setX(123.456);
//
//		// reading image
//
//		FileInputStream fis = new FileInputStream("src/main/java/sube.png");
//        byte[] data = new byte[fis.available()];
//        fis.read(data);
//        ad.setImage(data);
//        
//        Address ad1 = new Address();
//		ad1.setStreet("street2");
//		ad1.setCity("Bangalore");
//		ad1.setOpen(true);
//		ad1.setAddedDate(new Date());
//		ad1.setX(123.456);
//
//		// reading image
//
//		FileInputStream fis1 = new FileInputStream("src/main/java/sube.png");
//        byte[] data1 = new byte[fis1.available()];
//        fis1.read(data1);
//        ad1.setImage(data1);
//        
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
//		session.save(s1);
//		session.save(s2);
//		session.save(s3);
//		
//		session.save(ad);
//		session.save(ad1);
		// session.getTransaction().commit();
		tx.commit();
		session.close();

		System.out.println("Done");
	}
}
