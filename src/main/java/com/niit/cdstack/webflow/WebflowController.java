package com.niit.cdstack.webflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.cdstack.dao.CartDAO;
import com.niit.cdstack.model.ShippingAddress;

@Component
public class WebflowController {
	
	@Autowired
	CartDAO cdao;
	public void addShippingAddress(ShippingAddress sa)
	{
		
		cdao.addShippingAddress(sa);
	}
	
}
