package com.jsp.hibernate_mapping_onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_mapping_onetomany.entity.Company;
import com.jsp.hibernate_mapping_onetomany.entity.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)

	{
//		Company company = new Company();
//		company.setCompanyId(1);
//		company.setCompanyName("Oracle");
//
//		Employee employee1 = new Employee();
//		employee1.setEmployeeId(101);
//		employee1.setEmployeeName("Sandeep");
//
//		Employee employee2 = new Employee();
//		employee2.setEmployeeId(102);
//		employee2.setEmployeeName("Salman Khan");
//
//		List<Employee> eList = new ArrayList<Employee>();
//
//		eList.add(employee1);
//		eList.add(employee2);
//
//		company.setEmployees(eList);

		Configuration configuration = new Configuration();
		configuration.configure().addAnnotatedClass(Company.class).addAnnotatedClass(Employee.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transcation = session.beginTransaction();		
		System.out.println(session.get(Company.class, 1).getEmployees());
		

		transcation.commit();
		session.close();
		sessionFactory.close();

	}
}
