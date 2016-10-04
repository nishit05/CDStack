package com.niit.cdstack.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.cdstack.model.Query;
import com.niit.cdstack.service.QueryServiceImpl;

@Controller
public class PageController {

	@Autowired
	private QueryServiceImpl qsi;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String HomePg() {
		return "home";
	}

	@RequestMapping(value = "aboutus", method = RequestMethod.GET)
	public String AboutUs() {
		return "aboutus";
	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public ModelAndView ContactUs() {
		ModelAndView mv=new ModelAndView("contact");
		Query q=new Query();
		mv.addObject(q);
		return mv;
	}

	@RequestMapping(value="addquery",method=RequestMethod.POST)
	public String addQuery(@Valid @ModelAttribute("query")Query q,BindingResult result,RedirectAttributes rea,Model m)
	{
		if(result.hasErrors())
			return "contact";
		else
		{
			qsi.addQuery(q);
			rea.addFlashAttribute("msgs", "Query Submitted Successfully");
			return "redirect:contact";
		}
		
	}
}
