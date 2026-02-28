package com.jsp.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App_Insert {

	public static void main(String[] args) {
		Student student = new Student();
		student.setStudentId(101);
		student.setStudentName("Sandeep");
		student.setStudentEmail("nsandeep79522@gmail.com");
		student.setStudentMarks(89);
		student.setStudentAge(22);
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Student.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transcation = session.beginTransaction();
		System.out.println(session.get(Student.class, 101));
		session.save(student);
		transcation.commit();
		session.close();
		sessionFactory.close();
	}
}
