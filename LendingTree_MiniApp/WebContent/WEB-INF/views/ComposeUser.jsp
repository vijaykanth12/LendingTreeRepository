<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.net.URL"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<title>Compose User Page</title>
<style>
body {  
   
}  
.error{
     color:red;font-weight: bold;
}
</style>
</head>
<body>
<sec:authorize ifAllGranted="ROLE_USER">
 <center>
<form:form method="POST" action="composesave.html">
    
    
     <h2>Compose</h2>
     <table border="0" align="center">
		<tr>
		<td></td>
		<td><form:hidden path="id"/></td>
	  </tr>
	<%-- 
		<tr><td>Reg iD</td>
<td><form:input path="regid" /></td>
</tr>  
	
	
	<tr><td>From</td>
<td><form:input path="fromu" /></td>
</tr>  		

 --%>
 <tr><td>To</td>
<td><form:input path="tou" value="Admin" readonly="true"/></td>
</tr>
<tr><td>Subject</td>
<td><form:input path="subjectu"/></td>
<td ><form:errors path="subjectu" cssClass="error"></form:errors></td>
</tr>
<tr><td>Message</td>
<td><form:textarea path="messageu" style="width:143px"></form:textarea></td>
<td ><form:errors path="messageu" cssClass="error"></form:errors></td>
</tr>
<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Send"/>
					<input type="reset" value="Reset"/></td>
				</tr>
</table>

</form:form>
</center>
</sec:authorize>
</body>
</html>