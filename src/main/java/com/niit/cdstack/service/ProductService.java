package com.niit.cdstack.service;

import java.util.List;

import com.niit.cdstack.model.Products;

public interface ProductService {
	void addProduct(Products p);

	List<Products> getAllProducts();

	Products getProductById(int id);

	void deleteProduct(int id);
	
	void updateProduct(Products p);
}
