package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;



public class DeleteCourseDemo {

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
			
			session.beginTransaction();
			
			Course tempCourse = session.get(Course.class, 10);
			
			System.out.println("Deleting course: " + tempCourse);
			session.delete(tempCourse);
			
			
			
			
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
