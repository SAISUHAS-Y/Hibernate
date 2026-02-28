package com.jsp.hibernate.Hibernate_Project;

import java.util.Scanner;

import com.jsp.hibernate.Hibernate_Project.dao.ProductDAO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ProductDAO p = new ProductDAO();

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("1.addProduct\n2:FindProduct\n3:UpdateProduct\n4:deleteProduct\n5:exit");
			int choice = sc.nextInt();

			if (choice >= 1 && choice <= 4) {
				System.out.println("enter a  choice");

			}
			switch (choice) {
			case 1:
				p.addProduct();
				break;
			case 2:
				p.findProductById();
				break;
			case 3:
				p.updateProductById();
				break;
			case 4:
				p.deleteProductById();
				break;
			case 5:
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
