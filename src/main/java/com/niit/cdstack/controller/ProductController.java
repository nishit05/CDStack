package com.niit.cdstack.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/productform", method = RequestMethod.GET)
	public ModelAndView ProductForm() {
		ModelAndView mv = new ModelAndView("productform");
		Products p = new Products();
		mv.addObject(p);
		return mv;
	}

	@RequestMapping(value = "/addproducts", method = RequestMethod.POST)
	public String ProductValidation(@Valid @ModelAttribute("products") Products p, BindingResult result, Model m,
			RedirectAttributes rea, HttpServletRequest req) {
		int ct=0;
		List<Products>pl=service.getAllProducts();
		for (Products pr:pl)
		{
			if(p.getPname().equals(pr.getPname()) && p.getPtype().equals(pr.getPtype()))
				ct++;
		}
		if (result.hasErrors()) {
			return "productform";
		}

		else if(ct!=0)
		{
			m.addAttribute("msge", "Product already exists");
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
			
			if(!p.getFile().isEmpty())
			{
				service.addProduct(p);
			File d=new File("D:/Drive/src/main/webapp/resources/multipart/");
			if(!d.exists())
				d.mkdirs();
			File f=new File(d,p.getPname()+".jpg");
			try {
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(f));
				bos.write(p.getFile().getBytes());
				bos.close();
				System.out.println("Upload Sucessful");
			} catch (FileNotFoundException fne) {
				// TODO Auto-generated catch block
				System.out.println("Upload Unsucessful because "+fne.getMessage());
			} catch (IOException ioe) {
				// TODO Auto-generated catch block
				System.out.println("Upload Unsucessful because "+ioe.getMessage());
			}
			}
			else
			{
				m.addAttribute("msge","Please Upload an Image");
				return "productform";
			}
			//			File f=new File(req.getServletContext().getRealPath("/resources/images/")+p.getPid()+".jpg");
//			if(!p.getFile().isEmpty())
//			{
//				try {
//					FileUtils.writeByteArrayToFile(f, p.getFile().getBytes());
//					System.out.println("Image Uploaded");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			
			rea.addFlashAttribute("msg", "Product Added Successfully");
			return "redirect:productform";
			}
	}

	@RequestMapping(value = "data", method = RequestMethod.GET)
	public @ResponseBody List<Products> list() {
		System.out.println("Inside Angular Controller");
		return service.getAllProducts();
	}

	@RequestMapping(value = "cdata", method = RequestMethod.GET)
	public @ResponseBody List<Category> clist() {
		System.out.println("Inside Angular Controller");
		return csi.getAllCategory();
	}

	@RequestMapping(value = "products", method = RequestMethod.GET)
	public ModelAndView ProductList() {
		List<Products> list = service.getAllProducts();
		ModelAndView mv = new ModelAndView("products");
		mv.addObject("product", list);
		return mv;
	}

	@RequestMapping(value = "deleteproduct", method = RequestMethod.GET)
	public String DeleteProduct(@RequestParam("id") int id, RedirectAttributes rea) {
		service.deleteProduct(id);
		rea.addFlashAttribute("msgd", "Product Deleted Sucessfully");
		return "redirect:products";

	}

	@RequestMapping(value = "productview", method = RequestMethod.GET)
	public ModelAndView ProductView(@RequestParam("id") int id) {
		Products p = service.getProductById(id);
		ModelAndView mv = new ModelAndView("productview");
		mv.addObject("prdet", p);
		System.out.println("Inside Product View Method");
		return mv;
	}

	@RequestMapping(value = "editproduct", method = RequestMethod.GET)
	public ModelAndView EditProductForm(@RequestParam("id") int id) {
		Products p = service.getProductById(id);
		ModelAndView mv = new ModelAndView("editproduct");
		mv.addObject("products", p);
		return mv;
	}

	@RequestMapping(value = "updateproduct", method = RequestMethod.POST)
	public String UpdateProduct(@ModelAttribute("products") Products p, BindingResult result, Model m,
			RedirectAttributes rea) {
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
			m.addAttribute("msg", "Enter a Valid Category");
			return "editproduct";
		}

		else {
			if(!p.getFile().isEmpty())
			{
			service.updateProduct(p);
			File d=new File("D:/Drive/src/main/webapp/resources/multipart/");
			if(!d.exists())
				d.mkdirs();
			File f=new File(d,p.getPname()+".jpg");
			try {
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(f));
				bos.write(p.getFile().getBytes());
				bos.close();
				System.out.println("Upload Sucessful");
			} catch (FileNotFoundException fne) {
				// TODO Auto-generated catch block
				System.out.println("Upload Unsucessful because "+fne.getMessage());
			} catch (IOException ioe) {
				// TODO Auto-generated catch block
				System.out.println("Upload Unsucessful because "+ioe.getMessage());
			}
			}
			else
			{
				m.addAttribute("msge","Please Upload an Image");
				return "editproduct";
			}
			rea.addFlashAttribute("msgu", "Product Details Updated Successfully");
			return "redirect:products";
		}
	}
}
