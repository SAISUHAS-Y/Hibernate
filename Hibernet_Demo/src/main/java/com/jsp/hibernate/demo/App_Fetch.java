package com.jsp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_Fetch {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		configuration.addAnnotatedClass(Student.class);
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		
		Transaction transcation=session.beginTransaction();
		
		System.out.println(session.get(Student.class, 101));		
		transcation.commit();
		session.close();
		sessionFactory.close();
	}

}
