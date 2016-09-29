package com.niit.cdstack.validations;

public class FormValidator {
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
