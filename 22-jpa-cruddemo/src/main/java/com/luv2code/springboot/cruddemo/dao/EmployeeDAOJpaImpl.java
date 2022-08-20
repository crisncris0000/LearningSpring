package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findEmployees() {
		
		// create a query
		Query query = entityManager.createQuery("from Employee");
		
		// execute query and get result
		List<Employee> employees = query.getResultList();
		
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		// get employee
		
		Employee employee = entityManager.find(Employee.class, theId);
		
		// return employee
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		Employee dbEmployee = entityManager.merge(employee);
		
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		// delete with id
		
		Query query = entityManager
				.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", theId);
		
		query.executeUpdate();
		
	}

}
