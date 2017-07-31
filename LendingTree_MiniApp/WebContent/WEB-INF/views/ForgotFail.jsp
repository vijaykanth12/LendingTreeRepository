<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forgot Password Failure Page</title>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<form:form method="POST" action="forgotpass.html">
     <center> 
     
     <h2>Forgot Password</h2>

   <h4> <font  color="red"> User name or Email id is Invalid, Please try again after some time</font></h4>
     <table>
				
				<tr>
					<td><form:label path="username">User Name</form:label></td>
					<td><form:input path="username" value="${student.username}"/></td>
				</tr>
				<tr>
					<td><form:label path="emailid">Email Id</form:label></td>
					<td><form:input path="emailid" value="${user.emailid}"/></td>
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