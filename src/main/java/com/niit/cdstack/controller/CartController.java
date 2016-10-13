package com.niit.cdstack.controller;

import java.util.List;

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
	
	
	@RequestMapping(value="addtocart", method=RequestMethod.GET)
	public ModelAndView addToCart(@Valid @ModelAttribute("cart")Cart c,@RequestParam("id")int id,@RequestParam("name")String name,BindingResult result)
	{
		double sum=0; 
		Users us=new Users();
		Products p=new Products();
		List<Users>ul=csi.getAllUsers();
		for(Users u:ul)
			if(u.getUsername().equals(name))
				us=u;
		c.setU_id(us.getU_id());
		ModelAndView mv=new ModelAndView("/Cart/cart");
		
		List<Cart>cl=cdao.cartList(c.getU_id());
		for(Cart ct:cl)
		{
			if(ct.getPid()==id)
				{
					ct.setQty(ct.getQty()+1);
					c=ct;
				}
			else
			{
				c.setPid(id);
				c.setQty(1);
			}
		}
		List<Products>pl=psi.getAllProducts();
		for(Products pr:pl)
		{
			if(pr.getPid()==c.getPid())
			{
				p=pr;
				//p.setQty(p.getQty()-c.getQty());
			}
		}
		cdao.addToCart(c);
		
		//psi.updateProduct(p);
		mv.addObject("clist", cl);
		mv.addObject("ct_id", c.getCt_id());
		for(Cart ct:cl)
		{
			sum=sum+(ct.getQty()*ct.getPrice());
		}
		mv.addObject("total", sum);
		return mv;
	}
	
	

	@RequestMapping(value="viewcart",method=RequestMethod.GET)
	public ModelAndView Cart(@RequestParam("name")String name)
	{
		Users us=new Users();
		double sum=0;
		List<Users>ul=csi.getAllUsers();
		for(Users u:ul)
			if(u.getUsername().equals(name))
				us=u;
		List<Cart>cl=cdao.cartList(us.getU_id());
		ModelAndView mv=new ModelAndView("/Cart/cart");
		for(Cart c:cl)
		{
			sum=sum+(c.getQty()*c.getPrice());
		}
		
		mv.addObject("clist", cl);
		mv.addObject("total", sum);
		return mv;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public ModelAndView DeleteItem(@RequestParam("id")String id,Model rea,@RequestParam("name")String name,@RequestParam("pid")int pid)
	{
		Cart cr=new Cart();
		double sum=0;
		cdao.deleteFromCart(id);
		rea.addAttribute("msgd","Item deleted from Cart Successfully");
		ModelAndView mv=new ModelAndView("/Cart/cart");
		Users us=new Users();
		Products p=new Products();
		List<Products>pl=psi.getAllProducts();
		for(Products pr:pl)
		{
			if(pr.getPid()==pid)
				p=pr;
		}
		List<Users>ul=csi.getAllUsers();
		for(Users u:ul)
			if(u.getUsername().equals(name))
				us=u;
		List<Cart>cl=cdao.cartList(us.getU_id());
		for(Cart c:cl)
		{
			if(pid==c.getPid())
				cr=c;
			sum=sum+(c.getQty()*c.getPrice());
		}
		p.setQty(p.getQty()+cr.getQty());
		psi.updateProduct(p);
		mv.addObject("clist", cl);
		mv.addObject("total", sum);
		return mv;
	}
	
	@RequestMapping(value="updatecart",method=RequestMethod.GET)
	public ModelAndView UpdateQty(@RequestParam("qty")int qty,@RequestParam("id")int id,@RequestParam("name")String name)
	{
		double sum=0;
		Cart cr=new Cart();
		System.out.println("Cart obj method called");
		cdao.updateCart(qty, id);
		ModelAndView mv=new ModelAndView("/Cart/cart");
		mv.addObject("msgu","Item Update in Cart Successfully");
		Users us=new Users();
		Products p=new Products();
	
		List<Users>ul=csi.getAllUsers();
		for(Users u:ul)
			if(u.getUsername().equals(name))
				us=u;
		List<Cart>cl=cdao.cartList(us.getU_id());
		for(Cart c:cl)
		{
			if(id==c.getPid())
				cr=c;
			sum=sum+(c.getQty()*c.getPrice());
		}
		List<Products>pl=psi.getAllProducts();
		for(Products pr:pl)
		{
			if(pr.getPid()==id)
			{
				p=pr;
//				p.setQty(p.getQty()-(cr.getQty()-qty));
//				psi.updateProduct(p);
			}
			
		}
		
		mv.addObject("clist", cl);
		mv.addObject("total", sum);
		return mv;
		
	}
}
