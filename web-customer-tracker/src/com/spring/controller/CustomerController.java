package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Customer;
import com.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//Need to inject service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		//Get customers from Service
		
		List<Customer> theCustomers = customerService.getCustomers();
		
		//Add the customers to the model
		
		theModel.addAttribute("customers",theCustomers);
		return "list-customers";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//Save the customer to DB using service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	private String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//Get the customer from the service
		Customer theCustomer = customerService.getCustomers(theId);
		//Set customer as a model attribute to pre-populate the form
		theModel.addAttribute(theCustomer);
		//Send over to the form
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	private String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";	
	}
	
	@PostMapping("/search")
	private String serachCustomer(@RequestParam("searchBar") String searchBar, Model theModel) {
		
		List<Customer> customer = customerService.searchCustomer(searchBar);
		theModel.addAttribute("customers",customer);
		return "list-customers";
	}	

}
