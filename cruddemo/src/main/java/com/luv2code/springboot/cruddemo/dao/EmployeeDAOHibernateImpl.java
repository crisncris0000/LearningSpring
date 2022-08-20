package com.luv2code.springboot.cruddemo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findEmployees() {
		
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		
		Query<Employee> theQuery = currentSession
				.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		
		List<Employee> result = theQuery.getResultList();
		
		//return it
		
		
		return result;
	}

	@Override
	public Employee findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, theId);
		
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.
				createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
