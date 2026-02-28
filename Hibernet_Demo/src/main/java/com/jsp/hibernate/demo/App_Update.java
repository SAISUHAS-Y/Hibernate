package com.jsp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_Update {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		// fetch operation
		Student student = session.get(Student.class, 101);
		student.setStudentAge(234);
		student.setStudentName("Paru");

		// update operation
		session.update(student);

		tran.commit();
		session.close();
		sessionFactory.close();
	}
}
