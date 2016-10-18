package com.niit.cdstack.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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

import com.niit.cdstack.model.Supplier;
import com.niit.cdstack.service.SupplierServiceImpl;

@Controller
public class SupplierController {

	@Autowired
	private SupplierServiceImpl service;

	@RequestMapping(value = "/supplierform", method = RequestMethod.GET)
	public String SupplierForm(Map<String, Object> model) {
		Supplier sp = new Supplier();
		model.put("supplier", sp);
		return "supplierform";
	}

	@RequestMapping(value = "/addsupplier", method = RequestMethod.POST)
	public String SupplierValidation(@Valid @ModelAttribute("supplier") Supplier sp, BindingResult result, Model m,
			RedirectAttributes rea) {
		int ct = 0, gt = 0;
		List<Supplier> sl = service.getAllSupplier();
		for (Supplier s : sl) {
			if (s.getSname().equalsIgnoreCase(sp.getSname()))
				ct++;
		}
		char ch[] = sp.getContact().toCharArray();
		for (char l : ch) {
			if (!Character.isDigit(l))
				gt++;
		}
		if (result.hasErrors()) {
			return "supplierform";
		}
		
		else if (ct != 0) {
			m.addAttribute("msge", "Supplier Already Exists");
			return "supplierform";
		}

		else {
			if (!sp.getFile().isEmpty()) {
				service.addSupplier(sp);
				File d = new File("D:/Drive/src/main/webapp/resources/multipart/");
				if (!d.exists())
					d.mkdirs();
				File f = new File(d, sp.getSname() + ".jpg");
				try {
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
					bos.write(sp.getFile().getBytes());
					bos.close();
					System.out.println("Upload Sucessful");
				} catch (FileNotFoundException fne) {
					// TODO Auto-generated catch block
					System.out.println("Upload Unsucessful because " + fne.getMessage());
				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					System.out.println("Upload Unsucessful because " + ioe.getMessage());
				}
			} else {
				m.addAttribute("msge", "Please Upload an Image");
				return "supplierform";
			}
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

	@RequestMapping(value = "deletesupplier", method = RequestMethod.GET)
	public String DeleteSupplier(@RequestParam("id") int id, RedirectAttributes rea) {
		service.deleteSupplier(id);
		rea.addFlashAttribute("msgd", "Supplier Deleted Sucessfully");
		return "redirect:supplier";

	}

	@RequestMapping(value = "viewsupplier", method = RequestMethod.GET)
	public String SupplierView(@RequestParam("id") int id, Model m) {
		Supplier sp = service.getSupplierById(id);
		m.addAttribute("spdet", sp);
		return "supplierview";
	}

	@RequestMapping(value = "editsupplier", method = RequestMethod.GET)
	public ModelAndView EditSupplierForm(@RequestParam("id") int id) {
		Supplier p = service.getSupplierById(id);
		return new ModelAndView("editsupplier", "supplier", p);
	}

	@RequestMapping(value = "updatesupplier", method = RequestMethod.POST)
	public String UpdateSupplier(@ModelAttribute("supplier") Supplier sp, BindingResult result, Model m,
			RedirectAttributes rea) {
		int ct = 0, gt = 0;
		List<Supplier> sl = service.getAllSupplier();
		for (Supplier s : sl) {
			if (s.getSname().equalsIgnoreCase(sp.getSname()))
				ct++;
		}
		char ch[] = sp.getContact().toCharArray();
		for (char l : ch) {
			if (!Character.isDigit(l))
				gt++;
		}
		if (result.hasErrors()) {
			return "supplierform";
		}
		
		else if (ct != 0) {
			m.addAttribute("msge", "Supplier Already Exists");
			return "supplierform";
		}

		else {
			if (!sp.getFile().isEmpty()) {
				service.updateSupplier(sp);
				File d = new File("D:/Drive/src/main/webapp/resources/multipart/");
				if (!d.exists())
					d.mkdirs();
				File f = new File(d, sp.getSname() + ".jpg");
				try {
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
					bos.write(sp.getFile().getBytes());
					bos.close();
					System.out.println("Upload Sucessful");
				} catch (FileNotFoundException fne) {
					// TODO Auto-generated catch block
					System.out.println("Upload Unsucessful because " + fne.getMessage());
				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					System.out.println("Upload Unsucessful because " + ioe.getMessage());
				}
			} else {
				m.addAttribute("msge", "Please Upload an Image");
				return "editsupplier";
			}

			rea.addFlashAttribute("msgu", "Supplier Details Upadated Sucessfully");
			return "redirect:supplier";
		}
	}
}
