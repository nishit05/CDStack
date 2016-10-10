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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cdstack.dao.CartDAO;
import com.niit.cdstack.dao.CustomerDAO;
import com.niit.cdstack.model.Cart;
import com.niit.cdstack.model.Products;
import com.niit.cdstack.model.Users;
import com.niit.cdstack.service.CustomerServiceImpl;

@Controller
public class CartController {
	
	@Autowired
	private CartDAO cdao;
	
	@Autowired
	private CustomerServiceImpl csi;
	
	@RequestMapping(value="addtocart", method=RequestMethod.GET)
	public ModelAndView addToCart(@Valid @ModelAttribute("cart")Cart c,@RequestParam("id")int id,@RequestParam("name")String name,BindingResult result)
	{
		Users us=new Users();
		c.setPid(id);
		c.setQty(1);
		List<Users>ul=csi.getAllUsers();
		for(Users u:ul)
			if(u.getUsername().equals(name))
				us=u;
		c.setU_id(us.getU_id());
		ModelAndView mv=new ModelAndView("/Cart/cart");
		cdao.addToCart(c);
		List<Cart>cl=cdao.cartList(c.getU_id());
		mv.addObject("clist", cl);
		mv.addObject("ct_id", c.getCt_id());
		return mv;
	}
	
	

	@RequestMapping(value="viewcart",method=RequestMethod.GET)
	public ModelAndView Cart(@RequestParam("name")String name)
	{
		Users us=new Users();
		List<Users>ul=csi.getAllUsers();
		for(Users u:ul)
			if(u.getUsername().equals(name))
				us=u;
		List<Cart>cl=cdao.cartList(us.getU_id());
		ModelAndView mv=new ModelAndView("/Cart/cart");
		mv.addObject("clist", cl);
		return mv;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public ModelAndView DeleteItem(@RequestParam("id")String id,Model rea,@RequestParam("name")String name)
	{
		cdao.deleteFromCart(id);
		rea.addAttribute("msgd","Item deleted from Cart Successfully");
		ModelAndView mv=new ModelAndView("/Cart/cart");
		Users us=new Users();
		List<Users>ul=csi.getAllUsers();
		for(Users u:ul)
			if(u.getUsername().equals(name))
				us=u;
		List<Cart>cl=cdao.cartList(us.getU_id());
		mv.addObject("clist", cl);
		return mv;
	}
	
//	@RequestMapping(value="updateqty",method=RequestMethod.GET)
//	public ModelAndView UpdateQty(@RequestParam("id")String id)
//	{
//		cdao.updateQty(id);
//		ModelAndView mv=new ModelAndView("/Cart/cart");
//		mv.addObject("msgu","Item Update in Cart Successfully");
//		return mv;
//	}
}
