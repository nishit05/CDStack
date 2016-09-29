package com.niit.cdstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.cdstack.dao.CustomerDAO;
import com.niit.cdstack.model.Users;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerdao;
	
	@Override
	public void addUsers(Users u) {
		// TODO Auto-generated method stub
		customerdao.addUsers(u);
	}

}
