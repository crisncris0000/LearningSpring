package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;



public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Instructor.class)
													.addAnnotatedClass(InstructorDetail.class)
													.addAnnotatedClass(Course.class)
													.addAnnotatedClass(Review.class)
													.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// create a course and add some reviews then save the course
			
			
			Course course = new Course("Figurine collecting what to buy");
			
			
			course.addReview(new Review("The course was amazing, I learned to tell the real figures from the fakes"));
			course.addReview(new Review("The course was so garbage"));
			course.addReview(new Review("The course was alright had some issues understanding"));
			
			session.persist(course);
			System.out.println("Saving course: " + course);
			
			System.out.println("Course reviews: " + course.getReviews());
		
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Completed");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
