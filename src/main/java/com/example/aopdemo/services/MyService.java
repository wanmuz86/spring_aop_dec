package com.example.aopdemo.services;

import org.springframework.stereotype.Component;

// This is a class/component going to be managed by Spring

@Component 
public class MyService {

	
	public void performTask() {
		System.out.println("Performing task in MyService.");
	}
	
	public String getData() {
		return "Some Data";
	}
	
	// This is a method to simulate an error
	
	public void throwException() throws Exception {
		throw new Exception("An Error occured");
	}
}
