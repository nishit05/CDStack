package com.niit.cdstack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cdstack.dao.ProductsDAOImpl;

@Controller
public class PageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String HomePg() {
		return "home";
	}

	@RequestMapping(value = "aboutus", method = RequestMethod.GET)
	public String AboutUs() {
		return "aboutus";
	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String ContactUs() {
		return "contact";
	}


}
