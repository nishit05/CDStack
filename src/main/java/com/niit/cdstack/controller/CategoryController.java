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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.cdstack.model.Category;
import com.niit.cdstack.service.CategoryServiceImpl;

@Controller
public class CategoryController {

	@Autowired
	private CategoryServiceImpl service;
	
	@RequestMapping(value = "categoryform", method = RequestMethod.GET)
	public String CategoryForm(Map<String, Object> model) {
		Category c = new Category();
		model.put("category", c);
		return "categoryform";
	}
	
	@RequestMapping(value = "addcategory", method = RequestMethod.POST)
	public String CategoryValidation(@ModelAttribute("category") Category c, BindingResult result, Model m,RedirectAttributes rea) {
		int ct=0;
		List<Category>cl=service.getAllCategory();
		for(Category ca:cl)
		{
			if(ca.getName().equalsIgnoreCase(c.getName()))
				ct++;
		}
		if (result.hasErrors()) {
			return "categoryform";
		}
		
		else if (c.getName().isEmpty()) {
			m.addAttribute("msge", "Enter a Valid Name");
			return "categoryform";
		}
		else if(ct!=0)
		{
			m.addAttribute("msge", "Category Already exists");
			return "categoryform";
		}
		else {
			
			service.addCategory(c);
			rea.addFlashAttribute("msgc","Category Added Successfully");
			return "redirect:categoryform";
		}
	}
	
	@RequestMapping(value="category",method=RequestMethod.GET)
	public String CategoryList(Model m)
	{
		List<Category>list=service.getAllCategory();
		m.addAttribute("category", list);
		return "category";
	}
	
	@RequestMapping(value="deletecategory",method=RequestMethod.GET)
	public String DeleteCategory(@RequestParam("id")int id,RedirectAttributes rea)
	{
		service.deleteCategory(id);
		rea.addFlashAttribute("msgd","Category Deleted Successfully");
		return "redirect:category";
		
	}
	
	@RequestMapping(value = "editcategory", method = RequestMethod.GET)
	public ModelAndView EditCategoryForm(@RequestParam("id")int id) {
		Category c=service.getCategoryById(id);
		return new ModelAndView("editcategory", "category",c);
	}
	
	@RequestMapping(value="updatecategory",method=RequestMethod.POST)
	public String UpdateCategory(@ModelAttribute("Category") Category c, BindingResult result,Model m,RedirectAttributes rea)
	{
		if (result.hasErrors()) {
			return "editcategory";
		}

		else if (c.getName().isEmpty()) {
			m.addAttribute("msge", "Enter a Valid Name");
			return "editcategory";
		}

		else {
			service.updateCategory(c);
			rea.addFlashAttribute("msgu","Category Details Updated Successfully");
			return "redirect:category";
		}
	}
}
