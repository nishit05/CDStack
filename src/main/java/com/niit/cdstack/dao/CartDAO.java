package com.niit.cdstack.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.cdstack.model.Cart;

@Repository
public interface CartDAO {

	void addToCart(Cart ct);
	List<Cart>cartList(int id);
	void deleteFromCart(String id);
	Cart getCartById(String id);
	void updateCart(int qty,int id);
}
