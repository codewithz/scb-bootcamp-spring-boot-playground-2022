package com.scb.rpg.springplayground.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.scb.rpg.springplayground.dao.ICustomerDAO;
import com.scb.rpg.springplayground.entities.Customer;

@Repository
public class CustomerDAO implements ICustomerDAO {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public String addCustomer(Customer c) {
		System.out.println("---- DAO Layer ----");
		String query="Insert into customer(name,email,contact,account_type,account_creation_date) values (?,?,?,?,?)";
		int rowsInserted=template.update(query,c.getName(),c.getEmail(),c.getContact(),c.getAccountType(),c.getAccountCreationDate());
		
		if(rowsInserted==1) {
			return "SUCCESS";
		}
		else {
			return "FAILURE";
		}
	
	}

	@Override
	public List<Customer> getAllCustomers() {
		String query="Select  id,name,email,contact,account_type,account_creation_date from customer";
		RowMapper<Customer> rowMapper=new CustomerRowMapper();
		List<Customer> list=template.query(query, rowMapper);
		
		if(!list.isEmpty()) {
		return list;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No customers found in database");
		}
	}

	@Override
	public Customer getCustomerById(int id) {
		try {
		String query="Select  id,name,email,contact,account_type,account_creation_date from customer where id=?";
		RowMapper<Customer> rowMapper=new CustomerRowMapper();
		Customer c=template.queryForObject(query, rowMapper, id);
		
		if(c!=null) {
			return c;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer with id: "+id+" is not found");
		}
		
		
		}
		catch (Exception e) {
			if(e instanceof ResponseStatusException) {
				throw e;
			}
			else {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			}
		}
		}

	@Override
	public String updateCustomer(Customer c, int id) {
		System.out.println("---- DAO Layer ----");
		String query="Update customer set name=?,email=?,contact=?,account_type=?,account_creation_date=? where id=?";
		int rowsUpdated=template.update(query,c.getName(),c.getEmail(),c.getContact(),c.getAccountType(),c.getAccountCreationDate(),id);
		
		if(rowsUpdated==1) {
			return "SUCCESS";
		}
		else {
			return "FAILURE";
		}
	}

	@Override
	public String deleteCustomer(int id) {
		System.out.println("---- DAO Layer ----");
		String query="Delete from  customer  where id=?";
		int rowsDeleted=template.update(query,id);
		
		if(rowsDeleted==1) {
			return "SUCCESS";
		}
		else {
			return "FAILURE";
		}
	}

}
