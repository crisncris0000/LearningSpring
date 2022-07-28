package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;



public class GetInstructorDetailDemo {

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
			
			
			// get instructor detail object
			int theID = 5;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theID);
			
			// print instructor detail
			System.out.println("Instructor detail: " + instructorDetail);
			
			
			// print associated instructor
			System.out.println("Associated instructor: " + instructorDetail.getInstructor());
			
	
			
			
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Completed");
			
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}

	}

}
