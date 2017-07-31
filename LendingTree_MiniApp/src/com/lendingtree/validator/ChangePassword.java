package com.lendingtree.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lendingtree.bean.Changepassword;
public class ChangePassword implements Validator{

	@Override
	public boolean supports(Class<?> ch) {
		// TODO Auto-generated method stub
		return Changepassword.class.isAssignableFrom(ch);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		Changepassword chpwd=(Changepassword)target;
		
		String cpassword=chpwd.getPassword();
		String npwd=chpwd.getNewpassword();
		String cnpassword=chpwd.getConfirmnewpassword();
		
		
		
		 if(cpassword==null||cpassword.trim().equals(""))
	        {
			 	
	        	errors.rejectValue("password", "password","Password is required");

	        }
		
		 //new password validation
		  chpwd.setNewpassword(npwd);
	       npwd=npwd.trim().replaceAll(" ","");
	          
		  if(npwd==null || npwd.trim().equals(""))
	        {
	        	errors.rejectValue("newpassword", "newpassword","New Password is required");

	        }
		  else if(npwd.matches(cpassword)){
        	  
        	  errors.rejectValue("newpassword", "newpassword","New Password and Currrent Password can't be same");
          }

	        else
	        {
	        	 try{  
	  	        
	  	         
	  	             if(npwd.length()<6 ||npwd.length()>24 )
	  	            {
	  	          	  errors.rejectValue("newpassword","newpassword"," New Password length is minimum 6 and maximum 24 ");
	  	            }
	  	         
	  	            else if(!npwd.substring(0, 1).matches("^[A-Z]"))
	  	            {
	  	          	  errors.rejectValue("newpassword","newpassword"," New Password must start with upper case letters only");
	  	            }
	  	          
	  	            else if(!npwd.matches("^[A-Za-z0-9]+[.@_!$#&]+[A-Za-z0-9.@_!$#&]+$"))
	  	            {
	  	          	  errors.rejectValue("newpassword","newpassword","New Password must contain one Special character(.@_!$#&),one Digit,one Uppercase and Lowercase letters");
	  	            }
	  	            else if(!npwd.matches("^[A-Z0-9.@_!$#&]+[a-z]+[A-Za-z0-9.@_!$#&]+$"))
	  	            {
	  	          	  errors.rejectValue("newpassword","newpassword","New Password must contain one Special character(.@_!$#&),one Digit,one Uppercase and Lowercase letters");
	  	            }
	  	            else if(!npwd.matches("^[A-Za-z.@_!$#&]+[0-9]+[A-Za-z0-9.@_!$#&]+$"))
	  	            {
	  	          	  errors.rejectValue("newpassword","newpassword","New Password must contain one Special character(.@_!$#&),one Digit,one Uppercase and Lowercase letters");
	  	            }
	  	            else if(npwd.endsWith(".")||npwd.endsWith("@")||npwd.endsWith("_")||npwd.endsWith("!")||npwd.endsWith("$")||npwd.endsWith("#")||npwd.endsWith("&"))
	       		   {
	       			   errors.rejectValue("newpassword", "newpassword","New Password doesn't allow last character as special character");
	       		   }
	       	else
	       	{
	       		try{
	       			for(int i=0;i<npwd.length()-1;i++)
	       			{
	       			char ed = npwd.charAt(i);
	       			char emd = npwd.charAt(i+1);
	       		
	       			
	       			String ids =Character.toString(ed);
	       			
	       			String emdi = Character.toString(emd);
	       		
	       			if(ids.matches("^[.@_!$#&]+$")&&emdi.matches("^[.@_!$#&]+$"))
	       			{
	       				errors.rejectValue("newpassword", "newpassword","Consecutive special characters are not allowed in New Password");
	       			}
	       			}
	       		}
	       		catch(Exception e)
	       		{e.printStackTrace();}
	       	}
	       
	  	           
	  	        }
	  	        catch(Exception as){
	  	        	System.out.println(as);
	  	        }
	        }
		// validations for conform new password
		  if(cnpassword==null||cnpassword.trim().equals(""))
	        {
	        	errors.rejectValue("confirmnewpassword", "confirmnewpassword","Conform New Password is required");

	        }
		  else if(!cnpassword.matches(npwd))
	        {
	        	errors.rejectValue("confirmnewpassword", "confirmnewpassword","New Password and Conform New Password must be same");
	        }
		
	}

}
