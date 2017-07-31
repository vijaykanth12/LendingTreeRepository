<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Home Page</title>

</head>
<body>
 
 <sec:authorize ifAllGranted="ROLE_USER">

<center> <h2><font  color="blue">Loans</font></h2>
<br>
<br>


<div style="width:100%; height: 200px;">

<div style="width: 22%; float:left;">
								<h3>Personal Loan</h3>
								
								<a href='personalloan.html'>Apply Now </a>
</div>
<div style="width: 22%; float:left;">
								<h3>Education Loan</h3>
								
								<a href='educationloan.html'>Apply Now </a>
</div>
<div style="width: 22%; float:left;">


								<h3>Home Loan</h3>
								
								<a href='homeloan.html'>Apply Now </a>
</div>
<div style="width: 22%; float:left;">


								<h3>Business Loan</h3>
							
								<a href='businessloan.html'>Apply Now </a>
</div>



</div>

</center>
</sec:authorize>
</body>
</html>