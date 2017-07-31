<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Failure page</title>
<script type="text/javascript" src="jquery.js"></script>
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
<form:form method="POST" action="log.html">
     <center> 
     
     <h2>Login </h2>
	<h5> <font  color="red">Invalid Username or Password</font></h5>
     <h4> <font  color="red">[CARE:</font> Username and Password are case sensitive.]</h4>
     <table>
				
				<tr>
					<td><form:label path="username">Username</form:label></td>
					<td><form:input path="username" value="${student.username}"/></td>
					<td><form:errors path="username" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:password path="password" value="${user.password}"/></td>
					<td><form:errors path="password" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Login"/>
								<INPUT TYPE="RESET" value="Reset"></td>
				</tr>
	</table>
	</center>
	</form:form>
	<br>
	<center>
	<a href='signup.html'>New User? Register here</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='forgotpassword.html'>Forgot Password</a>
	
		</center>
</body>
</body>
</html>