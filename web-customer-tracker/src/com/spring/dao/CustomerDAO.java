package com.spring.dao;

import com.spring.entity.Customer;
import java.util.List;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);

	public List<Customer> serchCustomer(String searchBar);

}
