package com.scb.rpg.springplayground;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.scb.rpg.springplayground.dao.ICustomerDAO;
import com.scb.rpg.springplayground.entities.Customer;
import com.scb.rpg.springplayground.services.impl.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper=new ObjectMapper();
	ObjectWriter objectWriter=objectMapper.writer();
	
	
	@Mock
	private ICustomerDAO customerDAO;
	
	
	@InjectMocks
	private CustomerService customerService;
	
	Customer c1=new Customer(1, "Tom", "tom@gmail.com", "Savings", 9988776677l, LocalDate.parse("2022-07-12"));
	Customer c2=new Customer(2, "Alex", "alex@gmail.com", "Current", 9988776689l, LocalDate.parse("2022-06-12"));
	Customer c3=new Customer(3, "Mike", "mike@gmail.com", "Savings", 9988776698l, LocalDate.parse("2022-05-12"));
	
	@BeforeEach
	public void setUp() {
	
		MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(customerService).build();
		System.out.println("---------------------");
		
		
	}
	
	@Test
	public void getAllCustomers_success() throws Exception {
		
		List<Customer> customers=new ArrayList<>(Arrays.asList(c1,c2,c3));
		
		Mockito.when(customerDAO.getAllCustomers()).thenReturn(customers);
		
//		When
		List<Customer> customersReturned=customerDAO.getAllCustomers();
		
//		Then
		Assertions.assertNotNull(customersReturned);
		Assertions.assertEquals(customersReturned.size(), 3);
		Assertions.assertEquals(customersReturned.get(1).getEmail(),"alex@gmail.com" );
		
	}
	

}
