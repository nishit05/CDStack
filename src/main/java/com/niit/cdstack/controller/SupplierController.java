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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.cdstack.model.Supplier;
import com.niit.cdstack.service.SupplierServiceImpl;

@Controller
public class SupplierController {

	@Autowired
	private SupplierServiceImpl service;

	@RequestMapping(value = "supplierform", method = RequestMethod.GET)
	public String SupplierForm(Map<String, Object> model) {
		Supplier sp = new Supplier();
		model.put("supplier", sp);
		return "supplierform";
	}

	@RequestMapping(value = "addsupplier", method = RequestMethod.POST)
	public String SupplierValidation(@ModelAttribute("supplier") Supplier sp, BindingResult result, Model m,RedirectAttributes rea) {
		if (result.hasErrors()) {
			return "supplierform";
		}

		else if (sp.getSname().isEmpty()) {
			m.addAttribute("msge", "Enter a Valid Name");
			return "supplierform";	
		} 
		
		else if(sp.getHaddress().isEmpty())
		{
			m.addAttribute("msge", "Enter a Valid Address");
			return "supplierform";	
		}
		
		else if(sp.getContact().isEmpty() || sp.getContact().length()!=10)
		{
			m.addAttribute("msge", "Enter a Valid Contact No.");
			return "supplierform";	
		}
		
		else {

			service.addSupplier(sp);
			rea.addFlashAttribute("msgc", "Supplier added sucessfully!!!!");
			return "redirect:supplierform";
		}
	}

	@RequestMapping(value = "supplier", method = RequestMethod.GET)
	public String SupplierList(Model m) {
		List<Supplier> list = service.getAllSupplier();
		m.addAttribute("supplier", list);
		return "supplier";
	}

	@RequestMapping(value = "deletesupplier_id={id}", method = RequestMethod.GET)
	public String DeleteSupplier(@PathVariable("id") int id,RedirectAttributes rea) {
		service.deleteSupplier(id);
		rea.addFlashAttribute("msgd", "Supplier Deleted Sucessfully");
		return "redirect:supplier";

	}

	@RequestMapping(value = "viewsupplier_id={id}", method = RequestMethod.GET)
	public String SupplierView(@PathVariable("id") int id, Model m) {
		Supplier sp = service.getSupplierById(id);
		m.addAttribute("spdet", sp);
		return "supplierview";
	}

	@RequestMapping(value = "editsupplier_id={id}", method = RequestMethod.GET)
	public ModelAndView EditSupplierForm(@PathVariable("id") int id) {
		Supplier p = service.getSupplierById(id);
		return new ModelAndView("editsupplier", "supplier", p);
	}

	@RequestMapping(value = "updatesupplier", method = RequestMethod.POST)
	public String UpdateSupplier(@ModelAttribute("supplier") Supplier sp, BindingResult result, Model m,RedirectAttributes rea) {
		if (result.hasErrors()) {
			return "editsupplier";
		}

		else if (sp.getSname().isEmpty()) {
			m.addAttribute("msge", "Enter a Valid Name");
			return "editsupplier";	
		} 
		
		else if(sp.getHaddress().isEmpty())
		{
			m.addAttribute("msge", "Enter a Valid Address");
			return "editsupplier";	
		}
		
		else if(sp.getContact().isEmpty() || sp.getContact().length()!=10)
		{
			m.addAttribute("msge", "Enter a Valid Contact Number");
			return "editsupplier";	
		}

		else {
			service.updateSupplier(sp);
			rea.addFlashAttribute("msgu", "Supplier Details Upadated Sucessfully");
			return "redirect:supplier";
		}
	}
}
