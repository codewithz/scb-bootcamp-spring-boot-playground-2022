package com.scb.rpg.springplayground.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.scb.rpg.springplayground.entities.vo.CustomerSchemeVO;

public class CustomerSchemeVORowMapper implements RowMapper<CustomerSchemeVO>{

	@Override
	public CustomerSchemeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
//		c.name,c.email,c.account_type,s.name,s.description,cs.date_applied,cs.status "
		
		CustomerSchemeVO vo=new CustomerSchemeVO();
		
		vo.setCustomerName(rs.getString(1));
		vo.setEmail(rs.getString(2));
		vo.setAccountType(rs.getString(3));
		vo.setSchemeName(rs.getString(4));
		vo.setSchemeDescription(rs.getString(5));
		vo.setDateApplied(LocalDate.parse(rs.getString(6)));
		vo.setStatus(rs.getString(7));
		
		return vo;
		
	}
	
	

}
