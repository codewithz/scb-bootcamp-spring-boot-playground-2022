package com.scb.rpg.springplayground.dao;

import java.util.List;

import com.scb.rpg.springplayground.entities.vo.CustomerSchemeVO;

public interface ICustomerSchemeVODAO {
	
	public List<CustomerSchemeVO> getCustomerAndTheirSchemes();

}
