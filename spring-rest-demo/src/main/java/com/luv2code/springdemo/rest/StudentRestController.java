package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	// define @PostConstruct to load the data only once!

	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();

		students.add(new Student("Chris", "Rivera"));
		students.add(new Student("Bobby", "Lashley"));
		students.add(new Student("Sebastian", "Ramirez"));
		students.add(new Student("Brandon", "Garcia"));
	}

	// define endpoint for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}

	// define endpoint for "/student/{studentId} - return student at index"

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// just index into the list simple for now...

		if ((studentId >= students.size() || studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return students.get(studentId);
	}
}
