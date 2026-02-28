package com.jsp.hibernate_query.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jsp.hibernate_query.entity.Actor;

public class App_Criteria {
	
	public static void main(String[] args) {
		Configuration configuration=new Configuration()
				.configure().addAnnotatedClass(Actor.class);
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
		/*
		WARN: HHH90000022: Hibernate's legacy org.hibernate.Criteria API is deprecated; 
		use the JPA javax.persistence.criteria.CriteriaQuery instead
		*/
		//only fetch operation using Criteria interface 
		Criteria criteria=session.createCriteria(Actor.class);//("select a from actor a",Actor.class)
		/*  --Where Clause  */
//		criteria.add(Restrictions.eq("actorId", 103));
//		criteria.add(Restrictions.gt("actorAge", 40));
//		criteria.add(Restrictions.lt("actorAge", 50));
//		criteria.add(Restrictions.like("actorName", "Prabhas"));
//		criteria.add(Restrictions.between("actorId", 103,105));
//		criteria.add(Restrictions.in("actorId", 103,104,105));
		
		/*  --SELECT Clause  */
		criteria.setProjection(Projections.property("actorId"));
//		criteria.setProjection(Projections.property("actorName"));
		
		List<Integer> actors=criteria.list();
		
		for(Integer actor:actors) {
			System.out.println(actor);
		}
		
		
		transaction.commit();
	}

}
