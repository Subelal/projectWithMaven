package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Question q1 = new Question();
		q1.setQuestionId(4321);
		q1.setQuestion("What is casecade ??");
		
		Answer a1 = new Answer(123,"Casecase is important topic in hbernate",q1);
		Answer a2 = new Answer(124,"second Answer",q1);
		Answer a3 = new Answer(125,"Third answer",q1);
		
//		Answer a1 = new Answer(123,"Casecase is important topic in hbernate");
//		Answer a2 = new Answer(124,"second Answer");
//		Answer a3 = new Answer(125,"Third answer");
		
		List<Answer> listOfAns = new ArrayList<Answer>();
		listOfAns.add(a1);
		listOfAns.add(a2);
		listOfAns.add(a3);
		
		q1.setAnswers(listOfAns);
		Transaction tx =session.beginTransaction();
		session.save(q1);
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);
		tx.commit();
		session.close();
		factory.close();

	}
}
