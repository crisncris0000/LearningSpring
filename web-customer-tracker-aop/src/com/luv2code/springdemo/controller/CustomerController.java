package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer service
	@Autowired
	CustomerService service;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the dao 
		List<Customer> customers = service.getCustomers();
		// add the customers to the model
		
		theModel.addAttribute("customers", customers);
		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		
		Customer customer = new Customer();
		
		theModel.addAttribute("customer", customer);
		
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer into service
		
		service.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, 
									Model theModel) {
		
		// get the customer from the service
		Customer theCustomer = service.getCustomer(theId);
		
		// set the customer as a model attribute to pre populate the form
		theModel.addAttribute("customer", theCustomer);
		// send over our form
		
		
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		
		// delete the customer;
		
		service.deleteCustomer(theId);
		
		
		return "redirect:/customer/list";
	}
	
}
