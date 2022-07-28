package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
															.addAnnotatedClass(Student.class)
															.buildSessionFactory();
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					// use the session object to save java object
					
					// Create 3 student objects
					System.out.println("Creating student objects");
					
					Student theStudent = new Student("Christopher", "Rivera", "Christopherrivera384@gmail.com");
					Student theStudent2 = new Student("Sebastian", "Ramierez", "SuperDuper@hotmail.com");
					Student theStudent3 = new Student("Paul", "Walker", "paulwalker12@aol.com");
					
					// start a transaction
					session.beginTransaction();
					
					Student myStudent = session.get(Student.class, 4); // get student with primary key
					
					
					System.out.println(myStudent);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Completed");
					
				} finally {
					factory.close();
				}

	}

}
