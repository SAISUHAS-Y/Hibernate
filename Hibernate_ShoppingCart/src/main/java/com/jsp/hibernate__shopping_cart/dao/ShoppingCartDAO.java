package com.jsp.hibernate__shopping_cart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate__shopping_cart.entity.Cart;
import com.jsp.hibernate__shopping_cart.entity.Product;
import com.jsp.hibernate__shopping_cart.entity.User;

public class ShoppingCartDAO {

	Scanner sc = new Scanner(System.in);
	Configuration configuration = new Configuration().configure().addAnnotatedClass(User.class)
			.addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);

	SessionFactory factory = null;
	Session session = null;
	Transaction transaction = null;

	public void addProduct() {
		Product p = new Product();
		System.out.println("Enter the productId :---");
		p.setProductId(sc.nextInt());
		System.out.println("Enter the productName :---");
		p.setProductName(sc.next());
		System.out.println("Enter the productBrand :---");
		p.setProductBrand(sc.next());
		System.out.println("Enter the productPrice :---");
		p.setProductPrice(sc.nextInt());
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		if (session.save(p) != null) {
			System.out.println("Data are added Successfully.....!!!!!");
		} else {
			System.err.println("Data is not inserted Some problem might occured");
		}

		transaction.commit();
		session.close();
		factory.close();
	}

	public void addUserWithCart() {
		User u = new User();
		System.out.println("Enter your UserId:-");
		u.setUserId(sc.nextInt());
		System.out.println("Enter your UserName:-");
		u.setUserName(sc.next());
		System.out.println("Enter your UserEmail:-");
		u.setUserEmail(sc.next());
		System.out.println("Enter your UserMobile:-");
		u.setUserMobile(sc.nextLong());
		System.out.println("Enter your UserLocation:-");
		u.setUserLocation(sc.next());

		System.out.println("-------------------------");

		Cart c = new Cart();

		System.out.println("Enter your CartId:-");
		c.setCartId(sc.nextInt());

		// user is adding the product inside the cart
		System.out.println("user is adding the product inside the cart");
		u.setCart(c);

		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		session.save(u);
		session.save(c);
		transaction.commit();
		session.close();
		factory.close();
	}

	public void addProductToUserCart() {

		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();

		System.out.println("Pick the user");
		User u = session.get(User.class, sc.nextInt());
		Cart c = null;
		if (u != null) {
			c = u.getCart();
			System.out.println("Chosse the product");

			Product p = session.get(Product.class, sc.nextInt());
			System.out.println(p);
			if (p != null) {
				List<Product> plist = c.getProducts();
				plist.add(p);
				c.setProducts(plist);
				session.update(c);
				System.out.println("Successfully Added The product into cart");
				transaction.commit();

			} else {
				System.err.println("Product is Not found");
			}

		} else {
			System.err.println("User is not found!....");
		}

		session.close();
		factory.close();
	}

	public void removeProductFromUserCart() {
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		System.out.println("Enter the UserId to removed...:-");
		User u = session.get(User.class, sc.nextInt());
		if (u != null) {
			Cart cart = u.getCart();
			System.out.println("Enter the Product Id");
			int id = sc.nextInt();
			List<Product> plist = cart.getProducts();
			Product p = null;
			for (Product product : plist) {
				System.out.println(product);
				if (product.getProductId() == id) {
					p = product;
				} else {
					break;

				}

			}
			if (p != null) {
				plist.remove(p);
				cart.setProducts(plist);
				session.update(cart);
				transaction.commit();
			}
		} else {
			System.err.println("Product is not found");
		}

		session.close();
		factory.close();

	}

	public void findAllProductsFromUserCart() {
		factory = configuration.buildSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		System.out.println("Enter the user Id:-");
		User user = session.get(User.class, sc.nextInt());
		if (user != null) {
			Cart cart = user.getCart();
			List<Product> pList = cart.getProducts();
			System.out.println("All Product Details");
			for (Product product : pList) {
				System.out.println(product);
				transaction.commit();
				session.close();
			}

		} else {
			System.err.println("User is not found");
		}
	}

}
