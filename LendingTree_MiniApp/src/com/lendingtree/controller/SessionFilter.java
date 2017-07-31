package com.lendingtree.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;
public class SessionFilter  extends OncePerRequestFilter  {

	@SuppressWarnings("unused")
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		    // TODO Auto-generated method stub
			HttpSession ses=request.getSession();
			RequestDispatcher rd=null;
		    String path = request.getServletPath();
		    System.out.println("the Path is : "+path);
		    
		if(path.equals("/aboutus.html")||path.equals("/baselayout.html")
||path.equals("/emi.html")||path.equals("/signup.html")||path.equals("/save.html")||path.equals("/checkuser.html")||path.equals("/checkuseremp.html")
||path.equals("/login.html")||path.equals("/log.html")||path.equals("/forgotpassword.html")||path.equals("/home.html")||path.equals("/interest.html")||path.equals("/viewinterest.html")||path.equals("/getinterestrates.html")||path.equals("/interestgrid.html")||path.equals("/displayloan.html"))
			
		{
			
			 chain.doFilter(request, response);
			 
	
		}
		else
		{
			String username = null;
			try
			{
				 HttpSession as = request.getSession(false);
				 username = (String) as.getAttribute("username");
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		   
			if(username==null)
			{
				if(path.equals("/adminupdate.html")||path.equals("/editadmin.html")||path.equals("/adminsaveupdate.html")
					||path.equals("/adminchpwd.html")||path.equals("/adminchpwdupdate.html")||path.equals("/adhome.html")||path.equals("/adhomee.html")||path.equals("/bank.html")
					||path.equals("/banksave.html")||path.equals("/bankaddgrid.html")||path.equals("/updatebank.html")||path.equals("/bankupdate.html")||path.equals("/deletebank.html")
					||path.equals("/loan.html")||path.equals("/addloan.html")||path.equals("/loansave.html")||path.equals("/updateloan.html")||path.equals("/dept.html")||path.equals("/deptaddgrid.html")||path.equals("/adddept.html")||path.equals("/deptsave.html")||path.equals("/updatedept.html")||path.equals("/deptupdatesave.html")||path.equals("/deletedept.html")||path.equals("/emp.html")||path.equals("/addemp.html")||path.equals("/adddept.html")||path.equals("/empadddept.html")||path.equals("/bankemps.html")||path.equals("/empsave.html")||path.equals("/updateemp.html")||path.equals("/empupdatesave.html")||path.equals("/deleteemp.html")||path.equals("/cust.html")||path.equals("/personalresponse.html")||path.equals("/ploanresponsesave.html")||path.equals("/educationresponse.html")||path.equals("/eloanresponsesave.html")||path.equals("/homeresponse.html")||path.equals("/hloanresponsesave.html")||path.equals("/businessresponse.html")	
					||path.equals("/bloanresponsesave.html")||path.equals("/apersonalresponse.html")||path.equals("/aaploanresponse.html")||path.equals("/aeducationresponse.html")||path.equals("/aaeloanresponse.html")||path.equals("/ahomeresponse.html")||path.equals("/aahloanresponse.html")||path.equals("/abusinessresponse.html")||path.equals("/aabloanresponse.html")||path.equals("/msg.html")||path.equals("/compose.html")||path.equals("/user.html")||path.equals("/userhome.html")||path.equals("/apploan.html")||path.equals("//applyloansave.html")||path.equals("/displayloan.html")||path.equals("/displaybank.html")||path.equals("/displayinterest.html")||path.equals("/status.html")||path.equals("/usermsg.html")||path.equals("/composeuser.html")||path.equals("/composesave.html")||path.equals("/adminmsg.html")||path.equals("/composeadmin.html")||path.equals("/chpwdu.html")||path.equals("/userchpwdupdate.html")||path.equals("/updateuserk.html")||path.equals("/usersaveupdate.html")||path.equals("/chpwdusersuccess.html")||path.equals("/veryhome.html")||path.equals("/VericationDisplayGrid.html")||path.equals("/verpersonalresponse.html")||path.equals("/verploanresponsesave.html")||path.equals("/vereducationresponse.html")||path.equals("/vereloanresponsesave.html")
					||path.equals("/verhomeresponse.html")||path.equals("/verhloanresponsesave.html")||path.equals("/verbusinessresponse.html")||path.equals("/verbloanresponsesave.html")||path.equals("/vupdate.html")||path.equals("/VerificationDisplayGrid.html")||path.equals("/verificationupdate.html")||path.equals("/verificationupdatesave.html")||path.equals("/empchpwd.html")||path.equals("/empchpwdupdate.html")||path.equals("/search.html")||path.equals("/personalloan.html")||path.equals("/personalloansave.html")||path.equals("/educationloan.html")||path.equals("/educationloansave.html")||path.equals("/homeloan.html")||path.equals("/homeloansave.html")||path.equals("/businessloan.html")||path.equals("/businessloansave.html")||path.equals("/sanction.html")||path.equals("/loanapplied.html")||path.equals("/loanverified.html")||path.equals("/loanVDisplayGrid.html")||path.equals("/loanADisplayGrid.html")||path.equals("/dates.html")||path.equals("/very.html"))				
						
				{
					rd=request.getRequestDispatcher("psessionexpire.html");
			        rd.forward(request,response);
				}
				else
				{
					rd=request.getRequestDispatcher("sessionexpire.html");
					rd.forward(request,response);
				}
				
			}
			else
			{
				chain.doFilter(request, response);
			}
		}
		
	}
	}


