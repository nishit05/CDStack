package com.niit.cdstack.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.cdstack.model.Users;
import com.niit.cdstack.service.CustomerServiceImpl;

@Controller
public class CustomerController {

	@Autowired
	private HttpSession session;

	@Autowired
	private CustomerServiceImpl service;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String Register(Map<String, Object> model) {
		Users u = new Users();
		model.put("users", u);
		return "register";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.POST)
	public String UserValidation(@Valid @ModelAttribute("users") Users u, BindingResult result, Model m,
			RedirectAttributes rea) {
		int ct=0;
		List<Users>l=service.getAllUsers();
		for(Users ur:l){
			if(ur.getEmail().equalsIgnoreCase(u.getEmail()) || ur.getUsername().equalsIgnoreCase(u.getUsername()))
				ct++;
		}
		if (result.hasErrors()) {
			return "register";
		} else if (!u.getCpass().equals(u.getPassword())) {
			m.addAttribute("msge", "Passwords do not match");
			return "register";
		} 
		else if(ct!=0)
		{
			m.addAttribute("msge", "User Already exists");
			return "register";
		}
		else {
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
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("error", true);
		mv.addObject("access", false);
//		mv.addObject("accessdenied", "To access this please login");
		return mv;
//		return new ModelAndView("login", "error", true);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes rea) {
		System.out.println("In The Log out method");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		session.invalidate();
		rea.addFlashAttribute("logoutmsg", "Logged Out Successfully");
		return "redirect:login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView Welcome(Model m) {
		ModelAndView mv = new ModelAndView("home");
		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		String name = a.getName();
		session.setAttribute("name", name);
		return mv;
	}

	
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public ModelAndView ShowProfile(@RequestParam("name") String name) {
		Users us = new Users();
		ModelAndView mv = new ModelAndView("viewprofile");
		List<Users> li = service.getAllUsers();
		for (Users u : li) {
			if (u.getUsername().equals(name)) {
				us = u;
			}
		}
		mv.addObject("users", us);
		return mv;
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView EditForm(@RequestParam("id") int id) {
		Users u = service.getUserById(id);
		ModelAndView mv = new ModelAndView("edituser", "users", u);
		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String UserUpdate(@Valid @ModelAttribute("users") Users u, BindingResult result, Model m
			) {
		if (result.hasErrors()) {
			return "edituser";
		} else if (!u.getCpass().equals(u.getPassword())) {
			m.addAttribute("msge", "Passwords do not match");
			return "edituser";
		} else {
			service.updateUsers(u);
			session.setAttribute("name", u.getUsername());
			m.addAttribute("msgu", "Customer Details Updated Successfully");
			return "viewprofile";
		}
	}

}
