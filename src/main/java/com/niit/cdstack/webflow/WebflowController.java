package com.niit.cdstack.webflow;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
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
		Date od = new Date();
		Date dd = new Date();
		Calendar cd = Calendar.getInstance();

		Date d = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		String t = df.format(d);
		try {
			od = df.parse(t);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cd.setTime(od);
		cd.add(Calendar.DATE, 0);

		Date dc = cd.getTime();
		String t1 = df.format(dc);
		try {
			dd = df.parse(t1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean b = cdao.addShippingAddress(sa);
			double price = (double) hs.getAttribute("total");
			String add = sa.getAddress() + "\n" + sa.getCity() + "	" + sa.getPincode() + "\n" + sa.getState();
			o.setShippingaddress(add);
			o.setPrice(price);
			o.setName(sa.getName());
			o.setOrdate(od);
			o.setDeldate(dd);
			boolean flag = cdao.addOrder(o);
			if (!flag || !b) {
				hs.setAttribute("msgpe", "Adding unsuccessful");
				return "not added";
			} else {
				int i = getUserId();
				List<Cart> cl = cdao.cartList(i);
				for (Cart c : cl) {
					cdao.deleteFromCart(c.getCt_id());
				}

			}
		return "added";
	}
}
