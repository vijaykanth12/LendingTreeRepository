<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function winClose()
{
	 opener.location.reload(true); 
	self.close ();
}
</script>
</head>
<body onload="winClose()">
<center>
<h2  style="color:blue;">Successfully updated bank Details..for Bank list:<a href='bankupdategrid.html'>Click</a></h2>
</center>
</body>
</html>