package com.jsp.hibernate_query.criteriabuilder;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_query.entity.Actor;

public class App_CriteriaBuilder {
	
	public static void main(String[] args) {
		Configuration configuration=new Configuration()
				.configure().addAnnotatedClass(Actor.class);
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		
		/* Step-1 Build the builder for different criteria*/
		CriteriaBuilder cb=session.getCriteriaBuilder();
		
		/* Step-2 query construction using hQL inside operation*/
		CriteriaQuery<Actor> cq=cb.createQuery(Actor.class);
//		cq.from(Actor.class);
		//root is ness
		Root<Actor> root=cq.from(Actor.class);
		cq.select(root);  // not mandatory
//		cq.select(root.get("actorId"));
// --------- different clause or conditions------------------//
//		cq.where(cb.equal(root.get("actorId"), 101));
//		cq.where(cb.equal(root.get("actorName"), "Priyank"));
//		cq.where(cb.like(root.get("actorStream"), "Bollywood"));
//		cq.where(cb.gt(root.get("actorAge"), 55));
		cq.where(cb.lt(root.get("actorAge"), 55));
		
		
		/*Step-3 execute query using Query interface*/
		
		Query<Actor> query=session.createQuery(cq);
		List<Actor> actors=query.list();
		
		for(Actor a:actors) {
			System.out.println(a.getActorId());
		}
		

		transaction.commit();
		session.close();
		factory.close();
	}

}
