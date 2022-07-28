package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;



public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save java object
			// Create student object
			System.out.println("Creating new student object");
			Student theStudent = new Student("Micky", "Mouse", "Micky3@gmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(theStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find the student's id: primary key to retrieve the student
			System.out.println("Saved student. Generated id: " + theStudent.getId());
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id: primary key
			System.out.println("Getting student with id: " + theStudent.getId());
			
			Student myStudent = session.get(Student.class, theStudent.getId());
			System.out.println(myStudent);
			
			// commit
			session.getTransaction().commit();
			
			
			
			
			System.out.println("Completed");
			
		} finally {
			factory.close();
		}

	}

}
