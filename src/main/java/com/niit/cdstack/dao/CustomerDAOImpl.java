package com.niit.cdstack.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.model.UserRoles;
import com.niit.cdstack.model.Users;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUsers(Users u) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		s.saveOrUpdate(u);
		UserRoles ur=new UserRoles();
		ur.setAuthority("ROLE_USER");
		ur.setU_id(u.getU_id());
		s.save(ur);
		tr.commit();
		s.close();
	}

}
