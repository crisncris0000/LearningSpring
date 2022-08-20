package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService){
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findEmployees();
	}
	
	@GetMapping("/employees/{theId}")
	public Employee getEmployee(@PathVariable int theId) {
		
		Employee employee = employeeService.findById(theId);
		
		if(employee == null) {
			throw new RuntimeException("Employee id not found: " + theId);
		}
		
		return employee;
	}
	
	// add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		// in case they send an id set it to 0 to force a save
		
		employee.setId(0);
		employeeService.save(employee);
		
		return employee;
	}
	
	// Update employee using PUT 
	@PutMapping("/employees")
	public Employee updatEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	// Delete employee by id
	@DeleteMapping("employees/{theId}")
	public String deleteEmployee(@PathVariable int theId) {
		Employee employee = employeeService.findById(theId);
		
		if(employee == null) {
			throw new RuntimeException("Employee never existed in the first place! id: " + theId);
		}
		
		employeeService.deleteById(theId);
		
		return "Employee Id of " + theId;
	}
	
	
	
	
	
}
