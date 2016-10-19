package com.niit.cdstack.webflow;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.cdstack.dao.CartDAO;
import com.niit.cdstack.dao.CustomerDAO;
import com.niit.cdstack.model.Cart;
import com.niit.cdstack.model.Order;
import com.niit.cdstack.model.ShippingAddress;
import com.niit.cdstack.model.Users;

@Component
public class WebflowController {

	@Autowired
	CustomerDAO cudao;

	@Autowired
	CartDAO cdao;

	@Autowired
	HttpSession hs;

	public int getUserId() {
		int i = 0;
		String name = (String) hs.getAttribute("name");
		List<Users> ul = cudao.getAllUsers();
		for (Users u : ul) {
			if (u.getUsername().equals(name))
				i = u.getU_id();
		}
		return i;
	}

	public String addOrder(ShippingAddress sa, Order o) {
		if (o.getPaytype().equalsIgnoreCase("Select Card")) {
			hs.setAttribute("msge", "Select the Card Type");
			return "not added";
		} else {
			boolean b = cdao.addShippingAddress(sa);
			if (!b) {
				hs.setAttribute("msge", "Address adding unsuccessful");
				return "not added";
			} else {
				double price = (double) hs.getAttribute("total");
				String add = sa.getAddress() + "\n" + sa.getCity() + sa.getPincode() + "\n" + sa.getState();
				o.setShippingaddress(add);
				o.setPrice(price);
				o.setName(sa.getName());
				boolean flag = cdao.addOrder(o);
				if (!flag) {
					hs.setAttribute("msge", "Order adding unsuccessful");
					return "not added";
				} else {
					int i = getUserId();
					List<Cart> cl = cdao.cartList(i);
					for (Cart c : cl) {
						cdao.deleteFromCart(c.getCt_id());
					}
					
				}
			}
			return "added";
		}
	}

}
