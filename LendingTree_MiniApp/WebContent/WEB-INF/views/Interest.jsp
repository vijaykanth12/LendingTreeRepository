<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interest Page</title>
</head>
<body>
<center>

<form:form method="POST" action="getinterest.html">
    
    
     <h2>View Interest Rates</h2>

		
	  
		
			Loan Type
			<form:select path="loantype" style="width:150px">
				<option>Select Type</option>
				<option value="House">House</option>
				<option value="Education">Education</option>
				<option value="Personal">Personal</option>
				
				</form:select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Bank Name
			<form:select path="bname" style="width:150px">
				<option>Select Type</option>
				<option value="SBI">SBI</option>
				<option value="HDFC">HDFC</option>
				<option value="ICICI">ICICI</option>
				</form:select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" value="GET Interest Rates"/>
					
				

</form:form>
</center>
</body>
</html>