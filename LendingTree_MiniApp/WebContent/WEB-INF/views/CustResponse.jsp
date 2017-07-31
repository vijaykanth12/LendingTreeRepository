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
<title>Loan</title>

<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
     <script type="text/javascript" src="jquery.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({
      changeMonth: true,
      changeYear: true
    });
  } );
  </script>
  <script type="text/javascript" src="Js/countries.js"></script>
  
  <style>
body {  
   
}  
.error{
     color:red;font-weight: bold;
}
</style>

<script>
  function displayEmps()
  {
	  var status=document.getElementById("status").value;
	  
	  if(status=="Verification"){

	$.ajax({
	   	 
	    url: 'bankemps.html',   
	  	success: function(response){
	   
	      		var k=response.split(",");
	   			for(var i=0;i<k.length-1;i++)
	   			 {
		 			var l=document.getElementById("emps");
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
} 
  
  </script>

</head>
<body>

<form:form method="POST" action="loanresponse.html">
     <center>
    
     <h3>Personal Details</h3>
     <table border="0" align="center">
	<tr>
		<td><form:label path="id">Id</form:label></td>
		<td><form:input path="id"  readonly="true"/></td><td>
	  </tr>
	   <tr>
			<td>User Id</td>
			<td><form:input path="regid" readonly="true"/></td>
		</tr>  		
<tr><td>First Name</td>
<td><form:input path="firstname" readonly="true"/></td>

<tr><td>Last Name</td>
<td><form:input path="lastname" readonly="true"/></td>
<td ><form:errors path="lastname" cssClass="error"></form:errors></td></tr>

<tr><td>Email Id</td>
<td><form:input path="emailid" readonly="true"/></td>
<td ><form:errors path="emailid" cssClass="error"></form:errors></td></tr>
<tr><td>Mobile</td>
<td><form:input path="mobile" readonly="true"/></td>
<td ><form:errors path="mobile" cssClass="error"></form:errors></td></tr>
<tr><td>Gender</td>
<td><form:radiobutton path="gender" readonly="true" value="male"/>Male
<form:radiobutton path="gender" value="female"/>Female
</td>
<td ><form:errors path="gender" cssClass="error"></form:errors></td></tr>
<tr>
<tr><td>Date Of Birth</td>
<td><form:input path="dateofbirth" readonly="true" class="easyui-datebox"  style="width:150%;"></form:input></td>
<td ><form:errors path="dateofbirth" cssClass="error"></form:errors></td></tr>
<tr><td>PAN No</td>
<td><form:input path="pan" readonly="true"/></td>
<td ><form:errors path="pan" cssClass="error"></form:errors></td></tr>
	
	<tr>
			<td>Country</td>
			<td><form:input path="country" readonly="true"/></td>
			<td><form:errors path="country" cssClass="error"></form:errors></td></tr>
<tr><td>State</td>
<td><form:input path="state" readonly="true" ></form:input></td>
<td><form:errors path="state" cssClass="error"></form:errors></td></tr>
<tr><td>City</td>
<td><form:input path="city" readonly="true"/></td>
<td ><form:errors path="city" cssClass="error"></form:errors></td></tr>
<tr><td>Pin Code</td>
<td><form:input path="pincode" readonly="true"/></td>
<td ><form:errors path="pincode" cssClass="error"></form:errors></td></tr>

<tr><td>Address</td>
<td><form:textarea path="address" readonly="true" style="width:143px"></form:textarea></td>
<td ><form:errors path="address" cssClass="error"></form:errors></td></tr></table>
<h3>Education and Employment Details</h3>
<table>
<tr><td>Qualification</td>
<td><form:input path="qualification" readonly="true"/></td>
<td ><form:errors path="qualification" cssClass="error"></form:errors></td></tr>
<tr><td>Occupation</td>
<td><form:input path="occupation" readonly="true"/></td>
<td ><form:errors path="occupation" cssClass="error"></form:errors></td></tr>
<tr><td>Company</td>
<td><form:input path="company" readonly="true"/></td>
<td ><form:errors path="company" cssClass="error"></form:errors></td></tr>
<tr><td>Work Email Id</td>
<td><form:input path="workmail" readonly="true"/></td>
<td ><form:errors path="workmail" cssClass="error"></form:errors></td></tr>
<tr><td>Office Contact No</td>
<td><form:input path="ofccontact" readonly="true"/></td>
<td ><form:errors path="ofccontact" cssClass="error"></form:errors></td></tr>
<tr><td>Office Address</td>
<td><form:textarea path="ofcaddress" readonly="true" style="width:143px"></form:textarea></td>
<td ><form:errors path="ofcaddress" cssClass="error"></form:errors></td></tr>
<tr><td>Salary(per month)</td>
<td><form:input path="salary" readonly="true"/></td>
<td ><form:errors path="salary" cssClass="error"></form:errors></td></tr>


<tr>
			<td>Loan Type</td>
			<td><form:input path="loantype" readonly="true"/></td>
			<td><form:errors path="loantype" cssClass="error"></form:errors></td></tr>
			
		
		<tr>
			<td>Bank Type</td>
			<td><form:input path="Banktype" readonly="true"/></td>
			<td><form:errors path="Banktype" cssClass="error"></form:errors></td></tr>
		
		
		<tr><td>Interest Rate</td>
<td><form:input path="interest" readonly="true"/></td>
<td ><form:errors path="interest" cssClass="error"></form:errors></td></tr>
	
<tr>
			<td>Status Type</td>
			<td><form:select path="statustype" style="width:150px" id="status">
				<option>Select Option</option>
				<option value="Sanction">Sanction</option>
				<option value="Rejected">Reject</option>
				<option value="Verification">Verification</option>
			</form:select>
			</td>
		</tr>
<tr>
			<td>Assign To</td>
			<td><form:select path="assignto" style="width:150px" onclick="displayEmps();" id="emps">
				<option value="">Select Option</option>
				
			</form:select>
			</td>
		</tr>


				<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Submit"/>
					<input type="reset" value="Reset"/></td>
				</tr>
</table>
</center>
</form:form>

</body>
</html>