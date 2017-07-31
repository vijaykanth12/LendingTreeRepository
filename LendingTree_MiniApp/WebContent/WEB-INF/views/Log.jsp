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
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<style>
body {  
   
}  
.error{
     color:red;font-weight: bold;
}
</style>
</head>
<body>
 <center>
<form:form method="POST" action="log.html">
    
    
     <h2>Login</h2>
     <table border="0" align="center">

	   		
<tr>
	<td>username</td>
	<td><form:input path="username"/></td>
	<td ><form:errors path="username" cssClass="error"></form:errors></td>
</tr>
<tr>
	<td>password</td>
	<td><form:input path="password"/></td>
	<td ><form:errors path="password" cssClass="error"></form:errors></td>
</tr>

<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Login"/>
					<input type="reset" value="Reset"/></td>
				</tr>
</table>

</form:form>
</center>
</body>
</html>