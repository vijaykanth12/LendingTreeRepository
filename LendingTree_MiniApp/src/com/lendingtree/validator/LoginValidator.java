package com.lendingtree.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lendingtree.bean.LoginBean;
import com.lendingtree.bean.RegistrationBean;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> aa) {
		// TODO Auto-generated method stub
		return RegistrationBean.class.isAssignableFrom(aa);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		RegistrationBean bean=(RegistrationBean)target;
		
		String username=bean.getUsername();
		String password=bean.getPassword();
		
		if(username==null||username=="" ||username.matches("[\\s]+"))
		{
		
			errors.rejectValue("username", "username","User name is required");
			System.out.println("User Name is emptyyyyyyy");

		}
		if(password==null||password=="" ||password.matches("[\\s]+"))
		{
		
			errors.rejectValue("password", "password","Password is required");

		}
		
	}

}
