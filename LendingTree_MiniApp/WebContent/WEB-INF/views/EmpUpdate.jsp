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
<title>Employee Update  Page</title>
<script type="text/javascript" src="jquery.js"></script>
 <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.easyui.min.js"></script>
 <script type="text/javascript" src="jquery.js"></script>
<style>
body {  
   
}  
.error{
     color:red;font-weight: bold;
}
</style>
<script>
  function displayDepts()
  {
	

	$.ajax({
	   	 
	    url: 'empadddept.html',   
	  	success: function(response){
	   
	      		var k=response.split(",");
	   			for(var i=0;i<k.length-1;i++)
	   			 {
		 			var l=document.getElementById("depts");
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
  
 <script type="text/javascript">

 function deptDisplay()
 {
	   var c='${command.dept}';
	
	  
	 document.getElementById("dept").value=c;	
	/*   $("#dept").val(c); */
	 /*  document.getElementById("depts").value=c;	 */
 
 }
 </script>
</head>
<body onload="deptDisplay();">
<sec:authorize ifAllGranted="ROLE_ADMIN">
    <center>
<form:form method="POST" action="empupdatesave.html">
    
    
     <h2>Update Profile</h2>
 <table border="0" align="center">
		<tr>
		<td><form:label path="id">Id</form:label></td>
		<td><form:input path="id" value="${emp.id}" readonly="true"/></td><td>
	  </tr>
	  <tr>
			<td>Name</td>
			<td><form:input path="name" value="${emp.name}"/></td>
			<td ><form:errors path="name" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Designation</td>
			<td><form:input path="desig" value="${emp.desig}"/></td>
			<td ><form:errors path="desig" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Department</td>
			<td><form:input path="dept" id="depts" readonly="true" style="width:170px"/>
			
				
			</td>
			<td ><form:errors path="dept" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><form:input path="email" value="${emp.email}"/></td>
				<td ><form:errors path="email" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Username</td>
			<td><form:input path="username"  /></td>
				<td ><form:errors path="username" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			
			<td><form:hidden path="password" /></td>
				
		</tr>
		<tr>
			
			<td><form:hidden path="confirmpassword" /></td>
				
		</tr>
		<tr>
			<td>Mobile</td>
			<td><form:input path="mobile" value="${emp.mobile}"/></td>
				<td ><form:errors path="mobile" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
			<td>Address</td>
			<td><form:textarea path="address" style="width:166px" value="${emp.address}"></form:textarea></td>
				<td ><form:errors path="address" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Update"/>
					<input type="reset" value="Reset"/></td>
				</tr>
</table>

</form:form>
</center>
  </sec:authorize>     
</body>
<br>



</html>