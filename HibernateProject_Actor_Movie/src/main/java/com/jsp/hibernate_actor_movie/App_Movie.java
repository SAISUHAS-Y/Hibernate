package com.jsp.hibernate_actor_movie;

import java.util.Scanner;


import com.jsp.hibernate_actor_movie.dao.MovieDao;

public class App_Movie {
	public static void main(String[] args) {

		MovieDao m = new MovieDao();
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("1.addMovie\n2:findMovieByTitle\n3:findMovieByGenre\n4:findMovieByDirector"
					+ "\n5:findMovieByActionName\n6:updateMovieCollectionByVerdict"
					+ "\n7:updateMovieVerdictBetweenCollection\n8:deleteMoviesByVerdict"
					+ "\n9:deleteMoviesByActorId\n10:Exit");
			int choice = sc.nextInt();

			if (choice >= 1 && choice <= 10) {
				System.out.println("enter a  choice");

			}
			switch (choice) {
			case 1:
				m.addMovie();
				break;
			case 2:
				m.findMovieByTitle();
				break;
			case 3:
				m.findMovieByGenre();
				break;
			case 4:
				m.findMovieByDirector();
				break;
			case 5:
				m.findMovieByActionName();
				break;
			case 6:
				m.updateMovieCollectionByVerdict();
				;
				break;
			case 7:
				m.updateMovieVerdictBetweenCollection();
				break;
			case 8:
				m.deleteMoviesByVerdict();
				break;
			case 9:
				m.deleteMoviesByActorId();
				break;
			case 10:
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
