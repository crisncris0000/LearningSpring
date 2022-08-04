package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	
	// need to inject the session factory
	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get current hibernate session
		
		Session currentSession = factory.getCurrentSession();
		
		// create a query
		
		Query<Customer> theQuery = currentSession.
				createQuery("from Customer order by lastName",
							Customer.class);
		
		// execute query and get result list
		
		List<Customer> customers = theQuery.getResultList();
		
		
		// return the results
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	public Customer getCustomer(int theId) {
		Session session = factory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void delete(int theId) {
		Session session = factory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, theId);
		session.delete(customer);
		
	}
	
	
	
	

}
