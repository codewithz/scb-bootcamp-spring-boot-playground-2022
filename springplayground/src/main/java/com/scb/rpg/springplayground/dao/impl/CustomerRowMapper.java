package com.scb.rpg.springplayground.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.scb.rpg.springplayground.entities.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Customer c=new Customer();
		
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setAccountType(rs.getString("account_type"));
		c.setContact(rs.getLong("contact"));
		c.setEmail(rs.getString("email"));
		c.setAccountCreationDate(LocalDate.parse(rs.getString("account_creation_date")));
		
		return c;
		
	}
	
	

}
