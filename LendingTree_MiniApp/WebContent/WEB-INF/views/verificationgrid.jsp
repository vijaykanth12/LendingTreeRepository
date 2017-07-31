<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.easyui.min.js"></script>
</head>

<script>
	function update()
	{
    	var row = $('#dg').datagrid('getSelected');
    	
    	if (row){
    		
         window.location.href="verificationupdate.html?id="+row.id;  
    	}
    	else
     	{
        	$.messager.alert('Warning','Please select atleast one row!');
     	}
     
    }

</script>







<body>
<center>		



 <table id="dg" class="easyui-datagrid" title="Profile is" style="width:850px;height:200px"
    	
          multiSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="multiSelect:true,url:'VerificationDisplayGrid.html',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'id',width:80"> Id</th>
                <th align="center" data-options="field:'name',width:90"> Name</th>
                 
                <th align="center" data-options="field:'desig',width:90">Designation</th>
                 <th align="center" data-options="field:'dept',width:90">Department</th>
                 <th align="center" data-options="field:'email',width:90">Email</th>
                 <th align="center" data-options="field:'username',width:90">User Name</th>
                
                <th align="center" data-options="field:'password',width:90">Password</th>
                 <th align="center" data-options="field:'mobile',width:90">Mobile</th>
                 <th align="center" data-options="field:'address',width:90">Address</th>
                
       </tr>    </thead> 
    </table>	
</center>
<div style="margin:20px 0;"  align="center"> 
    
       
         <input type="button" name="Edit" value="Update Profile" onclick="update()" class="button"> 
         
       </div>
</body>
</html>