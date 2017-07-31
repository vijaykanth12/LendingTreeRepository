package com.lendingtree.validator;

import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lendingtree.bean.DeptBean;

public class DeptValidator implements Validator{

	@Override
	public boolean supports(Class<?> dd) {
		// TODO Auto-generated method stub
		return DeptBean.class.isAssignableFrom(dd);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("Department validator is running");
		DeptBean dept=(DeptBean)target;
		
		String de=dept.getDname();
		
		if(de==null||de=="" ||de.matches("[\\s]+"))
		{
			
			errors.rejectValue("dname", "dname"," Department name  iss required");

		}
		else{
			
	
		de=de.trim();
		//de=de.replaceAll("\\s+", " ");
		de = de.replace(" ", "");
		de=WordUtils.capitalizeFully(de);
		dept.setDname(de);
		
		if(de.length()<2||de.length()>30)
		{
			errors.rejectValue("dname", "dname","Department length is minimum 2 and maximum 30");
			}
		else if(!de.matches("^[A-Z a-z]+$"))
		{
			errors.rejectValue("dname", "dname","Department accepts alphabets only");
		}
		
	}
		
		
		
	}

}
