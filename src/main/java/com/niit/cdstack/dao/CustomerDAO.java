package com.niit.cdstack.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.cdstack.model.Users;

@Repository
public interface CustomerDAO {
	void addUsers(Users u);
	Users getUserById(int id);
	void updateUser(Users u);
	List<Users>getAllUsers();
}
