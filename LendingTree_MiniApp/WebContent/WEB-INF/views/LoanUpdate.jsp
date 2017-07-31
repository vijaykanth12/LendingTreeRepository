<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loan Update Page</title>
</head>
<style>
body {  
   
}  
.error{
     color:red;font-weight: bold;
}
</style>
<body>
<sec:authorize ifAllGranted="ROLE_ADMIN">
    <center>
<form:form method="POST" action="loanupdatesave.html">
    
    
     <h2>Update Loan</h2>
 <table border="0" align="center">
			<tr>
		<td><form:label path="id">Loan Id</form:label></td>
		<td><form:input path="id" readonly="true"/></td><td>
	  </tr>
	  
	  <tr>
			<td>Bank Name</td>
			<td><form:input path="bname" /></td>
			<td ><form:errors path="bname" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Loan Type</td>
			<td><form:input path="loantype"/></td>
			<td ><form:errors path="loantype" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Interest</td>
			<td><form:input path="interest"  style="width:168px"></form:input></td>
			<td ><form:errors path="interest" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Update Loan"/>
					<input type="reset" value="Reset"/></td>
				</tr>
</table>

</form:form>
</center>
    </sec:authorize>   
</body>

</html>