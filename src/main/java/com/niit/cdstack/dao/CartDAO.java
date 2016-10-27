package com.niit.cdstack.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.cdstack.model.Cart;
import com.niit.cdstack.model.Order;
import com.niit.cdstack.model.ShippingAddress;

@Repository
public interface CartDAO {

	void addToCart(Cart ct);
	List<Cart>cartList(int id);
	void deleteFromCart(String id);
	Cart getCartById(String id);
	void updateCart(int qty,int id,int uid);
	boolean addShippingAddress(ShippingAddress sa);
	boolean addOrder(Order o);
	List<Order> getOrderList(String id);
	void updateOrder(Order o);
}
