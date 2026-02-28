package com.jsp.hibernate.Hibernate_Project.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.Hibernate_Project.entity.Product;

public class ProductDAO {
	Scanner sc = new Scanner(System.in);

	Configuration configuration = new Configuration().configure().addAnnotatedClass(Product.class);
	SessionFactory factory = configuration.buildSessionFactory();

	Session session = null;
	Transaction transaction = null;

	public void addProduct() {
		Product p = new Product();
		System.out.println("Enter the productId:-");
		p.setProductId(sc.nextInt());
		System.out.println("Enter the productName:-");
		p.setProductName(sc.next());
		System.out.println("Enter the productBrand:-");
		p.setProductBrand(sc.next());
		System.out.println("Enter the productPrice:-");
		p.setProductPrice(sc.nextInt());
		session = factory.openSession();

		if (session.save(p) != null) {
			System.out.println("Data inserted successfully");
			transaction = session.beginTransaction();
			transaction.commit();
			session.close();
		} else {
			System.err.println(" Data is not inserted");
		}

	}

	public void findProductById() {
		session = factory.openSession();
		transaction = session.beginTransaction();
		System.out.println("Enter the productId");
		Product p = session.get(Product.class, sc.nextInt());
		if (p != null) {
			System.out.println(p);
			transaction.commit();
			session.close();
			System.out.println("Fetching  see......");
		} else {
			System.err.println("Not found the productId");
		}

	}

	public void updateProductById() {
		session = factory.openSession();
		transaction = session.beginTransaction();
		System.out.println("Enter the productId to Update");

		Product p = session.get(Product.class, sc.nextInt());
		if (p != null) {
			System.out.println("Enter the Upadated ProductPrice");
			p.setProductPrice(p.getProductPrice() + sc.nextInt());

			session.update(p);
			transaction.commit();
			session.close();
			System.out.println("Update succesfully");
			System.out.println(p);
		} else {
			System.err.println("Not found by Id");
		}

	}

	public void deleteProductById() {
		session = factory.openSession();
		transaction = session.beginTransaction();
		System.out.println("Enter the Id to be delete");
		Product p = session.get(Product.class, sc.nextInt());
		if (p != null) {
			session.delete(p);
			transaction.commit();
			session.close();
			System.out.println(" Product Data is deleted");
		} else {
			System.err.println("Product is not found by Id!!!");
		}

	}

}
