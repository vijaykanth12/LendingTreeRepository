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
<title>Department Update  Page</title>
<style>
body {  
   
}  
.error{
     color:red;font-weight: bold;
}
</style>
</head>
<body>
<sec:authorize ifAllGranted="ROLE_ADMIN">
    <center>
<form:form method="GET" action="deptupdatesave.html">
    
    
     <h2>Update Department</h2>
 <table border="0" align="center">
		<tr>
		<td><form:label path="deptid">Id</form:label></td>
		<td><form:input path="deptid"  readonly="true"/></td><td>
	  </tr>
	  <tr>
			<td>Department Name</td>
			<td><form:input path="dname" value="${dept.dname}"/></td>
			<td ><form:errors path="dname" cssClass="error"></form:errors></td>
		</tr>
	<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Update Dept"/>
					<input type="reset" value="Reset"/></td>
				</tr>
	
</table>

</form:form>
</center>
  </sec:authorize>     
</body>
<br>



</html>