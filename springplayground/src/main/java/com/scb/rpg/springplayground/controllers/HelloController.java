package com.scb.rpg.springplayground.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(path = "/hello",method = RequestMethod.GET)
	public String sayHello() {
		return "Hello RPG";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return  "Welcome to Standard Chartered";
	}
	
	@GetMapping("/names")
	public List<String> getCandidateNames(){
		
		List<String> names=new ArrayList<>();
		names.add("Ajay");
		names.add("Souvik");
		names.add("Utkarsh");
		names.add("Priya");
		names.add("Thamil");
		
		return names;
	}
	
	@GetMapping("/users/{id}")
	public String testPathVariable(@PathVariable int id) {
		
		String message="User at ID #"+id+" is Dominic";
		
		return message;
		
	}
	
	@GetMapping("/orders")
	public String testRequestParameter(@RequestParam int id) {
		
		String message="Order at id #"+id+" is DELIVERED";
		return message;
	}

}
