package com.niit.cdstack.dao;

import org.springframework.stereotype.Repository;

import com.niit.cdstack.model.Users;

@Repository
public interface CustomerDAO {
	void addUsers(Users u);
}
