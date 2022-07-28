package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;



public class AddCoursesForStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// create a course and add some reviews then save the course
			
			
			Course course = new Course("Data Structures and algorithms");
			Course course2 = new Course("Anime writing analysis");
			
			Student student = session.get(Student.class, 1);
			
			student.addCourse(course);
			student.addCourse(course2);
			
			session.persist(course);
			session.persist(course2);
			
			System.out.println(student);
			System.out.println("courses: " + student.getCourses());
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Completed");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
