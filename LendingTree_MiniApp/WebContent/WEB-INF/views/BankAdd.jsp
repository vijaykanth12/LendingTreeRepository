<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.net.URL"%>
<title>Bank Add Page</title>
</head>
<body>
 <center>
<form:form method="POST" action="savess.html">
    
    
     <h2>Bank Add Page</h2>
     <table border="0" align="center">
<tr>
		<td></td>
		<td><form:hidden path="id"/></td>
	  </tr>
	   		
<tr><td>Bank Id</td>
<td><form:input path="bid"/></td>

<tr><td>Bank Name</td>
<td><form:input path="bname"/></td>

<tr><td>Branch</td>
<td><form:input path="branch"/></td>

<tr><td>Address</td>
<td><form:input path="address" onblur="checkUser()" id="user"/></td>
</tr>
<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Add Bank"/>
					<input type="reset" value="Reset"/></td>
				</tr>
</table>

</form:form>
</center>
</body>
</html>