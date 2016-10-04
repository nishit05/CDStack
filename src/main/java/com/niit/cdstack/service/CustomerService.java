package com.niit.cdstack.service;

import java.util.List;

import com.niit.cdstack.model.Users;

public interface CustomerService {
	void addUsers(Users u);
	Users getUserById(int id);
	void updateUsers(Users u);
	List<Users>getAllUsers();
}
