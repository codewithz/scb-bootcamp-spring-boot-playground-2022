package com.scb.rpg.springplayground.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scb.rpg.springplayground.entities.Customer;
import com.scb.rpg.springplayground.services.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		List<Customer> customers=customerService.getAllCustomers();
		return customers;
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		Customer c=customerService.getCustomerById(id);
		return c;
	}
	
	@PostMapping("/customers")
	public String addCustomer(@RequestBody Customer c) {
		String message=customerService.addCustomer(c);
		return message;
	}
	
	@PutMapping("/customers/{id}")
	public String updateCustomer(@RequestBody Customer c,@PathVariable int id) {
		String message=customerService.updateCustomer(c, id);
		return message;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		String message=customerService.deleteCustomer(id);
		return message;
	}

}
