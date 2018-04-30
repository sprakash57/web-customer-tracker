package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Customer;

@Repository
public class CutomerDAOimpl implements CustomerDAO {
	
	//Need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create a query
		Query<Customer> query = currentSession.createQuery("from Customer",Customer.class);
		
		//Execute query
		List<Customer> customers = query.getResultList();
		
		//Return the result
		return customers;
	}

}
