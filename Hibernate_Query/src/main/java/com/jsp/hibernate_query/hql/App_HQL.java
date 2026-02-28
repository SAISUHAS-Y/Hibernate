package com.jsp.hibernate_query.hql;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.jsp.hibernate_query.entity.Actor;

/**
 * Hello world!
 *
 */
public class App_HQL 
{
	public static void main( String[] args )
	{
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Actor.class);
		SessionFactory factory=configuration.buildSessionFactory();
		Session  session=factory.openSession();
		Transaction transaction=session.beginTransaction();

//		Query<String> query=session.createQuery("SELECT a.actorName FROM Actor a");
//		List<String> actors=query.list();
//		for (String actor : actors) {
//			System.out.println(actor);
//		}
		// single feild 
		/*
		Query<String> query=session.createQuery("SELECT a.actorName FROM Actor a");
		List<String> actors=query.list();
		for (String actor : actors) {
			System.out.println(actor);
		}
		*/
		
		// Update
//		Query<Actor> query=session.createQuery("UPDATE Actor a SET a.actorAge=67 WHERE a.actorId=102");
//		int resUpdate=query.executeUpdate();
//		System.out.println(resUpdate+" data Updated");
		/* delete operation
		Query<Actor> query=session.createQuery("DELETE From Actor a WHERE a.actorId=102");
		int resDelete=query.executeUpdate();
		System.out.println(resDelete+" data Deleted");
		*/
		
		
		//using placeHolder
		Query<Actor> query=session.createQuery("update Actor a set a.actorName=?1 where a.actorId=:id");
		query.setParameter(1, "KichaSudeep");
		query.setParameter("id", 102);
		int rowUpdate=query.executeUpdate();
		System.out.println(rowUpdate+" data Updated");
		transaction.commit();
		session.close();
	}
}
