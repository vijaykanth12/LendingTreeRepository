<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    	 color:red;
     	 font-weight: bold;
		  }
</style>
</head>
<body>

     
	<center>
	
	  
	<form:form action="j_spring_security_check" >
	<c:if test="${not empty error}"><div style="color: red;">${error}</div></c:if>
     
     
     <h2>Sign In </h2>

     <h4> <font  color="red">[CARE:</font> Username and Password are case sensitive.]</h4>
     <table>
				
				<tr>
					<td>Username</td>
					<td><form:input path="username"/></td>
						
					<td><form:errors path="username" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password"/></td>
				    <td><form:errors path="password" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Login"/>
									<input type="reset" value="Reset"/></td>
				</tr>
	</table>
	
	</form:form>
	<br>
	<center>
	<a href='signup.html'>New User? Register here</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href='forgotpassword.html'>Forgot Password</a>	</center>
	
		</center>
	
</body>
</html>