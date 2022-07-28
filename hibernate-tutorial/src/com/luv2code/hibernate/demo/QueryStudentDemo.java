package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
				session.beginTransaction();
			
			// query students
				List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			
				displayStudents(theStudents);
			
			// query students: lastName = "Walker"
				theStudents = session.createQuery("from Student s where s.lastName = 'Walker'").getResultList();
			
			// display the students
				System.out.println("\nStudents with last name of Walker: ");
				displayStudents(theStudents);
			
			
			// Where students have either lastName of Mouse or firstName of Sebastian
					theStudents = session.createQuery("from Student s where s.lastName = 'Mouse' "
					+ "OR s.firstName = 'Sebastian'").getResultList();
			
			// display the students
					System.out.println("\nStudents with last name of Mouse or with firstName of Sebastian: ");
					displayStudents(theStudents);
			
			// Checking if it ends with email  LIKE %gmail.com			
					theStudents = session.createQuery("from Student s where "
					+ "s.email like '%gmail.com'").getResultList();
						
			// Display
					System.out.println("\nStudents with the email ending with gmail.com: ");
					displayStudents(theStudents);
						
			// commit transaction
					session.getTransaction().commit();
			
					System.out.println("Completed");
			
		} finally {
			factory.close();
		}

	}

	
	
	private static void displayStudents(List<Student> theStudents) {
		for(Student s : theStudents) {
			System.out.println(s);
		}
	}

}
