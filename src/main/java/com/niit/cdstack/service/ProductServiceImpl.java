package com.niit.cdstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cdstack.dao.ProductsDAO;
import com.niit.cdstack.model.Products;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductsDAO productsdao;
	
	@Override
	public void addProduct(Products p) {
		// TODO Auto-generated method stub
		productsdao.addProduct(p);
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productsdao.getAllProducts();
	}

	@Override
	public Products getProductById(int id) {
		// TODO Auto-generated method stub
		return productsdao.getProductById(id);
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productsdao.deleteProduct(id);
	}

	@Override
	public void updateProduct(Products p) {
		// TODO Auto-generated method stub
		productsdao.updateProduct(p);
	}

}
