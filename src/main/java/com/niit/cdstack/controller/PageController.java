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
	
	@RequestMapping(value="${pageContext.request.contextPath}/addquery",method=RequestMethod.POST)
	public String addQuery(@Valid @ModelAttribute("query")Query q,BindingResult result,Model m)
	{
		if(result.hasErrors())
			return "contact";
		else
		{
			qsi.addQuery(q);
			m.addAttribute("msgs", "Query Submitted Successfully");
			return "redirect:contact";
		}
		
	}
	
	@RequestMapping(value="viewquery",method=RequestMethod.GET)
	public String viewQuery(Model mv)
	{
		List<Query>ql=qsi.viewQuries();
		mv.addAttribute("qlist", ql);
		return "query";
	}
	
	@RequestMapping(value="deletequery",method=RequestMethod.GET)
	public String deleteQuery(@RequestParam("id")String id,Model rea)
	{
		qsi.deleteQuery(id);
		List<Query>ql=qsi.viewQuries();
		rea.addAttribute("msgd", "Query Deleted Successfully");
		rea.addAttribute("qlist", ql);
		return "query";
	}
}
