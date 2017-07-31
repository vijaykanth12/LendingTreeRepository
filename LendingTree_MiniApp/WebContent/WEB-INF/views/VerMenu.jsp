<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Basic MenuButton</h2>
    <p>Move mouse over the button to drop down menu.</p>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" style="padding:5px;">
        <a href="veryhome.html" class="easyui-linkbutton" data-options="plain:true">Home</a>
         <a href="very.html" class="easyui-linkbutton" data-options="plain:true">Verification Details</a>
       	 <a href="#" class="easyui-menubutton" data-options="menu:'#mm3'">Profile</a>
    </div>
  
    <div id="mm3" style="width:100px;">
        <div>Update Profile</div>
        <div>Change Password</div>
        
    </div>
    
</body>
</html>