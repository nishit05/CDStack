package com.niit.cdstack.service;

import java.util.List;

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

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return customerdao.getUserById(id);
	}

	@Override
	public void updateUsers(Users u) {
		// TODO Auto-generated method stub
		customerdao.updateUser(u);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return customerdao.getAllUsers();
	}

}
