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
<title>Add new Loan Page</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
 <script type="text/javascript" src="jquery.js"></script>
 <style>
body {  
   
}  
.error{
     color:red;font-weight: bold;
}
</style>
<script>
  function displayBanks()
  {
	

	$.ajax({
	   	 
	    url: 'bankloanadd.html',   
	  	success: function(response){
	   
	      		var k=response.split(",");
	      		
	      		/* var pl=document.getElementById("bank").valueOf();
	      	    for(var j=0;j<=k.length+1;j++)
	      		{
	      		   var option=document.createElement("option");
	      		   option.text=pl[j];
	      		   pl.remove(option);
	      		}  */
	      		
	      		for(var i=0;i<k.length-1;i++)
	   			 {
		 			var l=document.getElementById("bank");
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
</head>
<body>
<sec:authorize ifAllGranted="ROLE_ADMIN">
    <center>
<form:form method="POST" action="loansave.html">
    
    
     <h2>Add New Loan</h2>
 <table border="0" align="center">
		<tr>
		<td></td>
		<td><form:hidden path="id"/></td>
	  </tr>
	  <tr>
			<td>Bank Name</td>
			<td><form:select path="bname"  style="width:149px" onclick="displayBanks();" id="bank">
				<option value="">Select Banks</option>
				</form:select>
				</td>
			<td ><form:errors path="bname" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Loan Type</td>
			<td><form:input path="loantype"/></td>
			<td ><form:errors path="loantype" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Interest</td>
			<td><form:input path="interest" style="width:147px"></form:input></td>
			<td ><form:errors path="interest" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Add Loan"/>
					<input type="reset" value="Reset"/></td>
				</tr>
</table>

</form:form>
</center>
  </sec:authorize>     
</body>
<br>



</html>