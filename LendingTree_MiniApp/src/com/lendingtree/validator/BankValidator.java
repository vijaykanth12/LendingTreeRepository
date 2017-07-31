package com.lendingtree.validator;

import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lendingtree.bean.BankBean;

public class BankValidator implements Validator {

	@Override
	public boolean supports(Class<?> bb) {
		// TODO Auto-generated method stub
		return BankBean.class.isAssignableFrom(bb);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		BankBean bank=(BankBean)target;
		String bname=bank.getBname();
		String branch=bank.getBranch();
		String address=bank.getAddress();
		
	bname=WordUtils.capitalizeFully(bname);
		
		if(bname==null||bname=="" ||bname.matches("[\\s]+"))
		{
		
			errors.rejectValue("bname", "bname","Bank Name is required");

		}
		else{
			
	
		bname=bname.trim();
		
		bname=bname.replaceAll("\\s+", " ");
		
		bname=WordUtils.capitalizeFully(bname);
		bank.setBname(bname);
		
		if(bname.length()<2||bname.length()>30)
		{
			errors.rejectValue("bname", "bname","Bank Name length is minimum 2 and maximum 30");
			}
		else if(!bname.matches("^[A-Z a-z]+$"))
		{
			errors.rejectValue("bname", "bname","Bank Name accepts alphabets only");
		}
		
		}
	
//Branch validations
		
branch=WordUtils.capitalizeFully(branch);
		
		if(branch==null||branch=="" ||branch.matches("[\\s]+"))
		{
		
			errors.rejectValue("branch", "branch","Branch Name is required");

		}
		else{
			
	
		branch=branch.trim();
		
		branch = branch.replace(" ", "");
		branch=WordUtils.capitalizeFully(branch);
		bank.setBranch(branch);
		
		if(branch.length()<2||branch.length()>30)
		{
			errors.rejectValue("branch", "branch","Branch Name length is minimum 2 and maximum 30");
			}
		else if(!branch.matches("^[A-Z a-z]+$"))
		{
			errors.rejectValue("branch", "branch","Branch Name accepts alphabets only");
		}
		else if(branch.matches(bname))
		{
			errors.rejectValue("branch", "branch","Branch Name and Bank Name can't be same");
		}
		
		
		}
	
		// Address Validations
		if(address==null||address.trim().equals(""))
    	{
    		errors.rejectValue("address", "address","Address is required");

    	}else
    	{
    		address=address.trim();
			address=address.replaceAll("\\s+", " ");
			//city = city.replace(" ", "");
			//city=WordUtils.capitalizeFully(city);
			bank.setAddress(address);
    	
    	 
    		  if(address.length()<10||address.length()>100)
    		  {
    			  errors.rejectValue("address", "address","Address length is  minimum 10 and maximum 100.");
    		  }
    		  else if (!address.matches("^[a-zA-Z ]+[a-z A-Z0-9 :.#,/_-]+$")) {
    				errors.rejectValue("address", "address","Address should starts with alphabets and followed by alphabats,numbers,spacial charecters(:.,#/_-)");
    		  }
    		
    		  try{
					for(int i=0; i<address.length()-1; i++)
			        {
			         char   ch1=address.charAt(i);
			         char   ch2=address.charAt(i+1);
					
			         String ch = Character.toString(ch1);
			      
			         String chs = Character.toString(ch2); 
			       
					if(ch.matches("^[,.#/:-]+$")&&chs.matches("^[.,#/:-]+$"))
					{
						errors.rejectValue("address", "address","Consecutive special characters(.,#/:-) are not allowed in Address.");
					
					}
					
				}
				}
				catch(Exception e)
				{e.printStackTrace();}
			}
}
}
