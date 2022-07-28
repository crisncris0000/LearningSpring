package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;



public class CreateCoursesDemo {

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
			// start a transaction
			session.beginTransaction();
			int theId = 1;
			
			Instructor instructor = session.get(Instructor.class, theId);
			
			Course course = new Course("Programming 1");
			Course course2 = new Course("Data structures");
			Course course3 = new Course("Anime writing");

	
			instructor.add(course);
			instructor.add(course2);
			instructor.add(course3);
			
			session.save(course);
			session.save(course2);
			session.save(course3);
			
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Completed");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
