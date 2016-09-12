package com.niit.cdstack.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.cdstack.model.*;
@Repository
public interface ProductsDAO {
	void addProduct(Products p);
	List<Products> getAllProducts();
	
}
