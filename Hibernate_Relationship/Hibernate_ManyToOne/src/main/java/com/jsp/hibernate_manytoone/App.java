package com.jsp.hibernate_manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_manytoone.entity.Company;
import com.jsp.hibernate_manytoone.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Company c=new Company();
    	c.setCompanyId(1);
    	c.setCompanyName("Oracle");
    	
    	
    	Employee e1=new Employee();
    	e1.setEmployeeId(101);
    	e1.setEmployeeName("Sandeep");
    	e1.setEmployeeSalary(2286823);
    	
    	
    	Employee e2=new Employee();
    	e2.setEmployeeId(102);
    	e2.setEmployeeName("Rahul");
    	e2.setEmployeeSalary(12868);
    	
    	//adding company obj to employee
    	
    	e1.setCompany(c);
    	e2.setCompany(c);
    	
        Configuration configuration=new 
        		Configuration().configure().addAnnotatedClass(Company.class).
        									addAnnotatedClass(Employee.class);
        
        SessionFactory factory=configuration.buildSessionFactory();
        
        Session session=factory.openSession();
        
        Transaction transaction=session.beginTransaction();
        session.save(c);
        
        session.save(e1);
        session.save(e2);
        transaction.commit();
        
        session.close();
        factory.close();
        
    }
}
