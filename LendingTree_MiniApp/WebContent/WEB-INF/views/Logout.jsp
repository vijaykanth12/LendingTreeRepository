<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout Page</title>


<!-- <script>
    $(document).ready(function() {
        function disableBack() 
        { 
        	window.history.forward(); 
        }
		window.onload = disableBack();
        window.onpageshow = function(evt)
        {
        	if (evt.persisted) 
        		{
        		disableBack();
        		}
        }
    });
</script>
 -->
</head>



<body>
<center>
<h2><font color="blue">Successfully Logged out, For SignIn click below Link</font></h2>
<br>
<a href="login.html">Sign In</a>


	</center>
</body>
</html>