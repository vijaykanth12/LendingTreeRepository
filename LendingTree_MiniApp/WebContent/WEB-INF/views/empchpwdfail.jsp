<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Change Password Failure</title>
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
  <form:form method="POST" action="empchpwdupdate.html">
     
     
     <h2>Change Password</h2>
	  	<h3> <font  color="red">Invalid Credentials</font></h3>
   
     <table>
				
				<tr>
					<td>Current password</td>
					<td><form:password path="password" value="${student.username}"/></td>
					<td><form:errors path="password" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td>New password</td>
					<td><form:password path="newpassword" value="${user.password}"/></td>
					<td><form:errors path="newpassword" cssClass="error"></form:errors></td>
				</tr>
				<tr>
					<td>Confirm new password</td>
					<td><form:password path="confirmnewpassword" value="${user.password}"/></td>
					<td><form:errors path="confirmnewpassword" cssClass="error"></form:errors></td>
				</tr>
					
					<tr>
					
					<td></td>
					<td colspan="2"><input type="submit" value="Submit"/>
									<input type="reset" value="Reset"/></td>
				</tr>
	</table>
	
		</form:form>
	
	</center>

</body>
</html>