package com.jsp.hibernate_query.criteriabuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_query.entity.Actor;

public class App_CriteriaUpdate {
	
	public static void main(String[] args) {
		Configuration configuration=new Configuration()
				.configure().addAnnotatedClass(Actor.class);
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		//step builder
		CriteriaBuilder builder=session.getCriteriaBuilder();
		
		// Update Query construction
		
		CriteriaUpdate< Actor> update=builder.createCriteriaUpdate(Actor.class);
		Root<Actor > root=update.from(Actor.class);
		
		update.set(root.get("actorAge"), 97);
		update.where(builder.equal(root.get("actorId"), 101));
		
		
		// Query Executation
		
		Query<Actor>query=session.createQuery(update);
		int rowUpdated=query.executeUpdate();
		System.out.println(rowUpdated+"data get Updated");
		
		
		
		transaction.commit();
		session.close();
		factory.close();
	}

}
