package com.lendingtree.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lendingtree.bean.LoanBean;

public class InterestValidator implements Validator{

	@Override
	public boolean supports(Class<?> interest) {
		// TODO Auto-generated method stub
		return LoanBean.class.isAssignableFrom(interest);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		LoanBean loan=(LoanBean)target;
		String loantype=loan.getLoantype();
		
		
		if(loantype==null||loantype=="" ||loantype.matches("[\\s]+"))
		{
			
			errors.rejectValue("loantype", "loantype","Loan Type is required");

		}
	
		
		
	}

}
