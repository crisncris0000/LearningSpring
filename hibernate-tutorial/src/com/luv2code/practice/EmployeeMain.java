package com.luv2code.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EmployeeMain {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			Employee employee = new Employee("Christopher", "Rivera", "Treyarch");
			Employee employee2 = new Employee("Sebastian", "Ramirez", "SledgeHammer");
			Employee employee3 = new Employee("Bob", "Dillan", "Atlus");
			
			session.beginTransaction();
			
			//session.save(employee);
			//session.save(employee2);
			//session.save(employee3);
			
			
			Employee getEmployee = session.get(Employee.class, 2);
			
			System.out.println(getEmployee);
			
			
			//Getting someone who works at treyarch
			List<Employee> employees = session.createQuery("from Employee e where e.company = 'Atlus'").getResultList();
			
			displayEmployees(employees);
			
			session.createQuery("delete from Employee where id = 4").executeUpdate();
			
			
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

	private static void displayEmployees(List<Employee> employees) {
		for(Employee e: employees) {
			System.out.println(e);
		}
	}

}
