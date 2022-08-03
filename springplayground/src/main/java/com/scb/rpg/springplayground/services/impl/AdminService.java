package com.scb.rpg.springplayground.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.rpg.springplayground.dao.impl.CustomerSchemeVODAO;
import com.scb.rpg.springplayground.entities.vo.CustomerSchemeVO;
import com.scb.rpg.springplayground.services.IAdminService;

@Service
public class AdminService implements IAdminService{

	@Autowired
	CustomerSchemeVODAO customerSchemeDAO;
	
	@Override
	public List<CustomerSchemeVO> getCustomerAndTheirSchemes() {
		// TODO Auto-generated method stub
		List<CustomerSchemeVO> list=customerSchemeDAO.getCustomerAndTheirSchemes();
		return list;
	}

}
