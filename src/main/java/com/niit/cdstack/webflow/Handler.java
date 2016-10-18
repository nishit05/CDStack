package com.niit.cdstack.webflow;

import org.springframework.stereotype.Component;

import com.niit.cdstack.model.Supplier;

@Component
public class Handler {

	public Supplier init()
	{
		return new Supplier();
	}
}
