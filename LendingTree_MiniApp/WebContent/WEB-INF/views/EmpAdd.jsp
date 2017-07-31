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
<title>Employee Add page</title>
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
	      	/* 	var pl=document.getElementById("depts").valueOf();
	      	    for(var j=0;j<=k.length+1;j++)
	      		{
	      		   var option=document.createElement("option");
	      		   option.text=pl[j];
	      		   pl.remove(option);
	      		}  */
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
   <script>
   function displayId()
  {
	// var dept="Verification";

	 var de=document.getElementById("depts").value;
	
	  
	$.ajax({
	   	 
	    url: 'displaydeptss.html',   
	   	data:"dept="+de,
	   
	    success: function(response){
	   			
	      
	   			//alert(response);
	   			
	   		    document.getElementById("deptid").value = response;
	   			
				 
	   		
	    },
	    error: function(e){
	   		 alert('Error: ' + e);
	    }
	    });
} 
  
  </script> 
<script type="text/javascript">
function checkU() {
	
	var username=document.getElementById("user").value;
	
	$.ajax({
		 
		   url: 'checkuseree.html',   
		   data:'un='+username,
		   success: function(response){
		
			var uname=null;
			var e = response.trim().split(",");
				 for (var i=0;i<e.length;i++)
				{
			        uname = e[i];
			        if(username == uname)
					{
				         document.getElementById("usp").innerHTML ="<b>Username is not Available, Please Choose other one<b>";
					  /*    document.getElementById("uname").value = ""; */
						 return false;
					}
					/*  else{
							document.getElementById("usp").innerHTML ="";
						}   */
					
					
				}
		  }
				
		 });
	
 }
</script> 
<script type="text/javascript">
function checkEU() {
	
	var username=document.getElementById("user").value;
	
	$.ajax({
		 
		   url: 'checkuseremps.html',   
		   data:'un='+username,
		   success: function(response){
		
			var uname=null;
			var e = response.trim().split(",");
				 for (var i=0;i<e.length;i++)
				{
			        uname = e[i];
			        if(username == uname)
					{
				         document.getElementById("usp").innerHTML ="<b>Username is not Available, Please Choose other one<b>";
					  /*    document.getElementById("uname").value = ""; */
						 return false;
					}
					/*  else{
							document.getElementById("usp").innerHTML ="";
						}   */
					
					
				}
		  }
				
		 });
	
 }
</script>

</head>
<body onload="checkU();checkEU();">
<sec:authorize ifAllGranted="ROLE_ADMIN">
    <center>
<form:form method="POST" action="empsave.html">
    
    
     <h2>Add New Employee</h2>
 <table border="0" align="center">
		<tr>
		<td></td>
		<td><form:hidden path="id"/></td>
	  </tr>
	   
	  <tr>
			<td>Name</td>
			<td><form:input path="name"/></td>
				<td ><form:errors path="name" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Designation</td>
			<td><form:input path="desig"/></td>
				<td ><form:errors path="desig" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Department</td>
			<td><form:select path="dept" style="width:174px" onclick="displayDepts();"  onchange="displayId();" id="depts">
				<option value="">Select Department</option>
				</form:select>
					
			
   				
			
			
			</td>
				<td ><form:errors path="dept" cssClass="error"></form:errors></td>
		</tr>
		 <tr>
			<td>Dept Id</td>
			<td><form:input path="deptid" id="deptid" readonly="true"/></td>
				<td ><form:errors path="deptid"  cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><form:input path="email"/></td>
				<td ><form:errors path="email" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Username</td>
			<td><form:input path="username" id="user"/></td>
				<td ><form:errors path="username" cssClass="error"></form:errors></td>
				<td><span style="color:red"  id="usp"/></span></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password"/></td>
				<td ><form:errors path="password" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Confirm Password</td>
			<td><form:password path="confirmpassword"/></td>
				<td ><form:errors path="confirmpassword" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td><form:input path="mobile"/></td>
				<td ><form:errors path="mobile" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
			<td>Address</td>
			<td><form:textarea path="address" style="width:166px"></form:textarea></td>
				<td ><form:errors path="address" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Add Employee"/>
					<input type="reset" value="Reset"/></td>
				</tr>
</table>

</form:form>
</center>
    </sec:authorize>   
</body>
<br>



</html>