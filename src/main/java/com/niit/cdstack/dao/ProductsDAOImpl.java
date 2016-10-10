package com.niit.cdstack.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.model.Category;
import com.niit.cdstack.model.Products;
import com.niit.cdstack.validations.IdGenerator;

@Repository
@Transactional
public class ProductsDAOImpl implements ProductsDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void addProduct(Products p) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(p);
		t.commit();
		s.close();
		
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		List<Products>pl=s.createQuery("from Products order by category").list();
		s.close();
		return pl;
	}

	@Override
	public Products getProductById(int id) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		Products p=(Products) s.load(Products.class, new Integer(id));
		tr.commit();
		return p;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		Products p=(Products) s.get(Products.class, new Integer(id));
		if(null!=p)
		{
			s.delete(p);
		}
		tr.commit();
		s.close();
	}

	@Override
	public void updateProduct(Products p) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.update(p);
		t.commit();
		s.close();
		System.out.println("Details Updated");
	}



	
}
