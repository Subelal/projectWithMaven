package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLPagination {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Query<Student> q=session.createQuery("from Student",Student.class);
		
		q.setFirstResult(5);
		q.setMaxResults(15);
		
		List<Student> list = q.list();
		for(Student st:list){
			System.out.println(st);
		}
		
		session.close();
		
		factory.close();
	}
}
