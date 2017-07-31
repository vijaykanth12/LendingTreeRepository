<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dept Add Success</title>
<script>
function winClose()
{
	 opener.location.reload(true); 
	self.close ();
}
</script>
</head>
<body onload="winClose()">
<sec:authorize ifAllGranted="ROLE_ADMIN">
<center>
<h2  style="color:blue;">Successfully added new department Details..for Dept list:<a href='deptaddgrid.html'>Click</a></h2>
</center>
</sec:authorize>
</body>
</html>