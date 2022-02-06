package com.map.manytomany;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDemo {
	
	public static void main(String[] args) throws SQLException{
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.setEid(101);
		e1.setEmpName("Krisna");
		
		e2.setEid(102);
		e2.setEmpName("manish");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(111);
		p1.setProjectName("Extcloud");
		
		p2.setPid(222);
		p2.setProjectName("SmsCampaign");
		
		List<Employee> emplist = new ArrayList<Employee>();
		List<Project>  projlist = new ArrayList<Project>();
		
		emplist.add(e1);
		emplist.add(e2);
		
		projlist.add(p1);
		projlist.add(p2);
		
		e1.setProjects(projlist);
		e2.setProjects(projlist);
		p1.setEmployees(emplist);
		p2.setEmployees(emplist);
		
		
		
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		tx.commit();
		session.close();
		factory.close();

	}

}
