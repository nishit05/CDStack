package com.niit.cdstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.dao.ProductsDAO;
import com.niit.cdstack.model.Products;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductsDAO productsdao;
	
	@Override
	public void addProduct(Products p) {
		// TODO Auto-generated method stub
		productsdao.addProduct(p);
	}

}
