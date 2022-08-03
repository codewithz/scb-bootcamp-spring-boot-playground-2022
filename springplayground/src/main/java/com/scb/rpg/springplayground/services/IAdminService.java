package com.scb.rpg.springplayground.services;

import java.util.List;

import com.scb.rpg.springplayground.entities.vo.CustomerSchemeVO;

public interface IAdminService {
	
	public List<CustomerSchemeVO> getCustomerAndTheirSchemes();

}
