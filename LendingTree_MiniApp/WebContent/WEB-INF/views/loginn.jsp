<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.net.URL"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>


    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.easyui.min.js"></script>

   <style>
body {  
   
}
.error{
     color:red;font-weight: bold;
}
</style>
 <script>
        function submitForm(){
            $('#ff').form('submit');
        }
        function clearForm(){
            $('#ff').form('clear');
        }
    </script>
</head>
<body>


<%-- <form:form  id="ff" method="POST" action="log.html"> --%>
  
     <center>
       <div style="margin:20px 0;"></div>
    <div class="easyui-panel" title="LOGIN" style="width:100%;max-width:400px;padding:30px 60px;">
        <form id="ff" class="easyui-form" method="post" action="log.html" data-options="validate:true">
        <div style="margin-bottom:20px">
                	<label for="username" class="label-top">Username:</label>
           			<input name="username" class="easyui-validatebox tb" prompt="Username" iconWidth="28" style="width:100%;height:34px;padding:10px;" data-options="required:true,validateOnCreate:true,err:err">
            </div>
        <div style="margin-bottom:20px">
        	<label for="password" class="label-top">Password:</label>
            <input id="password" name="password" class="easyui-passwordbox" prompt="Password" iconWidth="28" style="width:100%;height:34px;padding:10px" data-options="required:true,validateOnCreate:true,err:err">
        </div></form>
               <div style="text-align:center;padding:5px 0">
             
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a>
        </div>
    </div>
  
  <style scoped="scoped">
  .tb{
      width:100%;
      margin:0;
      padding:5px 4px;
      border:1px solid #ccc;
      box-sizing:border-box;
  }
  .error-message{
      margin: 4px 0 0 0;
      padding: 0;
      color: red;
  }
</style>
<script type="text/javascript">
  function err(target, message){
      var t = $(target);
      if (t.hasClass('textbox-text')){
          t = t.parent();
      }
      var m = t.next('.error-message');
      if (!m.length){
          m = $('<div class="error-message"></div>').insertAfter(t);
      }
      m.html(message);
  }
  </script>
    
    
			</center>
      
</body>
<br>



</html>