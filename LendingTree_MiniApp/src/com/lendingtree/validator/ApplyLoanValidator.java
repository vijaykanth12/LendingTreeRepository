package com.lendingtree.validator;

import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lendingtree.bean.AppLoanBean;

public class ApplyLoanValidator implements Validator{

	@Override
	public boolean supports(Class<?> apploan) {
		// TODO Auto-generated method stub
		return AppLoanBean.class.isAssignableFrom(apploan);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		AppLoanBean loan=(AppLoanBean)target;
		String pan=loan.getPan();
		String qualification=loan.getQualification();
		String occupation=loan.getOccupation();
		String company=loan.getCompany();
		String emailid=loan.getWorkmail();
		String mobile=loan.getOfccontact();
		String address=loan.getOfcaddress();
		String sal=loan.getSalary();
		String loantype=loan.getLoantype();
		String banktype=loan.getBanktype();
		Integer amount=loan.getAmount();
	
		// Validations for PAN
		if(pan==null||pan=="" ||pan.matches("[\\s]+"))
		{
			
			errors.rejectValue("pan", "pan","PAN is required");

		}
		else if(!pan.matches("^[A-Z 0-9]+$"))
		{
			errors.rejectValue("pan", "pan","PAN number accepts Digits,Capital letters only");
		}
		else if(!pan.substring(0,1).matches("^[A-Z]+$"))
		{
			errors.rejectValue("pan", "pan","PAN number must start with Capital letters only");
		}
		
		else if(!(pan.length()==10))
		{
			errors.rejectValue("pan", "pan","PAN number must be 10 characters only");
		}
		
		else if(!pan.substring(0,5).matches("^[A-Z]+$"))
		{
			errors.rejectValue("pan", "pan","PAN number first five characters accepts Capital letters only");
		}
		else if(!pan.substring(5,9).matches("^[0-9]+$"))
		{
			errors.rejectValue("pan", "pan","PAN number 6 to 9 characters accepts digits only");
		}
		
		else if(!pan.substring(9,10).matches("^[A-Z]+$"))
	       {
	    	  errors.rejectValue("pan", "pan","PAN number must ends with capital letter only");
	       }
		
		
		// Validations for Qualification
		
		
		qualification=qualification.trim();
		qualification=qualification.replaceAll("\\s+", " ");
		//qualification = qualification.replace(" ", "");
		qualification=WordUtils.capitalizeFully(qualification);
		loan.setQualification(qualification);
		
		
		if(qualification==null||qualification=="" ||qualification.matches("[\\s]+"))
		{
			
			errors.rejectValue("qualification", "qualification","Qualification is required");

		}
		
	else  if(qualification.length()<2||qualification.length()>24)
	 {
		 errors.rejectValue("qualification", "qualification","qualification length is minimum 2 and maximum 24");

	 }
	 else if(!qualification.matches("^[a-zA-z ]+$"))
	 {
		 errors.rejectValue("qualification", "qualification","qualification should be contain alphabets only");
	 }
	 
// Validations for Occupation
		
		occupation=occupation.trim();
		occupation=occupation.replaceAll("\\s+", " ");
		//qualification = qualification.replace(" ", "");
		occupation=WordUtils.capitalizeFully(occupation);
		loan.setOccupation(occupation);
		
		
		if(occupation==null||occupation=="" ||occupation.matches("[\\s]+"))
		{
			
			errors.rejectValue("occupation", "occupation","Occupation is required");

		}
		else  if(occupation.length()<2||occupation.length()>24)
		 {
			 errors.rejectValue("occupation", "occupation","Occupation length is minimum 2 and maximum 24");

		 }
		 else if(!occupation.matches("^[a-zA-z ]+$"))
		 {
			 errors.rejectValue("occupation", "occupation","Occupation should be contain alphabets only");
		 }
//Validations for company field	
		
		company=company.trim();
		company=company.replaceAll("\\s+", " ");
		//qualification = qualification.replace(" ", "");
		company=WordUtils.capitalizeFully(company);
		loan.setCompany(company);
		
		
		if(company==null||company=="" ||company.matches("[\\s]+"))
		{
			
			errors.rejectValue("company", "company","Company is required");

		}
		else  if(company.length()<2||company.length()>24)
		 {
			 errors.rejectValue("company", "company","Company length is minimum 2 and maximum 24");

		 }
		 else if(!company.matches("^[a-zA-z ]+$"))
		 {
			 errors.rejectValue("company", "company","Company should be contain alphabets only");
		 }
	
// Validations for office email id
		emailid=emailid.toLowerCase();
		System.out.println("Email id is "+emailid);
		loan.setWorkmail(emailid);
		        
		if(emailid==null || emailid=="" || emailid=="null"){
		     errors.rejectValue("workmail", "workmail","Email id is required");
	    }
	    else{
	     	 if(emailid.length()<10 ||emailid.length()>50){
	     		 errors.rejectValue("workmail", "workmail","Email id length is minimum 10 and maximum 50");
	     	 }
	     	 else if(!emailid.matches("[a-zA-Z0-9._@]+\\.?")){
	     		 errors.rejectValue("workmail", "workmail","Email id accepts Alphabets,Digits,Special symbols(. @ _) only");
	     	 }
	     	 else if(!emailid.matches("[a-zA-Z]{1,}[a-zA-Z0-9._@]{1,}$")){
	     		errors.rejectValue("workmail", "workmail","Emailid should start with alphabets");
	     	 }
	     	 else if(!emailid.matches("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})$ ?")){
	     		errors.rejectValue("workmail", "workmail","Email id is Invalid");
	     	 }
	     	 else{
	     		 try{
	     			 System.out.println("Running try block");
	       		    final String[] e1=emailid.split("@");
	           	   String e11=e1[0];
	           	   String e12=e1[1];
	           	   if(e11.matches(e12)){
	           		errors.rejectValue("workmail", "workmail","Email id is Invalid");
	           	   }
	           	   else if(e12.contains(".")){
	           		  final  String [] emailid1=e12.split("\\.");
	           		   String emailid11=emailid1[0];
	           		   String emailid12=emailid1[1];
	           		   String emailid13=emailid1[2];
	           		   System.out.println("0 value is "+emailid11);
	           		   System.out.println("1 value is "+emailid12);
	           		   System.out.println("2 value is  "+emailid13);
	           		   if(e11.matches(emailid11)){
	           			errors.rejectValue("workmail", "workmail","Email id account name can't match with domain name");
	           		   }
	           		   else if(e11.matches(emailid12)){
	           			errors.rejectValue("workmail", "workmail","Email id account name can't match with domain name");
	           		   }
	           		 else if(e11.matches(emailid13)){
	            			errors.rejectValue("workmail", "workmail","Email id account name can't match with domain name");
	            		   }
	           		   
	           		   else if(emailid11.matches(emailid12)){
	           			errors.rejectValue("workmail", "workmail","Email id domain name can't match with domain name");
	           		   }
	           		   else if(e12.split("\\.").length>=4){
	           			errors.rejectValue("workmail", "workmail","Email id is Invalid");
	           		   }
	           		   else if(emailid11.matches(emailid13)){
	              			errors.rejectValue("workmail", "workmail","Email id domain name can't match with domain name");
	              		   }
	           		   
	           		   else if(emailid12.matches(emailid13)){
	           			errors.rejectValue("workmail", "workmail","Email id domain name  can't match with domain name");
	           		   }
	           		   
	           	        }
	     	        }
	       		
	       			 catch(Exception ee){
	       				 System.out.println("Runnig catch block");
	           			final String[] e1=emailid.split("@");
	                 	   String e11=e1[0];
	                 	   String e12=e1[1];
	                 	   if(e11.matches(e12)){
	                 		 errors.rejectValue("workmail", "workmail","Email id is invalid");
	                 	   }
	                 	   else if(e12.contains(".")){
	                 		   final String [] em1=e12.split("\\.");
	                 		   String em11=em1[0];
	                 		   String em12=em1[1];
	                 		   
	                 		   
	                 		   if(e11.matches(em11)){
	                 			 errors.rejectValue("workmail", "workmail","Email id account name can't match with domain name");
	                 		   }
	                 		   else if(e11.matches(em12)){
	                 			 errors.rejectValue("workmail", "workmail","Email id account name can't match with domain name");
	                 		   }
	                 		   else if(em11.matches(em12)){
	                 			 errors.rejectValue("workmail", "workmail","Email id domain name  can't match with domain name");
	                 		   }
	                 		  
	                 		   
	                 	        }
	       		   
	       		 }
	       		 }
		}
	 
	
// Validations for office contact number
		  mobile=mobile.trim();
	    	mobile= mobile.replace(" ", "");
	    	loan.setOfccontact(mobile);
	    	if(mobile==null||mobile.trim().equals(""))
	    	 {
	    	 	errors.rejectValue("ofccontact", "ofccontact","Office Contact is required");

	    	 }

	    	else if(mobile.length()<8||mobile.length()>15)
	    	{
	    	 	errors.rejectValue("ofccontact", "ofccontact","Office Contact length is minimum 8 and  maximum 15");

	    	}
	    	else if(!mobile.matches("^[0-9]+$"))
	    	{
	    	 	errors.rejectValue("ofccontact", "ofccontact","Office Contact should accepts numbers only");

	    	}
	    	else if(mobile.substring(0,5).equals("00000"))
	    	{
	    	 	errors.rejectValue("ofccontact", "ofccontact","First 5 zero's are not allowed in Office Contact");
	    	}	
//Validations for office address
	    	 if(address==null||address.trim().equals(""))
	     	{
	     		errors.rejectValue("ofcaddress", "ofcaddress","Office Address is required");

	     	}else
	     	{
	     		address=address.trim();
	 			address=address.replaceAll("\\s+", " ");
	 			//city = city.replace(" ", "");
	 			//city=WordUtils.capitalizeFully(city);
	 			loan.setOfcaddress(address);
	     	
	     	 
	     		  if(address.length()<10||address.length()>100)
	     		  {
	     			  errors.rejectValue("ofcaddress", "ofcaddress","Office Address length is  minimum 10 and maximum 100.");
	     		  }
	     		  else if (!address.matches("^[a-zA-Z ]+[a-z A-Z0-9 :.#,/_-]+$")) {
	     				errors.rejectValue("ofcaddress", "ofcaddress","Office Address should starts with alphabets and followed by alphabats,numbers,spacial charecters(:.,#/_-)");
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
	 						errors.rejectValue("ofcaddress", "ofcaddress","Consecutive special characters(.,#/:-) are not allowed in Office Address.");
	 					
	 					}
	 					
	 				}
	 				}
	 				catch(Exception e)
	 				{e.printStackTrace();}
	 			}
// Validations for salary
	    	 sal=sal.trim();
	    	 sal= sal.replace(" ", "");
		    	loan.setSalary(sal);
		    	if(sal==null||sal.trim().equals(""))
		    	 {
		    	 	errors.rejectValue("salary", "salary","Salary is required");

		    	 }

		    	else if(!sal.matches("^[0-9]+$"))
		    	{
		    	 	errors.rejectValue("salary", "salary","Salary should accepts numbers only");

		    	}
		    	 	 
 // Validations for Loan type
	    	 if(loantype==null||loantype.trim().equals(""))
		     	{
		     		errors.rejectValue("loantype", "loantype","Loan type is required");

		     	}
// Validations for Bank type
	    	 if(banktype==null||banktype.trim().equals(""))
		     	{
		     		errors.rejectValue("banktype", "banktype","Bank type is required");

		     	}
	    	 
	    	 
// Validations for Amount
	    
	 if(amount==null)
	   {
	    	errors.rejectValue("amount", "amount","Amount is required");

	   } 
	 else if(amount.intValue()>1500000 || amount.intValue()<100000)
	   {
		    errors.rejectValue("amount", "amount","Amount accepts maximam 1500000 Lakhs and minimam 100000 Lakh only");
	   }
	  loan.setAmount(amount);

	
	}

}
