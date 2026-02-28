package com.jsp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_Delete {

	public static void main(String[] args) {

		Configuration configuration = new 
				Configuration().configure().addAnnotatedClass(Student.class);
		
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		
	
		
		session.delete(session.get(Student.class, 101));
		
		
		tr.commit();
		session.close();
		factory.close();
	}

}
