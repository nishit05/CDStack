package com.dell.cdstack1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

		@RequestMapping(value = "login", method = RequestMethod.GET)
		public String Login() {
			return "login";
		}

		@RequestMapping(value = "register", method = RequestMethod.GET)
		public String Register() {
			return "register";
		}

}
