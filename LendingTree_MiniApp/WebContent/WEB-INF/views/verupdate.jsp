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
<title>Update  Profile</title>
<style>
body {  
   
}  
.error{
     color:red;font-weight: bold;
}
</style>
</head>
<body>
<sec:authorize ifAllGranted="ROLE_DEPT">
    <center>
<form:form method="POST" action="verificationupdatesave.html">
    
    
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
			<td><form:input path="desig" readonly="true"/></td>
			<td ><form:errors path="desig" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Department</td>
			<!-- <td><form:input path="desig" value="${emp.dept}"/></td>-->
			
			<td><form:input path="dept" style="width:170px" readonly="true"></form:input>
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
			<td><form:input path="username" readonly="true"/></td>
			<td ><form:errors path="username" cssClass="error"></form:errors></td>
		</tr>
		<tr>
		
			<td><form:hidden path="password"/></td>
			
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
					<td colspan="2"><input type="submit" value="Update "/>
					<input type="reset" value="Reset"/></td>
				</tr>
</table>

</form:form>
</center>
</sec:authorize>       
</body>
<br>



</html>