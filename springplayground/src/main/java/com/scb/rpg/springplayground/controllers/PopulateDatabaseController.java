package com.scb.rpg.springplayground.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.rpg.springplayground.config.payloads.ApiSuccessPayload;
import com.scb.rpg.springplayground.services.impl.PopulateService;

@RestController
public class PopulateDatabaseController {
	
	@Autowired
	PopulateService populateService;
	
	@PostMapping("/populate/customers")
	public ResponseEntity<ApiSuccessPayload> populateCustomer() {
		
		HttpStatus status=HttpStatus.OK;
		String message=populateService.populateCustomers();
		ApiSuccessPayload payload=ApiSuccessPayload.build(message, message, status);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
				
		
		return response; 
		
	}

}
