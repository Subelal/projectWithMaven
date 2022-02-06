package com.map;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	
	public static void main(String[] args) throws SQLException{
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java?  ");
		
		Answer a1 = new Answer();
		a1.setAnswerId(343);
		a1.setAnswer("Java is programming language !!!!");
		a1.setQuestion(q1);
		

		Answer a2 = new Answer();
		a2.setAnswerId(345);
		a2.setAnswer("Java has oops concept !!!!");
		a2.setQuestion(q1);
		
		
		Answer a3 = new Answer();
		a3.setAnswerId(346);
		a3.setAnswer("Java  perform group of object !!!!");
		a3.setQuestion(q1);
		
		Answer a4 = new Answer();
		a4.setAnswerId(347);
		a4.setAnswer("Java has Collections to perform group of object !!!!");
		a4.setQuestion(q1);
		
		List<Answer> listofAns = new ArrayList<Answer>();
		listofAns.add(a1);
		listofAns.add(a2);
		listofAns.add(a3);
		listofAns.add(a4);
		
		q1.setAnswers(listofAns);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
//		session.save(q1);
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);
//		session.save(a4);
		
		tx.commit();
		System.out.println("=======================================================================================");
		Question q11 =(Question)session.get(Question.class, 1212);
		System.out.println(q11.getQuestionId());
		System.out.println(q11.getQuestion());
//		System.out.println(q11.getAnswers());
		
//		for(Answer a : question.getAnswers()){
//			System.out.println(a.getAnswer());
//		}
		
		session.close();
		factory.close();
	}

}
