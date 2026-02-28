package com.jsp.hibernate_query.criteriabuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_query.entity.Actor;

public class App_CriteriaDelete {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Actor.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// step builder
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		// Delete Query constructor
		
		CriteriaDelete<Actor>delete=builder.createCriteriaDelete(Actor.class);
		Root<Actor> root=delete.from(Actor.class);
//		delete.where(builder.equal(root.get("actorId"), 104));
		delete.where(builder.equal(root.get("actorAge"), 97));
		
		
		// Query Exceution
		
		Query<Actor> query=session.createQuery(delete);
		int rowDelete=query.executeUpdate();
		
		System.out.println(rowDelete+" Data Get Deleted Succesfully");
		
		
		
		
		transaction.commit();
		session.close();
		factory.close();
	}
}
