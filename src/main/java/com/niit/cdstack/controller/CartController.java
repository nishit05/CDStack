package com.niit.cdstack.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cdstack.dao.CartDAO;
import com.niit.cdstack.model.Cart;
import com.niit.cdstack.model.Order;
import com.niit.cdstack.model.Products;
import com.niit.cdstack.model.Users;
import com.niit.cdstack.service.CustomerServiceImpl;
import com.niit.cdstack.service.ProductServiceImpl;

@Controller
public class CartController {

	@Autowired
	private CartDAO cdao;

	@Autowired
	private CustomerServiceImpl csi;

	@Autowired
	private ProductServiceImpl psi;

	@Autowired
	private HttpSession session;

	@RequestMapping(value = "addtocart", method = RequestMethod.GET)
	public ModelAndView addToCart(@Valid @ModelAttribute("cart") Cart c, @RequestParam("id") int id,
			@RequestParam("name") String name, BindingResult result) {
		double sum = 0;
		int n = 0;
		Users us = new Users();
		// Products p = new Products();
		List<Users> ul = csi.getAllUsers();
		for (Users u : ul)
			if (u.getUsername().equals(name))
				us = u;
		c.setU_id(us.getU_id());

		// ModelAndView mv = new ModelAndView("/Cart/cart");
		c.setPid(id);
		c.setQty(1);
		cdao.addToCart(c);
		List<Cart> cl = cdao.cartList(c.getU_id());
		// for (Cart ct : cl) {
		// if (ct.getPid() == id) {
		// ct.setQty(ct.getQty() + 1);
		// c = ct;
		// cdao.addToCart(c);
		// }
		// }

		ModelAndView mv = new ModelAndView("/Cart/cart");
		mv.addObject("clist", cl);
		mv.addObject("ct_id", c.getCt_id());
		for (Cart ct : cl) {
			sum = sum + (ct.getQty() * ct.getPrice());
		}
		session.setAttribute("total", sum);
		// session.setAttribute("num", n);

		mv.addObject("total", sum);
		// List<Products>pl=psi.getAllProducts();
		// for(Products pr:pl)
		// {
		// if(pr.getPid()==c.getPid())
		// {
		// p=pr;
		// //p.setQty(p.getQty()-c.getQty());
		// }
		// }

		// psi.updateProduct(p);

		return mv;
	}

	@RequestMapping(value = "viewcart", method = RequestMethod.GET)
	public ModelAndView Cart(@RequestParam("name") String name) {
		Users us = new Users();
		double sum = 0;
		List<Users> ul = csi.getAllUsers();
		for (Users u : ul)
			if (u.getUsername().equals(name))
				us = u;
		List<Cart> cl = cdao.cartList(us.getU_id());
		if (cl.isEmpty()) {
			ModelAndView mv = new ModelAndView("/Cart/emptycart");
			mv.addObject("msgc", "Your Cart is Empty");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("/Cart/cart");
			for (Cart c : cl) {
				sum = sum + (c.getQty() * c.getPrice());
			}
			session.setAttribute("total", sum);
			mv.addObject("clist", cl);
			return mv;
		}
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView DeleteItem(@RequestParam("id") String id, Model rea, @RequestParam("name") String name,
			@RequestParam("pid") int pid, @RequestParam("qty") int qty) {
		Cart cr = new Cart();
		Users us = new Users();
		double sum = 0;
		cdao.deleteFromCart(id);
		List<Users> ul = csi.getAllUsers();
		for (Users u : ul)
			if (u.getUsername().equals(name))
				us = u;
		List<Cart> cl = cdao.cartList(us.getU_id());
		if (cl.isEmpty()) {
			rea.addAttribute("msgd", "Item deleted from Cart Successfully");
			ModelAndView mv = new ModelAndView("/Cart/emptycart");
			mv.addObject("msgc", "Your Cart is Empty");
			return mv;
		} else {
			rea.addAttribute("msgd", "Item deleted from Cart Successfully");
			ModelAndView mv = new ModelAndView("/Cart/cart");
			Products p = new Products();
			List<Products> pl = psi.getAllProducts();
			for (Products pr : pl) {
				if (pr.getPid() == pid)
					p = pr;
			}

			for (Cart c : cl) {
				if (pid == c.getPid())
					cr = c;
				sum = sum + (c.getQty() * c.getPrice());
			}

			// p.setQty(p.getQty()+cr.getQty());
			// psi.updateProduct(p);
			// n=n-qty;
			// session.setAttribute("num", n);
			mv.addObject("clist", cl);
			mv.addObject("total", sum);
			return mv;
		}
	}

	@RequestMapping(value = "updatecart", method = RequestMethod.GET)
	public ModelAndView UpdateQty(@RequestParam("qty") int qty, @RequestParam("id") int id,
			@RequestParam("name") String name, @RequestParam("uid") int uid) {
		double sum = 0;
		int n = 0;
		Cart cr = new Cart();
		System.out.println("Cart obj method called");
		cdao.updateCart(qty, id, uid);
		ModelAndView mv = new ModelAndView("/Cart/cart");
		mv.addObject("msgu", "Item Update in Cart Successfully");
		Users us = new Users();
		Products p = new Products();

		List<Users> ul = csi.getAllUsers();
		for (Users u : ul)
			if (u.getUsername().equals(name))
				us = u;
		List<Cart> cl = cdao.cartList(us.getU_id());
		for (Cart c : cl) {
			if (id == c.getPid())
				cr = c;
			n = n + c.getQty();
			sum = sum + (c.getQty() * c.getPrice());
		}
		List<Products> pl = psi.getAllProducts();
		for (Products pr : pl) {
			if (pr.getPid() == id) {
				p = pr;
				// p.setQty(p.getQty()-(cr.getQty()-qty));
				// psi.updateProduct(p);
			}

		}
		session.setAttribute("total", sum);
		mv.addObject("clist", cl);
		mv.addObject("total", sum);
		return mv;

	}
	
	@RequestMapping(path="orderstate",method=RequestMethod.GET)
	public ModelAndView trackOrderForm()
	{
		Order o=new Order();
		ModelAndView mv=new ModelAndView("/Cart/orderstate");
		mv.addObject("order", o);
		return mv;
		
	}
	
	@RequestMapping(path="ordertrack",method=RequestMethod.POST)
	public ModelAndView trackOrder(@Valid @RequestParam("id")String id,@ModelAttribute("order")Order or,BindingResult result)
	{
		
		List<Order>orl=cdao.getOrderList(id);
		ModelAndView mv=new ModelAndView("/Cart/ordertrack");
		for(Order ol:orl)
		{
			if(ol.getId().equals(id))
			{
				
				Date d=new Date();
				Date od=ol.getDeldate();
				DateFormat df=DateFormat.getDateInstance(DateFormat.SHORT);
				String s1=df.format(od);
				String s2=df.format(d);
				System.out.println(s1+" "+s2);
				if(s1.equalsIgnoreCase(s2))
				{
					ol.setStatus(true);
					cdao.updateOrder(ol);
					mv.addObject("msg", "The Order for id "+ol.getId()+" is delivered");
				}
				else
				{
					mv.addObject("msg", "The Order for id "+ol.getId()+" is not delivered");
				}
			}
			else
			{
				System.out.println(ol.getId().equals(id));
				mv.addObject("msg", "Order id does not exist");
			}
				
		}
		return mv;	
	}
}
