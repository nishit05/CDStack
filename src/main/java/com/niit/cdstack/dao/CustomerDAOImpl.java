package com.niit.cdstack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.model.Products;
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

	@Override
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		Users u=(Users) s.load(Users.class, new Integer(id));
		t.commit();
		return u;
	}

	@Override
	public void updateUser(Users u) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.update(u);
		t.commit();
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		List<Users>ul=s.createQuery("from Users").list();
		s.close();
		return ul;
	}




}
