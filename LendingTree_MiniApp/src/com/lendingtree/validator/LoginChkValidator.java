package com.lendingtree.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lendingtree.bean.LoginChkBean;


public class LoginChkValidator implements Validator{

	 @Override
	 public boolean supports(Class<?> loginchk) {
		// TODO Auto-generated method stub
		return LoginChkBean.class.isAssignableFrom(loginchk);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		LoginChkBean bean=(LoginChkBean)target;
		String un=bean.getUsername();
		String pwd=bean.getPassword();
		

        if(un==null||un.trim().equals(""))
    	{
        	System.out.println("username is empty");
        	 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.username", "User name is required.");
        }
     
  
        if(pwd==null||pwd.trim().equals(""))
    	{
        	System.out.println("Password is empty");
    		errors.rejectValue("password", "password","Password is required");

    	}
	}

}
