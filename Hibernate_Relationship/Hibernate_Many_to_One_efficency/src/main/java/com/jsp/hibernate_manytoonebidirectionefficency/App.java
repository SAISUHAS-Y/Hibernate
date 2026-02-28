package com.jsp.hibernate_manytoonebidirectionefficency;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_manytoonebidirectionefficency.entity.Company;
import com.jsp.hibernate_manytoonebidirectionefficency.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Company company=new Company();
    	company.setCompanyId(1);
    	company.setCompanyName("Oracle");
    	
    	
    	Employee employee1=new Employee();
    	employee1.setEmployeeId(101);
    	employee1.setEmployeeName("Sandeep");
    	employee1.setEmployeeSalary(76172537);
    	
    	Employee employee2= new Employee();
    	employee2.setEmployeeId(102);
    	employee1.setEmployeeName("Goutham");
    	employee1.setEmployeeSalary(76172700);
    	
    	//adding company into employee
    	employee1.setCompany(company);
    	employee2.setCompany(company);
    	
    	
    	//adding employee to company
    	
//    	------> dont use the list
    	
        Configuration configuration=new Configuration().configure()
        		.addAnnotatedClass(Company.class).addAnnotatedClass(Employee.class);
        
        SessionFactory factory=configuration.buildSessionFactory();
        
        Session session=factory.openSession();
        
        Transaction transaction=session.beginTransaction();
        
        session.save(company);
        session.save(employee1);
        session.save(employee2);
      
        transaction.commit();
        
        session.close();
        factory.close();
    }
}
