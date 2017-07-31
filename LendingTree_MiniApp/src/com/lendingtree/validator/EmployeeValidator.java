package com.lendingtree.validator;

import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lendingtree.bean.BankBean;
import com.lendingtree.bean.EmployeeBean;

public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> ee) {
		// TODO Auto-generated method stub
		return  BankBean.class.isAssignableFrom(ee);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		

		EmployeeBean emp=(EmployeeBean)target;
		String name=emp.getName();
		String desig=emp.getDesig();
		String dept=emp.getDept();
		String emailid=emp.getEmail();
		String un=emp.getUsername();
		String pwd=emp.getPassword();
		String cpwd=emp.getConfirmpassword();
		String mobile=emp.getMobile();
		String address=emp.getAddress();
		
		
		if(name==null||name=="" ||name.matches("[\\s]+"))
		{
			
			errors.rejectValue("name", "name"," Employee Name is required");

		}
		else{
			
	
		name=name.trim();
		name=name.replaceAll("\\s+", " ");
		//name = name.replace(" ", "");
		name=WordUtils.capitalizeFully(name);
		emp.setName(name);
		
		if(name.length()<2||name.length()>30)
		{
			errors.rejectValue("name", "name","Employee Name length is minimum 2 and maximum 30");
			}
		else if(!name.matches("^[A-Z a-z]+$"))
		{
			errors.rejectValue("name", "name","Employee Name accepts alphabets only");
		}
		
	}
		
		//Validations for desig
		if(desig==null||desig=="" ||desig.matches("[\\s]+"))
		{
			
			errors.rejectValue("desig", "desig"," Designation is required");

		}
		else{
			
	
			desig=desig.trim();
			desig=desig.replaceAll("\\s+", " ");
			//desig = desig.replace(" ", " ");
			desig=WordUtils.capitalizeFully(desig);
		emp.setDesig(desig);
		
		if(desig.length()<2||desig.length()>30)
		{
			errors.rejectValue("desig", "desig","Designation length is minimum 2 and maximum 30");
			}
		else if(!desig.matches("^[A-Z a-z]+$"))
		{
			errors.rejectValue("desig", "desig","Designation accepts alphabets only");
		}
		
	}
		//validations for dept
		
		if(dept==null||dept=="" ||dept.matches("[\\s]+"))
		{
			
			errors.rejectValue("dept", "dept"," Department is required");

		}
		
		
// Validations for email id
        
	emailid=emailid.toLowerCase();
	System.out.println("Email id is "+emailid);
	emp.setEmail(emailid);
	        
	if(emailid==null || emailid=="" || emailid=="null"){
	     errors.rejectValue("email", "email","Email id is required");
    }
    else{
     	 if(emailid.length()<10 ||emailid.length()>50){
     		 errors.rejectValue("email", "email","Email id length is minimum 10 and maximum 50");
     	 }
     	 else if(!emailid.matches("[a-zA-Z0-9._@]+\\.?")){
     		 errors.rejectValue("email", "email","Email id accepts Alphabets,Digits,Special symbols(. @ _) only");
     	 }
     	 else if(!emailid.matches("[a-zA-Z]{1,}[a-zA-Z0-9._@]{1,}$")){
     		errors.rejectValue("email", "email","Emailid should start with alphabets");
     	 }
     	 else if(!emailid.matches("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})$ ?")){
     		errors.rejectValue("email", "email","Email id is Invalid");
     	 }
     	 else{
     		 try{
     			 System.out.println("Running try block");
       		    final String[] e1=emailid.split("@");
           	   String e11=e1[0];
           	   String e12=e1[1];
           	   if(e11.matches(e12)){
           		errors.rejectValue("email", "email","Email id is Invalid");
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
           			errors.rejectValue("email", "email","Email id account name can't match with domain name");
           		   }
           		   else if(e11.matches(emailid12)){
           			errors.rejectValue("email", "email","Email id account name can't match with domain name");
           		   }
           		 else if(e11.matches(emailid13)){
            			errors.rejectValue("email", "email","Email id account name can't match with domain name");
            		   }
           		   
           		   else if(emailid11.matches(emailid12)){
           			errors.rejectValue("email", "email","Email id domain name can't match with domain name");
           		   }
           		   else if(e12.split("\\.").length>=4){
           			errors.rejectValue("email", "email","Email id is Invalid");
           		   }
           		   else if(emailid11.matches(emailid13)){
              			errors.rejectValue("email", "email","Email id domain name can't match with domain name");
              		   }
           		   
           		   else if(emailid12.matches(emailid13)){
           			errors.rejectValue("email", "email","Email id domain name  can't match with domain name");
           		   }
           		   
           	        }
     	        }
       		
       			 catch(Exception ee){
       				 System.out.println("Runnig catch block");
           			final String[] e1=emailid.split("@");
                 	   String e11=e1[0];
                 	   String e12=e1[1];
                 	   if(e11.matches(e12)){
                 		 errors.rejectValue("email", "email","Email id is invalid");
                 	   }
                 	   else if(e12.contains(".")){
                 		   final String [] em1=e12.split("\\.");
                 		   String em11=em1[0];
                 		   String em12=em1[1];
                 		   
                 		   
                 		   if(e11.matches(em11)){
                 			 errors.rejectValue("email", "email","Email id account name can't match with domain name");
                 		   }
                 		   else if(e11.matches(em12)){
                 			 errors.rejectValue("email", "email","Email id account name can't match with domain name");
                 		   }
                 		   else if(em11.matches(em12)){
                 			 errors.rejectValue("email", "email","Email id domain name  can't match with domain name");
                 		   }
                 		  
                 		   
                 	        }
       		   
       		 }
       		 }
	}
 
		  // Validations for user name
		   if(un==null||un.trim().equals(""))
	    	{
	    		errors.rejectValue("username", "username","User Name is required");

	    	}
	        else{
	        	
	     
	        un=un.trim();
	        un = un.replace(" ", "");
	        emp.setUsername(un);
	    	if(un.length()<6||un.length()>30)
	    	{
	    		errors.rejectValue("username", "username","User Name length is minimum 6 and  maximum 30.");
	    	}
	    	else if(name.equals(un)||dept.equals(un)||desig.equals(un))
	    	{
	    		errors.rejectValue("username", "username","User Name should not match with  Name or Designation or Department");
	    	}
	    	
	    
	    	else if(!un.matches("^[a-z]+[0-9]+$"))
	    	{
	    		errors.rejectValue("username", "username","User name should be lower case alphabets then followed by digits only");
	    	}
	    	else if(un.matches("^[A-Z]+$"))
	    	{
	    		errors.rejectValue("username", "username","User Name accepts lower case alphabets only");
	    	}
	        }
	        //Validations for Password
	       
		   try{  
	           emp.setPassword(pwd);
	            pwd=pwd.trim().replaceAll(" ","");
	          
	            if(pwd==""||pwd.trim().equals(""))
	            {
	          	  errors.rejectValue("password","password","Password is required ");
	            }
	           
	            else  if(pwd.length()<6 ||pwd.length()>24 )
	            {
	          	  errors.rejectValue("password","password"," Password length is minimum 6 and maximum 24 ");
	            }
	         
	            else if(!pwd.substring(0, 1).matches("^[A-Z]"))
	            {
	          	  errors.rejectValue("password","password"," Password must start with upper case letters only");
	            }
	          
	            else if(!pwd.matches("^[A-Za-z0-9]+[.@_!$#&]+[A-Za-z0-9.@_!$#&]+$"))
	            {
	          	  errors.rejectValue("password","password","Password must contain one Special character(.@_!$#&),one Digit,one Uppercase and Lowercase letters");
	            }
	            else if(!pwd.matches("^[A-Z0-9.@_!$#&]+[a-z]+[A-Za-z0-9.@_!$#&]+$"))
	            {
	          	  errors.rejectValue("password","password","Password must contain one Special character(.@_!$#&),one Digit,one Uppercase and Lowercase letters");
	            }
	            else if(!pwd.matches("^[A-Za-z.@_!$#&]+[0-9]+[A-Za-z0-9.@_!$#&]+$"))
	            {
	          	  errors.rejectValue("password","password","Password must contain one Special character(.@_!$#&),one Digit,one Uppercase and Lowercase letters");
	            }
	            else if(pwd.endsWith(".")||pwd.endsWith("@")||pwd.endsWith("_")||pwd.endsWith("!")||pwd.endsWith("$")||pwd.endsWith("#")||pwd.endsWith("&"))
     		   {
     			   errors.rejectValue("password", "password","Password doesn't allow last character as special character");
     		   }
     	else
     	{
     		try{
     			for(int i=0;i<pwd.length()-1;i++)
     			{
     			char ed = pwd.charAt(i);
     			char emd = pwd.charAt(i+1);
     		
     			
     			String ids =Character.toString(ed);
     			
     			String emdi = Character.toString(emd);
     		
     			if(ids.matches("^[.@_!$#&]+$")&&emdi.matches("^[.@_!$#&]+$"))
     			{
     				errors.rejectValue("password", "password","Consecutive special characters are not allowed in Password");
     			}
     			}
     		}
     		catch(Exception e)
     		{e.printStackTrace();}
     	}
     
	             if(pwd.substring(0, 3).equals(un.substring(0, 3).toLowerCase()))
	            {
	          	  errors.rejectValue("password","password","First 3 characters of user name and Password don't be same");
	            }
	           else if (pwd.substring(0, 3).equals(name.substring(0, 3).toLowerCase()))
	            {
	          	  errors.rejectValue("password","password","First 3 characters of Name and Password don't be same");
	            }
	           
	        }
	        catch(Exception as){
	        	System.out.println(as);
	        }
		   // Validations for Conform Password
	        cpwd=cpwd.trim();
	        cpwd = cpwd.replace(" ", "");
	        emp.setConfirmpassword(cpwd);
	        if(cpwd==""||cpwd.trim().equals(""))
	        {
	        	errors.rejectValue("confirmpassword", "confirmpassword","Confirm Password is required");

	        }

	        else if(!pwd.matches(cpwd))
	        	{
	        	errors.rejectValue("confirmpassword", "confirmpassword","Password and Confirm Password must be same");

	        	}
		   
		   
		   
		   
		   
		   
	        //Validations for mobile
	        
	        mobile=mobile.trim();
	    	mobile= mobile.replace(" ", "");
	    emp.setMobile(mobile);
	    	if(mobile==null||mobile.trim().equals(""))
	    	 {
	    	 	errors.rejectValue("mobile", "mobile","Mobile is required");

	    	 }

	    	else if(mobile.length()<8||mobile.length()>15)
	    	{
	    	 	errors.rejectValue("mobile", "mobile","Mobile length is minimum 8 and  maximum 15");

	    	}
	    	else if(!mobile.matches("^[0-9]+$"))
	    	{
	    	 	errors.rejectValue("mobile", "mobile","Mobile should accepts numbers only");

	    	}
	    	else if(mobile.substring(0,5).equals("00000"))
	    	{
	    	 	errors.rejectValue("mobile", "mobile","First 5 zero's are not allowed in Mobile");
	    	}
// Validations for address
	    	
	    	 if(address==null||address.trim().equals(""))
	     	{
	     		errors.rejectValue("address", "address","Address is required");

	     	}else
	     	{
	     		address=address.trim();
	 			address=address.replaceAll("\\s+", " ");
	 			//city = city.replace(" ", "");
	 			//city=WordUtils.capitalizeFully(city);
	 			emp.setAddress(address);
	     	
	     	 
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
