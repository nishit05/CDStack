package com.niit.cdstack.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.cdstack.dao.ProductsDAO;
import com.niit.cdstack.model.Products;

import junit.framework.Assert;

public class ProductTest {

	@Autowired
	private static ProductsDAO productsdao;

	@Autowired
	private static Products products;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.cdstack");
		context.refresh();
		
		productsdao=(ProductsDAO) context.getBean("productsdao");
		products=(Products) context.getBean("products");
		
	}
	
	@Test
	public void getProductTest()
	{
		products=productsdao.getProductById(1);
		String n=products.getPname();
		assertEquals("get Product Test case", "2012", n);
	}
}
