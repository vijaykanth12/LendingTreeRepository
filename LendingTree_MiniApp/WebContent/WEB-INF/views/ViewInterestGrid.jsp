<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Interest Grid Page</title>
<meta charset="UTF-8">

  <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.easyui.min.js"></script>
</head>




<body>
<center>			



 <table id="dg" class="easyui-datagrid" title="Interest rate is" style="width:500px;height:250px"
    	
          multiSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="multiSelect:true,url:'interestgrid.html',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'bname',width:150">Bank Name</th>
                <th align="center" data-options="field:'loantype',width:150">Loan Type</th>
                <th align="center" data-options="field:'interest',width:150">Interest</th>
              </tr>   
        </thead> 
    </table>	
</center>

</body>
</html>