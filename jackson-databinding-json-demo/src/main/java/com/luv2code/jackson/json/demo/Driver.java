package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Driver {
	
	public static void main(String[] args) {
		
		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO: data/sample-lite.json
			// data/sample-lite.json
			
			Student student = 
				mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			
			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());
			System.out.println(student.getAddress());
			
			Address address = student.getAddress();
			
			System.out.println("Street = " + address.getStreet());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}
