<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.net.URL"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Apply Loan Page</title>

<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
     
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );
  </script>
  <script type="text/javascript" src="Js/countries.js"></script>
  <script type="text/javascript" src="jquery.js"></script>
  <script>
  
  function checnum(as)
  {
  	var dd = as.value;
  
  	if(isNaN(dd))
  	{
  		dd = dd.substring(0,(dd.length-1));
  		as.value = dd;
  	}
  }  
  
  
  
   function displayLoan()
  {
	 var loan=document.getElementById("loandisplay").value;
	
	  
	$.ajax({
	   	 
	    url: 'displayloan.html',   
	   	data:"loans="+loan,
	    success: function(response){
	   
	      		var k=response.split(",");
	   			for(var i=0;i<k.length-1;i++)
	   			 {
		 			var l=document.getElementById("loandisplay");
	   				var option=document.createElement("option");
	   				option.text=k[i];
	   				l.add(option);
				 }
	   		
	    },
	    error: function(e){
	   		 alert('Error: ' + e);
	    }
	    });
} 
  
  </script>
  <script>
   function displayBank()
  {
	 var loan=document.getElementById("loandisplay").value;

	 var bank=document.getElementById("bankdisplay").value;
	
	  
	$.ajax({
	   	 
	    url: 'displaybank.html',   
	   	data:"loans="+loan+"&banks="+bank,
	   
	    success: function(response){
	   			
	      		var k=response.split(",");
	   			for(var i=0;i<k.length-1;i++)
	   			 {
		 			var l=document.getElementById("bankdisplay");
	   				var option=document.createElement("option");
	   				option.text=k[i];
	   				l.add(option);
				 }
	   		
	    },
	    error: function(e){
	   		 alert('Error: ' + e);
	    }
	    });
} 
  
  </script>
  
   <script>
   function displayInterest()
  {
	 var loan=document.getElementById("loandisplay").value;

	 var bank=document.getElementById("bankdisplay").value;
	
	  
	$.ajax({
	   	 
	    url: 'displayinterest.html',   
	   	data:"loans="+loan+"&banks="+bank,
	   
	    success: function(response){
	   			
	      
	   			alert(response);
	   			
	   		    document.getElementById("interestrate").value = response;
	   			
				 
	   		
	    },
	    error: function(e){
	   		 alert('Error: ' + e);
	    }
	    });
} 
  
  </script>
 <style>
		body {  
   
			 }  
		.error{
     			color:red;font-weight: bold;
			  }
</style>
</head>
<body>

<form:form method="POST" action="applyloansave.html">


     <center>
    
     <h2>Apply Loan</h2>
     <table border="0" align="center">

	 <tr>
		<td></td>
		<td><form:hidden path="id"/></td>
	  </tr>  		
<%-- <tr><td>First Name</td>
<td><form:hidden path="firstname"/></td>
<td ><form:errors path="firstname" cssClass="error"></form:errors></td></tr>
<tr><td>Last Name</td>
<td><form:input path="lastname"/></td>
<td ><form:errors path="lastname" cssClass="error"></form:errors></td></tr>

<tr><td>Email Id</td>
<td><form:input path="emailid"/></td>
<td ><form:errors path="emailid" cssClass="error"></form:errors></td></tr>
<tr><td>Mobile</td>
<td><form:input path="mobile"/></td>
<td ><form:errors path="mobile" cssClass="error"></form:errors></td></tr>
<tr><td>Gender</td>
<td><form:radiobutton path="gender" value="male"/>Male
<form:radiobutton path="gender" value="female"/>Female
</td>
<td ><form:errors path="gender" cssClass="error"></form:errors></td></tr>
<tr>
<tr><td>Date Of Birth</td>
<td><form:input path="dateofbirth" class="easyui-datebox"  style="width:150%;"></form:input></td>
<td ><form:errors path="dateofbirth" cssClass="error"></form:errors></td></tr>  --%>
<tr><td>PAN No</td>
<td><form:input path="pan"/></td>
<td ><form:errors path="pan" cssClass="error"></form:errors></td></tr>
<tr><td>Qualification</td>
<td><form:input path="qualification"/></td>
<td ><form:errors path="qualification" cssClass="error"></form:errors></td></tr>
<tr><td>Occupation</td>
<td><form:input path="occupation"/></td>
<td ><form:errors path="occupation" cssClass="error"></form:errors></td></tr>
<tr><td>Company</td>
<td><form:input path="company"/></td>
<td ><form:errors path="company" cssClass="error"></form:errors></td></tr>
<tr><td>Work Email Id</td>
<td><form:input path="workmail"/></td>
<td ><form:errors path="workmail" cssClass="error"></form:errors></td></tr>
<tr><td>Office Contact No</td>
<td><form:input path="ofccontact"/></td>
<td ><form:errors path="ofccontact" cssClass="error"></form:errors></td></tr>
<tr><td>Office Address</td>
<td><form:textarea path="ofcaddress" style="width:143px"></form:textarea></td>
<td ><form:errors path="ofcaddress" cssClass="error"></form:errors></td></tr>
<tr><td>Salary (Per Month)</td>
<td><form:input path="salary"/></td>
<td ><form:errors path="salary" cssClass="error"></form:errors></td></tr>



<tr>
			<td>Loan Type</td>
			<td><form:select path="loantype"  style="width:149px" onclick="displayLoan();" id="loandisplay">
				<option value="">Select Loan Type</option>
			
			
				</form:select>
			</td>
			<td ><form:errors path="loantype" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Bank Type</td>
			<td><form:select path="banktype" style="width:149px"  onclick="displayBank();" onchange="displayInterest();" id="bankdisplay">
				<option value="">Select Bank Type</option>
			
				</form:select>
			</td>
			<td ><form:errors path="banktype" cssClass="error"></form:errors></td>
		</tr>
		
		<tr><td>Amount ( Max.15L)</td>
<td><input name=amount type=text size=20 onkeyup=checnum(this) ></td>
<td ><form:errors path="amount" cssClass="error"></form:errors></td></tr>
		
		<tr><td>Interest Rate</td>
<td><form:input path="interest" id="interestrate" readonly="true"/></td>
<td ><form:errors path="interest" cssClass="error"></form:errors></td></tr>


				<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Apply"/>
					<input type="reset" value="Reset"/></td>
				</tr> 
</table>
</center>
</form:form>

</body>
</html>