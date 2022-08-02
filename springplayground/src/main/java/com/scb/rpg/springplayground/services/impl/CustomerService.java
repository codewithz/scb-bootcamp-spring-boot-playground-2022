package com.scb.rpg.springplayground.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.stereotype.Service;

import com.scb.rpg.springplayground.dao.ICustomerDAO;
import com.scb.rpg.springplayground.entities.Customer;
import com.scb.rpg.springplayground.services.ICustomerService;


@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	ICustomerDAO customerDAO;

	@Override
	public String addCustomer(Customer c) {
		System.out.println("------ Service Layer---------");
		String result=customerDAO.addCustomer(c);
		
		return  result;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> list=customerDAO.getAllCustomers();
		
		return list;
		
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer c=customerDAO.getCustomerById(id);
		return c;
	}

	@Override
	public String updateCustomer(Customer c, int id) {
		String result=customerDAO.updateCustomer(c, id);
		return result;
	}

	@Override
	public String deleteCustomer(int id) {
		String result=customerDAO.deleteCustomer(id);
		return result;
	}

}
