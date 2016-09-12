package com.niit.cdstack.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.model.Products;

@Repository
@Transactional
public class ProductsDAOImpl implements ProductsDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addProduct(Products p) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.openSession();
		s.saveOrUpdate(p);
		s.close();
		
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	



}
