package com.nativequery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.Student;


public class SQLQuery {
	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String q = "select * from student";
		NativeQuery nq=session.createSQLQuery(q);
		
		List<Object[]> list =nq.list(); 
		for(Object[] st :list){
			System.out.println(st[1]+" : "+st[4]);
		}
		
		session.close();
		factory.close();
	}

}
