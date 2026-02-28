package com.jsp.hibernate__shopping_cart;

import java.util.Scanner;

//import com.jsp.hibernate.Hibernate_Project.dao.ProductDAO;
import com.jsp.hibernate__shopping_cart.dao.ShoppingCartDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ShoppingCartDAO c= new ShoppingCartDAO();

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("1.addProduct\n2:addUserWithCart\n3:addProductToUserCart\n4:removeProductFromUserCart\n5:findAllProductsFromUserCart\n6:Exit");
			int choice = sc.nextInt();

			if (choice >= 1 && choice <= 6) {
				System.out.println("enter a  choice");

			}
			switch (choice) {
			case 1:
				c.addProduct();;
				break;
			case 2:
				c.addUserWithCart();
				break;
			case 3:
				c.addProductToUserCart();
				break;
			case 4:
				c.removeProductFromUserCart();
				break;
			case 5:
				c.findAllProductsFromUserCart();
				break;
			case 6:
				System.out.println("Thankyou!!!!");
				System.exit(0);
				break;
			default:
				System.out.println("invaid choice");

			}
			System.out.println("---------");

		}
    }
}
