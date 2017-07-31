package com.lendingtree.validator;

import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lendingtree.bean.BankBean;
import com.lendingtree.bean.LoanBean;

public class LoanValidator implements Validator {

	@Override
	public boolean supports(Class<?> loan) {
		// TODO Auto-generated method stub
		return BankBean.class.isAssignableFrom(loan);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		LoanBean loan=(LoanBean)target;
		String bname=loan.getBname();
		String loantype=loan.getLoantype();
		String interest=loan.getInterest();
		
	// Validations for bname
		
		if(bname==null||bname=="" ||bname.matches("[\\s]+"))
		{
			
			errors.rejectValue("bname", "bname","Bank Name is required");

		}
	// Validations for loan type
		
		if(loantype==null||loantype=="" ||loantype.matches("[\\s]+"))
		{
			
			errors.rejectValue("loantype", "loantype"," Loan type is required");

		}
		else{
			
	
		loantype=loantype.trim();
		loantype=loantype.replaceAll("\\s+", " ");
		loantype = loantype.replace(" ", " ");
		loantype=WordUtils.capitalizeFully(loantype);
		loan.setLoantype(loantype);
		
		if(loantype.length()<2||loantype.length()>30)
		{
			errors.rejectValue("loantype", "loantype","Loan type length is minimum 2 and maximum 30");
		}
		else if(!loantype.matches("^[A-Z a-z]+$"))
		{
			errors.rejectValue("loantype", "loantype","Loan type accepts alphabets only");
		}
		
	}
	
	// Validations for Interest
		
		if(interest==null||interest=="" ||interest.matches("[\\s]+"))
		{
			
			errors.rejectValue("interest", "interest","Interest  is required");

		}
		else{
			
	
		interest=interest.trim();
		//interest=interest.replaceAll("\\s+", " ");
		interest = interest.replace(" ", "");
		interest=WordUtils.capitalizeFully(interest);
		loan.setInterest(interest);
		// valid = (value.match(/^-?\d*(\.\d+)?$/));
		if(interest.length()<1||interest.length()>10)
		{
			errors.rejectValue("interest", "interest","Interest length is minimum 1 and maximum 10");
		}
		else if(!interest.matches("^[-+]?[0-9]*\\.?[0-9]+$"))
		{
			errors.rejectValue("interest", "interest","Interest accepts numbers only");
		}
		else if(interest.substring(0,1).matches("^[-]+$"))
		{
			errors.rejectValue("interest", "interest","Interest can't accepts (-)ve numbers ");
		}
	}
	
		
		
	}

}
