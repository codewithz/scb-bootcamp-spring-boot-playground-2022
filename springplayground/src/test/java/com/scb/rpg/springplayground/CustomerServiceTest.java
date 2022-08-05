package com.scb.rpg.springplayground;

import static org.assertj.core.api.Assertions.assertThatIOException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.scb.rpg.springplayground.dao.impl.CustomerDAO;
import com.scb.rpg.springplayground.entities.Customer;
import com.scb.rpg.springplayground.services.impl.CustomerService;

public class CustomerServiceTest {
	
	
	@Mock // component I want to mock
	private CustomerDAO customerDAO;
	 
	@InjectMocks // this is the component where the mocked component is injected
	private CustomerService customerService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	Customer c1=new Customer(1001, "Tom", "tom@gmail.com", "Savings", 9988776655l, LocalDate.parse("2021-09-12"));
	Customer c2=new Customer(1002, "Alex", "alex@gmail.com", "Current", 9988776654l, LocalDate.parse("2022-01-14"));
	Customer c3=new Customer(1003, "Mike", "mike@gmail.com", "Savings", 9988776653l, LocalDate.parse("2020-12-12"));
	
	@Test
	public void getAllCustomers_success() {
//		Mock
		List<Customer> customers=new ArrayList<>(Arrays.asList(c1,c2,c3));
		
		Mockito.when(customerDAO.getAllCustomers()).thenReturn(customers);
//		When
		List<Customer> customersReturned=customerService.getAllCustomers();
		
		
//		Then
		
		Assertions.assertNotNull(customersReturned);
		Assertions.assertEquals(customersReturned.size(), 3);
		Assertions.assertEquals(customersReturned.get(1).getEmail(), "alex@gmail.com");
			
		
	}
	
	@Test
	public void getCustomerById_success() {
//		Mock
		Customer customer=c3;
		
		Mockito.when(customerDAO.getCustomerById(customer.getId())).thenReturn(customer);
//		When
		
		Customer customerReturned=customerService.getCustomerById(1003);

//		Then
		
		Assertions.assertNotNull(customerReturned);
		Assertions.assertEquals(customerReturned.getAccountCreationDate(), LocalDate.parse("2020-12-12"));
		Assertions.assertEquals(customerReturned.getAccountType(), "Savings");
		
		
		
	}
	@Test
	public void addCustomer_success() {
//		Mock
		Customer customer=c1;
		
		Mockito.when(customerDAO.addCustomer(customer)).thenReturn("SUCCESS");
//		When 
			
		String message=customerService.addCustomer(customer);
		
//		Then
		Assertions.assertNotNull(message);
		Assertions.assertEquals(message, "SUCCESS");
		
		
		
	}
	
	@Test
	public void updateCustomer_success() {
//		Mock
		Customer customer=c1;
		
		Mockito.when(customerDAO.updateCustomer(customer,1001)).thenReturn("SUCCESS");
//		When 
			
		String message=customerService.updateCustomer(customer,1001);
		
//		Then
		Assertions.assertNotNull(message);
		Assertions.assertEquals(message, "SUCCESS");
		
		
		
	}
	
	@Test
	public void deleteCustomer_success() {
//		Mock
		
		Mockito.when(customerDAO.deleteCustomer(1003)).thenReturn("SUCCESS");
//		When 
			
		String message=customerService.deleteCustomer(1003);
		
//		Then
		Assertions.assertNotNull(message);
		Assertions.assertEquals(message, "SUCCESS");
		
		
		
	}
		
		
	
}
