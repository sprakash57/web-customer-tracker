package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.Customer;

@Repository
public class CutomerDAOimpl implements CustomerDAO {
	
	//Need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public List<Customer> getCustomers() {
		
		//Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Create a query
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName",Customer.class);
		
		//Execute query
		List<Customer> customers = query.getResultList();
		
		//Return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//Get current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the customer
		currentSession.saveOrUpdate(theCustomer);	
	}

	@Override
	public Customer getCustomers(int theId) {
		
		//Get the current Hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//Retrieve from database using the primary key
		Customer theCustomer = session.get(Customer.class,theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);
		
		query.executeUpdate();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Customer> serchCustomer(String searchBar) {
		System.out.println(searchBar);
		Session session = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		if (searchBar != null && searchBar.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
			query = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			query.setParameter("theName", "%" + searchBar.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            query = session.createQuery("from Customer", Customer.class);            
        }
		
		List<Customer> customer = query.getResultList();
		System.out.println(customer);
		
		return customer;
	}

}
