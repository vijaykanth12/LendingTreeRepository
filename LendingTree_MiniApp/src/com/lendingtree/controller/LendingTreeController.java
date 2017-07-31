package com.lendingtree.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lendingtree.bean.AppLoanBean;
import com.lendingtree.bean.ApplicationLogBean;
import com.lendingtree.bean.ApplyLoanBean;
import com.lendingtree.bean.BankBean;
import com.lendingtree.bean.Changepassword;
import com.lendingtree.bean.DeptBean;
import com.lendingtree.bean.EmployeeBean;
import com.lendingtree.bean.GetLoanBean;
import com.lendingtree.bean.InterestBean;
import com.lendingtree.bean.LoanApplyBean;
import com.lendingtree.bean.LoanBean;
import com.lendingtree.bean.LoginBean;
import com.lendingtree.bean.LoginChkBean;
import com.lendingtree.bean.MessageBean;
import com.lendingtree.bean.RegistrationBean;
import com.lendingtree.bean.Transactionbean;
import com.lendingtree.bean.UploadFileBean;
import com.lendingtree.model.ApplicationLog;
import com.lendingtree.model.ApplyLoan;
import com.lendingtree.model.Bank;
import com.lendingtree.model.Dept;
import com.lendingtree.model.Employee;
import com.lendingtree.model.Loan;
import com.lendingtree.model.LoanApply;
import com.lendingtree.model.MessageModel;
import com.lendingtree.model.Registration;
import com.lendingtree.model.TransactionLog;
import com.lendingtree.model.UploadFile;
import com.lendingtree.model.UserRole;
import com.lendingtree.model.Userlist;
import com.lendingtree.model.Userslist;
import com.lendingtree.service.ApplyLoanService;
import com.lendingtree.service.BankService;
import com.lendingtree.service.DeptService;
import com.lendingtree.service.EmployeeService;
import com.lendingtree.service.LendingTreeService;
import com.lendingtree.service.LoanService;
import com.lendingtree.service.MessageModelService;
import com.lendingtree.service.RegistrationService;
import com.lendingtree.service.UploadFileService;
import com.lendingtree.validator.ABusinessLoanValidator;
import com.lendingtree.validator.AEducationLoanValidator;
import com.lendingtree.validator.AHomeLoanValidator;
import com.lendingtree.validator.APersonalLoanValidator;
import com.lendingtree.validator.AaBusinessLoanValidator;
import com.lendingtree.validator.AaEducationLoanValidator;
import com.lendingtree.validator.AaHomeLoanValidator;
import com.lendingtree.validator.AaPersonalLoanValidator;
import com.lendingtree.validator.ApplyLoanValidator;
import com.lendingtree.validator.BankValidator;
import com.lendingtree.validator.BusinessLoanValidator;
import com.lendingtree.validator.ChangePassword;
import com.lendingtree.validator.DeptValidator;
import com.lendingtree.validator.EducationLoanValidator;
import com.lendingtree.validator.EmployeeValidator;
import com.lendingtree.validator.HomeLoanValidator;
import com.lendingtree.validator.InterestValidator;
import com.lendingtree.validator.LendingtreeValidator;
import com.lendingtree.validator.LoanApplyValidator;
import com.lendingtree.validator.LoanValidator;
import com.lendingtree.validator.LoginChkValidator;
import com.lendingtree.validator.LoginValidator;
import com.lendingtree.validator.MessageValidator;
import com.lendingtree.validator.UserMsgValidator;
import com.lendingtree.validator.VBusinessLoanValidator;
import com.lendingtree.validator.VHomeLoanValidator;
import com.lendingtree.validator.VPersonalLoanValidator;
//import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@SuppressWarnings("unused")
@Controller
	
	public class LendingTreeController {
	@Autowired
	private RegistrationService regService;
	@Autowired
	private BankService bankService;
	@Autowired
	private EmployeeService empService;
	@Autowired
	private LoanService loanService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private ApplyLoanService apploanService;
	@Autowired
	private MessageModelService msgService;
	@Autowired
	private UploadFileService fileService;
	
	@Autowired
	private LendingTreeService lts;
	
	private Logger log = Logger.getLogger(LendingTreeController.class);
	
//Base Layout 
		
	@RequestMapping(value="/baseLayout" ,method = RequestMethod.GET)
		public ModelAndView index(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("baseLayout");			
		}
		
//Sessions 
		
		@RequestMapping(value="/psessionexpire" ,method = RequestMethod.GET)
		public ModelAndView psession(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("psessionexpire");			
		}
		
		@RequestMapping(value="/sessionexpire" ,method = RequestMethod.GET)
		public ModelAndView session(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("sessionexpire");			
		}
		
		@RequestMapping(value="/aboutus" ,method = RequestMethod.GET)
		public ModelAndView aboutus(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("aboutus");			
		}

//Emi calculator
		
		@RequestMapping(value="/emi" ,method = RequestMethod.GET)
		public ModelAndView emi(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			
			return new ModelAndView("emical");			
		}
		@RequestMapping(value="/emiuser" ,method = RequestMethod.GET)
		public ModelAndView emiuser(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			
			return new ModelAndView("emiu");			
		}

//Registration 
		
		@RequestMapping(value="/signup",method=RequestMethod.GET)
		public ModelAndView regStudent(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			
			return new ModelAndView("registration");
		}
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public ModelAndView reguser(@ModelAttribute("command") RegistrationBean bean,BindingResult result,HttpServletRequest request,Userslist uli,UserRole ur) throws IllegalAccessException, InvocationTargetException {
		
		try{
			
			
			Registration reg=new Registration();
			LendingtreeValidator valid=new LendingtreeValidator();
			valid.validate(bean,result);
			
			if(result.hasErrors())
			{
				return new ModelAndView("registration");
			}	 
			
			List<Registration> lis=regService.listUsers();
			System.out.println("The list is "+lis);
			if(lis.size()==0){
				  System.out.println("Running If loop");
				  bean.setType("ROLE_ADMIN");
				  //bean.setStatus(0);
				  BeanUtils.copyProperties(reg,bean);
				  regService.reguser(reg);
				
				// Spring security
				 
				  uli.setUsername(bean.getUsername());
				  uli.setPassword(bean.getPassword());
				  uli.setEnabled(false);
				  uli.setStatus("inactive");
				  regService.saveuserslist(uli); 
				  
				  ur.setRole(bean.getType());				  
				  ur.setUsersListModel(uli);
				  regService.saveuserrole(ur);		
				
				
				}
			
			else{
						bean.setType("ROLE_USER");
						//bean.setStatus(0);
						BeanUtils.copyProperties(reg,bean);
						regService.reguser(reg);
				
						// Spring security
				  
						uli.setUsername(bean.getUsername());
						uli.setPassword(bean.getPassword());
						uli.setEnabled(false);
						uli.setStatus("inactive");
						regService.saveuserslist(uli); 
				  
						ur.setRole(bean.getType());				  
						ur.setUsersListModel(uli);
						regService.saveuserrole(ur);	
				 }

// Email sending for admin and users
			
				String users=bean.getUsername();
				String pswd=bean.getPassword();
				String email=bean.getEmailid();
			
				final String Username = "schimaticsoft@gmail.com";
				final String Password = "Naresh@5009";
				HttpSession session1 = request.getSession(true);
				String r = null;
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");
				
				System.out.println("Email is running");
				Session session = Session.getDefaultInstance(props, 
					    new javax.mail.Authenticator(){
					        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					           return new PasswordAuthentication(
					            		"schimaticsoft@gmail.com", "Naresh@5009");
					        }
					});

				 String link = "http://localhost:2222/LendingTree_MiniApp/Active.html?user="+users;
		         StringBuilder bodyText = new StringBuilder(); 
		            bodyText.append("<div>")
		                 .append("  Dear User <br/><br/>")
		                  .append("Your profile is successfully registered with us.<br/>")
		                 .append("Your Username  is : "
		 						+users
		 						+"<br/>"
								+ " Your Password is:"
								+ pswd
								+"<br/>")
		              
		                 .append("<a href=\""+link+"\">"+"Click here to activate your account"+"</a>")
		                 .append("  <br/><br/>")
		                 .append("  Thanks,<br/>")
		                 .append("</div>");

					Message message = new MimeMessage(session);
				
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(email));
				
					message.setSubject("Your Profile is created successfully");
					
			        message.setContent(bodyText.toString(), "text/html; charset=utf-8");
				
				
				    Transport.send(message);						
					System.out.println("Mail sent successfuly");

		}
		catch(Exception e)
		{
			log.error("Lending Tree System ::LendingTreeController ::RegistrationSave",e);
		}
		
		
				return new ModelAndView("regsuccess");
		
		}
		
		@RequestMapping(value="/Active",method=RequestMethod.GET)
		public ModelAndView activateuser(@ModelAttribute("command")Userslist uli,HttpServletRequest request) {
			System.out.println(" Activate user is running");
			Registration reg=new Registration();
		
			 String un=request.getParameter("user");
			 System.out.println("Printing username is "+un);
			
	    	 regService.activateuser(un);
			
			return new ModelAndView("activateusersuccess");
		
		}

//Login
		
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginpage(@RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout,ModelAndView model)
	{
		
		if (error!= null) {
			model.addObject("error", "Invalid Username and Password");
			System.out.println("Error is not null : so error is adding in the "
					+ "mylogin controller : error:" + error + ":");
			
		}
		
		model.setViewName("login");
		model.addObject("command",new RegistrationBean());
		return model;
		
	}
	
	//for 403 access denied page
		
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
		public ModelAndView accesssDenied() {

		  ModelAndView model = new ModelAndView();

		  //check if user is login
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		  }

		  model.setViewName("403");
		  return model;

	}
	@RequestMapping(value="/log" ,method = RequestMethod.GET)
	public  ModelAndView getStudents(@ModelAttribute("command")RegistrationBean bean,BindingResult result,HttpServletResponse response, HttpServletRequest request,Principal prince){
	
		ApplicationLog almodel=new ApplicationLog();
		ApplicationLogBean albean=new ApplicationLogBean();
		EmployeeBean beans=new EmployeeBean();
		
	try{
	try{
		
		/*LoginValidator validd=new LoginValidator();
		validd.validate(bean,result);
		if(result.hasErrors())
		{
			return new ModelAndView("login");
			
		}	*/	
		
		bean.setUsername(prince.getName());
		
		Registration reg=new Registration();
		
		BeanUtils.copyProperties(bean,reg);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   		String username = auth.getName();
   		String pwd = (String) auth.getCredentials();              // Getting Password
   		
   		String uname=prince.getName();
   		
   		bean.setPassword(pwd);
		
		/*String uname=bean.getUsername();
		String pwd=bean.getPassword();*/
		System.out.println("The username is "+uname);
		System.out.println("The password  is "+pwd);
		HttpSession ses=request.getSession();
		
		ses.setMaxInactiveInterval(60*3);
		
		ses.setAttribute("username", uname);
		ses.setAttribute("password", pwd);
		regService.getStudent(bean);
		
		List<Registration> lis=regService.getUser(uname,pwd);
		System.out.println("Printing lis is  "+lis.size());
		ses.setAttribute("list", lis);
		  // From Employee Model 
		
		Authentication auths = SecurityContextHolder.getContext().getAuthentication();
   		String uns= auth.getName();
   		String pwds = (String) auth.getCredentials();              // Getting Password
   		
   		String un=prince.getName();
		
		System.out.println(" The value of un is "+un);
		System.out.println(" The value of pwds is "+pwds);
		
		/*String un=beans.getUsername();              
 		String pwds=beans.getPassword();*/
		ses.setAttribute("un", un);
		ses.setAttribute("pwds", pwds);
		List<Employee> lt=empService.getEmpss(un,pwds);
		ses.setAttribute("emplist",lt);
		System.out.println("The List size is........"+lt);

		InetAddress ip = InetAddress.getLocalHost();
        String hostname = ip.getHostName();
        Date dt=new Date();
  		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
  		String sd=sdf.format(dt);
  		ses.setAttribute("logintime", sd);
  		
  		String s=ip.toString();
  		albean.setIp(s);
  		albean.setHostname(hostname);
  		albean.setUserame(uname);
  		albean.setLogindate(sd);
		
		
		if(lis.size()>0)
		 {
			
			
		    @SuppressWarnings("rawtypes")
			Iterator it = lis.iterator();
				while (it.hasNext()) 
				{
					Registration std=(Registration)it.next();
					String typename=std.getType();
				
					
					
						albean.setType(typename);
						Integer status=std.getStatus();
					
							if(typename.matches("ROLE_ADMIN"))
							{
						
								albean.setOpenPage("AdminLoginSuccess");
								BeanUtils.copyProperties(almodel, albean);
								regService.appLog(almodel);
							    return new ModelAndView("adhomes"); 	
						
							}
							else
							{
								albean.setOpenPage("UserLoginSuccess");
								BeanUtils.copyProperties(almodel, albean);
								regService.appLog(almodel);
								return new ModelAndView("userhome"); 	
							}
				}
		 }		
	 
		 if(lt.size()>0)
		 {
			 System.out.println("Running Employee login if ");
			 @SuppressWarnings("rawtypes")
			 Iterator its = lt.iterator();
				while (its.hasNext()) 
				{
					Employee emp=(Employee)its.next();
					String dept=emp.getDept();
					String type=emp.getType();
					/*if(dept.matches("Pickup"))
					{
						return new ModelAndView("picdept"); 	
					}*/
					 if(type.matches("ROLE_DEPT"))
					{
						 
						albean.setType(dept);
						albean.setOpenPage("VerificationLoginSuccess");
	 	    			BeanUtils.copyProperties(almodel, albean);
	 	    			regService.appLog(almodel);
						return new ModelAndView("verdept"); 	
					}
					/*else if(dept.matches("Legal"))
					{
						return new ModelAndView("legdept"); 	
					}*/
				}
		 }
		 	
	}
	catch(Exception e){
	System.out.println(e);
	 
 }
	
	}
	catch(Exception e)
	{
		log.error("Lending Tree System ::LendingTreeController ::Login",e);
	}
		return new ModelAndView("LogFailure");
	}
//forgot password
		
	@RequestMapping(value="/forgotpassword",method=RequestMethod.GET)
	public ModelAndView forgotpassword(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
	{
		return new ModelAndView("forgotpage");
	}
	
		@RequestMapping(value="/forgotpass" ,method = RequestMethod.POST)
		public  ModelAndView forgetpass(@ModelAttribute("command")  RegistrationBean bean,BindingResult result,HttpServletResponse response, HttpServletRequest request) throws IOException{
		try{
		String user=bean.getUsername();
		String email=bean.getEmailid();
		String fn=bean.getFirstname();
		List<Registration> li=null;
		String ps="";
		try{
				li=regService.forgotpass(user,email);
				ps=li.get(0).getPassword();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				if(li.size()>0)
				{
					 final String Username = "schimaticsoft@gmail.com";
						final String Password = "Naresh@5009";
						String r = null;
			
				//E-Mail id for forgot password
				
					System.out.println("username................."+bean.getUsername());
					System.out.println("Firstname ********"+bean.getFirstname());
					HttpSession session1 = request.getSession(true);
					Properties props = new Properties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
						System.out.println("coming to email");
						Session session = Session.getDefaultInstance(props, 
							    new javax.mail.Authenticator(){
							        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
							           return new PasswordAuthentication(
							            		"schimaticsoft@gmail.com", "Naresh@5009");
							        }
							});
						try {

							Message message = new MimeMessage(session);
							message.setFrom(new InternetAddress(Username));
							message.setRecipients(Message.RecipientType.TO,
									InternetAddress.parse( bean.getEmailid()));
							System.out.println("comming email");	
							message.setSubject("Your Lending tree Login Details");
							try{
							message.setText("Hello"+ "\n You can login with below details."+"\n\nYour Username: "
										+user
										+ " \nYour Password:"
										+ ps+"\n\n\n We appreciate your business and, as always, if you have any questions or need assistance don't hesitate in contacting us"+"\n\n https://lendongtreesystem.co.in/login.htm");
							}catch(Exception e){}
							System.out.println("comin to email lasttttttttt");	
						
							  Transport.send(message);					
							System.out.println("password sent successfuly");

							System.out.println("Done");
							
						} 
						catch (MessagingException e1) {
							throw new RuntimeException(e1);
						}
						
						return new ModelAndView ("forgotsuccess");
				}
				
		}
		catch(Exception e)
		{
			log.error("Lending Tree System ::LendingTreeController ::ForgotPassword",e);
		}
				return new ModelAndView ("forgotfail");
				}
// Interest
		
		@RequestMapping(value="/interest" ,method = RequestMethod.GET)
		public ModelAndView interest(@ModelAttribute("command") GetLoanBean bean,BindingResult result)
		{
			return new ModelAndView("interestgrid");			
		}
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/InterestDisplayGrid", method = RequestMethod.GET)
		public List InterestGrid(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletResponse response) throws IOException {
		
			PrintWriter out=null;
			out=response.getWriter();
			System.out.println("enter into datagrid list");
			List<Loan> li=loanService.getLoans();
			System.out.println("list size is: "+li.size());
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"li"});
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray array = JSONArray.fromObject(li,jsonConfig);
			System.out.println(array);
			out.print(array);
			out.flush();
		    out.close();
			return array;
		}
		
		//View Interest rate module
		@RequestMapping(value="/viewinterest" ,method = RequestMethod.GET)
		public ModelAndView viewInterestrate(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletResponse response, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
			
		
			return new ModelAndView("viewinterest");			
		}	
		
		@RequestMapping(value="/getinterestrates" ,method = RequestMethod.GET)
		public ModelAndView getInterestrate(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletResponse response, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
			try{
			InterestValidator valid=new InterestValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("viewinterest");
				
			}	 
			
			String loantype=bean.getLoantype();
			String bank=bean.getBname();
			HttpSession ses=request.getSession();
			ses.setAttribute("loan", loantype);
			ses.setAttribute("bank", bank);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::Get Interest Rates",e);
			}
			return new ModelAndView("viewinterestgrid");			
		}	
	
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/interestgrid", method = RequestMethod.GET)
		public List viewinterestdisplaygrid(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out=null;
		out=response.getWriter();
		System.out.println("enter into datagrid list");
		HttpSession ses=request.getSession(false);
		String loantype=(String) ses.getAttribute("loan");
		String bank=(String) ses.getAttribute("bank");
		List<Loan> lis=loanService.getInterestrates(loantype);
		System.out.println("list size is: "+lis.size());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"lis"});
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray array = JSONArray.fromObject(lis,jsonConfig);
		System.out.println(array);
		out.print(array);
		out.flush();
	    out.close();
		return array;
		}		
		
// Checking user name availability in registration 
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/checkuser",method=RequestMethod.GET)
		public List checkStudent(@ModelAttribute("command")RegistrationBean bean,BindingResult result,HttpServletResponse response) throws IOException
		{
			System.out.println("Check user is running");
			try{
				System.out.println("Try block is running");
				PrintWriter pt=response.getWriter();
				List<Registration> lis=regService.listUsers();
				String k=bean.getUsername();
				System.out.println(" Printing list of registration is"+lis.size());
				if(lis.size()>0)
				{
				Iterator itt=lis.iterator();
				while(itt.hasNext()) 
			        {
					 	Registration std=(Registration)itt.next();
			        	if(k==null)
			        	{
			        		k=(std.getUsername());
			        		
			        	}
			        	else
			        	{
			        		k=k+","+std.getUsername();
			        		
			        	}
			        	
			        }
				 pt.println(k);
				 System.out.println("Printing value of k......");
				 System.out.println(k);
			      }
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::checkuser",e);
			}
						return null;
			}
// Checking User name in employee model
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/checkuseremp",method=RequestMethod.GET)
		public List checkUserEmp(@ModelAttribute("command")RegistrationBean bean,BindingResult result,HttpServletResponse response) throws IOException
		{
			try{
				
			PrintWriter pt=response.getWriter();
			List<Employee> lis=empService.listUsers();
			String k=bean.getUsername();
			if(lis.size()>0)
			{
				Iterator itt=lis.iterator();
				while(itt.hasNext()) 
			        {
					 	Employee std=(Employee)itt.next();
			        	if(k==null)
			        	{
			        		k=(std.getUsername());
			        		
			        	}
			        	else
			        	{
			        		k=k+","+std.getUsername();
			        		
			        	}
			        	
			        }
				 pt.println(k);
				 System.out.println(k);
			      }
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::checkuseremp",e);
			}
						return null;
			}

		// Checking user name availability in Employee Add
		
				@SuppressWarnings("rawtypes")
				@RequestMapping(value="/checkuseree",method=RequestMethod.GET)
				public List checkStudentEmp(@ModelAttribute("command")EmployeeBean bean,BindingResult result,HttpServletResponse response) throws IOException
				{
					try{
					PrintWriter pt=response.getWriter();
					List<Registration> lis=regService.listUsers();
					String k=bean.getUsername();
					if(lis.size()>0)
					{
						Iterator itt=lis.iterator();
						while(itt.hasNext()) 
					        {
							 	Registration std=(Registration)itt.next();
					        	if(k==null)
					        	{
					        		k=(std.getUsername());
					        	}
					        	else
					        	{
					        		k=k+","+std.getUsername();
					        		
					        	}
					        	
					        }
						 pt.println(k);
						 System.out.println(k);
					      }
					}
					catch(Exception e)
					{
						log.error("Lending Tree System ::LendingTreeController ::checkuseree",e);
					}
								return null;
					}
		// Checking User name in employee model
				
				@SuppressWarnings("rawtypes")
				@RequestMapping(value="/checkuseremps",method=RequestMethod.GET)
				public List checkUserEmpp(@ModelAttribute("command")EmployeeBean bean,BindingResult result,HttpServletResponse response) throws IOException
				{
					try{
						
					PrintWriter pt=response.getWriter();
					List<Employee> lis=empService.listUsers();
					String k=bean.getUsername();
					if(lis.size()>0)
					{
						Iterator itt=lis.iterator();
						while(itt.hasNext()) 
					        {
							 	Employee std=(Employee)itt.next();
					        	if(k==null)
					        	{
					        		k=(std.getUsername());
					        		
					        	}
					        	else
					        	{
					        		k=k+","+std.getUsername();
					        		
					        	}
					        	
					        }
						 pt.println(k);
						 System.out.println(k);
					      }
					}
					catch(Exception e)
					{
						log.error("Lending Tree System ::LendingTreeController ::checkuseremps",e);
					}
								return null;
					}
//Admin 
		
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/adminupdate" ,method = RequestMethod.GET)
		public ModelAndView adminupdate(@ModelAttribute("command")RegistrationBean bean,BindingResult result,HttpServletResponse response, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
			try{
			Registration reg=null;
			HttpSession ses=request.getSession(false);
			String uname=(String) ses.getAttribute("username");
			String pwd=(String) ses.getAttribute("password");
			List<Registration>  lis= regService.getUser(uname,pwd);
			
			for (Iterator iterator = lis.iterator(); iterator.hasNext();) {
				 reg = (Registration) iterator.next();
			}
			BeanUtils.copyProperties(bean,reg);
			
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::adminupdate",e);
			}
			return new ModelAndView("adminedit");			
		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/adminDisplayGrid", method = RequestMethod.GET)
		public List admin(@ModelAttribute("command")RegistrationBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		PrintWriter out=null;
		out=response.getWriter();
		
		HttpSession ses=request.getSession(false);
		List li=(List) ses.getAttribute("list");
		System.out.println("enter into datagrid list");
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"li"});
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray array = JSONArray.fromObject(li,jsonConfig);
		System.out.println(array);
		out.print(array);
		out.flush();
	    out.close();
		return array;
		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/editadmin" ,method = RequestMethod.GET)
		public ModelAndView editadmin(@ModelAttribute("command")RegistrationBean bean,BindingResult result,HttpServletResponse response, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
			try{
			Registration reg=null;
			List<Registration> li=regService.getRegId(bean.getId());
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				 reg = (Registration) iterator.next();
			}
			BeanUtils.copyProperties(bean,reg);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::editadmin",e);
			}
		
		
			return new ModelAndView("adminedit");			
		}
		@RequestMapping(value="/adminsaveupdate" ,method = RequestMethod.GET)
		public ModelAndView adminsaveus(@ModelAttribute("command")RegistrationBean bean,BindingResult result) throws IllegalAccessException, InvocationTargetException
		{
			try{
			Registration reg=new Registration();
			
			LendingtreeValidator valid=new LendingtreeValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("adminedit");
				
			}	 
			
			
			BeanUtils.copyProperties(reg,bean);
			regService.editUser(reg);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::adminsaveupdate",e);
			}
			return new ModelAndView("upprofilesuccess");	
			
		}
		@RequestMapping(value="/adminchpwd" ,method = RequestMethod.GET)
		public ModelAndView adminchpwd(@ModelAttribute("command")Changepassword bean,BindingResult result)
		{
			return new ModelAndView("adminchpwd");			
		}
		
		
		@RequestMapping(value="/adminchpwdupdate" ,method = RequestMethod.POST)
		public ModelAndView uppwdsuccess(@ModelAttribute("command")Changepassword bean,BindingResult result,HttpServletResponse response,HttpServletRequest request)
		{
			try{
			HttpSession ses=request.getSession(false);
			String uname=(String) ses.getAttribute("username");
			String pwd=(String) ses.getAttribute("password");
			List<Registration>  lis= regService.getUser(uname,pwd);
			
			Integer id=lis.get(0).getId();
			String password=lis.get(0).getPassword();
			String currentpassword=bean.getPassword();
			String newpassword=bean.getNewpassword();
			System.out.println("new password is "+newpassword);
			String confirmnewpwd=bean.getConfirmnewpassword();
			
			ChangePassword valid=new ChangePassword(); //change password validations
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("adminchpwd");
				
			}	 
			if(password.equals(currentpassword))
			{
				if(newpassword.equals(confirmnewpwd))
				{
					
					regService.adminchangePassword(id,newpassword,confirmnewpwd);
					return new ModelAndView("uppwdsuccess");
				}
			}
			else
			{
		     return new ModelAndView("uppwdfail");
			}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::adminchpwd",e);
			}
			return new ModelAndView("uppwdfail");
		 }
			
		
// Admin Module 
		@RequestMapping(value="/adhome" ,method = RequestMethod.GET)
		public ModelAndView asindex(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("adhomes");			
		}
		@RequestMapping(value="/adhomee" ,method = RequestMethod.GET)
		public ModelAndView asindexs(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("adhomess");			
		}
		//Bank management
		@RequestMapping(value="/bank" ,method = RequestMethod.GET)
		public ModelAndView banka(@ModelAttribute("command")BankBean bean,BindingResult result)
		{
			return new ModelAndView("bankm");			
		}
		@RequestMapping(value="/addbanks" ,method = RequestMethod.GET)
		public ModelAndView bankadd(@ModelAttribute("command")BankBean bean,BindingResult result)
		{
			return new ModelAndView("bankadd");			
		}
		
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/banksave" ,method = RequestMethod.POST)
		public ModelAndView addbanksaves(@ModelAttribute("command")BankBean bean,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
		
			
			try{
			BankValidator valid=new BankValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("bankadd");
				
			}
			TransactionLog tllog=new TransactionLog();
			
			Transactionbean tlbean=new Transactionbean();
			Date dt=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
       		String sd=sdf.format(dt);
       		HttpSession hs=request.getSession(false); 
       
       		List li=(List)hs.getAttribute("list");
       	
       		Iterator it=li.iterator();
       	 
       		String un=null,tp=null;
       		while(it.hasNext())
       		{
       			Registration rr=(Registration)it.next();
       			un=rr.getUsername();
       		    tp=rr.getType();
       			
       		}
       	
		 tlbean.setUsername(un);
       	 tlbean.setType(tp);
       	 tlbean.setTask("New Bank Details Added");
       	 tlbean.setTaskdt(sd);
       	 BeanUtils.copyProperties(tllog, tlbean);
       	 regService.Transactionlogdetails(tllog);
       	 
       	 	Bank bank=new Bank();
			BeanUtils.copyProperties(bank,bean);
			
			//bankService.addbank(bank);
			lts.add(bank);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::banksave",e);
			}
			return new ModelAndView("bankaddsuccess");			
		}
	
			 
// Display Grid
		
		@RequestMapping(value="/DisplayGrid", method = RequestMethod.GET)
		public void listStudent(@ModelAttribute("command")BankBean bean,BindingResult result,HttpServletResponse response) throws IOException {
		PrintWriter out=null;
		out=response.getWriter();
		System.out.println("enter into datagrid list");
		List<Bank> li=bankService.getBanks();
		System.out.println("list size is: "+li.size());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"li"});
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray array = JSONArray.fromObject(li,jsonConfig);
		System.out.println(array);
		out.print(array);
		out.flush();
	    out.close();
		//return array;
		}
		@RequestMapping(value="/bankaddgrid" ,method = RequestMethod.GET)
		public ModelAndView addbankgrid(@ModelAttribute("command")BankBean bean,BindingResult result)
		{
			return new ModelAndView("bankm");			
		}
		// Update Bank
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/updatebank" ,method = RequestMethod.GET)
		public ModelAndView updatebank(@ModelAttribute("command")BankBean bean,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
			try{
			
			Bank bank=null;
			List<Bank> li=bankService.getBankId(bean.getId());
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				 bank = (Bank) iterator.next();
			}
			TransactionLog tllog=new TransactionLog();
			Transactionbean tlbean=new Transactionbean();
			Date dt=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
       		String sd=sdf.format(dt);
       		HttpSession hs=request.getSession(false); 
        
       		List liw=(List)hs.getAttribute("list");
       	
       		Iterator it=liw.iterator();
       	 
       		String un=null,tp=null;
       		while(it.hasNext())
       		{
       			Registration rr=(Registration)it.next();
       			un=rr.getUsername();
       			tp=rr.getType();
       		}
       	 tlbean.setUsername(un);
       	 tlbean.setType(tp);
       	 tlbean.setTask("Bank Details Updated");
       	 tlbean.setTaskdt(sd);
       	 BeanUtils.copyProperties(tllog, tlbean);
       	 regService.Transactionlogdetails(tllog);
			BeanUtils.copyProperties(bean,bank);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::updatebank",e);
			}
			return new ModelAndView("bankupdate");			
		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/bankupdate" ,method = RequestMethod.POST)
		public ModelAndView updatebanks(@ModelAttribute("command")BankBean bean,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
			try{
		
			BankValidator valid=new BankValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("bankupdate");
				
			}
			TransactionLog tllog=new TransactionLog();
			Transactionbean tlbean=new Transactionbean();
			Date dt=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
       		String sd=sdf.format(dt);
       		HttpSession hs=request.getSession(false); 
       
       		List liw=(List)hs.getAttribute("list");
       	
       		Iterator it=liw.iterator();
       	 
       		String un=null,tp=null;
       		while(it.hasNext())
       		{
       			Registration rr=(Registration)it.next();
       			un=rr.getUsername();
       			tp=rr.getType();
       		}
       	 tlbean.setUsername(un);
       	 tlbean.setType(tp);
       	 tlbean.setTask("Bank Details Updated");
       	 tlbean.setTaskdt(sd);
       	 BeanUtils.copyProperties(tllog, tlbean);
       	 regService.Transactionlogdetails(tllog);
			Bank bank=new Bank();
			BeanUtils.copyProperties(bank,bean);
			//bankService.editBank(bank);
			lts.edit(bank);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::bankupdate",e);
			}
			return new ModelAndView("bankupdatesuccess");	
			
		}
		@RequestMapping(value="/bankupdategrid" ,method = RequestMethod.GET)
		public ModelAndView updatebankgrid(@ModelAttribute("command")BankBean bean,BindingResult result)
		{
			return new ModelAndView("bankm");			
		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/deletebank" ,method = RequestMethod.POST)
		public ModelAndView deletebank(@ModelAttribute("command")BankBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
TransactionLog tllog=new TransactionLog();
			
			Transactionbean tlbean=new Transactionbean();
			Date dt=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
       		String sd=sdf.format(dt);
       		HttpSession hs=request.getSession(false); 
       
       		List li=(List)hs.getAttribute("list");
       	
       		Iterator it=li.iterator();
       	 
       		String un=null,tp=null;
       		while(it.hasNext())
       		{
       			Registration rr=(Registration)it.next();
       			un=rr.getUsername();
       			tp=rr.getType();
       		}
       	 tlbean.setUsername(un);
       	 tlbean.setType(tp);
       	 tlbean.setTask("Bank Deleted");
       	 tlbean.setTaskdt(sd);
       	 BeanUtils.copyProperties(tllog, tlbean);
       	 regService.Transactionlogdetails(tllog);
       	 
			try{
			String ids=request.getParameter("id");
			String[] ids1=ids.split(",");
			String id="";
			try{
					for(int i=0;i<=ids1.length;i++)
					{
						id=ids1[i];
						bankService.deleteBank(id);
						
					}
				}
			catch(Exception e){
				System.out.println("deleted ids"+e);
			}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::deletebank",e);
			}
				return new ModelAndView("deletebanksuccess");
			}
			
		@RequestMapping(value="/bankdeletegrid" ,method = RequestMethod.GET)
		public ModelAndView deletebanksuccess(@ModelAttribute("command")RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("bankm");			
		}
		
//Loan management 
		
		@RequestMapping(value="/loan" ,method = RequestMethod.GET)
		public ModelAndView loan(@ModelAttribute("command")LoanBean bean,BindingResult result)
		{
			return new ModelAndView("loank");			
		}
		
		@RequestMapping(value="/addloan" ,method = RequestMethod.GET)
		public ModelAndView addloan(@ModelAttribute("command")LoanBean bean,BindingResult result)
		{
			return new ModelAndView("addloan");			
		}
		@RequestMapping(value="/loansave" ,method = RequestMethod.POST)
		public ModelAndView loansave(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanValidator valid=new LoanValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("addloan");
				
			}
			TransactionLog tllog=new TransactionLog();
			
			Transactionbean tlbean=new Transactionbean();
			Date dt=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
       		String sd=sdf.format(dt);
       		HttpSession hs=request.getSession(false); 
       
       		List li=(List)hs.getAttribute("list");
       	
       		Iterator it=li.iterator();
       	 
       		String un=null,tp=null;
       		while(it.hasNext())
       		{
       			Registration rr=(Registration)it.next();
       			un=rr.getUsername();
       			tp=rr.getType();
       		}
       	  tlbean.setUsername(un);
       	  tlbean.setType(tp);
          tlbean.setTask("New Loan Details Added");
          tlbean.setTaskdt(sd);
        	 BeanUtils.copyProperties(tllog, tlbean);
        	 regService.Transactionlogdetails(tllog);
			Loan loan=new Loan();
			BeanUtils.copyProperties(loan,bean);
			//loanService.addloan(loan);
			lts.add(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::loansave",e);
			}
			return new ModelAndView("loansave");
		}
		
		@RequestMapping(value="/LoanDisplayGrid", method = RequestMethod.GET)
		public void listLoan(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletResponse response) throws IOException {
				PrintWriter out=null;
				out=response.getWriter();
				System.out.println("enter into datagrid list");
				List<Loan> li=loanService.getLoans();
				System.out.println("list size is: "+li.size());
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setExcludes(new String[]{"li"});
				jsonConfig.setIgnoreDefaultExcludes(false);
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				JSONArray array = JSONArray.fromObject(li,jsonConfig);
				System.out.println(array);
				out.print(array);
				out.flush();
			    out.close();
				//return array;
			}
		 
		
	@RequestMapping(value="/loanaddgrid" ,method = RequestMethod.GET)
	public ModelAndView loanaddgrid(@ModelAttribute("command")LoanBean bean,BindingResult result)
	{
		return new ModelAndView("loank");			
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/bankloanadd",method=RequestMethod.GET)
	public  ModelAndView displaybank(@ModelAttribute("command")BankBean bean,BindingResult result,HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		try{
		System.out.println("Controller is running");
		PrintWriter out=null;
		String ps=null;
		out=response.getWriter();	
		List<Bank> li=bankService.listBanks();
		System.out.println("loan list issssssssss"+li);
		Iterator itr = li.iterator();
		System.out.println(li.size());
		if(li.size()>0)
		{
		
			while(itr.hasNext())
			{
				ps = (String) itr.next();
				ps=ps+",";
				out.println(ps);
				
			}
			
	}
		}
		catch(Exception e)
		{
			log.error("Lending Tree System ::LendingTreeController ::bankloanadd",e);
		}
		return null;
	
					
		}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/updateloan" ,method = RequestMethod.GET)
	public ModelAndView updateloanws(@ModelAttribute("command")LoanBean bean,BindingResult result) throws IllegalAccessException, InvocationTargetException
	{
		try{
		Loan loan=null;
		List<Loan> li=loanService.getLoanId(bean.getId());
		for (Iterator iterator = li.iterator(); iterator.hasNext();) {
			 loan = (Loan) iterator.next();
			
		}
		BeanUtils.copyProperties(bean,loan);
		}
		catch(Exception e)
		{
			log.error("Lending Tree System ::LendingTreeController ::updateloan",e);
		}
		return new ModelAndView("updateloan");	
		
	}
	
	@RequestMapping(value="/loanupdatesave" ,method = RequestMethod.POST)
	public ModelAndView updateloans(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
	{
		try{
		LoanValidator valid=new LoanValidator();
		valid.validate(bean,result);
		if(result.hasErrors())
		{
			return new ModelAndView("updateloan");
			
		}	 
		TransactionLog tllog=new TransactionLog();
		
		Transactionbean tlbean=new Transactionbean();
		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
   		String sd=sdf.format(dt);
   		HttpSession hs=request.getSession(false); 
   
   		List li=(List)hs.getAttribute("list");
   	
   		Iterator it=li.iterator();
   	 
   		String un=null,tp=null;
   		while(it.hasNext())
   		{
   			Registration rr=(Registration)it.next();
   			un=rr.getUsername();
   			tp=rr.getType();
   		}
   		tlbean.setUsername(un);
   		tlbean.setType(tp);
   		tlbean.setTask("Loan Details Updated");
   		tlbean.setTaskdt(sd);
   		BeanUtils.copyProperties(tllog, tlbean);
   		regService.Transactionlogdetails(tllog);
		Loan loan=new Loan();
		BeanUtils.copyProperties(loan,bean);
		//loanService.editLoan(loan);
		lts.edit(loan);
		}
		catch(Exception e)
		{
			log.error("Lending Tree System ::LendingTreeController ::loanupdatesave",e);
		}
		return new ModelAndView("loanupdatesuccess");	
		
	}
	@RequestMapping(value="/deleteloan" ,method = RequestMethod.POST)
	public ModelAndView deleteloan(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
	{
		TransactionLog tllog=new TransactionLog();
		
		Transactionbean tlbean=new Transactionbean();
		Date dt=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
   		String sd=sdf.format(dt);
   		HttpSession hs=req.getSession(false); 
   
   		List li=(List)hs.getAttribute("list");
   	
   		Iterator it=li.iterator();
   	 
   		String un=null,tp=null;
   		while(it.hasNext())
   		{
   			Registration rr=(Registration)it.next();
   			un=rr.getUsername();
   			tp=rr.getType();
   		}
   		tlbean.setUsername(un);
   		tlbean.setType(tp);
   		tlbean.setTask("Loan Deleted");
   		tlbean.setTaskdt(sd);
   		BeanUtils.copyProperties(tllog, tlbean);
   		regService.Transactionlogdetails(tllog);
		try{
			String ids=req.getParameter("id");
			String[] ids1=ids.split(",");
			String id="";
			try{
					for(int i=0;i<=ids1.length;i++)
					{
						id=ids1[i];
						loanService.deleteLoan(id);
						
					}
				}
			catch(Exception e){
				System.out.println("deleted ids"+e);
			}
		}
		catch(Exception e)
		{
			log.error("Lending Tree System ::LendingTreeController ::deleteloan",e);
		}
		return new ModelAndView("loandeletesuccess");
			}
//Department management
		
	@RequestMapping(value="/dept" ,method = RequestMethod.GET)
		public ModelAndView dept(@ModelAttribute("command")DeptBean bean,BindingResult result)
		{
			return new ModelAndView("deptm");			
		}
		
		@RequestMapping(value="/deptaddgrid" ,method = RequestMethod.GET)
		public ModelAndView deptaddgrid(@ModelAttribute("command")DeptBean bean,BindingResult result)
		{
			return new ModelAndView("deptm");			
		}
		@RequestMapping(value="/adddept" ,method = RequestMethod.GET)
		public ModelAndView adddept(@ModelAttribute("command")DeptBean bean,BindingResult result)
		{
			return new ModelAndView("deptadd");			
		}
	
		@RequestMapping(value="/deptsave" ,method = RequestMethod.POST)
		public ModelAndView savedept(@ModelAttribute("command")DeptBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
			try{
			System.out.println("save dept method is running");
			DeptValidator valid=new DeptValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("deptadd");
				
			}
			TransactionLog tllog=new TransactionLog();
			
			Transactionbean tlbean=new Transactionbean();
			Date dt=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
	   		String sd=sdf.format(dt);
	   		HttpSession hs=request.getSession(false); 
	   
	   		List li=(List)hs.getAttribute("list");
	   	
	   		Iterator it=li.iterator();
	   	 
	   		String un=null,tp=null;
	   		while(it.hasNext())
	   		{
	   			Registration rr=(Registration)it.next();
	   			un=rr.getUsername();
	   			tp=rr.getType();
	   		}
	   	 tlbean.setUsername(un);
	   	 tlbean.setType(tp);
	   	 tlbean.setTask("New Department Added");
	   	 tlbean.setTaskdt(sd);
	   	 BeanUtils.copyProperties(tllog, tlbean);
	   	 regService.Transactionlogdetails(tllog);
			
	   	 Dept dept=new Dept();
	   	 BeanUtils.copyProperties(dept,bean);
		    deptService.adddept(dept);
			//lts.add(dept);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::deptsave",e);
			}
			return new ModelAndView("deptsave");
		}
		
	
			@RequestMapping(value="/DeptDisplayGrid", method = RequestMethod.GET)
			public void listDept(@ModelAttribute("command")DeptBean bean,BindingResult result,HttpServletResponse response) throws IOException {
				PrintWriter out=null;
				out=response.getWriter();
				System.out.println("enter into datagrid list");
				List<Dept> li=deptService.getDepts();
				System.out.println("list size is: "+li.size());
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setExcludes(new String[]{"li"});
				jsonConfig.setIgnoreDefaultExcludes(false);
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				JSONArray array = JSONArray.fromObject(li,jsonConfig);
				System.out.println(array);
				out.print(array);
				out.flush();
			    out.close();
				//return array;
			}
		
		 
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/updatedept" ,method = RequestMethod.GET)
		public ModelAndView updatedept(@ModelAttribute("command")DeptBean bean,BindingResult result) throws IllegalAccessException, InvocationTargetException
		{
			try{
			Dept dept=null;
			List<Dept> li=deptService.getDeptId(bean.getDeptid());
			System.out.println(" The list value is :"+li);
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				 dept = (Dept) iterator.next();
				
			}
			BeanUtils.copyProperties(bean,dept);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::updatedept",e);
			}
			return new ModelAndView("deptupdate");			
		}
		@RequestMapping(value="/deptupdatesave" ,method = RequestMethod.GET)
		public ModelAndView deptdept(@ModelAttribute("command")DeptBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException
		{
			try{
			System.out.println("dept update method is running");
			DeptValidator valid=new DeptValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("deptupdate");
				
			}
			
			TransactionLog tllog=new TransactionLog();
			
			Transactionbean tlbean=new Transactionbean();
			Date dt=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
	   		String sd=sdf.format(dt);
	   		HttpSession hs=request.getSession(false); 
	   
	   		List li=(List)hs.getAttribute("list");
	   	
	   		Iterator it=li.iterator();
	   	 
	   		String un=null,tp=null;
	   		while(it.hasNext())
	   		{
	   			Registration rr=(Registration)it.next();
	   			un=rr.getUsername();
	   			tp=rr.getType();
	   		}
	   	 tlbean.setUsername(un);
	   	 tlbean.setType(tp);
	   	 tlbean.setTask("Department Updated");
	   	 tlbean.setTaskdt(sd);
	   	 BeanUtils.copyProperties(tllog, tlbean);
	   	 regService.Transactionlogdetails(tllog);
	   	 
			Dept dept=new Dept();
			BeanUtils.copyProperties(dept,bean);
			deptService.editDept(dept);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::deptupdatesave",e);
			}
			return new ModelAndView("deptupdatesave");			
		}
		
		@RequestMapping(value="/deletedept" ,method = RequestMethod.GET)
		public ModelAndView deletedept(@ModelAttribute("command")DeptBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
TransactionLog tllog=new TransactionLog();
			
			Transactionbean tlbean=new Transactionbean();
			Date dt=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
	   		String sd=sdf.format(dt);
	   		HttpSession hs=req.getSession(false); 
	   
	   		List li=(List)hs.getAttribute("list");
	   	
	   		Iterator it=li.iterator();
	   	 
	   		String un=null,tp=null;
	   		while(it.hasNext())
	   		{
	   			Registration rr=(Registration)it.next();
	   			un=rr.getUsername();
	   			tp=rr.getType();
	   		}
	   		tlbean.setUsername(un);
	   		tlbean.setType(tp);
	   		tlbean.setTask("Department Deleted");
	   		tlbean.setTaskdt(sd);
	   		BeanUtils.copyProperties(tllog, tlbean);
	   		regService.Transactionlogdetails(tllog);
			try{
			String ids=req.getParameter("deptid");
			System.out.println("Id is "+ids);
			String[] ids1=ids.split(",");
			String id="";
			try{
					for(int i=0;i<=ids1.length;i++)
					{	
						id=ids1[i];
						deptService.deleteDept(id);
					}
				}
			catch(Exception e){
				System.out.println("deleted ids"+e);
			}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::deletedept",e);
			}
		return new ModelAndView("deletedeptsuccess");
			}
		
// Employee management
		
		@RequestMapping(value="/emp" ,method = RequestMethod.GET)
		public ModelAndView emp(@ModelAttribute("command")RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("empm");			
		}
		@RequestMapping(value="/addemp" ,method = RequestMethod.GET)
		public ModelAndView addemp(@ModelAttribute("command")EmployeeBean bean,BindingResult result)
		{
			return new ModelAndView("addemp");			
		}

		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/empadddept",method=RequestMethod.GET)
		public  ModelAndView empadddept(@ModelAttribute("command")DeptBean bean,BindingResult result,HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			try{
			System.out.println("Controller is running");
			PrintWriter out=null;
			String ps=null;
			out=response.getWriter();	
			List<Dept> li=deptService.listDepts();
			System.out.println("dept list is"+li);
			Iterator itr = li.iterator();
			System.out.println(li.size());
			if(li.size()>0)
			{
			
				while(itr.hasNext())
				{
					ps = (String) itr.next();
					ps=ps+",";
					out.println(ps);
				}
			}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::empadddept",e);
			}
			return null;
		
						
			}
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/bankemps",method=RequestMethod.GET)
		public  ModelAndView bankemps(@ModelAttribute("command")EmployeeBean bean,BindingResult result,HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			try{
			System.out.println("Controller is running");
			PrintWriter out=null;
			String ps=null;
			out=response.getWriter();	
			List<Employee> li=empService.listDepts();
			System.out.println("dept list is"+li);
			Iterator itr = li.iterator();
			System.out.println(li.size());
			if(li.size()>0)
			{
			
				while(itr.hasNext())
				{
					ps = (String) itr.next();
					ps=ps+",";
					out.println(ps);
					
			}
				
		}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::bankemps",e);
			}
			return null;
	   }
		
		@SuppressWarnings({"unchecked", "rawtypes" })
		@RequestMapping(value="/empsave" ,method = RequestMethod.POST)
		public ModelAndView empsave(@ModelAttribute("command")EmployeeBean bean,BindingResult result,Employee emp,HttpServletRequest request,Userslist uli,UserRole ur) throws IllegalAccessException, InvocationTargetException
		{
			try{
			EmployeeValidator valid=new EmployeeValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("addemp");
				
			} 
				bean.setType("ROLE_DEPT");
				List<Employee> lis = empService.emplist();
				
				// Spring security
				uli.setUsername(bean.getUsername());
				uli.setPassword(bean.getPassword());
				uli.setEnabled(false);
				uli.setStatus("inactive");
				regService.saveuserslist(uli); 
			  
				ur.setRole(bean.getType());				  
				ur.setUsersListModel(uli);
				regService.saveuserrole(ur);	
			  
			  
			String id = null;
			String lid = null;
			
			int lslid= 0;
			String fslid= null;
			
			
			if(lis.size()>0)
					{
				for (Iterator<Employee> iterator = lis.iterator(); iterator.hasNext();) {
					emp = (Employee) iterator.next();
					
					lid = emp.getId();
					
					 
				}
				
				lslid= Integer.parseInt(lid.substring(4,8));
				 fslid = lid.substring(0,4);
				 
				 int did = lslid+1;
				 if (did<10)
				 {
					 id = fslid+"000"+did;
				 }
				 else if (did>=10||did<100)
				 {
					 id = fslid+"00"+did;
				 }
				 else if(did>=100 || did<1000)
				 {
					 
					 id = fslid+"0"+did;
				 }
				 else
				 {
					 id = fslid+did;
				 }
				
				
					}
			else
			{
				id = "LTSE0001";
			}
			
			
			
			
			
			bean.setId(id);
		
			/*List<Dept> lis=deptService.listDept();
			
			HttpSession ses=request.getSession();
			
			
			
			ses.setAttribute("deptlist", lis);*/
			
			
			//Employee emp=new Employee();
			
			/*List<Dept> li=deptService.listDept();
			System.out.println(" The list is......"+li.size());
			
			for (Iterator<Dept> iterator = li.iterator(); iterator.hasNext();) {
				dept = (Dept) iterator.next();
			}
			Set s = new HashSet();
			s.add(dept);
			s.add(emp);
			dept.setEmployee(s);*/
			
			
			BeanUtils.copyProperties(emp,bean);
			
			Dept dept=new Dept();
			
			String did=emp.getDeptid();
			List<Dept> li = deptService.viewdepts(did);
			
			//List<Dept> lis=deptService.listDept();
			
			for (Iterator<Dept> iterator = li.iterator(); iterator.hasNext();) {
				dept = (Dept) iterator.next();
				
				
			}
			Set s = new HashSet();
			
			s.add(emp);
			
			s.add(dept);
			dept.setEmployee(s);
			
			empService.addemp(dept);
			//empService.addemployee(emp,request);
			
			
			// Email sending for employees 
			String users=bean.getUsername();
			String pswd=bean.getPassword();
			String email=bean.getEmail();
			
				final String Username = "schimaticsoft@gmail.com";
				final String Password = "Naresh@5009";
				HttpSession session1 = request.getSession(true);
				String r = null;
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				System.out.println("Email is running");
				Session session = Session.getDefaultInstance(props, 
					    new javax.mail.Authenticator(){
					        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					           return new PasswordAuthentication(
					            		"schimaticsoft@gmail.com", "Naresh@5009");
					        }
					});

				 String link = "http://localhost:2222/LendingTree_MiniApp/Active.html?user="+users;
		         StringBuilder bodyText = new StringBuilder(); 
		            bodyText.append("<div>")
		                 .append("  Dear User <br/><br/>")
		                  .append("  Your profile is successfully registered with us.<br/>")
		                 .append("Your Username  is : "
		 						+users
		 						+"<br/>"
								+ " Your Password is:"
								+ pswd
								+"<br/>")
		              
		                 .append("<a href=\""+link+"\">"+"Click here to activate your account"+"</a>")
		                 .append("  <br/><br/>")
		                 .append("  Thanks,<br/>")
		                 .append("</div>");

					Message message = new MimeMessage(session);
				
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(email));
				
					message.setSubject("Your Profile is created successfully");
					
			        message.setContent(bodyText.toString(), "text/html; charset=utf-8");
				
				
				       Transport.send(message);						
					System.out.println("Mail sent successfuly");

				}
				
		
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::empsave",e);
			}
			return new ModelAndView("empsave"); 
}

// Employee Display Grid
			
			
				@RequestMapping(value="/EmpDisplayGrid", method = RequestMethod.GET)
				public void listEmployee(@ModelAttribute("command")EmployeeBean bean,BindingResult result,HttpServletResponse response) throws IOException {
					PrintWriter out=null;
					out=response.getWriter();
					System.out.println("enter into datagrid list");
					List<Employee> li=empService.getEmployees();
					System.out.println("list size is: "+li.size());
					JsonConfig jsonConfig = new JsonConfig();
					jsonConfig.setExcludes(new String[]{"li"});
					jsonConfig.setIgnoreDefaultExcludes(false);
					jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
					JSONArray array = JSONArray.fromObject(li,jsonConfig);
					System.out.println(array);
					out.print(array);
					out.flush();
				    out.close();
					//return array;
				}
			 
			
		@RequestMapping(value="/empaddgrid" ,method = RequestMethod.GET)
		public ModelAndView empaddgrid(@ModelAttribute("command")EmployeeBean bean,BindingResult result)
		{
			return new ModelAndView("empm");			
		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/updateemp" ,method = RequestMethod.GET)
		public ModelAndView updateemp(@ModelAttribute("command")EmployeeBean bean,BindingResult result) throws IllegalAccessException, InvocationTargetException
		{
			try{
			Employee emp=null;
			List<Employee> li=empService.getEmployeeId(bean.getId());
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				emp = (Employee) iterator.next();
				
			}
			BeanUtils.copyProperties(bean,emp);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::updateemp",e);
			}
			return new ModelAndView("empupdate");	
			
		}
		
		@RequestMapping(value="/empupdatesave" ,method = RequestMethod.POST)
		public ModelAndView updateemps(@ModelAttribute("command")EmployeeBean bean,BindingResult result) throws IllegalAccessException, InvocationTargetException
		{
			try{
			EmployeeValidator valid=new EmployeeValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("empupdate");
				
			}	 
			Employee emp=new Employee();
			BeanUtils.copyProperties(emp,bean);
			empService.editEmployee(emp);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::empupdatesave",e);
			}
			return new ModelAndView("empupdatesuccess");	
			
		}
		@RequestMapping(value="/deleteemp" ,method = RequestMethod.GET)
			public ModelAndView deleteemp(@ModelAttribute("command")EmployeeBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req)
			{
			try{
				String ids=req.getParameter("id");
				String[] ids1=ids.split(",");
				String id="";
				try{
						for(int i=0;i<=ids1.length;i++)
						{
							id=ids1[i];
							empService.deleteEmploye(id);
							
						}
					}
				 catch(Exception e){
					System.out.println("deleted ids"+e);
				}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::deleteemp",e);
			}
			return new ModelAndView("empdeletesuccess");
				}
// Customer Management
		
		@RequestMapping(value="/cust" ,method = RequestMethod.GET)
		public ModelAndView cust(@ModelAttribute("command")LoanApplyBean bean,BindingResult result)
		{
			return new ModelAndView("cust");			
		}
		
		
			@RequestMapping(value="/CusDisplayGrid", method = RequestMethod.GET)
			public void listCust(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse response) throws IOException {
			 PrintWriter out=null;
				out=response.getWriter();
				System.out.println("enter into datagrid list");
				List<LoanApply> li=apploanService.getCustomers();
				System.out.println("list size is: "+li.size());
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setExcludes(new String[]{"li"});
				jsonConfig.setIgnoreDefaultExcludes(false);
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				JSONArray array = JSONArray.fromObject(li,jsonConfig);
				System.out.println(array);
				out.print(array);
				out.flush();
			    out.close();
				//return array;
			}
		 
		
		 
	/*// Down load to pdf format
		 @RequestMapping(value = "/downloadpdfformat", method = RequestMethod.GET)

		 public ModelAndView downloadpdfformat(@ModelAttribute("command")LoanApplyBean bean, HttpServletResponse response, ServletRequest request  ) throws Exception {
		 	PrintWriter out =response.getWriter();
		 	List<LoanApply> li=apploanService.getCustomers();
		 	String aa="pdffile.pdf";
		 	
		 	FileWriter writer = new FileWriter(aa); 
		 	for(LoanApply str: li) {
		 		  writer.write(str);
		 		}
		 		writer.close();
		 	 if (li.size()>0) 
		        {
		            response.setContentType("application/pdf");
		            response.addHeader("Content-Disposition", "attachment; filename="+aa);
		            try
		            {
		                Files.copy(file, response.getOutputStream());
		                response.getOutputStream().flush();
		            } 
		            catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
		 	
			return null;	 
		 
		 }*/
		/*@RequestMapping(value="/responsecust" ,method = RequestMethod.GET)
		public ModelAndView addcust(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			ApplyLoan loan=null;
			List<ApplyLoan>  li= apploanService.getCustId(bean.getId());
			for (Iterator<ApplyLoan> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (ApplyLoan) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			return new ModelAndView("responsecust");
		}	*/
		
		@RequestMapping(value="/personalresponse" ,method = RequestMethod.GET)
		public ModelAndView personalResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::personalresponse",e);
			}
			return new ModelAndView("personalresponse");
		}	
		@RequestMapping(value="/ploanresponsesave" ,method = RequestMethod.POST)
		public ModelAndView ploanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			
				APersonalLoanValidator valid=new   APersonalLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("personalresponse");
					
				}	 
			
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::ploanresponsesave",e);
			}
			return new ModelAndView("taskassign");
	}
			
		
		@RequestMapping(value="/educationresponse" ,method = RequestMethod.GET)
		public ModelAndView educationResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::educationresponse",e);
			}
			return new ModelAndView("educationresponse");
		}
		
		@RequestMapping(value="/eloanresponsesave" ,method = RequestMethod.POST)
		public ModelAndView eloanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			 AEducationLoanValidator valid=new  AEducationLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("educationresponse");
					
				}	 
			
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::eloanresponsesave",e);
			}
			return new ModelAndView("taskassign");
	}
		
		
		
		
		@RequestMapping(value="/homeresponse" ,method = RequestMethod.GET)
		public ModelAndView homeResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::homeresponse",e);
			}
			return new ModelAndView("homeresponse");
		}
		@RequestMapping(value="/hloanresponsesave" ,method = RequestMethod.POST)
		public ModelAndView hloanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			 AHomeLoanValidator valid=new  AHomeLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("homeresponse");
					
				}	 
			
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::hloanresponsesave",e);
			}
			return new ModelAndView("taskassign");
	}
		
		@RequestMapping(value="/businessresponse" ,method = RequestMethod.GET)
		public ModelAndView businessResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::businessresponse",e);
			}
			return new ModelAndView("businessresponse");
		}	
		@RequestMapping(value="/bloanresponsesave" ,method = RequestMethod.POST)
		public ModelAndView bloanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			 ABusinessLoanValidator valid=new  ABusinessLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("businessresponse");
					
				}	 
			
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::bloanresponsesave",e);
			}
			return new ModelAndView("taskassign");
	}
		//
		@RequestMapping(value="/apersonalresponse" ,method = RequestMethod.GET)
		public ModelAndView apersonalResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::apersonalresponse",e);
			}
			return new ModelAndView("apersonalresponse");
		}	
		
		@RequestMapping(value="/aaploanresponse" ,method = RequestMethod.POST)
		public ModelAndView aaploanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			 AaPersonalLoanValidator valid=new  AaPersonalLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("apersonalresponse");
					
				}	 
			/*
				DateTimeFormatter sdf =DateTimeFormatter.ofPattern("MM/dd/yyyy");
				
				  LocalDate today = LocalDate.now();
				 
				  String asd=sdf.format(today);*/	
				  Date dt=new Date();
			  		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			  		String asd=sdf.format(dt);
			bean.setLoanacceptdate(asd);
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::aaploanresponse",e);
			}
			return new ModelAndView("loansuccess");
	}
		@RequestMapping(value="/aeducationresponse" ,method = RequestMethod.GET)
		public ModelAndView aeducationResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::aeducationresponse",e);
			}
			return new ModelAndView("aeducationresponse");
		}
		@RequestMapping(value="/aaeloanresponse" ,method = RequestMethod.POST)
		public ModelAndView aaeloanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			 AaEducationLoanValidator valid=new  AaEducationLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("aeducationresponse");
					
				}	 
				  Date dt=new Date();
			  		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			  		String asd=sdf.format(dt);
			bean.setLoanacceptdate(asd);
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::aaeloanresponse",e);
			}
			return new ModelAndView("loansuccess");
	}
		@RequestMapping(value="/ahomeresponse" ,method = RequestMethod.GET)
		public ModelAndView ahomeResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::ahomeresponse",e);
			}
			return new ModelAndView("ahomeresponse");
		}
		@RequestMapping(value="/aahloanresponse" ,method = RequestMethod.POST)
		public ModelAndView aahloanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			 AaHomeLoanValidator valid=new  AaHomeLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("ahomeresponse");
					
				}	 
				/*DateTimeFormatter sdf =DateTimeFormatter.ofPattern("MM/dd/yyyy");
				
				  LocalDate today = LocalDate.now();
				 
				  String asd=sdf.format(today);	
				
			bean.setLoanacceptdate(asd);*/
				  Date dt=new Date();
			  		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
			  		String asd=sdf.format(dt);
			bean.setLoanacceptdate(asd);
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::aahloanresponse",e);
			}
			return new ModelAndView("loansuccess");
	}
		@RequestMapping(value="/abusinessresponse" ,method = RequestMethod.GET)
		public ModelAndView abusinessResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::abusinessresponse",e);
			}
			return new ModelAndView("abusinessresponse");
		}	
		
		@RequestMapping(value="/aabloanresponse" ,method = RequestMethod.POST)
		public ModelAndView aabloanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			 AaBusinessLoanValidator valid=new  AaBusinessLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("abusinessresponse");
					
				}	 
				/*DateTimeFormatter sdf =DateTimeFormatter.ofPattern("MM/dd/yyyy");
				
				  LocalDate today = LocalDate.now();
				 
				  String asd=sdf.format(today);	
				
			bean.setLoanacceptdate(asd);*/
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::abloanresponse",e);
			}
			return new ModelAndView("loansuccess");
	}	
		
		@RequestMapping(value="/loanresponse" ,method = RequestMethod.POST)
		public ModelAndView loanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			
			
			
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			
			return new ModelAndView("taskassign");
	}
		@RequestMapping(value="/subcust" ,method = RequestMethod.GET)
		public ModelAndView subcust(@ModelAttribute("command")RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("subcust");			
		}
//View Loans 
		
@RequestMapping(value="/adminpersonalloan" ,method = RequestMethod.GET)
	public ModelAndView viewpersonalloan(@ModelAttribute("command")LoanApplyBean bean,BindingResult result)
		{
			return new ModelAndView("adminpersonal");			
		}	
	

@RequestMapping(value="/PersonalDisplayGrid", method = RequestMethod.GET)
public void personalDisplaygrid(@ModelAttribute("command")AppLoanBean bean,BindingResult result,HttpServletResponse response) throws IOException {
 PrintWriter out=null;
	out=response.getWriter();
	System.out.println("enter into datagrid list");
	List<LoanApply> li=apploanService.getPersonalloan();
	System.out.println("list size is: "+li.size());
	JsonConfig jsonConfig = new JsonConfig();
	jsonConfig.setExcludes(new String[]{"li"});
	jsonConfig.setIgnoreDefaultExcludes(false);
	jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
	JSONArray array = JSONArray.fromObject(li,jsonConfig);
	System.out.println(array);
	out.print(array);
	out.flush();
    out.close();
	//return array;
}	
		
//Messages 
		@RequestMapping(value="/msg" ,method = RequestMethod.GET)
		public ModelAndView msg(@ModelAttribute("command")RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("msg");			
		}
		@RequestMapping(value="/compose" ,method = RequestMethod.GET)
		public ModelAndView compose(@ModelAttribute("command")RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("compose");			
		}
		
//Admin Logout
		@RequestMapping(value="/adminlogout",method=RequestMethod.GET)
		public ModelAndView adminlogout(@ModelAttribute("command") RegistrationBean bean,BindingResult result,HttpServletRequest request)
		{
		
				HttpSession ses=request.getSession();
				//ses.invalidate();
				String username=(String)ses.getAttribute("username");
				String logintime=(String)ses.getAttribute("logintime");
				DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				Date dateobj1 = new Date();
				String logouttime = df1.format(dateobj1);
				
				regService.logoutAppLog(username,logintime,logouttime);
		       
		        ses.invalidate();
		        return new ModelAndView("logoutsuccess");
		}
		
//User Module
		
		@RequestMapping(value="/user" ,method = RequestMethod.GET)
		public ModelAndView user(@ModelAttribute("command") ApplyLoanBean bean,BindingResult result)
		{
			return new ModelAndView("userhome");			
		}
		@RequestMapping(value="/userhome" ,method = RequestMethod.GET)
		public ModelAndView userhome(@ModelAttribute("command") ApplyLoanBean bean,BindingResult result)
		{
			return new ModelAndView("userhome");			
		}
		@RequestMapping(value="/apploan" ,method = RequestMethod.GET)
		public ModelAndView apploan(@ModelAttribute("command") AppLoanBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
		{
			return new ModelAndView("loan");			
		}
		@RequestMapping(value="/applyloansave" ,method = RequestMethod.POST)
		public ModelAndView apploans(@ModelAttribute("command") AppLoanBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
		{
			try{
			ApplyLoanValidator valid=new ApplyLoanValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("loan");
				
			}	
			
			System.out.print("Apply loan method running");
			HttpSession ses=request.getSession(false);
			String uname=(String) ses.getAttribute("username");
			String pwd=(String) ses.getAttribute("password");
			System.out.println("User name in applyloan is "+uname);
			System.out.println("Password  in applyloan is "+pwd);
		
			List<Registration>  li= regService.getUser(uname,pwd);
			System.out.println("Printing list is "+li);
			Integer id=li.get(0).getId();
			String fn=li.get(0).getFirstname();
			System.out.println("Printing firstname is "+fn);
			String ln=li.get(0).getLastname();
			String email=li.get(0).getEmailid();
			String mobile=li.get(0).getMobile();
			String gender=li.get(0).getGender();
			String dob=li.get(0).getDateofbirth();
			String country=li.get(0).getCountry();
			String state=li.get(0).getState();
			String city=li.get(0).getCity();
			String pin=li.get(0).getPincode();
			String address=li.get(0).getAddress();
			
			
			bean.setRegid(id);
			bean.setFirstname(fn);
			bean.setLastname(ln);
			bean.setEmailid(email);
			bean.setMobile(mobile);
			bean.setGender(gender);
			bean.setDateofbirth(dob);
			bean.setCountry(country);
			bean.setState(state);
			bean.setCity(city);
			bean.setPincode(pin);
			bean.setAddress(address);
			
			
			
			bean.setStatustype("Applied");
			ApplyLoan loan=new ApplyLoan();
			BeanUtils.copyProperties(loan, bean);
			apploanService.addapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::applyloansave",e);
			}
			return new ModelAndView("apploans");			
		}
		

		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/displayloan",method=RequestMethod.GET)
		public  ModelAndView loantypechk(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			try{
				
			PrintWriter out=null;
			String ps=null;
			out=response.getWriter();	
			List<Loan> li=loanService.listLoanTypes();
			System.out.println("loan list is"+li);
			Iterator itr = li.iterator();
			System.out.println(li.size());
			if(li.size()>0)
			{
			
				while(itr.hasNext())
				{
					ps = (String) itr.next();
					ps=ps+",";
					out.println(ps);
					
			}
				
		}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::displayloan",e);
			}
			return null;
		
						
			}
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/displaybank",method=RequestMethod.GET)
		public  ModelAndView banktypechk(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			try{
			PrintWriter out=null;
			String ps=null;
			out=response.getWriter();	
			String loantype=request.getParameter("loans");
			System.out.println("value of loantype is "+loantype);
			String banke=request.getParameter("banks");
			System.out.println("value of banktype is "+banke);
			
			
			List<Loan> li=loanService.listBankType(loantype);
			System.out.println("Bank  list is.............."+li);
			Iterator itr = li.iterator();
			System.out.println(li.size());
			if(li.size()>0)
			{
			
				while(itr.hasNext())
				{
					ps = (String) itr.next();
					ps=ps+",";
					out.println(ps);
					
			}
				
		}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::displaybank",e);
			}
			return null;
		
						
			}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/displayinterest",method=RequestMethod.GET)
		public  ModelAndView interestDisplay(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			try{
			PrintWriter out=null;
			String ps=null;
			out=response.getWriter();	
			String loantype=request.getParameter("loans");
			System.out.println("value of loantype is "+loantype);
			String bank=request.getParameter("banks");
			System.out.println("value of banktype is "+bank);
			
			
			List<Loan> li=loanService.getInterest(loantype,bank);
			System.out.println("Interest rate is "+li);
			Iterator itr = li.iterator();
			System.out.println(li.size());
			if(li.size()>0)
			{
			
				while(itr.hasNext())
				{
					ps = (String) itr.next();
				
					out.println(ps);
					
			}
				
		}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::displayinterest",e);
			}
			return null;
		
						
			}	
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/displaydeptss",method=RequestMethod.GET)
		public  ModelAndView displaydeptid(@ModelAttribute("command")LoanBean bean,BindingResult result,HttpServletRequest request, HttpServletResponse response) throws IOException
		{
			try{
			PrintWriter out=null;
			String pss=null;
			out=response.getWriter();	
			String dname=request.getParameter("dept");
			System.out.println("Dname is "+dname);
			
			List<Loan> li=loanService.getDeptids(dname);
			System.out.println("List of depts is........ "+li);
			Iterator itr = li.iterator();
			System.out.println(li.size());
			if(li.size()>0)
			{
			
				while(itr.hasNext())
				{
					pss = (String) itr.next();
				
					out.println(pss);
					
			    }
				
		    }
	  }
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::displayinterest",e);
			}
			return null;
		
						
			}	
			
		
		@RequestMapping(value="/status" ,method = RequestMethod.GET)
		public ModelAndView status(@ModelAttribute("command")ApplyLoanBean bean,BindingResult result)
		{
			
			return new ModelAndView("status");			
		}
		
		@RequestMapping(value="/statusgrid" ,method = RequestMethod.GET)
		public  void getuserlist(@ModelAttribute("command")  LoanApplyBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException{
			 PrintWriter out=null;
				out=response.getWriter();
				System.out.println("enter into datagrid list");
				HttpSession ses=request.getSession(false);
				String uname=(String) ses.getAttribute("username");
				String pwd=(String) ses.getAttribute("password");
				List<Registration>  lis= regService.getUser(uname,pwd);
				
				Integer id=lis.get(0).getId();
				List<ApplyLoan> li=apploanService.getRegid(request,id);
				System.out.println("list size is: "+li.size());
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setExcludes(new String[]{"li"});
				jsonConfig.setIgnoreDefaultExcludes(false);
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				JSONArray array = JSONArray.fromObject(li,jsonConfig);
				System.out.println(array);
				out.print(array);
				out.flush();
			    out.close();
				//return array;
		}
		@RequestMapping(value="/usermsg" ,method = RequestMethod.GET)
		public ModelAndView usermsg(@ModelAttribute("command") MessageBean bean,BindingResult result)
		{
			
			return new ModelAndView("msguser");			
		}
		
		@RequestMapping(value="/composeuser" ,method = RequestMethod.GET)
		public ModelAndView composeuser(@ModelAttribute("command") MessageBean bean,BindingResult result)
		{
			return new ModelAndView("composeuser");			
		}
		
		@RequestMapping(value="/composesave" ,method = RequestMethod.POST)
		public ModelAndView composesave(@ModelAttribute("command") MessageBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
		{
			try{
			UserMsgValidator valid=new UserMsgValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("composeuser");
				
			}	 
			
			HttpSession ses=request.getSession(false);
			
			String uname=(String) ses.getAttribute("username");
			String pwd=(String) ses.getAttribute("password");
			List<Registration>  lis= regService.getUser(uname,pwd);
			
			Integer id=lis.get(0).getId();
			
			String type=lis.get(0).getType();
			bean.setRegid(id);
			bean.setFromu(type);
			MessageModel msgs=new MessageModel();
			
			BeanUtils.copyProperties(msgs,bean);
			
			
			msgService.msgsave(msgs);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::composesave",e);
			}
			return new ModelAndView("composesave");			
		}
// Admin messages
		
		@RequestMapping(value="/adminmsg" ,method = RequestMethod.GET)
		public ModelAndView adminmsg(@ModelAttribute("command") MessageBean bean,BindingResult result)
		{
			
			return new ModelAndView("msgadmin");			
		}
		

	
		@RequestMapping(value="/adminmsggrid" ,method = RequestMethod.GET)
		public void adminmsggrid(@ModelAttribute("command") MessageBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException
		{
			 PrintWriter out=null;
				out=response.getWriter();
				System.out.println("enter into admin msg datagrid list");
				HttpSession ses=request.getSession(false);
				String uname=(String) ses.getAttribute("username");
				String pwd=(String) ses.getAttribute("password");
				List<Registration>  lis= regService.getUser(uname,pwd);
				
				Integer id=lis.get(0).getId();
				
				String type=lis.get(0).getType();
				List<MessageModel> li=msgService.getType(request,type);
				System.out.println("list size is: "+li.size());
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setExcludes(new String[]{"li"});
				jsonConfig.setIgnoreDefaultExcludes(false);
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				JSONArray array = JSONArray.fromObject(li,jsonConfig);
				System.out.println(array);
				out.print(array);
				out.flush();
			    out.close();
				//return array;
			
				
		}
		
		
		
	
		@RequestMapping(value="/usermsggrid" ,method = RequestMethod.GET)
		public void usermsggrid(@ModelAttribute("command") MessageBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException
		{
			 PrintWriter out=null;
				out=response.getWriter();
				HttpSession ses=request.getSession(false);
				String uname=(String) ses.getAttribute("username");
				String pwd=(String) ses.getAttribute("password");
				List<Registration>  lis= regService.getUser(uname,pwd);
				
				Integer id=lis.get(0).getId();
				String type=lis.get(0).getType();
				List<MessageModel> li=msgService.getUserMsg(request,type,id);
				System.out.println("list size is: "+li.size());
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setExcludes(new String[]{"li"});
				jsonConfig.setIgnoreDefaultExcludes(false);
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				JSONArray array = JSONArray.fromObject(li,jsonConfig);
				System.out.println(array);
				out.print(array);
				out.flush();
			    out.close();
				
			    //return array;
			
				
		}
		
		// admin message module
		@RequestMapping(value="/composeadmin" ,method = RequestMethod.GET)
		public ModelAndView composeadmin(@ModelAttribute("command") MessageBean bean,BindingResult result)
		{
			
			return new ModelAndView("composeadmin");			
		}
		@RequestMapping(value="/composeadminsave" ,method = RequestMethod.POST)
		public ModelAndView composeadminsave(@ModelAttribute("command") MessageBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
		{
			try{
			MessageValidator valid=new MessageValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("composeadmin");
				
			}	 
			
			HttpSession ses=request.getSession(false);
			String uname=(String) ses.getAttribute("username");
			String pwd=(String) ses.getAttribute("password");
			List<Registration>  lis= regService.getUser(uname,pwd);
			
			String type=lis.get(0).getType();
			bean.setFromu(type);
			MessageModel msgs=new MessageModel();
			BeanUtils.copyProperties(msgs,bean);
			msgService.msgsave(msgs);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::composeadminsave",e);
			}
			return new ModelAndView("composeadminsuccess");			
		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/updateu" ,method = RequestMethod.GET)
		public ModelAndView updateuser(@ModelAttribute("command") RegistrationBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
		{
			try{
			Registration reg=null;
			HttpSession ses=request.getSession(false);
			String uname=(String) ses.getAttribute("username");
			String pwd=(String) ses.getAttribute("password");
			List<Registration>  lis= regService.getUser(uname,pwd);
			
			for (Iterator iterator = lis.iterator(); iterator.hasNext();) {
				 reg = (Registration) iterator.next();
			}
			BeanUtils.copyProperties(bean,reg);
			
			
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::updateu",e);
			}
			return new ModelAndView("useredit");				
		}

		@RequestMapping(value="/profileupdategrid" ,method = RequestMethod.GET)
		public ModelAndView profielupdateuser(@ModelAttribute("command") ApplyLoanBean bean,BindingResult result)
		{
			
			return new ModelAndView("updateuser");			
		}
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/userDisplayGrid", method = RequestMethod.GET)
		public List user(@ModelAttribute("command")RegistrationBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out=null;
		out=response.getWriter();
		
		HttpSession ses=request.getSession(false);
		List li=(List) ses.getAttribute("list");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"li"});
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray array = JSONArray.fromObject(li,jsonConfig);
		System.out.println(array);
		out.print(array);
		out.flush();
	    out.close();
		return array;
		}
		@RequestMapping(value="/chpwdu" ,method = RequestMethod.GET)
		public ModelAndView chpwduser(@ModelAttribute("command") Changepassword bean,BindingResult result)
		{
			return new ModelAndView("chpwduser");			
		}
		@RequestMapping(value="/userchpwdupdate" ,method = RequestMethod.POST)
		public ModelAndView useruppwdsuccess(@ModelAttribute("command")Changepassword bean,BindingResult result,HttpServletResponse response,HttpServletRequest request)
		{
			try{
			HttpSession ses=request.getSession(false);
			String uname=(String) ses.getAttribute("username");
			String pwd=(String) ses.getAttribute("password");
			List<Registration>  lis= regService.getUser(uname,pwd);
			
			Integer id=lis.get(0).getId();
			String password=lis.get(0).getPassword();
			String currentpassword=bean.getPassword();
			String newpassword=bean.getNewpassword();
			System.out.println("new password is "+newpassword);
			String confirmnewpwd=bean.getConfirmnewpassword();
			ChangePassword valid=new ChangePassword();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("chpwduser");
				
			}	 
			if(password.equals(currentpassword))
			{
				if(newpassword.equals(confirmnewpwd))
				{
					
					 regService.adminchangePassword(id,newpassword,confirmnewpwd);
					 return new ModelAndView("chpwdusersuccess");
				}
			}
			else
			{
		     return new ModelAndView("chpwdfail");
			}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::userchpwdupdate",e);
			}
			return new ModelAndView("chpwdfail");
		 }
			
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/updateuserk" ,method = RequestMethod.GET)
		public ModelAndView updateusersucess(@ModelAttribute("command")RegistrationBean bean,BindingResult result) throws IllegalAccessException, InvocationTargetException
		{
			try{
			Registration reg=null;
			List<Registration> li=regService.getRegId(bean.getId());
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				 reg = (Registration) iterator.next();
			}
			BeanUtils.copyProperties(bean,reg);
			
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::updateuserk",e);
			}
			return new ModelAndView("useredit");			
					
		}
		@RequestMapping(value="/usersaveupdate" ,method = RequestMethod.GET)
		public ModelAndView usersaveus(@ModelAttribute("command")RegistrationBean bean,BindingResult result) throws IllegalAccessException, InvocationTargetException
		{
			try{
			Registration reg=new Registration();
			
			LendingtreeValidator valid=new LendingtreeValidator();
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("useredit");
				
			}	 
			
			
			BeanUtils.copyProperties(reg,bean);
			regService.editUser(reg);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::usersaveupdate",e);
			}
			return new ModelAndView("updateusersuccess");	
			
		}
		
		
		@RequestMapping(value="/chpwdusersuccess" ,method = RequestMethod.GET)
		public ModelAndView chpwdusersucess(@ModelAttribute("command") ApplyLoanBean bean,BindingResult result)
		{
			return new ModelAndView("chpwdusersuccess");			
		}
		//user Logout
		@RequestMapping(value="/userlogout",method=RequestMethod.GET)
		public ModelAndView userlogout(@ModelAttribute("command") RegistrationBean bean,BindingResult result,HttpServletRequest request)
		{
				
						HttpSession ses=request.getSession();
						//ses.invalidate();
						String username=(String)ses.getAttribute("username");
						String logintime=(String)ses.getAttribute("logintime");
						DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
						Date dateobj1 = new Date();
						String logouttime = df1.format(dateobj1);
						
						regService.logoutAppLog(username,logintime,logouttime);
				       
				        ses.invalidate();
				        return new ModelAndView("logoutsuccess");
		}	
				
// Pickup Department Module
		/*@RequestMapping(value="/pickup" ,method = RequestMethod.GET)
		public ModelAndView pickup(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("picdept");			
		}
		@RequestMapping(value="/pickhome" ,method = RequestMethod.GET)
		public ModelAndView pickuphome(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("picdept");			
		}
		
		@RequestMapping(value="/viewapp" ,method = RequestMethod.GET)
		public ModelAndView viewapp(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("viewApp");			
		}
		@RequestMapping(value="/pickview" ,method = RequestMethod.GET)
		public ModelAndView pickview(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("pickview");			
		}
		@RequestMapping(value="/pickupsuccess" ,method = RequestMethod.GET)
		public ModelAndView pickupsuccess(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("pickupsuccess");			
		}
		@RequestMapping(value="/picmsg" ,method = RequestMethod.GET)
		public ModelAndView msgpic(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("msgpic");			
		}
		
		@RequestMapping(value="/composepic" ,method = RequestMethod.GET)
		public ModelAndView composepic(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("composepic");			
		}*/
		
// Verification Department Module
		
		@RequestMapping(value="/veryhome" ,method = RequestMethod.GET)
		public ModelAndView veryhome(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("verdept");			
		}
		
		@RequestMapping(value="/very" ,method = RequestMethod.GET)
		public ModelAndView very(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("ver");			
		}
		
		
		@RequestMapping(value="/VericationDisplayGrid", method = RequestMethod.GET)
		public void verifiationdisplaygrid(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
		 PrintWriter out=null;
			out=response.getWriter();
			
			HttpSession ses=request.getSession(false);
			String uname=(String) ses.getAttribute("un");
			String pwd=(String) ses.getAttribute("pwds");
			System.out.println("User name in applyloan is "+uname);
			System.out.println("Password  in applyloan is "+pwd);
			
			List<Employee>  li= empService.getEmployeeList(uname,pwd);
			System.out.println("Printing list is "+li);
			String name=li.get(0).getName();
			String dept=li.get(0).getDept();
			System.out.println("Employee name is "+name);
			
			List<ApplyLoan> lis=apploanService.getEmpName(name,dept);
			
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"lis"});
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray array = JSONArray.fromObject(lis,jsonConfig);
			System.out.println(array);
			out.print(array);
			out.flush();
		    out.close();
			//return array;
		}
		
		/*@RequestMapping(value="/responsevery" ,method = RequestMethod.GET)
		public ModelAndView verificationdept(@ModelAttribute("command")AppLoanBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			ApplyLoan loan=null;
			List<ApplyLoan>  li= apploanService.getCustId(bean.getId());
			for (Iterator<ApplyLoan> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (ApplyLoan) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			return new ModelAndView("responsevery");
		}	*/
		
		/*@RequestMapping(value="/verificationsave" ,method = RequestMethod.POST)
		public ModelAndView verycust(@ModelAttribute("command") AppLoanBean bean,BindingResult result) throws IllegalAccessException, InvocationTargetException
		{
			ApplyLoan loan=new ApplyLoan();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			return new ModelAndView("vercust");			
		}*/
		@RequestMapping(value="/verpersonalresponse" ,method = RequestMethod.GET)
		public ModelAndView verpersonalResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::verpersonalresponse",e);
			}
			return new ModelAndView("verpersonalresponse");
		}	
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/verploanresponsesave" ,method = RequestMethod.POST)
		public ModelAndView verploanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			
			 VPersonalLoanValidator valid=new   VPersonalLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("verpersonalresponse");
					
				}	 
				TransactionLog tllog=new TransactionLog();
				Transactionbean tlbean=new Transactionbean();
				Date dt=new Date();
				SimpleDateFormat sdff=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		   		String sd=sdff.format(dt);
		   		HttpSession hs=req.getSession(false); 
		   
		   		List liw=(List)hs.getAttribute("emplist");
		   	
		   		Iterator it=liw.iterator();
		   	 
		   		String un=null,tp=null;
		   		while(it.hasNext())
		   		{
		   			Employee rr=(Employee)it.next();
		   			un=rr.getUsername();
		   			tp=rr.getDept();
		   		}
		   	 tlbean.setUsername(un);
		   	 tlbean.setType(tp);
		   	 tlbean.setTask("Personal Loan Verified");
		   	 tlbean.setTaskdt(sd);
		   	 BeanUtils.copyProperties(tllog, tlbean);
		   	 regService.Transactionlogdetails(tllog);
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::verploanresponsesave",e);
			}
			return new ModelAndView("vercust");
		
		
		}
		
		
		
		@RequestMapping(value="/vereducationresponse" ,method = RequestMethod.GET)
		public ModelAndView vereducationResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::vereducationresponse",e);
			}
			return new ModelAndView("vereducationresponse");
		}
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/vereloanresponsesave" ,method = RequestMethod.POST)
		public ModelAndView vereloanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			 EducationLoanValidator valid=new  EducationLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("vereducationresponse");
					
				}	 
				TransactionLog tllog=new TransactionLog();
				Transactionbean tlbean=new Transactionbean();
				Date dt=new Date();
				SimpleDateFormat sdff=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		   		String sd=sdff.format(dt);
		   		HttpSession hs=req.getSession(false); 
		   
		   		List liw=(List)hs.getAttribute("emplist");
		   	
		   		Iterator it=liw.iterator();
		   	 
		   		String un=null,tp=null;
		   		while(it.hasNext())
		   		{
		   			Employee rr=(Employee)it.next();
		   			un=rr.getUsername();
		   			tp=rr.getDept();
		   		}
		   	 tlbean.setUsername(un);
		   	 tlbean.setType(tp);
		   	 tlbean.setTask("Education Loan Verified");
		   	 tlbean.setTaskdt(sd);
		   	 BeanUtils.copyProperties(tllog, tlbean);
		   	 regService.Transactionlogdetails(tllog);
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::vereloanresponsesave",e);
			}
			return new ModelAndView("vercust");
		
		
		}
		@RequestMapping(value="/verhomeresponse" ,method = RequestMethod.GET)
		public ModelAndView verhomeResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::verhomeresponse",e);
			}
			return new ModelAndView("verhomeresponse");
		}
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/verhloanresponsesave" ,method = RequestMethod.POST)
		public ModelAndView verhloanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			 VHomeLoanValidator valid=new  VHomeLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("verhomeresponse");
					
				}	 
			
				TransactionLog tllog=new TransactionLog();
				Transactionbean tlbean=new Transactionbean();
				Date dt=new Date();
				SimpleDateFormat sdff=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		   		String sd=sdff.format(dt);
		   		HttpSession hs=req.getSession(false); 
		   
		   		List liw=(List)hs.getAttribute("emplist");
		   	
		   		Iterator it=liw.iterator();
		   	 
		   		String un=null,tp=null;
		   		while(it.hasNext())
		   		{
		   			Employee rr=(Employee)it.next();
		   			un=rr.getUsername();
		   			tp=rr.getDept();
		   		}
		   	 tlbean.setUsername(un);
		   	 tlbean.setType(tp);
		   	 tlbean.setTask("Home Loan Verified");
		   	 tlbean.setTaskdt(sd);
		   	 BeanUtils.copyProperties(tllog, tlbean);
		   	 regService.Transactionlogdetails(tllog);
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::verhloanresponsesave",e);
			}
			return new ModelAndView("vercust");
		
		
		}
		@RequestMapping(value="/verbusinessresponse" ,method = RequestMethod.GET)
		public ModelAndView verbusinessResponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			LoanApply loan=null;
			List<LoanApply>  li= apploanService.getCustId(bean.getId());
			for (Iterator<LoanApply> iterator = li.iterator(); iterator.hasNext();) {
					 loan= (LoanApply) iterator.next();
			}
			BeanUtils.copyProperties(bean, loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::verbusinessresponse",e);
			}
			return new ModelAndView("verbusinessresponse");
		}	
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/verbloanresponsesave" ,method = RequestMethod.POST)
		public ModelAndView verbloanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
			 VBusinessLoanValidator valid=new  VBusinessLoanValidator();
				valid.validate(bean,result);
				if(result.hasErrors())
				{
					return new ModelAndView("verbusinessresponse");
					
				}	 
				TransactionLog tllog=new TransactionLog();
				Transactionbean tlbean=new Transactionbean();
				Date dt=new Date();
				SimpleDateFormat sdff=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		   		String sd=sdff.format(dt);
		   		HttpSession hs=req.getSession(false); 
		   
		   		List liw=(List)hs.getAttribute("emplist");
		   	
		   		Iterator it=liw.iterator();
		   	 
		   		String un=null,tp=null;
		   		while(it.hasNext())
		   		{
		   			Employee rr=(Employee)it.next();
		   			un=rr.getUsername();
		   			tp=rr.getDept();
		   		}
		   	 tlbean.setUsername(un);
		   	 tlbean.setType(tp);
		   	 tlbean.setTask("BusinessLoan Verified");
		   	 tlbean.setTaskdt(sd);
		   	 BeanUtils.copyProperties(tllog, tlbean);
		   	 regService.Transactionlogdetails(tllog);
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::verbloanresponsesave",e);
			}
			return new ModelAndView("vercust");
		
		
		}
		
		@RequestMapping(value="/verloanresponse" ,method = RequestMethod.POST)
		public ModelAndView verloanresponse(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			
			try{
			
			LoanApply loan=new LoanApply();
			BeanUtils.copyProperties(loan, bean);
			apploanService.updateapplyloan(loan);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::verloanresponse",e);
			}
			return new ModelAndView("vercust");
	}
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/vupdate" ,method = RequestMethod.GET)
		public ModelAndView vuupdate(@ModelAttribute("command") EmployeeBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
		{
			try{
			Employee emp=null;
			HttpSession ses=request.getSession(false);
			String uname=(String) ses.getAttribute("un");
			String pwd=(String) ses.getAttribute("pwds");
			List<Employee>  lis= empService.getUser(uname,pwd);
			
			for (Iterator iterator = lis.iterator(); iterator.hasNext();) {
				emp = (Employee) iterator.next();
			}
			BeanUtils.copyProperties(bean,emp);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::vupdate",e);
			}
			return new ModelAndView("verupdate");			
		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/VerificationDisplayGrid", method = RequestMethod.GET)
		public void verificationdisplaygrid(@ModelAttribute("command")EmployeeBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter out=null;
		out=response.getWriter();
		HttpSession ses=request.getSession(false);
		List li=(List) ses.getAttribute("emplist");
		System.out.println("enter into datagrid list");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"li"});
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray array = JSONArray.fromObject(li,jsonConfig);
		System.out.println(array);
		out.print(array);
		out.flush();
	    out.close();
		//return array;
		}
		
		@SuppressWarnings("rawtypes") // Verification department update 
		@RequestMapping(value="/verificationupdate" ,method = RequestMethod.GET)
		public ModelAndView verificationupdate(@ModelAttribute("command")EmployeeBean bean,BindingResult result) throws IllegalAccessException, InvocationTargetException
		{
			try{
			Employee emp=null;
			List<Employee> li=empService.getEmployeeId(bean.getId());
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				emp = (Employee) iterator.next();
			}
			BeanUtils.copyProperties(bean,emp);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::verificationupdate",e);
			}
			return new ModelAndView("verupdate");			
					
		}
		
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/verificationupdatesave" ,method = RequestMethod.POST)
		public ModelAndView verificationupdatesave(@ModelAttribute("command")EmployeeBean bean,BindingResult result,HttpServletResponse res,HttpServletRequest req) throws IllegalAccessException, InvocationTargetException
		{
			try{
				
				TransactionLog tllog=new TransactionLog();
				Transactionbean tlbean=new Transactionbean();
				Date dt=new Date();
				SimpleDateFormat sdff=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		   		String sd=sdff.format(dt);
		   		HttpSession hs=req.getSession(false); 
		   
		   		List liw=(List)hs.getAttribute("emplist");
		   	
		   		Iterator it=liw.iterator();
		   	 
		   		String un=null,tp=null;
		   		while(it.hasNext())
		   		{
		   			Employee rr=(Employee)it.next();
		   			un=rr.getUsername();
		   			tp=rr.getDept();
		   		}
		   	 tlbean.setUsername(un);
		   	 tlbean.setType(tp);
		   	 tlbean.setTask("Profile Updated");
		   	 tlbean.setTaskdt(sd);
		   	 BeanUtils.copyProperties(tllog, tlbean);
		   	 regService.Transactionlogdetails(tllog);
		   	 
			Employee emp=new Employee();
			BeanUtils.copyProperties(emp,bean);
			empService.editVerification(emp);
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::verificationupdatesave",e);
			}
			return new ModelAndView("veprofilesuccess");	
			
		}
		@RequestMapping(value="/empchpwd" ,method = RequestMethod.GET)
		public ModelAndView empchpwd(@ModelAttribute("command")Changepassword bean,BindingResult result)
		{
			return new ModelAndView("empchpwd");			
		}
		
		
		@RequestMapping(value="/empchpwdupdate" ,method = RequestMethod.POST)
		public ModelAndView employee(@ModelAttribute("command")Changepassword bean,BindingResult result,HttpServletResponse response,HttpServletRequest request)
		{
			try{
			HttpSession ses=request.getSession(false);
			String uname=(String) ses.getAttribute("un");
			String pwd=(String) ses.getAttribute("pwds");
			List<Employee>  lis= empService.getUser(uname,pwd);
			
			String id=lis.get(0).getId();
			String password=lis.get(0).getPassword();
			String currentpassword=bean.getPassword();
			String newpassword=bean.getNewpassword();
			System.out.println("new password is "+newpassword);
			String confirmnewpwd=bean.getConfirmnewpassword();
			
			ChangePassword valid=new ChangePassword(); //change password validations
			valid.validate(bean,result);
			if(result.hasErrors())
			{
				return new ModelAndView("empchpwd");
				
			}	 
			
			if(password.equals(currentpassword))
			{
				if(newpassword.equals(confirmnewpwd))
				{
					
					empService.empchangePassword(id,newpassword,confirmnewpwd);
					 return new ModelAndView("empchpwdsuccess");
				}
			}
			else
			{
		     return new ModelAndView("empchpwdfail");
			}
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::empchpwd",e);
			}
			return new ModelAndView("empchpwdfail");
		 }
			
		@RequestMapping(value="/versub" ,method = RequestMethod.GET)
		public ModelAndView verysub(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("versub");			
		}
		@RequestMapping(value="/verymsg" ,method = RequestMethod.GET)
		public ModelAndView verymsg(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("verymsg");			
		}
		@RequestMapping(value="/vercompose" ,method = RequestMethod.GET)
		public ModelAndView vercompose(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("vercompose");			
		}
		
// Documents Uploads
		
		@RequestMapping(value="/uploaddoc" ,method = RequestMethod.GET)
		public ModelAndView uploaddoc(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("uploaddoc");			
		}
		
// Verification Logout
		@RequestMapping(value="/verificationlogout",method=RequestMethod.GET)
		public ModelAndView verificationlogout(@ModelAttribute("command") RegistrationBean bean,BindingResult result,HttpServletRequest request)
		{
				
						HttpSession ses=request.getSession();
						//ses.invalidate();
						String username=(String)ses.getAttribute("un");
						String logintime=(String)ses.getAttribute("logintime");
						DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
						Date dateobj1 = new Date();
						String logouttime = df1.format(dateobj1);
						
						regService.logoutAppLog(username,logintime,logouttime);
				       
				        ses.invalidate();
				        return new ModelAndView("logoutsuccess");
		}		
//Legal Department Module
		/*@RequestMapping(value="/legalD" ,method = RequestMethod.GET)
		public ModelAndView legal(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("legdept");			
		}
		@RequestMapping(value="/legalhome" ,method = RequestMethod.GET)
		public ModelAndView legalhome(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("legdept");			
		}
		@RequestMapping(value="/legal" ,method = RequestMethod.GET)
		public ModelAndView legals(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("legd");			
		}
		@RequestMapping(value="/legalchk" ,method = RequestMethod.GET)
		public ModelAndView legalchk(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("legalchk");			
		}
		@RequestMapping(value="/legalsuccess" ,method = RequestMethod.GET)
		public ModelAndView legalsuccess(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("legalsuccess");			
		}
		@RequestMapping(value="/legalmsg" ,method = RequestMethod.GET)
		public ModelAndView legalmsg(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("legalmsg");			
		}
		
		@RequestMapping(value="/legalcompose" ,method = RequestMethod.GET)
		public ModelAndView legalcompose(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
		{
			return new ModelAndView("legalcompose");			
		}*/
		
	@SuppressWarnings("rawtypes")
		// Search field for status in admin 
		@RequestMapping(value="/search" ,method = RequestMethod.GET)
		public void search(@ModelAttribute("command")  AppLoanBean bean,BindingResult result,HttpServletResponse response, HttpServletRequest request) throws IOException{
				String status=bean.getStatustype();
				PrintWriter out=null;
				out=response.getWriter();
				HttpSession ses=request.getSession();
				ses.setAttribute("status", status);
				List li1= apploanService.searchStatusType(status);
				System.out.println("the list is"+ li1.size());
				JSONArray array=null;
				 if(li1.size()>0)
				 {
					
					    JsonConfig jsonConfig = new JsonConfig();
						jsonConfig.setExcludes(new String[]{"li"});
						jsonConfig.setIgnoreDefaultExcludes(false);
						jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
						array = JSONArray.fromObject(li1,jsonConfig);
						System.out.println(array);
						out.print(array);
						out.flush();
					    out.close();
						//return array;
				 }
				 else
				 {
					 	JsonConfig jsonConfig = new JsonConfig();
						jsonConfig.setExcludes(new String[]{"li"});
						jsonConfig.setIgnoreDefaultExcludes(false);
						jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
						array = JSONArray.fromObject(li1,jsonConfig);
						System.out.println(array);
						out.print(array);
						out.flush();
					    out.close();
						//return array;
				 }
		}
	
	
	// Personal Loan 
	
	@RequestMapping(value="/personalloan" ,method = RequestMethod.GET)
	public ModelAndView personalloan(@ModelAttribute("command") LoanApplyBean bean,BindingResult result)
	{
		return new ModelAndView("personalloan");			
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/personalloansave" ,method = RequestMethod.POST)
	public ModelAndView personalloansave(@ModelAttribute("command") LoanApplyBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
	{
		try{
		LoanApplyValidator valid=new LoanApplyValidator();
		valid.validate(bean,result);
		if(result.hasErrors())
		{
			return new ModelAndView("personalloan");
			
		}	 
		
		
		TransactionLog tllog=new TransactionLog();
		Transactionbean tlbean=new Transactionbean();
		Date dt=new Date();
		SimpleDateFormat sdff=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
   		String sd=sdff.format(dt);
   		HttpSession hs=request.getSession(false); 
   
   		List liw=(List)hs.getAttribute("list");
   	
   		Iterator it=liw.iterator();
   	 
   		String un=null,tp=null;
   		while(it.hasNext())
   		{
   			Registration rr=(Registration)it.next();
   			un=rr.getUsername();
   			tp=rr.getType();
   		}
   	 tlbean.setUsername(un);
   	 tlbean.setType(tp);
   	 tlbean.setTask("Personal loan applied");
   	 tlbean.setTaskdt(sd);
   	 BeanUtils.copyProperties(tllog, tlbean);
   	 regService.Transactionlogdetails(tllog);
		
		/*DateTimeFormatter sdf =DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		  LocalDate today = LocalDate.now();
		 
		  String asd=sdf.format(today);
		  System.out.println(asd);*/
     Date dts=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		String asd=sdf.format(dts);
		//bean.setLoanacceptdate(asd);
		 HttpSession ses=request.getSession(false);
		String uname=(String) ses.getAttribute("username");
		String pwd=(String) ses.getAttribute("password");
		
		System.out.println("User name in applyloan is "+uname);
		System.out.println("Password  in applyloan is "+pwd);
	
		List<Registration>  li= regService.getUser(uname,pwd);
		System.out.println("Printing list is "+li);
		Integer id=li.get(0).getId();
		
		bean.setRegid(id);
		bean.setLoantype("Personal Loan");
		bean.setStatus("Applied");
		
		bean.setLoanapplydate(asd);
		LoanApply loan=new LoanApply();
		BeanUtils.copyProperties(loan, bean);
		apploanService.applypersonalloan(loan);
		}
		catch(Exception e)
		{
			log.error("Lending Tree System ::LendingTreeController ::personalloansave",e);
		}
		return new ModelAndView("personalloansave");			
	}	
	
	
	// Educational loan
	
	@RequestMapping(value="/educationloan" ,method = RequestMethod.GET)
	public ModelAndView educationloan(@ModelAttribute("command") LoanApplyBean bean,BindingResult result)
	{
		return new ModelAndView("educationloan");			
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/educationloansave" ,method = RequestMethod.POST)
	public ModelAndView educationloansave(@ModelAttribute("command") LoanApplyBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
	{
		try{
		 EducationLoanValidator valid=new  EducationLoanValidator();
		valid.validate(bean,result);
		if(result.hasErrors())
		{
			return new ModelAndView("educationloan");
			
		}
		TransactionLog tllog=new TransactionLog();
		Transactionbean tlbean=new Transactionbean();
		Date dt=new Date();
		SimpleDateFormat sdff=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
   		String sd=sdff.format(dt);
   		HttpSession hs=request.getSession(false); 
   
   		List liw=(List)hs.getAttribute("list");
   	
   		Iterator it=liw.iterator();
   	 
   		String un=null,tp=null;
   		while(it.hasNext())
   		{
   			Registration rr=(Registration)it.next();
   			un=rr.getUsername();
   			tp=rr.getType();
   		}
   	 tlbean.setUsername(un);
   	 tlbean.setType(tp);
   	 tlbean.setTask("Education loan applied");
   	 tlbean.setTaskdt(sd);
   	 BeanUtils.copyProperties(tllog, tlbean);
   	 regService.Transactionlogdetails(tllog);
   	 
		/*DateTimeFormatter sdf =DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		  LocalDate today = LocalDate.now();
		 
		  String asd=sdf.format(today);*/
   	 Date dts=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		String asd=sdf.format(dts);
		
		HttpSession ses=request.getSession(false);
		String uname=(String) ses.getAttribute("username");
		String pwd=(String) ses.getAttribute("password");
		
		System.out.println("User name in applyloan is "+uname);
		System.out.println("Password  in applyloan is "+pwd);
	
		List<Registration>  li= regService.getUser(uname,pwd);
		System.out.println("Printing list is "+li);
		Integer id=li.get(0).getId();
		
		bean.setRegid(id);
		bean.setLoantype("Education Loan");
		bean.setStatus("Applied");
		bean.setLoanapplydate(asd);
		LoanApply loan=new LoanApply();
		BeanUtils.copyProperties(loan, bean);
		apploanService.applypersonalloan(loan);
		}
		catch(Exception e)
		{
			log.error("Lending Tree System ::LendingTreeController ::educationloansave",e);
		}
		return new ModelAndView("educationloansave");			
	}	
	
// Home Loan
	
	@RequestMapping(value="/homeloan" ,method = RequestMethod.GET)
	public ModelAndView homeloan(@ModelAttribute("command") LoanApplyBean bean,BindingResult result)
	{
		return new ModelAndView("homeloan");			
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/homeloansave" ,method = RequestMethod.POST)
	public ModelAndView homeloansave(@ModelAttribute("command") LoanApplyBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
	{
		try{
		HomeLoanValidator valid=new HomeLoanValidator();
		valid.validate(bean,result);
		if(result.hasErrors())
		{
			return new ModelAndView("homeloan");
			
		}
		TransactionLog tllog=new TransactionLog();
		Transactionbean tlbean=new Transactionbean();
		Date dt=new Date();
		SimpleDateFormat sdff=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
   		String sd=sdff.format(dt);
   		HttpSession hs=request.getSession(false); 
   
   		List liw=(List)hs.getAttribute("list");
   	
   		Iterator it=liw.iterator();
   	 
   		String un=null,tp=null;
   		while(it.hasNext())
   		{
   			Registration rr=(Registration)it.next();
   			un=rr.getUsername();
   			tp=rr.getType();
   		}
   	 tlbean.setUsername(un);
   	 tlbean.setType(tp);
   	 tlbean.setTask("Home loan applied");
   	 tlbean.setTaskdt(sd);
   	 BeanUtils.copyProperties(tllog, tlbean);
   	 regService.Transactionlogdetails(tllog);
		/*DateTimeFormatter sdf =DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		  LocalDate today = LocalDate.now();
		 
		  String asd=sdf.format(today);*/
   	 	Date dts=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		String asd=sdf.format(dts);
		HttpSession ses=request.getSession(false);
		String uname=(String) ses.getAttribute("username");
		String pwd=(String) ses.getAttribute("password");
		System.out.println("User name in applyloan is "+uname);
		System.out.println("Password  in applyloan is "+pwd);
	
		List<Registration>  li= regService.getUser(uname,pwd);
		System.out.println("Printing list is "+li);
		Integer id=li.get(0).getId();
		
		bean.setRegid(id);
		bean.setLoantype("Home Loan");
		bean.setStatus("Applied");
		bean.setLoanapplydate(asd);
		LoanApply loan=new LoanApply();
		BeanUtils.copyProperties(loan, bean);
		apploanService.applypersonalloan(loan);
		}
		catch(Exception e)
		{
			log.error("Lending Tree System ::LendingTreeController ::homeloansave",e);
		}
		return new ModelAndView("homeloansave");			
	}
//Business Loan
	@RequestMapping(value="/businessloan" ,method = RequestMethod.GET)
	public ModelAndView businessloan(@ModelAttribute("command") LoanApplyBean bean,BindingResult result)
	{
		return new ModelAndView("businessloan");			
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/businessloansave" ,method = RequestMethod.POST)
	public ModelAndView businessloansave(@ModelAttribute("command") LoanApplyBean bean,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException
	{
		try{
		BusinessLoanValidator valid=new BusinessLoanValidator();
		valid.validate(bean,result);
		if(result.hasErrors())
		{
			return new ModelAndView("businessloan");
			
		}	
		TransactionLog tllog=new TransactionLog();
		Transactionbean tlbean=new Transactionbean();
		Date dt=new Date();
		SimpleDateFormat sdff=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
   		String sd=sdff.format(dt);
   		HttpSession hs=request.getSession(false); 
   
   		List liw=(List)hs.getAttribute("list");
   	
   		Iterator it=liw.iterator();
   	 
   		String un=null,tp=null;
   		while(it.hasNext())
   		{
   			Registration rr=(Registration)it.next();
   			un=rr.getUsername();
   			tp=rr.getType();
   		}
   	 tlbean.setUsername(un);
   	 tlbean.setType(tp);
   	 tlbean.setTask("Business loan applied");
   	 tlbean.setTaskdt(sd);
   	 BeanUtils.copyProperties(tllog, tlbean);
   	 regService.Transactionlogdetails(tllog);
		/*DateTimeFormatter sdf =DateTimeFormatter.ofPattern("MM/dd/yyyy");
		
		  LocalDate today = LocalDate.now();
		 
		  String asd=sdf.format(today);*/
   	 	Date dts=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		String asd=sdf.format(dts);
		
		HttpSession ses=request.getSession(false);
		String uname=(String) ses.getAttribute("username");
		String pwd=(String) ses.getAttribute("password");
		System.out.println("User name in applyloan is "+uname);
		System.out.println("Password  in applyloan is "+pwd);
	
		List<Registration>  li= regService.getUser(uname,pwd);
		System.out.println("Printing list is "+li);
		Integer id=li.get(0).getId();
		
		bean.setRegid(id);
		bean.setLoantype("Business Loan");
		bean.setStatus("Applied");
		bean.setLoanapplydate(asd);
		LoanApply loan=new LoanApply();
		BeanUtils.copyProperties(loan, bean);
		apploanService.applypersonalloan(loan);
		}
		catch(Exception e)
		{
			log.error("Lending Tree System ::LendingTreeController ::businessloansave",e);
		}
		return new ModelAndView("businessloansave");			
	}

	@RequestMapping(value="/loanapplied" ,method = RequestMethod.GET)
	public ModelAndView loanapplied(@ModelAttribute("command")LoanApplyBean bean,BindingResult result)
	{
		return new ModelAndView("loanapplied");			
	}
	
	
		@RequestMapping(value="/loanADisplayGrid", method = RequestMethod.GET)
		public void applylistCust(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse response) throws IOException {
		 PrintWriter out=null;
			out=response.getWriter();
			System.out.println("enter into datagrid list");
			List<LoanApply> li=apploanService.getLoanCustomers();
			System.out.println("list size is: "+li.size());
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"li"});
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray array = JSONArray.fromObject(li,jsonConfig);
			System.out.println(array);
			out.print(array);
			out.flush();
		    out.close();
			//return array;
		}	
	
	
	
	 @RequestMapping(value="/ loanverified" ,method = RequestMethod.GET)
		public ModelAndView loanverified(@ModelAttribute("command")LoanApplyBean bean,BindingResult result)
		{
			return new ModelAndView("loanverified");			
		}
		
	
			@RequestMapping(value="/loanVDisplayGrid", method = RequestMethod.GET)
			public void loanVerified(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletResponse response) throws IOException {
			 PrintWriter out=null;
				out=response.getWriter();
				System.out.println("enter into datagrid list");
				List<LoanApply> li=apploanService.getLoanCustomers();
				System.out.println("list size is: "+li.size());
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setExcludes(new String[]{"li"});
				jsonConfig.setIgnoreDefaultExcludes(false);
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				JSONArray array = JSONArray.fromObject(li,jsonConfig);
				System.out.println(array);
				out.print(array);
				out.flush();
			    out.close();
				//return array;
			}	
		
	
//  List of loans sanction between dates
			
			
			@RequestMapping(value = "/dates", method = RequestMethod.GET)

			public void  sanctiondates(@ModelAttribute("command") LoanApplyBean bean,BindingResult result, ServletResponse response, ServletRequest request ) throws Exception {
			
				
				
				 PrintWriter out=null;
				 out=response.getWriter();
				 String start=request.getParameter("from");
				 String end=request.getParameter("to");
				 List<LoanApply> li= apploanService.sanctiondates(start,end);
				 System.out.println("the list is"+ li.size());
					
				 JsonConfig jsonConfig = new JsonConfig();
				 jsonConfig.setExcludes(new String[]{"li"});
				 jsonConfig.setIgnoreDefaultExcludes(false);
				 jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				 JSONArray array = JSONArray.fromObject(li,jsonConfig);
				 System.out.println(array);
				 out.print(array);
				 out.flush();
				 out.close();
				 //return array;	
			}
			
// Reports
			@RequestMapping(value = "/sanction", method = RequestMethod.GET)
			public ModelAndView  sanctionbean(@ModelAttribute("command") LoanApply bean, ServletResponse response ) throws Exception {
				
			
				List<LoanApply> li=regService.getReports();
				System.out.println(" Reports list is "+li);
				
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("reports",regService.getReports());	
			
			
				return new ModelAndView("sanctionreports",model);
				
			
			}
//HTML file export
			 @RequestMapping(value = "/downloadhtmlformat", method = RequestMethod.GET)

			 public ModelAndView downloadhtmlformat(@ModelAttribute("command")LoanApplyBean bean, HttpServletResponse response, ServletRequest request  ) throws Exception {
			 	try{
				 PrintWriter out =response.getWriter();
				List<LoanApply> li=apploanService.getCustomers();
			 	String aa="customers.html";
			 	
			 	response.addHeader("Content-Disposition", "attachment;filename="+aa);
			 	out.println("<h1 align='center'>Customers Detailse are</h1>");
			 	out.print("<table border='1' align='center'><tr><th>Loan Id</th><th>User Id</th><th>First name</th><th>Loan Type</th><th>Bank Type</th><th>Interest</th><th>Loan Amount</th><th>Loan Applied Date</th><th>Loan Sanction/Reject Date</th><th>Status</th></tr>");
			 	Iterator<LoanApply> it=li.iterator();
			 	while(it.hasNext())
			 	{
			 		LoanApply loan=(LoanApply)it.next();
			 		out.println("<tr><td>"+loan.getId()+"</td><td>"+loan.getRegid()+"</td><td>"+loan.getFirstname()+"</td><td>"+loan.getLoantype()+"</td><td>"+loan.getBanktype()+"</td><td>"+loan.getInterestrate()+"</td><td>"+loan.getLoanamount()+"</td><td>"+loan.getLoanapplydate()+"</td><td>"+loan.getLoanacceptdate()+"</td><td>"+loan.getStatus()+"</td></tr>");
			 	}
			 	 out.println("</table>");
			 	 
			 	}
			 	catch(Exception e)
				{
					log.error("Lending Tree System ::LendingTreeController ::downloadhtmlformat",e);
				}
			 	 
			      return null;
			  }
// PDF file export
			@RequestMapping(value = "/downloadpdfformat", method = RequestMethod.GET)
			public ModelAndView  pdfformat(@ModelAttribute("command") LoanApply bean, HttpServletResponse response ) throws Exception {
			   
				   
			   
				List<LoanApply> li=apploanService.getCustomers();
			    
				 String aa="customers.pdf";
				 response.addHeader("Content-Disposition", "attachment;filename="+aa);
			   
			   
			    return new ModelAndView("pdfView", "li", li);
			}
// Excel file export
			@RequestMapping(value = "/downloadexcelformat", method = RequestMethod.GET)

			public ModelAndView reportinexcel(@ModelAttribute("command") LoanApply bean, HttpServletResponse response, ServletRequest request  ){

				List<LoanApply> li=apploanService.getCustomers();
				 
				 String aa="customers.xls";
				((HttpServletResponse) response).addHeader("Content-Disposition", "attachment;filename="+aa);

			     return new ModelAndView("excelView", "li", li);
			 }
// XML file export
			@RequestMapping(value = "/downloadxmlformat", method = RequestMethod.GET)

			public void reportinxml(@ModelAttribute("command") LoanApply bean, HttpServletResponse response, ServletRequest request  ) throws Exception{
				try{
				String csvFileName = "customers.xml";
				 
			     response.setContentType("text/csv");
			     String headerKey = "Content-Disposition";
			     String headerValue = String.format("attachment; filename=\"%s\"",
			             csvFileName);
			   response.setHeader(headerKey, headerValue);
			   List<LoanApply> li=apploanService.getCustomers();
				
				  ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
			              CsvPreference.STANDARD_PREFERENCE);


				 String[] header = { "id", "regid", "firstname", "loantype",
			             "banktype", "interestrate", "loanamount","loanapplydate","loanacceptdate","status" };

				 csvWriter.writeHeader(header);
				 
				 for (LoanApply lp : li) {
			         csvWriter.write(lp, header);
			     }

			     csvWriter.close();
			 	 String aa="customers.xml";
				 response.addHeader("Content-Disposition", "attachment;filename="+aa);
				}
				catch(Exception e)
				{
					log.error("Lending Tree System ::LendingTreeController ::downloadxmlformat",e);
				}

			 }
// CSV file export
			@RequestMapping(value = "/downloadcsvformat", method = RequestMethod.GET)

			public void reportincsv(@ModelAttribute("command") LoanApply bean, HttpServletResponse response, ServletRequest request  ) throws Exception{
				try{ 
				String csvFileName = "customers.csv";
				 
			     response.setContentType("text/csv");
			     String headerKey = "Content-Disposition";
			     String headerValue = String.format("attachment; filename=\"%s\"",
			             csvFileName);
			   response.setHeader(headerKey, headerValue);
			   List<LoanApply> li=apploanService.getCustomers();
				
				  ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
			              CsvPreference.STANDARD_PREFERENCE);


				  String[] header = { "id", "regid", "firstname", "loantype",
				             "banktype", "interestrate", "loanamount","loanapplydate","loanacceptdate","status" };

				 csvWriter.writeHeader(header);
				 
				 for (LoanApply lp : li) {
			         csvWriter.write(lp, header);
			     }

			     csvWriter.close();
			 	String aa="customers.csv";
				 response.addHeader("Content-Disposition", "attachment;filename="+aa);
				}
				catch(Exception e)
				{
					log.error("Lending Tree System ::LendingTreeController ::downloadcsvformat",e);
				}

			 }
// Text file export
			@RequestMapping(value = "/downloadtextformat", method = RequestMethod.GET)

			public void reportintext(@ModelAttribute("command") LoanApply bean, HttpServletResponse response, ServletRequest request  ) throws Exception{
				try{ 
				String csvFileName = "customers.txt";
				 
			     response.setContentType("text/csv");
			     String headerKey = "Content-Disposition";
			     String headerValue = String.format("attachment; filename=\"%s\"",
			             csvFileName);
			   response.setHeader(headerKey, headerValue);
			   List<LoanApply> li=apploanService.getCustomers();
				
				  ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
			              CsvPreference.STANDARD_PREFERENCE);


				  String[] header = { "id", "regid", "firstname", "loantype",
				             "banktype", "interestrate", "loanamount","loanapplydate","loanacceptdate","status" };

				 csvWriter.writeHeader(header);
				 
				 
				 for (LoanApply lp : li) {
			         csvWriter.write(lp, header);
			     }

			     csvWriter.close();
			 	String aa="customers.txt";
				 response.addHeader("Content-Disposition", "attachment;filename="+aa);
				}
				catch(Exception e)
				{
					log.error("Lending Tree System ::LendingTreeController ::downloadtextformat",e);
				}

			 }
// DOC file export
			
			@RequestMapping(value = "/downloaddocformat", method = RequestMethod.GET)

			public void docformat(@ModelAttribute("command") LoanApply bean, HttpServletResponse response, ServletRequest request  ) throws Exception{
				
				try{
				
				String csvFileName = "customers.doc";
				 
			     response.setContentType("text/csv");
			     String headerKey = "Content-Disposition";
			     String headerValue = String.format("attachment; filename=\"%s\"",
			             csvFileName);
			   response.setHeader(headerKey, headerValue);
			   List<LoanApply> li=apploanService.getCustomers();
				
				  ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
			              CsvPreference.STANDARD_PREFERENCE);


				  String[] header = { "id", "regid", "firstname", "loantype",
				             "banktype", "interestrate", "loanamount","loanapplydate","loanacceptdate","status" };

				 csvWriter.writeHeader(header);
				 
				 
				 for (LoanApply lp : li) {
			         csvWriter.write(lp, header);
			     }

			     csvWriter.close();
			 	String aa="customers.doc";
				 response.addHeader("Content-Disposition", "attachment;filename="+aa);

			 
			}
			catch(Exception e)
			{
				log.error("Lending Tree System ::LendingTreeController ::downloaddocformat",e);
			}
			}
			
// Database  export and import
			
			@RequestMapping(value="/exportdb" ,method = RequestMethod.GET)
			public ModelAndView exportdb(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
			{
				
				try {
			    	  
					  String path="D:/vijaykanth/lendingtreeDmp";
					
			    	  String str = "exp lendingtree/vijay file= "+path;
			    	  
			    	  Process process = Runtime.getRuntime().exec(str);
					  BufferedReader in = 
					             new BufferedReader(new InputStreamReader(process.getErrorStream()));
					  String line = null;
					  while ((line = in.readLine()) != null) {
					  
					  }
					    	  
			          
				   
				   }
					catch (Exception e) {
				    System.out.println(e);
				   }
				return new ModelAndView("dbexport");	
				
				
			}
			@RequestMapping(value="/importdb" ,method = RequestMethod.GET)
			public ModelAndView importdb(@ModelAttribute("command") RegistrationBean bean,BindingResult result)
			{
			
				
			 try {
			    	  
			    	  String[] str = {"imp", "lendingtree/vijay file=D:/vijaykanth/lendingtreeDmp.DMP", 
			                  "fromuser=lendingtree", "touser=lts", 
			                  "full=N ignore=Y grants=Y indexes=Y;"};

			    	  Process process = Runtime.getRuntime().exec(str);
					  BufferedReader in = 
					             new BufferedReader(new InputStreamReader(process.getErrorStream()));
					  String line = null;
					  while ((line = in.readLine()) != null) {
					  }
					    	  
			          
				   
				 }
				 catch (Exception e) {
				   System.out.println(e);
				 }
			 return new ModelAndView("dbimport");
			}
			
			
			
// File upload
			
			@RequestMapping(value="/uploaddoc" ,method = RequestMethod.POST)
			public ModelAndView index(@ModelAttribute("command") UploadFileBean bean,BindingResult result)
			{
				return new ModelAndView("uploaddoc");			
			}
			
			@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
			public ModelAndView fileUplaod(@ModelAttribute("command")LoanApplyBean bean,BindingResult result,HttpServletRequest servletRequest,@RequestParam(value = "file", required = false) MultipartFile image)throws Exception 
			{
				System.out.println("Do upload is running");
				String filename=image.getOriginalFilename();  
				String arnpath="D:/vijaykanth/WorkSpace_App/LendingTree_MiniApp/WebContent/images";
				try {
						File file = new File(arnpath + "/"+ filename);
						 
						FileUtils.writeByteArrayToFile(file, image.getBytes());
						System.out.println("bytes"+image.getBytes());
						System.out.println("Go to the location:  " + file.toString()
						+ " on your computer and verify that the image has been stored");
					}
				catch (IOException e) {
						throw e;
				}
						
				LoanApply pm=new LoanApply();
				BeanUtils.copyProperties(pm,bean);
				apploanService.addDocs(pm);
				return new ModelAndView("success");
				}
			
			
			// Import files
			
			@RequestMapping(value = "/openjsp", method = RequestMethod.GET)
			public ModelAndView openjspexel(@ModelAttribute("command")  LoanApply bean, ServletResponse response, ServletRequest request  ){

				
			     return new ModelAndView("openjsp");
			 }
			
			@RequestMapping(value = "/gettingexcel",method=RequestMethod.POST)
			public String processExcel2003(@RequestParam(value = "excelfile", required = false) MultipartFile  excelfile) {		
				
				System.out.println("comming1 ");
				
				try {
					
					System.out.println("comming ");
					List<LoanApply> lstUser = new ArrayList();
					int i = 1;
					System.out.println(excelfile.getInputStream());
					// Creates a workbook object from the uploaded excelfile
					HSSFWorkbook workbook = new HSSFWorkbook(excelfile.getInputStream());
					System.out.println(workbook.getNumberOfSheets());
					// Creates a worksheet object representing the first sheet
					HSSFSheet worksheet = workbook.getSheetAt(0);
					// Reads the data in excel file until last row is encountered
					while (i <= worksheet.getLastRowNum()) {
					
						LoanApply loan=new LoanApply();
						// Creates an object representing a single row in excel
						HSSFRow row = worksheet.getRow(i++);
						// Sets the Read data to the model class
						//fir.setId( (int) row.getCell( (short) 0).getNumericCellValue());
						loan.setId(row.getCell( (short) 1).getRowIndex());
						loan.setRegid(row.getCell( (short) 2).getRowIndex());
						
						loan.setFirstname(row.getCell((short) 3).getStringCellValue());
						
						loan.setLoantype(row.getCell((short) 4).getStringCellValue());
						loan.setBanktype(row.getCell((short) 5).getStringCellValue());
						loan.setInterestrate(row.getCell((short) 6).getStringCellValue());
						
						loan.setLoanamount(row.getCell((short) 7).getStringCellValue());
						loan.setLoanapplydate(row.getCell((short) 8).getStringCellValue());
						loan.setLoanacceptdate(row.getCell((short) 9).getStringCellValue());
						
						
						loan.setStatus(row.getCell((short) 10).getStringCellValue());
						apploanService.addexcel(loan);
					
						lstUser.add(loan);
					}			
					


				} catch (Exception e) {
					e.printStackTrace();
				}

				return "success";
			}
	}
