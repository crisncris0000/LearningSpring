package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.luv2code.springboot.cruddemo.entity.Employee;

// Changing from employees to /members
// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
