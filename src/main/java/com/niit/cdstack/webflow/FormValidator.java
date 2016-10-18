package com.niit.cdstack.webflow;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.cdstack.model.Order;

@Component
public class FormValidator {
	String msg=new String();
	
	public String Validator(Order o,MessageContext ms)
	{
		if(!IsName(o.getName()) && o.getName().isEmpty())
		{
			ms.addMessage(new MessageBuilder().error().source("name").defaultText("Name should be Filled").build());
		msg="failure";
		return msg;
		}
		else
		{
			msg="sucess";
			return msg;
		}
		
		
	}
	public boolean IsName(String k)
	{
		int flag=0;
		char p[]=k.toCharArray();
		for(char t:p)
			if(Character.isDigit(t) || !Character.isLetter(t))
				flag++;
		
		if(flag!=0)
			return true;
		
		else
		return false;
		
	}
	
	public boolean IsValidPassword(String l)
	{
		int len=l.length();
		if(len<6 || len>10)
			return true;
		else
		return false; 
	}
}
