<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bank Update Page</title>

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
<form:form method="POST" action="bankupdate.html">
    
    
     <h2>Update Bank</h2>
 <table border="0" align="center">
			<tr>
		<td><form:label path="id">Id</form:label></td>
		<td><form:input path="id" value="${abc.id}" readonly="true"/></td><td>
	  </tr>
	  <tr>
			<td>Bank Name</td>
			<td><form:input path="bname" value="${abc.bname}"/></td>
			<td ><form:errors path="bname" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Branch</td>
			<td><form:input path="branch" value="${abc.branch}" /></td>
			<td ><form:errors path="branch" cssClass="error"></form:errors></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><form:textarea path="address" value="${abc.address}" style="width:166px"></form:textarea></td>
			<td ><form:errors path="address" cssClass="error"></form:errors></td>
		</tr>
		
		<tr>
					<td></td>
					<td colspan="2"><input type="submit" value="Update Bank"/>
					<input type="reset" value="Reset"/></td>
				</tr>
</table>

</form:form>
</center>
   </sec:authorize>    
</body>

</html>