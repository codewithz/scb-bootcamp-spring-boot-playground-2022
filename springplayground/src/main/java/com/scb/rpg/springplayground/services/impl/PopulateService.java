package com.scb.rpg.springplayground.services.impl;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.scb.rpg.springplayground.dao.impl.CustomerDAO;
import com.scb.rpg.springplayground.entities.Customer;
import com.scb.rpg.springplayground.services.IPopulateService;

@Service
public class PopulateService implements IPopulateService{
	
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public String populateCustomers() {
		
		for(int i=1;i<=1000;i++) {
		
		Faker faker=new Faker();
		
		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		String email=String.format("%s.%s@gmail.com", firstName,lastName);
		String contactString=faker.number().digits(10);
		System.out.println(contactString);
		long contact=Long.parseLong(contactString);
		String accountType=i%2==0?"Savings":"Current";
//		LocalDate accountCreationDate=LocalDate.parse(faker.date()
		System.out.println(faker.date().between(new Date(),new Date(2010,02,01)));
		LocalDate accountCreationDate=LocalDate.now();
		
		Customer c=new Customer(firstName+" "+lastName, email, accountType, contact, accountCreationDate);
		System.out.println(c);
		customerDAO.addCustomer(c);
		}
		
		return "SUCCESS";
		
		
	}
	
	

}
