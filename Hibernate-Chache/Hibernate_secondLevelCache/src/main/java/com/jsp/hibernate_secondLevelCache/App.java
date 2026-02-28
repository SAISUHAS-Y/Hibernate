package com.jsp.hibernate_secondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
    	Configuration configuration=new Configuration()
    			.configure().addAnnotatedClass(Mobile.class);
    	
    	SessionFactory factory=configuration.buildSessionFactory();
    	
    	
    	// session -1
//    	com.jsp.hibernate.Hibernate_caching.Mobile@49469ffa
//    	com.jsp.hibernate.Hibernate_caching.Mobile@49469ffa
    	Session session1=factory.openSession();
    	
    	Transaction transaction1=session1.beginTransaction();
    	
    	Mobile mobile1=	session1.get(Mobile.class, 101);
    	System.out.println(mobile1);
    	
    	Mobile mobile2=session1.get(Mobile.class, 101);
    	System.out.println(mobile2);
    	
    	transaction1.commit();
    	session1.close();
    	
    	System.out.println();
    	System.out.println();
    	//session -2 because session will execute 1 time in database with help of caching memory
//    	of 1st level it will take the copy of it next it will not check for db
//    	com.jsp.hibernate.Hibernate_caching.Mobile@4cad79bc
//    	com.jsp.hibernate.Hibernate_caching.Mobile@4cad79bc
    	
    	Session session2=factory.openSession();
    	
    	Transaction transaction2=session2.beginTransaction();
    	
    	Mobile mobile3=	session2.get(Mobile.class, 101);
    	System.out.println(mobile3);
    	
    	Mobile mobile4=session2.get(Mobile.class, 101);
    	System.out.println(mobile4);
    	
    	transaction2.commit();
    	session2.close();
    }
}

