package com.jsp.hibernate_query.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.jsp.hibernate_query.entity.Actor;

public class App_SQL {
	
	public static void main(String[] args) {
		Configuration configuration=new Configuration()
				.configure().addAnnotatedClass(Actor.class);
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		//---------------------fetch operations------------------------//
		/*
		NativeQuery<Actor> nativeQuery=session
				.createNativeQuery("Select * from actor",Actor.class);
		List<Actor> actors=nativeQuery.list();
		for (Actor actor : actors) {
			System.out.println(actor);
		}
		*/
		
		//--------------------Update operation---------------------//
		
		/*
		NativeQuery<Actor> nativeQuery=session.createNativeQuery
				("Update actor set actorAge=:age where actorId=:id",Actor.class);
		nativeQuery.setParameter("age", 89);
		nativeQuery.setParameter("id", 101);
		
		int rowUpdate=nativeQuery.executeUpdate();
		System.out.println(rowUpdate+" Data is ");
		*/
		NativeQuery<Actor> nativeQuery=session.createNativeQuery
				("delete from actor where actorId=:id",Actor.class);
		nativeQuery.setParameter("id", 101);
		int rowdelete=nativeQuery.executeUpdate();
		System.out.println(rowdelete+" Data is deleted");
		
		
		
		
		transaction.commit();
		session.close();
	}

}
