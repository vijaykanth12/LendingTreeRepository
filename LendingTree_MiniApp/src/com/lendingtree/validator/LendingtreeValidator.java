package com.lendingtree.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.WordUtils;

import com.lendingtree.bean.RegistrationBean;

public class LendingtreeValidator implements Validator{

	@Override
	public boolean supports(Class<?> aa) {
		// TODO Auto-generated method stub
		 return RegistrationBean.class.isAssignableFrom(aa);
	}
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		RegistrationBean std=(RegistrationBean)target;
		String fn=std.getFirstname();
		String mn=std.getMiddlename();
		String ln=std.getLastname();
		String un=std.getUsername();
		String pwd=std.getPassword();
		String conformpassword=std.getConformpassword();
		String email=std.getEmailid();
		String mobile=std.getMobile();
		String gen=std.getGender();
		String dob=std.getDateofbirth();
		String lang=std.getLanguagesknown();
		String country=std.getCountry();
		String state=std.getState();
		String city=std.getCity();
		String pin=std.getPincode();
		String address=std.getAddress();
		
	//Validations for First name
		
		fn=WordUtils.capitalizeFully(fn);
		std.setFirstname(fn.trim());
		if(fn==null||fn=="" ||fn.matches("[\\s]+"))
		{
			
			errors.rejectValue("firstname", "firstname","First name is required");

		}
		else{
			
	
		fn=fn.trim();
		fn=fn.replaceAll("\\s+", "");
		fn = fn.replace(" ", "");
		
		fn=WordUtils.capitalizeFully(fn);
		std.setFirstname(fn);
		
		if(fn.length()<2||fn.length()>30)
		{
			errors.rejectValue("firstname", "firstname","First name length is minimum 2 and maximum 30");
			}
		else if(!fn.matches("^[A-Z a-z]+$"))
		{
			errors.rejectValue("firstname", "firstname","First name accepts alphabets only");
		}
		else if(fn.equals("Firstname")||fn.equalsIgnoreCase("Middlename")||fn.equals("Lastname"))
		{
			errors.rejectValue("firstname", "firstname","Please Don't enter First name or Middle name or Last name in First name field");

		}
		}
		//Validations for middle name
		std.setMiddlename(mn.trim());	
		if(mn==null||mn=="" ||mn.matches("[\\s]+"))
		{
			
			errors.rejectValue("middlename", "middlename","Middle name is required");

		}
		else {
			
	
		mn=mn.trim();
        mn= mn.replace(" ", "");
        mn = WordUtils.capitalizeFully(mn);
        std.setMiddlename(mn);
			
        	if(mn.length()<2||mn.length()>30)
			{
				errors.rejectValue("middlename", "middlename","Middle name length is minimum 2 and maximum 30");
			}
			else if(!mn.matches("^[A-Za-z]+$"))
			{
				errors.rejectValue("middlename", "middlename","Middle name accepts alphabets only");
			}
			else if(fn.equals(mn))
			{
				errors.rejectValue("middlename", "middlename","Middle name and First name can't be same");
			}
			else if(mn.equals("Firstname")||mn.equals("Middlename")||mn.equals("Lastname"))
			{	
				errors.rejectValue("middlename", "middlename","Please Don't enter First name or Middle name or Last name in Middle name field");
			}
		}
		// Validations for Last Name
		std.setLastname(ln.trim()); 
		if(ln==null||ln.trim().equals(""))
		{
			errors.rejectValue("lastname", "lastname","Last name is required");

		}
		else
		{
			ln=ln.trim();
			ln = ln.replace(" ", "");
			ln=WordUtils.capitalizeFully(ln);
			std.setLastname(ln);
			if(ln.length()<2||ln.length()>30)
			{	
				errors.rejectValue("lastname", "lastname","Last name length is minimum 2 and maximum 30");
			}
			else if(!ln.matches("^[A-Za-z]+$"))
			{
				errors.rejectValue("lastname", "lastname","Last name accepts alphabets only");
			}
			else if(ln.equals("Firstname")||ln.equals("Middlename")||ln.equals("Lastname"))
			{		
				errors.rejectValue("lastname", "lastname","Please Don't enter First name or Middle name or Last name in Last name field");
				}
			else if(fn.equals(ln))
			{
				errors.rejectValue("lastname", "lastname","Last name and First name can't be same");
			}
			else if(mn.equals(ln))
			{
				errors.rejectValue("lastname", "lastname","Last name and Middle name can't be same");
			}
		}
			// Validations for User Name
		  	std.setUsername(un.trim());
	        if(un==null||un.trim().equals(""))
	    	{
	    		errors.rejectValue("username", "username","User name is required");

	    	}
	        else{
	        	
	     
	        un=un.trim();
	        un = un.replace(" ", "");
	        std.setUsername(un);
	    	
	    	
	    	try{
	    		if(un.length()<6||un.length()>30)
		    	{
		    		errors.rejectValue("username", "username","User name length is minimum 6 and  maximum 30.");
		    	}
		    	else if(fn.equals(un)||mn.equals(un)||ln.equals(un))
		    	{
		    		errors.rejectValue("username", "username","User name should not match with First name or Middle name or Last name");
		    	}
		    	
		    	else if(un.equals("Firstname")||un.equals("Middlename")||un.equals("Lastname")||un.equals("Username"))
		    	{
		    		errors.rejectValue("username", "username","User name should not contain  First name  or Last name or Middle name");
		    	}
		    	else if(!un.matches("^[a-z]+[0-9]+$"))
		    	{
		    		errors.rejectValue("username", "username","User name should be lower case alphabets then followed by digits only");
		    	}
		    	else if(un.matches("^[A-Z]+$"))
		    	{
		    		errors.rejectValue("username", "username","User name accepts lower case alphabets only");
		    	}
		    	else if(un.substring(0, 3).equals(fn.substring(0, 3).toLowerCase()))
	            {
	          	  errors.rejectValue("username","username","First 3 characters of First name and User name don't be same");
	            }
	    	  else if(un.substring(0, 3).equals(mn.substring(0, 3).toLowerCase()))
	            {
	          	  errors.rejectValue("username","username","First 3 characters of Middle name and User name don't be same");
	            }
	    	  else if(un.substring(0, 3).equals(ln.substring(0, 3).toLowerCase()))
	            {
	          	  errors.rejectValue("username","username","First 3 characters of Last name and User name don't be same");
	            }
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println(e);	    	}
	        }
	        //Validations for Password
	        try{  
	        	std.setPassword(pwd.trim());
	        	std.setPassword(pwd);
	            pwd=pwd.trim().replaceAll(" ","");
	            std.setPassword(pwd);
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
     
	             if(pwd.substring(0, 3).equals(fn.substring(0, 3)))
	            {
	          	  errors.rejectValue("password","password","First 3 characters of First name and Password don't be same");
	            }
	           else if (pwd.substring(0, 3).equals(mn.substring(0, 3)))
	            {
	          	  errors.rejectValue("password","password","First 3 characters of Middle name and Password don't be same");
	            }
	            else if(pwd.substring(0,3).equals(ln.substring(0, 3)))
	            {
	          	  errors.rejectValue("password","password","First 3 characters of Last name and Password don't be same");
	            }
	           /* else if(pwd.substring(0,3).equals(un.substring(0, 3).toLowerCase())) 
	            {
	          	  errors.rejectValue("password","password","First 3 characters of User name and Password don't be same");
	            }*/
	            else if(un.substring(0,3).equals(pwd.substring(0, 3).toLowerCase())) 
	            {
	          	  errors.rejectValue("password","password","First 3 characters of User name and Password don't be same");
	            }
	             
	        }
	        catch(Exception as){
	        	System.out.println(as);
	        }
	       // Validations for Conform Password
	        std.setConformpassword(conformpassword.trim());
	        conformpassword=conformpassword.trim();
	        conformpassword = conformpassword.replace(" ", "");
	        std.setConformpassword(conformpassword);
	        if(conformpassword==""||conformpassword.trim().equals(""))
	        {
	        	errors.rejectValue("conformpassword", "conformpassword","Confirm Password is required");

	        }

	        else if(!pwd.matches(conformpassword))
	        	{
	        	errors.rejectValue("conformpassword", "conformpassword","Password and Confirm Password must be same");

	        	}
// Validations for Email id
	
	 std.setEmailid(email.trim());
	
	
	
	 email=email.toLowerCase();
	 

	 
	 	if(email==null || email=="" || email.trim().equals("")){
    	     errors.rejectValue("emailid", "emailid","Email id is required");
        }
	 	
	 	else {
	 		  email=email.trim();
		      email = email.replace(" ", "");
	 		  std.setEmailid(email);
	 		 if(email==null || email=="" || email=="null"){
	    	     errors.rejectValue("emailid", "emailid","Email id is required");
	        }
	 		 else if(email.length()<10 ||email.length()>50){
	 
     		  errors.rejectValue("emailid", "emailid","Email id length is minimum 10 and maximum 50");
     	 }
     	 else if(!email.matches("[a-zA-Z0-9._@]+\\.?")){
     		 errors.rejectValue("emailid", "emailid","Email id accepts Alphabets,Digits,Special symbols(. @ _) only");
     	 }
     	 else if(!email.matches("[a-zA-Z]{1,}[a-zA-Z0-9._@]{1,}$")){
     		errors.rejectValue("emailid", "emailid","Emailid should start with alphabets");
     	 }
     	 else if(!email.matches("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})$ ?")){
     		errors.rejectValue("emailid", "emailid","Email id is Invalid, Format is ' t.vijaykanth@schimatic.com '");
     	 }
	 
     	 else{
     		 try{
     		
       		    final String[] e1=email.split("@");
           	   String e11=e1[0];
           	   String e12=e1[1];
           	   if(e11.matches(e12)){
           		errors.rejectValue("emailid", "emailid","Email id is Invalid");
           	   }
           	   else  if(e11.length()<3||e11.length()>20)
        		{
        			errors.rejectValue("emailid", "emailid","Email id account name length is minimam 3 and maximam 20");
        		}
           	   
           	   
           	   
           	   
           	   
           	   else if(e12.contains(".")){
           		  final  String [] emailid1=e12.split("\\.");
           		   String emailid11=emailid1[0];
           		   String emailid12=emailid1[1];
           		   String emailid13=emailid1[2];
           		  
           		   
           		   
           		   if(e11.matches(emailid11)){
           			errors.rejectValue("emailid", "emailid","Email id account name can't match with domain name");
           		  }
           		
           		   
           		 else  if(emailid11.length()<3||emailid11.length()>20)
         		{
         			errors.rejectValue("emailid", "emailid","Email id domain name length is minimam 3 and maximam 20");
         		}   
           		   
           		 else  if(emailid12=="com" && emailid13=="in")
          		{
          			errors.rejectValue("emailid", "emailid","Email id accepts neither com nor in only");
          		}   
           		 else  if(emailid12=="in" && emailid13=="com")
           		{
           			errors.rejectValue("emailid", "emailid","Email id accepts neither com nor in only");
           		}      
           		   
           		   
           		   
           		   
           		   
           		else if(e11.matches(emailid12)){
           			errors.rejectValue("emailid", "emailid","Email id account name can't match with domain name");
           		   }
           		 else if(e11.matches(emailid13)){
            			errors.rejectValue("emailid", "emailid","Email id account name can't match with domain name");
            		   }
           		   
           		   else if(emailid11.matches(emailid12)){
           			errors.rejectValue("emailid", "emailid","Email id domain name can't match with domain name");
           		   }
           		   else if(e12.split("\\.").length>=4){
           			errors.rejectValue("emailid", "emailid","Email id is Invalid");
           		   }
           		   else if(emailid11.matches(emailid13)){
              			errors.rejectValue("emailid", "emailid","Email id domain name can't match with domain name");
              		   }
           		   
           		   else if(emailid12.matches(emailid13)){
           			errors.rejectValue("emailid", "emailid","Email id domain name  can't match with domain name");
           		   }
           		   
           	        }
     	        }
       		
       			 catch(Exception ee){
       				 System.out.println("Runnig catch block");
           			final String[] e1=email.split("@");
                 	   String e11=e1[0];
                 	   String e12=e1[1];
                 	   if(e11.matches(e12)){
                 		 errors.rejectValue("emailid", "emailid","Email id is invalid");
                 	   }
                 	   else if(e12.contains(".")){
                 		   final String [] em1=e12.split("\\.");
                 		   String em11=em1[0];
                 		   String em12=em1[1];
                 		   
                 		   
                 		   if(e11.matches(em11)){
                 			 errors.rejectValue("emailid", "emailid","Email id account name can't match with domain name");
                 		   }
                 		  else  if(em11.length()<3||em11.length()>20)
                   		{
                   			errors.rejectValue("emailid", "emailid","Email id domain name length is minimam 3 and maximam 20");
                   		}   
                 		   else if(e11.matches(em12)){
                 			 errors.rejectValue("emailid", "emailid","Email id account name can't match with domain name");
                 		   }
                 		   else if(em11.matches(em12)){
                 			 errors.rejectValue("emailid", "emailid","Email id domain name  can't match with domain name");
                 		   }
                 		  
                 		   
                 	        }
       		   
       		 }
       		 }
	 	}
	
 
 //Validations for Mobile
	    std.setMobile(mobile.trim());
	    mobile=mobile.trim();
    	mobile= mobile.replace(" ", "");
    	std.setMobile(mobile);
    	if(mobile==null||mobile.trim().equals(""))
    	 {
    	 	errors.rejectValue("mobile", "mobile","Mobile No is required");

    	 }

    	else if(mobile.length()<8||mobile.length()>15)
    	{
    	 	errors.rejectValue("mobile", "mobile","Mobile No length is minimum 8 and  maximum 15");

    	}
    	else if(!mobile.matches("^[0-9]+$"))
    	{
    	 	errors.rejectValue("mobile", "mobile","Mobile No should accepts numbers only");

    	}
    	else if(mobile.substring(0,5).equals("00000"))
    	{
    	 	errors.rejectValue("mobile", "mobile","First 5 zero's are not allowed in Mobile No");
    	}

// Validations for gender
    	  if( gen == null || ("".equals(std.getGender())))
    	  {
    		  errors.rejectValue("gender", "gender","Gender is required");
    	  }
   // Validations for Date of Birth
    	  std.setDateofbirth(dob.trim());
    	  if(dob=="" ||dob.trim().equals(""))
    	    {
    	    	errors.rejectValue("dateofbirth","dateofbirth","Date of birth is required");	
    	    }
    	    else if(!dob.equals(null) || !dob.equals("")){
    	    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    		 try{  //get current date time with Date()
    		   Date date = new Date();
    		
    		 int  y=date.getYear()+1900;
    		 int m=date.getMonth()+1;
    		 int d=date.getDate();
    		 System.out.println("year is"+y);
    		System.out.println(m);
    		System.out.println(d); 
    		String[] di=dob.split("/");
    		System.out.println(di[0]);
    		System.out.println(di[1]);
    		System.out.println(di[2]);
    		int month = Integer.parseInt(di[0]);
    		int dat = Integer.parseInt(di[1]);
    		int year = Integer.parseInt(di[2]);
    		int  ny=y-year;
    		int nm=m-month;
    		int nd=d-dat;
    		if ((ny ==0 && nm == 0 && nd < 0)||(ny==0 && nm<0 && nd<=nd) || ny< 0) {
    			errors.rejectValue("dateofbirth","dateofbirth","Future date can't be accepted");	
    	    
    	 }
    		else if ((ny == 18 && nm == 0 && nd < 0)||(ny==18 && nm<0 && nd<=nd) || ny< 18) {
    			errors.rejectValue("dateofbirth","dateofbirth","Age must be above 18 for registration");	
    		}   
    	     }
    		 catch(Exception ed) 
    	     {
    	    	 
    	     System.out.println("error for dob"+ed);	
    	     }
    	    }
    	  // Validations for Languages Known
    	  if(lang==null || lang==""){
              errors.rejectValue("languagesknown", "languagesknown","Languages Known is required");        	    	  
	      }
    	  // Validations for Country
    	  if(country==null||country=="" ||country.matches("[\\s]+"))
    	  {
    	  	errors.rejectValue("country", "country","Country is required");

    	  }
    	  if(state==null||state=="" ||state.matches("[\\s]+"))
    	  {
    	  	errors.rejectValue("state", "state","State is required");

    	  }
    	  // Validations for city
    	  std.setCity(city.trim());
    	  if(city==null||city.trim().equals(""))
    		{
    			errors.rejectValue("city", "city","City is required");

    		}
    	  else{
    		  city=city.trim();
    			city=city.replaceAll("\\s+", " ");
    			//city = city.replace(" ", "");
    			city=WordUtils.capitalizeFully(city);
    			std.setCity(city);
    	  
    	 if(city.length()<2||city.length()>30)
    	{
    		errors.rejectValue("city", "city","City length is minimum 2 and maximum 24");

    	}
    	else if(!city.matches("^[a-zA-z ]+$"))
    	{
    		errors.rejectValue("city", "city","City should be contain alphabets only");

    	}
    	else if(city.equals("Firstname")||city.equals("Middlename")||city.equals("Lastname"))
		{		
			errors.rejectValue("city", "city","Please Don't enter First Name or Middle Name or Last Name in City field");
			}
    	else if(city.equals("City"))
		{
			errors.rejectValue("city", "city","Please Don't enter City in City field");
		}
		else if(fn.equals(city))
		{
			errors.rejectValue("city", "city","City and First Name can't be same");
		}
		else if(mn.equals(city))
		{
			errors.rejectValue("city", "city","City and Middle Name can't be same");
		}
		else if(ln.equals(city))
		{
			errors.rejectValue("city", "city","City and Last Name can't be same");
		}
    	  }

    	// Validations for Pin Code
    	  std.setPincode(pin.trim());
    	  if(pin==""||pin.trim().equals(""))
    	 {
    	 	errors.rejectValue("pincode", "pincode","Pin Code is required");

    	 }
    	  else
    	  {
    		  pin=pin.trim();
  			
  			pin = pin.replace(" ", "");
  			
  			std.setPincode(pin);
    	 
    	 if(pin.length()<3||pin.length()>8)
    	{
    		 	errors.rejectValue("pincode", "pincode","Pin Code length is minimum 3 maximum 8");

    	}
    	else if(!pin.matches("^[0-9]+$"))
    	{
    	 	errors.rejectValue("pincode", "pincode","Pin Code shold conatain digits only");
    	}
	}
    	  // Validations for Address
    	std.setAddress(address.trim());
    	 if(address==null||address.trim().equals(""))
    	{
    		errors.rejectValue("address", "address","Address is required");

    	}else
    	{
    		address=address.trim();
			address=address.replaceAll("\\s+", " ");
			//city = city.replace(" ", "");
			//city=WordUtils.capitalizeFully(city);
			std.setAddress(address);
    	
    	 
    		  if(address.length()<4||address.length()>100)
    		  {
    			  errors.rejectValue("address", "address","Address length is  minimum 4 and maximum 100.");
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


