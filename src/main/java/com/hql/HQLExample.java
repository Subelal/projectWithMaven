package com.hql;

import java.util.Arrays;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class HQLExample {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session =factory.openSession();
		Transaction  tx = session.beginTransaction();
		
		String query ="from Student as s where s.city=:x and s.name=:n";		
		  Query q=session.createQuery(query);
		  
		  q.setParameter("x", "mumbai");
		  q.setParameter("n", "Sonu");
		  
		  List<Student> list = q.list();
		  for(Student s: list){
			  System.out.println(s.getName()+" :"+s.getCerti());
		  }
		System.out.println("====================================================");
		
//		Query q2 = session.createQuery("delete from Student as s where s.name=:x");
//		q2.setParameter("x", "sonu");
//		int r=q2.executeUpdate();
//		
//		System.out.println("Delete:");
//		System.out.println("No of r"+r);
		
//		Query q3=session.createQuery("update Student as s set s.city=:c where s.name=:d");
//		q3.setParameter("c", "Dil");
//		q3.setParameter("d", "sonu");
//		
//		int r1 = q3.executeUpdate();
//		System.out.println("Update:");
//		System.out.println(r1);
		System.out.println("=====================JOIN+++++INNER JOIN++++++++++++===============");
		
		Query q4 = session.createQuery("SELECT q.questionId,q.question ,a.answerId,a.answer "
				+ "from "
				+ "Question as q INNER JOIN q.answers as a ");
		
		List<Object[]> listofjoin = q4.getResultList();
		
		for(Object[] oj:listofjoin){
			System.out.println(Arrays.toString(oj));
		}
		
		
		tx.commit();
		
		
		factory.close();
        	
	}

}
