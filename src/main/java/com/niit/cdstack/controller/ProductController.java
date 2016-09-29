package com.niit.cdstack.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.cdstack.model.Category;
import com.niit.cdstack.model.Products;
import com.niit.cdstack.service.CategoryServiceImpl;
import com.niit.cdstack.service.ProductServiceImpl;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl service;
	
	@Autowired
	private CategoryServiceImpl csi;

	@RequestMapping(value = "productform", method = RequestMethod.GET)
	public String ProductForm(Map<String,Object>model) {
		Products p = new Products();
		model.put("products", p);
		List <Category>li=csi.getAllCategory();
		model.put("catlist", li);
		return "productform";
	}

	@RequestMapping(value = "addproducts", method = RequestMethod.POST)
	public String ProductValidation(@Valid @ModelAttribute("products") Products p, BindingResult result, Model m,RedirectAttributes rea) {
		if (result.hasErrors()) {
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

		else {

			service.addProduct(p);
			rea.addFlashAttribute("msg","Product Added Successfully");
			return "redirect:productform";
		}
	}

	@RequestMapping(value = "data", method = RequestMethod.GET)
	public @ResponseBody List<Products> list() {
		System.out.println("Inside Angular Controller");
		return service.getAllProducts();
	}

	@RequestMapping(value = "products", method = RequestMethod.GET)
	public ModelAndView ProductList() {
		List<Products> list = service.getAllProducts();
		ModelAndView mv = new ModelAndView("products");
		mv.addObject("product", list);
		return mv;
	}

	@RequestMapping(value = "deleteproduct-id={id}", method = RequestMethod.GET)
	public String DeleteProduct(@PathVariable("id") int id,RedirectAttributes rea) {
		service.deleteProduct(id);
		rea.addFlashAttribute("msgd", "Product Deleted Sucessfully");
		return "redirect:products";

	}

	@RequestMapping(value = "productview-id={id}", method = RequestMethod.GET)
	public ModelAndView ProductView(@PathVariable("id") int id) {
		Products p=service.getProductById(id);
		ModelAndView mv=new ModelAndView("productview");
		mv.addObject("prdet", p);
		//m.addAttribute("prdet", p);
		System.out.println("Inside Product View Method");
		return mv;
	}

	@RequestMapping(value = "editproduct-id={id}", method = RequestMethod.GET)
	public ModelAndView EditProductForm(@PathVariable("id") int id) {
		Products p = service.getProductById(id);
		ModelAndView mv=new ModelAndView("editproduct");
		mv.addObject("products", p);
		List<Category> li=csi.getAllCategory();
		mv.addObject("catlist", li);
		return mv;
	}

	@RequestMapping(value = "updateproduct", method = RequestMethod.POST)
	public String UpdateProduct(@ModelAttribute("products") Products p, BindingResult result, Model m,RedirectAttributes rea) {
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
		
		else if (p.getCategory().equals("Select Option")) {
			m.addAttribute("msge", "Enter a Valid Category");
			return "productform";
		}

		else {
			service.updateProduct(p);
			rea.addFlashAttribute("msgu", "Product Details Updated Successfully");
			return "redirect:products";
		}
	}
}
