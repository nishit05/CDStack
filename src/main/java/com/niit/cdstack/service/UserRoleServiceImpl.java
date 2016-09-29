package com.niit.cdstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.cdstack.dao.UserRoleDAO;
import com.niit.cdstack.model.UserRoles;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDAO userroledao;

	@Override
	public void addUserRoles(UserRoles ur) {
		// TODO Auto-generated method stub
		userroledao.addUserRoles(ur);

	}

}
