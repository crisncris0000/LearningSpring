package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;



public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			
			// associate the objects
			// start a transaction
			session.beginTransaction();
			
			
			// get instructor by primary key / id
			int theID = 1;
			
			Instructor instructor = session.get(Instructor.class, theID);
			
			
			System.out.println("Found instructor: " + instructor);
			
			
			// delete instructor
			
			
			// Deletes Instructor detail as well because of CascadeType.ALL 
			// Everything associated with that instructor will be deleted
			if(instructor != null) {
				System.out.println("Deleting existing instructor: " + instructor);
				session.delete(instructor);
			}
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Completed");
			
		} finally {
			factory.close();
		}

	}

}
