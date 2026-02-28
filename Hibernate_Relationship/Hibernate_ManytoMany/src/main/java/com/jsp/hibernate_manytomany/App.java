package com.jsp.hibernate_manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_manytomany.entity.Customer;
import com.jsp.hibernate_manytomany.entity.Product;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Customer customer1 = new Customer();
		customer1.setCustomerId(101);
		customer1.setCustomerName("Sandeep");

		Customer customer2 = new Customer();
		customer2.setCustomerId(102);
		customer2.setCustomerName("AranvaBhai");

		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("Mobile");
		product1.setProductPrice(70890);

		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("Chappal");
		product2.setProductPrice(700);

		// adding product into Customer
		//satisfying the customer Mapping to @manytomany Product 

		List<Product> plist = new ArrayList<Product>();
		plist.add(product1);
		plist.add(product2);

		
		//satisfying the Product Mapping to @manytomany Customer
//		List<Customer> cuslist = new ArrayList<Customer>();
//		cuslist.add(customer1);
//		cuslist.addLast(customer2);

		// now set into list

		customer1.setProducts(plist);
		customer2.setProducts(plist);

//		product1.setCustomers(cuslist);
//		product2.setCustomers(cuslist);

		Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Product.class);

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(customer1);
		session.save(customer2);
		session.save(product1);
		session.save(product2);
		transaction.commit();
		session.close();
		factory.close();
	}
}
