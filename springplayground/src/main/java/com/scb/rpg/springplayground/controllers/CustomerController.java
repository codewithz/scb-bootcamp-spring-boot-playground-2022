package com.scb.rpg.springplayground.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers=customerService.getAllCustomers();
		HttpStatus status=HttpStatus.OK;
		ResponseEntity<List<Customer>> response=new ResponseEntity<List<Customer>>(customers, status);
		return response;
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		Customer c=customerService.getCustomerById(id);
		HttpStatus status=HttpStatus.OK;
		ResponseEntity<Customer> response=new ResponseEntity<Customer>(c, status);
		return response;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<String> addCustomer(@RequestBody Customer c) {
		String message=customerService.addCustomer(c);
		HttpStatus status=HttpStatus.CREATED;
		ResponseEntity<String> response=new ResponseEntity<String>(message, status);
		return response;
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer c,@PathVariable int id) {
		String message=customerService.updateCustomer(c, id);
		HttpStatus status=HttpStatus.CREATED;
		ResponseEntity<String> response=new ResponseEntity<String>(message, status);
		return response;
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
		String message=customerService.deleteCustomer(id);
		HttpStatus status=HttpStatus.NO_CONTENT;
		ResponseEntity<String> response=new ResponseEntity<String>(message, status);
		return response;
	}

}
