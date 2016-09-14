package com.niit.cdstack.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	public String ProductValidation(@ModelAttribute("products") Products p, BindingResult result, Model m) {
		if (result.hasErrors()) {
			return "productform";
		}
		
		else if (p.getPname().isEmpty()) {
			m.addAttribute("msge", "Enter a Valid Name");
			return "productform";
		}
		
		else if (p.getPrice() == 0.0f) {
			m.addAttribute("msge", "Price cannot be 0");
			return "productform";
		}

		else if (p.getQty() == 0) {
			m.addAttribute("msge", "Quantity cannot be 0");
			return "productform";
		}

		else if (p.getPtype().equals("Select Option")) {
			m.addAttribute("msge", "Enter a Valid CD type");
			return "productform";
		}
		
		else if (p.getCategory().equals("Select Option")) {
			m.addAttribute("msge", "Enter a Valid Category");
			return "productform";
		}
		
		else if (p.getContent().isEmpty()) {
			m.addAttribute("msge", "Enter a Valid Description");
			return "productform";
		}

		else {
			
			service.addProduct(p);
			m.addAttribute("msgc", "Product added sucessfully!!!!");
			return "productform";
		}
	}
	
	@RequestMapping(value="products",method=RequestMethod.GET)
	public String ProductList(Model m)
	{
		List<Products>list=service.getAllProducts();
		m.addAttribute("product", list);
		return "products";
	}
	
	@RequestMapping(value="deleteproduct_id={id}",method=RequestMethod.GET)
	public String DeleteProduct(@PathVariable("id")int id)
	{
		service.deleteProduct(id);
		return "redirect:products";
		
	}
	
	@RequestMapping(value="viewproduct_id={id}",method=RequestMethod.GET)
	public String ProductView(@PathVariable("id")int id,Model m)
	{
		Products p=service.getProductById(id);
		m.addAttribute("prdet", p);
		return "productview";
	}
	
	@RequestMapping(value = "editproduct_id={id}", method = RequestMethod.GET)
	public ModelAndView EditProductForm(@PathVariable("id")int id) {
		Products p=service.getProductById(id);
		return new ModelAndView("editproduct", "products",p);
	}
	
	@RequestMapping(value="updateproduct",method=RequestMethod.POST)
	public String UpdateProduct(@ModelAttribute("products") Products p, BindingResult result,Model m)
	{
		if (result.hasErrors()) {
			return "editproduct";
		}

		else if (p.getPrice() == 0.0f) {
			m.addAttribute("msg", "Price cannot be 0");
			return "editproduct";
		}

		else if (p.getQty() == 0) {
			m.addAttribute("msg", "Quantity cannot be 0");
			return "editproduct";
		}

		else if (p.getPtype().equals("Select Option")) {
			m.addAttribute("msg", "Enter a Valid Category");
			return "editproduct";
		}

		else {
			
			service.updateProduct(p);
			return "redirect:products";
		}
	}
}
