package com.niit.cdstack.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.cdstack.model.Products;
import com.niit.cdstack.service.ProductServiceImpl;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl service;
	
	@RequestMapping(value = "productform", method = RequestMethod.GET)
	public String ProductForm(Map<String, Object> model) {
		Products p = new Products();
		model.put("products", p);
		return "productform";
	}

	@RequestMapping(value = "addproducts", method = RequestMethod.POST)
	public String ProductValidation( @ModelAttribute("products") Products p, BindingResult result, Model m) {
		if (result.hasErrors()) {
			return "productform";
		}

		else if (p.getPrice() == 0.0f) {
			m.addAttribute("msg", "Price cannot be 0");
			return "productform";
		}

		else if (p.getQty() == 0) {
			m.addAttribute("msg", "Quantity cannot be 0");
			return "productform";
		}

		else if (p.getPtype().equals("Select Option")) {
			m.addAttribute("msg", "Enter a Valid Category");
			return "productform";
		}

		else {
			
			service.addProduct(p);
			return "addproductsucess";
		}
	}

}
