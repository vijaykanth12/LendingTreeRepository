package com.lendingtree.validator;

import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lendingtree.bean.MessageBean;



public class MessageValidator implements Validator {

	@Override
	public boolean supports(Class<?> aa) {
		// TODO Auto-generated method stub
		 return MessageBean.class.isAssignableFrom(aa);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MessageBean msg=(MessageBean)target;
	Integer rid=msg.getRegid();
	String msgs=msg.getSubjectu();
	String sub=	msg.getSubjectu();
	
	
	
	msg.setRegid(rid);
	if(rid==null)
	{
		
		errors.rejectValue("regid", "regid","Reg Id  is required");

	}
	msg.setMessageu(msgs.trim());
	if(msgs==null||msgs=="" ||msgs.matches("[\\s]+"))
	{
		
		errors.rejectValue("messageu", "messageu","Message  is required");

	}
	msg.setSubjectu(sub.trim());
	if(sub==null||sub=="" ||sub.matches("[\\s]+"))
	{
		
		errors.rejectValue("subjectu", "subjectu","Subject is required");

	}
	
	
	}

}
