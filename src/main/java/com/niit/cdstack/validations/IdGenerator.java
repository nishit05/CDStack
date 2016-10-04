package com.niit.cdstack.validations;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.cdstack.model.Category;
import com.niit.cdstack.model.Products;
import com.niit.cdstack.service.CategoryServiceImpl;

public class IdGenerator {

	
	@Autowired
	private CategoryServiceImpl csi;
	
	@Autowired
	private Products p;
	
	public void IdGenerate()
	{
		 Category cat=csi.getCategoryById(1);
		String id=new String();
		if(cat.getName().equalsIgnoreCase("Bollywood"))
			id="BW-101";
	}
	
}
