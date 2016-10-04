package com.niit.cdstack.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.model.Query;

@Repository
@Transactional
public class QueryDAOImpl implements QueryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addQuery(Query q) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(q);
		t.commit();
		s.close();
	}

}
