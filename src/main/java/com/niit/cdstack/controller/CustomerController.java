package com.niit.cdstack.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.cdstack.model.Users;
import com.niit.cdstack.service.CustomerServiceImpl;
import com.niit.cdstack.validations.FormValidator;

@Controller
public class CustomerController {

	FormValidator fv = new FormValidator();

	@Autowired
	private CustomerServiceImpl service;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String Register(Map<String, Object> model) {
		Users u = new Users();
		model.put("users", u);
		return "register";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.POST)
	public String ProductValidation(@Valid @ModelAttribute("users") Users u, BindingResult result, Model m,
			RedirectAttributes rea) {
		if (result.hasErrors()) {
			return "register";
		} else if (fv.IsName(u.getName())) {
			m.addAttribute("msge", "Name should contain only Letters");
			return "register";
		}
		else if(fv.IsValidPassword(u.getPassword()))
		{
			m.addAttribute("msge", "Password should be 6-10 characters long");
			return "register";
		}
		else if (!u.getCpass().equals(u.getPassword())) {
			m.addAttribute("msge", "Passwords do not match");
			return "register";
		} else {
			service.addUsers(u);
			rea.addFlashAttribute("msgs", "Customer Added Successfully");
			return "redirect:register";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailure", method = RequestMethod.GET)
	public ModelAndView LoginFail() {
		return new ModelAndView("login", "error", true);
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	 public String logout(HttpServletRequest request,HttpServletResponse response,RedirectAttributes rea) {
		 System.out.println("In The Log out method");
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if (auth != null) {
		 new SecurityContextLogoutHandler().logout(request, response, auth);
		 }
	 
		 rea.addFlashAttribute("logoutmsg", "Logged Out Successfully");
		 return "redirect:login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView Welcome(Model m) {
		ModelAndView mv=new ModelAndView("home");
		Authentication a=SecurityContextHolder.getContext().getAuthentication();
		String name=a.getName();
		mv.addObject("msg", "Welcome "+name);
		return mv;
	}
}
