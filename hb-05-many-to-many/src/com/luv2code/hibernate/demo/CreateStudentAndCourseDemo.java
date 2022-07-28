package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;



public class CreateStudentAndCourseDemo {

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
			
			
			Course course = new Course("Figurine collecting what to buy");
			
			session.persist(course);
			
			Student student = new Student("Christopher", "Rivera", "CR@gmail.com");
			Student student2 = new Student("Sebastian", "Ramirez", "SR@gmail.com");
			Student student3 = new Student("Brandon", "Torres", "BT@gmail.com");
			
			course.addStudent(student);
			course.addStudent(student2);
			course.addStudent(student3);
			
			session.save(student);
			session.save(student2);
			session.save(student3);
			
			System.out.println("Saved students: " + course.getStudents());
			
			System.out.println("Saving course: " + course);
			
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Completed");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
