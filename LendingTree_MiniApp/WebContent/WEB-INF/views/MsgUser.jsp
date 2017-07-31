<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department Management</title>
<meta charset="UTF-8">

  <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.easyui.min.js"></script>
</head>
<script>
	function add()
	{
		window.location.href="composeuser.html";
	}  
</script> 
<script>
	function update()
	{
    	var row = $('#dg').datagrid('getSelected');
    	
    	if (row){
         window.location.href="updatedept.html?id="+row.id;  
    	}
    	else
     	{
        	$.messager.alert('Warning','Please select atleast one row!');
     	}
     
    }

</script>

<script>
 function del()
       {
	 	
	 	var rows = $('#dg').datagrid('getSelections');
  	 
      
      
      // alert(rows[i]);
       if(rows)
       { 
    	   var ids =[];
    	   for(var i=0; i<rows.length; i++){
    	   alert("For loop is running");
			ids.push(rows[i].id);
		}
      	ids=ids.toString();
      	alert(ids);
    	$.messager.confirm('My Title', 'Are you sure you want to delete this user?', function(r){
        if (r){
            	  
         			 window.location.href="deletedept.html?id="+ids;

            	  
              }
          });
       }
       else
    	   {
    	  	 $.messager.alert('Warning','Please select atleast one row!');
    	   }
}
 
</script>



<body>
<sec:authorize ifAllGranted="ROLE_USER">
<center>			 <!-- <h2><font  color="red">Bank Management is under Maintenance</font></h2>
  						<a href='addbank.html'>Add New</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='updatebank.html'>Update</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='deletebank.html'>Delete</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  -->




 <table id="dg" class="easyui-datagrid" title="Inbox" style="width:600px;height:200px"
    	
          multiSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="multiSelect:true,url:'usermsggrid.html',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'fromu',width:100">From</th>
                <th align="center" data-options="field:'subjectu',width:150">Subject</th>
                 <th align="center" data-options="field:'messageu',width:300">Message</th>
                
       </tr>    </thead> 
    </table>	
</center>
<div style="margin:20px 0;"  align="center"> 
    
        <input type="button" name="Add" value="Compose" onclick="add()" class="button">&nbsp;&nbsp;&nbsp; 
        
      <!--   <input type="button" name="Delete" value="Delete" onclick="del()" class="button">&nbsp;&nbsp;&nbsp;  -->
       </div>
       </sec:authorize>
</body>
</html>