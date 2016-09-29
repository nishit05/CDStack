package com.niit.cdstack.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.model.UserRoles;
import com.niit.cdstack.model.Users;

@Repository
@Transactional
public class UserRoleDAOImpl implements UserRoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUserRoles(UserRoles ur) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Users u=new Users();
		ur.setU_id(u.getU_id());
		s.saveOrUpdate(ur);
		s.close();
	}

}
