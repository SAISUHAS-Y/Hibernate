package com.jsp.hibernate_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
//    	Car car1=new Car();
//    	car1.setCarId(101);
//    	car1.setCarModel("Omini");
//    	car1.setCarBrand("Maruti");
//    	car1.setCarPrice(50000);
//    	
//    	Car car2=new Car();
//    	car2.setCarId(102);
//    	car2.setCarModel("Q7");
//    	car2.setCarBrand("Audii");
//    	car2.setCarPrice(450000);
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("mysql-config");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        et.begin();
        
        //fetch or find operation
        
        /* 
         * Car c =em.find(Car.class, 101);
         *  System.out.println(c);
         */
        
        // Update operation
        /*
        Car c =em.find(Car.class, 101);
        c.setCarPrice(c.getCarPrice()+6353);
        em.merge(c);
        */
       
        Car c =em.find(Car.class, 101);
        em.remove(c);
        
        et.commit();
        em.close();
        emf.close();
    }
}
