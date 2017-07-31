package com.lendingtree.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lendingtree.bean.LoanApplyBean;

public class AaBusinessLoanValidator implements Validator {

	@Override
	public boolean supports(Class<?> a) {
		// TODO Auto-generated method stub
		return LoanApplyBean.class.isAssignableFrom(a);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		LoanApplyBean loan=(LoanApplyBean)target;
		String fn=loan.getFirstname();
		String mn=loan.getMiddlename();
		String ln=loan.getLastname();
		String email=loan.getEmail();
		String mobile=loan.getMobile();
		String gender=loan.getGender();
		String dob=loan.getDateofbirth();
		String ms=loan.getMaritalstatus();
		String pan=loan.getPan();
		String edu=loan.getEducationqualification();
		String address=loan.getAddress();
		String country=loan.getCountry();
		String state=loan.getState();
		String city=loan.getCity();
		String pin=loan.getPincode();
		String desig=loan.getDesignation();
		String company=loan.getCompany();
		String workmail=loan.getWorkemail();
		String ofccontact=loan.getOfccontact();
		String ofcaddress=loan.getOfcaddress();
		String firm=loan.getFirm();
		String profession=loan.getProfession();
		String nbuss=loan.getNatureofbusiness();
		String noexp=loan.getNoofexp();
		String income=loan.getIncome();
		String lamount=loan.getLoanamount();
		String purpose=loan.getPurpose();
		String banktype=loan.getBanktype();
		// Education loan
		
		String fsname=loan.getFsname();
		String passport=loan.getPassportno();
		String aadhar=loan.getAadhaarno();
		String admission=loan.getAdmissionstatus();
		String university=loan.getUniversity();
		String namecourse=loan.getNamecourse();
		String courseduration=loan.getCourseduration();
		String collegead=loan.getCollegeaddress();
		String ctype=loan.getCoursetype();
		
		//Home loan
		String bname=loan.getBuildername();
		String bulidname=loan.getBuildingname();
		String barea=loan.getBuiltuparea();
		String sname=loan.getSellername();
		String scontact=loan.getSellercontactno();
		String saddress=loan.getSelleraddress();
		String property=loan.getPropertycost();
		String lpurpose=loan.getLoanpurpose();
		
		// Busines Loan
		
		String lestatus=loan.getLegalstatus();
		String yincop=loan.getYearofincorp();
		String rocregno=loan.getRocregno();
		String ownership=loan.getOwnership();
		String landline=loan.getLandline();
		String noofbranches=loan.getNoofbranches();
		String ncities=loan.getNameofcities();
		String nemps=loan.getNoofemployees();
		String fax=loan.getFax();
		String taxpaid=loan.getTaxpaid();
		String regaddres=loan.getRegofcaddress();

		fn=WordUtils.capitalizeFully(fn);
		loan.setFirstname(fn.trim());
		if(fn==null||fn=="" ||fn.matches("[\\s]+"))
		{
			
			errors.rejectValue("firstname", "firstname","First name is required");

		}
		else{
			
	
		fn=fn.trim();
		fn=fn.replaceAll("\\s+", "");
		fn = fn.replace(" ", "");
		
		fn=WordUtils.capitalizeFully(fn);
		loan.setFirstname(fn);
		
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
		loan.setMiddlename(mn.trim());	
		if(mn==null||mn=="" ||mn.matches("[\\s]+"))
		{
			
			errors.rejectValue("middlename", "middlename","Middle name is required");

		}
		else {
			
	
		mn=mn.trim();
        mn= mn.replace(" ", "");
        mn = WordUtils.capitalizeFully(mn);
        loan.setMiddlename(mn);
			
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
		loan.setLastname(ln.trim()); 
		if(ln==null||ln.trim().equals(""))
		{
			errors.rejectValue("lastname", "lastname","Last name is required");

		}
		else
		{
			ln=ln.trim();
			ln = ln.replace(" ", "");
			ln=WordUtils.capitalizeFully(ln);
			loan.setLastname(ln);
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

		// Validations for Email id
		
		 loan.setEmail(email.trim());
		
		
		
		 email=email.toLowerCase();
		 

		 
		 	if(email==null || email=="" || email.trim().equals("")){
	    	     errors.rejectValue("email", "email","Email id is required");
	        }
		 	
		 	else {
		 		  email=email.trim();
			      email = email.replace(" ", "");
		 		  loan.setEmail(email);
		 		 if(email==null || email=="" || email=="null"){
		    	     errors.rejectValue("email", "email","Email id is required");
		        }
		 		 else if(email.length()<10 ||email.length()>50){
		 
	     		  errors.rejectValue("email", "email","Email id length is minimum 10 and maximum 50");
	     	 }
	     	 else if(!email.matches("[a-zA-Z0-9._@]+\\.?")){
	     		 errors.rejectValue("email", "email","Email id accepts Alphabets,Digits,Special symbols(. @ _) only");
	     	 }
	     	 else if(!email.matches("[a-zA-Z]{1,}[a-zA-Z0-9._@]{1,}$")){
	     		errors.rejectValue("email", "email","Emailid should start with alphabets");
	     	 }
	     	 else if(!email.matches("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})$ ?")){
	     		errors.rejectValue("email", "email","Email id is Invalid");
	     	 }
		 
	     	 else{
	     		 try{
	     		
	       		    final String[] e1=email.split("@");
	           	   String e11=e1[0];
	           	   String e12=e1[1];
	           	   if(e11.matches(e12)){
	           		errors.rejectValue("email", "email","Email id is Invalid");
	           	   }
	           	   else  if(e11.length()<2||e11.length()>20)
	        		{
	        			errors.rejectValue("email", "email","Email id account name length is minimam 2 and maximam 20");
	        		}
	           	   
	           	   
	           	   
	           	   
	           	   
	           	   else if(e12.contains(".")){
	           		  final  String [] emailid1=e12.split("\\.");
	           		   String emailid11=emailid1[0];
	           		   String emailid12=emailid1[1];
	           		   String emailid13=emailid1[2];
	           		  
	           		   
	           		   
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
	           			final String[] e1=email.split("@");
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
		
		 	 //Validations for Mobile
		    loan.setMobile(mobile.trim());
		    mobile=mobile.trim();
	    	mobile= mobile.replace(" ", "");
	    	loan.setMobile(mobile);
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

if(gender==null||gender=="" ||gender.matches("[\\s]+"))
{
errors.rejectValue("gender", "gender","Gender is required");

}
//Validations for Date of Birth
loan.setDateofbirth(dob.trim());
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
errors.rejectValue("dateofbirth","dateofbirth","Age must be above 18 ");	
}   
}
catch(Exception ed) 
{

System.out.println("error for dob"+ed);	
}
}

//Validations for Ms
if(ms==null||ms=="" ||ms.matches("[\\s]+"))
{
errors.rejectValue("maritalstatus", "maritalstatus","Marrital Status is required");

}

/*if(fsname==null||fsname=="" ||fsname.matches("[\\s]+"))
{
	errors.rejectValue("fsname", "fsname","Father/Spouse name is required");

}*/

loan.setFsname(fsname.trim());
if(fsname==null||fsname=="" ||fsname.matches("[\\s]+"))
{
	
	errors.rejectValue("fsname", "fsname","Father/Spouse name is required");

}
else {
	

	fsname=fsname.trim();
	fsname= fsname.replace(" ", "");
	fsname = WordUtils.capitalizeFully(fsname);
    loan.setFsname(fsname);
	
	if(fsname.length()<2||fsname.length()>30)
	{
		errors.rejectValue("fsname", "fsname","Father/Spouse name length is minimum 2 and maximum 30");
	}
	else if(!fsname.matches("^[A-Za-z]+$"))
	{
		errors.rejectValue("fsname", "fsname","Father/Spouse name accepts alphabets only");
	}
	
}
loan.setPan(pan.trim());
if(pan==null||pan=="" ||pan.matches("[\\s]+"))
{
	
	errors.rejectValue("pan", "pan","PAN No is required");

}
else if(!pan.matches("^[A-Z 0-9]+$"))
{
	errors.rejectValue("pan", "pan","PAN No accepts Digits,Capital letters only");
}
else if(!pan.substring(0,1).matches("^[A-Z]+$"))
{
	errors.rejectValue("pan", "pan","PAN No must start with Capital letters only");
}

else if(!(pan.length()==10))
{
	errors.rejectValue("pan", "pan","PAN No must be 10 characters only");
}

else if(!pan.substring(0,5).matches("^[A-Z]+$"))
{
	errors.rejectValue("pan", "pan","PAN No first five characters accepts Capital letters only");
}
else if(!pan.substring(5,9).matches("^[0-9]+$"))
{
	errors.rejectValue("pan", "pan","PAN No 6 to 9 characters accepts digits only");
}

else if(!pan.substring(9,10).matches("^[A-Z]+$"))
   {
	  errors.rejectValue("pan", "pan","PAN No must ends with capital letter only");
   }
//Validations For Education Qualification
loan.setEducationqualification(edu.trim());	
if(edu==null||edu=="" ||edu.matches("[\\s]+"))
{
errors.rejectValue("educationqualification", "educationqualification","Education Qualification  is required");

}
else  if(edu.length()<2||edu.length()>24)
{
errors.rejectValue("educationqualification", "educationqualification","Education Qualification length is minimum 2 and maximum 24");

}
else if(!edu.matches("^[a-zA-z]+$"))
{
errors.rejectValue("educationqualification", "educationqualification","Education Qualification should be contain alphabets only");
}

/*if(passport==null||passport=="" ||passport.matches("[\\s]+"))
	{
			errors.rejectValue("passportno", "passportno","Passport No is required");

		
	}
*/

loan.setPassportno(passport.trim());
if(passport==null||passport=="" ||passport.matches("[\\s]+"))
{
	
	errors.rejectValue("passportno", "passportno","Passport No is required");

}
else {
	

	passport=passport.trim();
	passport= passport.replace(" ", "");
	passport = WordUtils.capitalizeFully(passport);
    loan.setPassportno(passport);
	
	if(passport.length()<7||passport.length()>15)
	{
		errors.rejectValue("passportno", "passportno","Passport No  length is minimum 7 and maximum 15");
	}
	else if(!passport.matches("^[A-Za-z0-9]+$"))
	{
		errors.rejectValue("passportno", "passportno","Passport No accepts alphabets and digits only");
	}
	
}
/*if(aadhar==null||aadhar=="" ||aadhar.matches("[\\s]+"))
		{
			errors.rejectValue("aadhaarno", "aadhaarno","Aadhaar No is required");
		
		}
*/

loan.setAadhaarno(aadhar.trim());
if(aadhar==null||aadhar=="" ||aadhar.matches("[\\s]+"))
{
	
	errors.rejectValue("aadhaarno", "aadhaarno","Aadhaar No is required");

}
else {
	

	aadhar=aadhar.trim();
	aadhar= aadhar.replace(" ", "");
	aadhar = WordUtils.capitalizeFully(aadhar);
   loan.setAadhaarno(aadhar);
	
	if(aadhar.length()!=12)
	{
		errors.rejectValue("aadhaarno", "aadhaarno","Aadhaar No length is must 12 digits");
	}
	else if(!aadhar.matches("^[0-9]+$"))
	{
		errors.rejectValue("aadhaarno", "aadhaarno","Aadhaar No accepts  digits only");
	}
	
}







		//Validations for Address
		loan.setAddress(address.trim());
		 if(address==null||address.trim().equals(""))
		{
			errors.rejectValue("address", "address","Address is required");

		}else
		{
			address=address.trim();
			address=address.replaceAll("\\s+", " ");
			//city = city.replace(" ", "");
			//city=WordUtils.capitalizeFully(city);
			loan.setAddress(address);

		 
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
		  
		if(country==null||country=="" ||country.matches("[\\s]+"))
		{
			errors.rejectValue("country", "country","Country is required");

		}
		if(state==null||state=="" ||state.matches("[\\s]+"))
		{
			errors.rejectValue("state", "state","State is required");

		}
		// Validations for city
		loan.setCity(city.trim());
		if(city==null||city.trim().equals(""))
			{
				errors.rejectValue("city", "city","City is required");

			}
		else{
			  city=city.trim();
				city=city.replaceAll("\\s+", " ");
				//city = city.replace(" ", "");
				city=WordUtils.capitalizeFully(city);
				loan.setCity(city);

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
		//Validations for Pin Code
		loan.setPincode(pin.trim());
		if(pin==""||pin.trim().equals(""))
		{
			errors.rejectValue("pincode", "pincode","Pin Code is required");

		}
		else
		{
			  pin=pin.trim();
			
			pin = pin.replace(" ", "");
			
			loan.setPincode(pin);

		if(pin.length()<3||pin.length()>8)
		{
			 	errors.rejectValue("pincode", "pincode","Pin Code length is minimum 3 maximum 8");

		}
		else if(!pin.matches("^[0-9]+$"))
		{
			errors.rejectValue("pincode", "pincode","Pin Code shold conatain digits only");
		}
		}
		
		
		if(lestatus==null||lestatus=="" ||lestatus.matches("[\\s]+"))
		{
			errors.rejectValue("legalstatus", "legalstatus","Legal Status is required");

		}


		/*if(yincop==null||yincop=="" ||yincop.matches("[\\s]+"))
		{
		errors.rejectValue("yearofincorp", "yearofincorp","Year of Incorporation is required");

		}*/

		loan.setYearofincorp(yincop.trim());
		if(yincop==""||yincop.trim().equals(""))
		{
			errors.rejectValue("yearofincorp", "yearofincorp","Year of Incorporation is required");

		}
		else
		{
			yincop=yincop.trim();
			
			yincop =yincop.replace(" ", "");
			
			loan.setYearofincorp(yincop);

		if(yincop.length()!=4)
		{
			 	errors.rejectValue("yearofincorp", "yearofincorp","Year of Incorporation length must be 4 digits");

		}
		else if(!yincop.matches("^[0-9]+$"))
		{
			errors.rejectValue("yearofincorp", "yearofincorp","Year of Incorporation shold conatain digits only");
		}
		}		
		
		/*if(rocregno==null||rocregno=="" ||rocregno.matches("[\\s]+"))
		{
		errors.rejectValue("rocregno", "rocregno","Registration No is required");

		}*/

		loan.setRocregno(rocregno.trim());
		if(rocregno==""||rocregno.trim().equals(""))
		{
			errors.rejectValue("rocregno", "rocregno","Registration No is required");

		}
		else
		{
			rocregno=rocregno.trim();
			
			rocregno =rocregno.replace(" ", "");
			
			loan.setRocregno(rocregno);

			if(rocregno.length()<3||rocregno.length()>8)
			{
				 	errors.rejectValue("rocregno", "rocregno","Registration No length is minimum 3 maximum 8");

			}
		else if(!rocregno.matches("^[0-9]+$"))
		{
			errors.rejectValue("rocregno", "rocregno","Registration No shold conatain digits only");
		}
		}		
		
		if(ownership==null||ownership=="" ||ownership.matches("[\\s]+"))
		{
		errors.rejectValue("ownership", "ownership","Ownership  is required");

		}
		
		/*if(landline==null||landline=="" ||landline.matches("[\\s]+"))
		{
		errors.rejectValue("landline", "landline","Landline No is required");

		}*/
		   loan.setLandline(landline.trim());
		   landline=landline.trim();
		   landline= landline.replace(" ", "");
	       loan.setLandline(landline);
	       
	    	if(landline==null||landline.trim().equals(""))
	    	 {
	    	 	errors.rejectValue("landline", "landline","Landline No is required");

	    	 }

	    	else if(landline.length()<8||landline.length()>15)
	    	{
	    	 	errors.rejectValue("landline", "landline","Landline No length is minimum 8 and  maximum 15");

	    	}
	    	else if(!landline.matches("^[0-9]+$"))
	    	{
	    	 	errors.rejectValue("landline", "landline","Landline No should accepts numbers only");

	    	}
	    	else if(landline.substring(0,5).equals("00000"))
	    	{
	    	 	errors.rejectValue("landline", "landline","First 5 zero's are not allowed in Landline No");
	    	}
		
		
		/*if(noofbranches==null||noofbranches=="" ||noofbranches.matches("[\\s]+"))
		{
		errors.rejectValue("noofbranches", "noofbranches","No of Branches is required");

		}
*/
	    	
	    	loan.setNoofbranches(noofbranches.trim());
	    	noofbranches= noofbranches.replace(" ", "");
		    loan.setNoofbranches(noofbranches);
		    if(noofbranches==null||noofbranches.trim().equals(""))
		    	 {
		    	 	errors.rejectValue("noofbranches", "noofbranches","No of Branches is required");

		    	 }

		    	else if(noofbranches.length()<1||noofbranches.length()>5)
		    	{
		    	 	errors.rejectValue("noofbranches", "noofbranches","No of Branches length is minimum 1 and  maximum 5");

		    	}
		    	else if(!noofbranches.matches("^[0-9]+$"))
		    	{
		    	 	errors.rejectValue("noofbranches", "noofbranches","No of Branches should accepts numbers only");

		    	}
	
		    
		/*if(ncities==null||ncities=="" ||ncities.matches("[\\s]+"))
		{
		errors.rejectValue("nameofcities", "nameofcities","Name of cities is required");

		}
*/
		    loan.setNameofcities(ncities.trim());
		    ncities= ncities.replace(" ", "");
		    loan.setNameofcities(ncities);
		    if( ncities==null|| ncities.trim().equals(""))
		    	 {
		    	 	errors.rejectValue("nameofcities", "nameofcities","Name of cities is required");

		    	 }

		    	else if(ncities.length()<3|| ncities.length()>100)
		    	{
		    	 	errors.rejectValue("nameofcities", "nameofcities","Name of cities length is minimum 3 and  maximum 100");

		    	}
		    	else if(!ncities.matches("^[A-Za-z,]+$"))
		    	{
		    	 	errors.rejectValue("nameofcities", "nameofcities","Name of cities should accepts alphabets and , only");

		    	}
		
	/*if(nemps==null||nemps=="" ||nemps.matches("[\\s]+"))
		{
		errors.rejectValue("noofemployees", "noofemployees","No of employees is required");

		}
*/
		    loan.setNoofemployees(nemps.trim());
		    nemps= nemps.replace(" ", "");
		   loan.setNoofemployees(nemps);
		    if(nemps==null|| nemps.trim().equals(""))
		    	 {
		    	 	errors.rejectValue("noofemployees", "noofemployees","No of employees is required");

		    	 }

		    	else if(nemps.length()<1|| nemps.length()>10)
		    	{
		    	 	errors.rejectValue("noofemployees", "noofemployees","No of employees length is minimum 1 and  maximum 10");

		    	}
		    	else if(!nemps.matches("^[0-9]+$"))
		    	{
		    	 	errors.rejectValue("noofemployees", "noofemployees","No of employees should accepts numbers only");

		    	}

		   
		/*if(fax==null||fax=="" ||fax.matches("[\\s]+"))
		{
		errors.rejectValue("fax", "fax"," Fax is required");

		}*/

		    loan.setFax(fax.trim());
		    fax= fax.replace(" ", "");
		    loan.setFax(fax);
		    if(fax==null|| fax.trim().equals(""))
		    	 {
		    	 	errors.rejectValue("fax", "fax","Fax is required");

		    	 }

		    	else if(fax.length()<5|| fax.length()>20)
		    	{
		    	 	errors.rejectValue("fax", "fax","Fax length is minimum 5 and  maximum 20");

		    	}
		    	else if(!fax.matches("^[0-9]+$"))
		    	{
		    	 	errors.rejectValue("fax", "fax","Fax should accepts numbers only");

		    	}


		if(taxpaid==null||taxpaid=="" ||taxpaid.matches("[\\s]+"))
		{
		errors.rejectValue("taxpaid", "taxpaid","taxpaid is required");

		}

		/*if(regaddres==null||regaddres=="" ||regaddres.matches("[\\s]+"))
		{
		errors.rejectValue("regofcaddress", "regofcaddress","Office address is required");

		}*/
		
    	loan.setRegofcaddress(regaddres.trim());
    	 if(regaddres==null||regaddres.trim().equals(""))
    	{
    		errors.rejectValue("regofcaddress", "regofcaddress"," Office Address is required");

    	}else
    	{
    		regaddres=regaddres.trim();
    		regaddres=regaddres.replaceAll("\\s+", " ");
			//city = city.replace(" ", "");
			//city=WordUtils.capitalizeFully(city);
			loan.setRegofcaddress(regaddres);
    	
    	 
    		  if(regaddres.length()<4||regaddres.length()>100)
    		  {
    			  errors.rejectValue("regofcaddress", "regofcaddress"," Office Address length is  minimum 4 and maximum 100.");
    		  }
    		  else if (!regaddres.matches("^[a-zA-Z ]+[a-z A-Z0-9 :.#,/_-]+$")) {
    				errors.rejectValue("regofcaddress", "regofcaddress"," Office Address should starts with alphabets and followed by alphabets,numbers,spacial charecters(:.,#/_-)");
    		  }
    		
    		  
    		try{
					for(int i=0; i<regaddres.length()-1; i++)
			        {
			         char   ch1=regaddres.charAt(i);
			         char   ch2=regaddres.charAt(i+1);
					
			         String ch = Character.toString(ch1);
			      
			         String chs = Character.toString(ch2); 
			       
					if(ch.matches("^[,.#/:-]+$")&&chs.matches("^[.,#/:-]+$"))
					{
						errors.rejectValue("regofcaddress", "regofcaddress","Consecutive special characters(.,#/:-) are not allowed in Office Address.");
					
					}
					
				}
				}
				catch(Exception e)
				{e.printStackTrace();}
			}
    	 income=WordUtils.capitalizeFully(income);
    	 loan.setIncome(income.trim());
    	 if(income==null||income=="" ||income.matches("[\\s]+"))
    	 {
    	 	
    	 	errors.rejectValue("income", "income","Income is required");

    	 }
    	 else{
    	 	

    	 	income=income.trim();
    	 	income=income.replaceAll("\\s+", "");
    	 	income = income.replace(" ", "");

    	 	income=WordUtils.capitalizeFully(income);
    	    loan.setIncome(income);

    	 if(income.length()<3||income.length()>30)
    	 {
    	 	errors.rejectValue("income", "income","Income length is minimum 3 and maximum 30");
    	 }
    	 else if(!income.matches("^[0-9]+$"))
    	 {
    	 	errors.rejectValue("income", "income","Income accepts digits only");
    	 }

    	 }


    	 /*if(lamount==null||lamount=="" ||lamount.matches("[\\s]+"))
    	 {
    	 	errors.rejectValue("loanamount", "loanamount","Loan Amount is required");

    	 }*/
    	 loan.setLoanamount(lamount.trim());
    	 lamount=lamount.trim();
    	 lamount= lamount.replace(" ", "");
    	 loan.setLoanamount(lamount);


    	 if(lamount==null||lamount.trim().equals(""))
    	  {
    	  	errors.rejectValue("loanamount", "loanamount","Loan amount is required");

    	  }

    	 else if(lamount.length()<3||lamount.length()>30)
    	 {
    	  	errors.rejectValue("loanamount", "loanamount","Loan amount length is minimum 3 and  maximum 30");

    	 }
    	 else if(!lamount.matches("^[0-9]+$"))
    	 {
    	  	errors.rejectValue("loanamount", "loanamount","Loan amount should accepts numbers only");

    	 }
    	

    	
    	 if(banktype==null||banktype=="" ||banktype.matches("[\\s]+"))
    	 {
    	 	errors.rejectValue("banktype", "banktype","Bank type is required");

    	 }

    	 String tenture=loan.getTenture();

    	 tenture=WordUtils.capitalizeFully(tenture);
    	 loan.setTenture(tenture.trim());
    	 if(tenture==null||tenture=="" ||tenture.matches("[\\s]+"))
    	 {
    	 	
    	 	errors.rejectValue("tenture", "tenture","Tenture  is required");

    	 }
    	 else{
    	 	

    	 	tenture=tenture.trim();
    	 	tenture=tenture.replaceAll("\\s+", "");
    	 	tenture = tenture.replace(" ", "");

    	 	tenture=WordUtils.capitalizeFully(tenture);
    	 	loan.setTenture(tenture);

    	 if(tenture.length()<1||tenture.length()>5)
    	 {
    	 	errors.rejectValue("tenture", "tenture","Tenture length is minimum 1 and maximum 5");
    	 }
    	 else if(!tenture.matches("^[0-9]+$"))
    	 {
    	 	errors.rejectValue("tenture", "tenture","Tenture accepts digits only");
    	 }

    	 }
    	 
    	 
    		String status=loan.getStatus();
    		if(status==null||status=="" ||status.matches("[\\s]+"))
    		{
    			errors.rejectValue("status", "status","Status Type is required");

    		}	
	}

}
