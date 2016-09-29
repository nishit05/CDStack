package com.niit.cdstack.dao;

import org.springframework.stereotype.Repository;

import com.niit.cdstack.model.UserRoles;

@Repository
public interface UserRoleDAO {
	void addUserRoles(UserRoles ur);
	
}
