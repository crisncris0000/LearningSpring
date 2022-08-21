package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	// load employee data
	
	private List<Employee> employees;
	// add mapping for "/list"
	
	@PostConstruct
	private void loadData() {
		Employee employee = new Employee(1, "Christopher", "Rivera", "ChrisR@gmail.com");
		Employee employee2 = new Employee(2, "Seb", "Ram", "Sebby@gmail.com");
		Employee employee3 = new Employee(3, "Robert", "Nunez", "Robb@gmail.com");
		
		employees = new ArrayList<>();
		
		employees.add(employee);
		employees.add(employee2);
		employees.add(employee3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", employees);
		
		return "list-employees";
	}
	
	
	
}
