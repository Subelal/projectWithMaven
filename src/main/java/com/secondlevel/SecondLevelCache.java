package com.secondlevel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class SecondLevelCache {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session1 = factory.openSession();
		Student student = session1.get(Student.class, 1212);
		System.out.println(student);
		session1.close();

		Session session2 = factory.openSession();
		Student student2 = session2.get(Student.class, 1212);
		System.out.println(student2);

		session2.close();
		factory.close();

	}

}
