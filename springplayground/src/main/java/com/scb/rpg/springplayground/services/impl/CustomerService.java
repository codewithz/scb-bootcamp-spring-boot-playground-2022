package com.scb.rpg.springplayground.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scb.rpg.springplayground.entities.Customer;
import com.scb.rpg.springplayground.services.ICustomerService;


@Service
public class CustomerService implements ICustomerService {

	@Override
	public String addCustomer(Customer c) {
		System.out.println("------ Service Layer---------");
		System.out.println(c);
		
		return  "SUCCESS";
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=new ArrayList<>();
		
		Customer c1=new Customer(1001,"Tom","tom@gmail.com","Savings",99877676l,LocalDate.now());
		Customer c2=new Customer(1002,"Alex","alex@gmail.com","Current",99877678l,LocalDate.now());
		Customer c3=new Customer(1003,"Mike","mike@gmail.com","Savings",998776777l,LocalDate.now());
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		return list;
		
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer c1=new Customer(id,"Tom","tom@gmail.com","Savings",99877676l,LocalDate.now());
		return c1;
	}

	@Override
	public String updateCustomer(Customer c, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
