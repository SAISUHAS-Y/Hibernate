package com.jsp.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.onetoone.entity.Aadhar;
import com.jsp.hibernate.onetoone.entity.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	/*
       Person person=new Person();
       person.setPersonId(101);
       person.setPersonName("Sandeeep");
       
       Aadhar aadhar=new Aadhar();
       aadhar.setAadharId(1);
       aadhar.setAadharNumber(790035586938l);
       
       
       
       ////Adding the aadhar object to Person Object
       person.setAadhar(aadhar);
       
       //adding the person obj to aadhar
       
//       aadhar.setPerson(person);
       
       */
       Configuration configuration=new Configuration().configure()
    		   .addAnnotatedClass(Person.class).addAnnotatedClass(Aadhar.class);
       
       SessionFactory factory=configuration.buildSessionFactory();
       
       Session session=factory.openSession();
       
       Transaction transaction=session.beginTransaction();
       
       Person person=session.get(Person.class, 101);
       System.out.println(person);
       Aadhar aadhar=person.getAadhar();
       System.out.println(aadhar);
       transaction.commit();
       session.close();
       factory.close();
       
    }
}
