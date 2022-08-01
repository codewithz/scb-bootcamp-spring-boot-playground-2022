package com.scb.rpg.springplayground.services;

import java.util.List;

import com.scb.rpg.springplayground.entities.Customer;

public interface ICustomerService {
	
	public String addCustomer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int id);
	public String updateCustomer(Customer c,int id);
	public String deleteCustomer(int id);

}
