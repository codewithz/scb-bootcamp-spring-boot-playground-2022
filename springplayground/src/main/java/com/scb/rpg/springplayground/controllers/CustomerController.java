package com.scb.rpg.springplayground.controllers;

import java.time.LocalDateTime;
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

import com.scb.rpg.springplayground.config.payloads.ApiSuccessPayload;
import com.scb.rpg.springplayground.entities.Customer;
import com.scb.rpg.springplayground.services.ICustomerService;

import io.swagger.annotations.Api;

@RestController
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<ApiSuccessPayload> getAllCustomers(){
		
		List<Customer> customers=customerService.getAllCustomers();
		HttpStatus status=HttpStatus.OK;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(customers, "Customers List Found", status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<ApiSuccessPayload> getCustomerById(@PathVariable int id) {
		Customer c=customerService.getCustomerById(id);
		HttpStatus status=HttpStatus.OK;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(c,"Customer Found", status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<ApiSuccessPayload> addCustomer(@RequestBody Customer c) {
		String message=customerService.addCustomer(c);
		HttpStatus status=HttpStatus.CREATED;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(message, message, status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<ApiSuccessPayload> updateCustomer(@RequestBody Customer c,@PathVariable int id) {
		String message=customerService.updateCustomer(c, id);
		HttpStatus status=HttpStatus.CREATED;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(message, message, status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<ApiSuccessPayload> deleteCustomer(@PathVariable int id) {
		String message=customerService.deleteCustomer(id);
		HttpStatus status=HttpStatus.OK;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(message, message, status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}

}
