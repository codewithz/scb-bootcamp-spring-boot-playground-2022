package com.scb.rpg.springplayground.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.scb.rpg.springplayground.dao.ICustomerSchemeVODAO;
import com.scb.rpg.springplayground.entities.vo.CustomerSchemeVO;


@Repository
public class CustomerSchemeVODAO  implements ICustomerSchemeVODAO{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public List<CustomerSchemeVO> getCustomerAndTheirSchemes() {
		// TODO Auto-generated method stub
		
		String query="Select c.name,c.email,c.account_type,s.name,s.description,cs.date_applied,cs.status \r\n"
		+ "FROM customer c \r\n"
		+ "JOIN customer_scheme cs \r\n"
		+ "on c.id=cs.customer_id \r\n"
		+ "JOIN bank_scheme s \r\n"
		+ "ON s.id=cs.scheme_id \r\n";
		
		RowMapper<CustomerSchemeVO> rowMapper=new CustomerSchemeVORowMapper();
		List<CustomerSchemeVO> list=template.query(query, rowMapper);
		
		return list;
	}

}
