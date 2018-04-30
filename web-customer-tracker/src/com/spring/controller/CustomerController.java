package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dao.CustomerDAO;
import com.spring.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		
		//Get customers from DAO
		
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//Add the customers to the model
		
		theModel.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
		
	}

}
