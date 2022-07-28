package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;



public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects 
			
			Instructor instructor = new Instructor("Christopher", "Rivera", "christopherrivera134@gmail.com");
			
			InstructorDetail detail = new InstructorDetail("Ancient Pizza", "gamer");
			
			instructor.setInstructorDetail(detail);
			
			
			
			// start a transaction
			session.beginTransaction();
			
			
			
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			
			
			
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Completed");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
