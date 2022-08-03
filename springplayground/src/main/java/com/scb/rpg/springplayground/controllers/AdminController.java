package com.scb.rpg.springplayground.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.rpg.springplayground.config.payloads.ApiSuccessPayload;
import com.scb.rpg.springplayground.entities.Customer;
import com.scb.rpg.springplayground.entities.vo.CustomerSchemeVO;
import com.scb.rpg.springplayground.services.IAdminService;

@RestController
public class AdminController {
	
	@Autowired
	IAdminService adminService;
	
	@GetMapping("/customers/shcemes")
	public ResponseEntity<ApiSuccessPayload> getAllCustomersAndTheirSchemes(){
		
		
		List<CustomerSchemeVO> customerSchemes=adminService.getCustomerAndTheirSchemes();
		HttpStatus status=HttpStatus.OK;
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(customerSchemes, "Customers and Scheme List Found", status);
		
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}

}
