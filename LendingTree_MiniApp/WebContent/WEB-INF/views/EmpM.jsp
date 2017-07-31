<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

   <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.easyui.min.js"></script>
</head>
<script>
/* function add()
{
window.location.href="addemp.html";
}  */

function add()
{
	var left = (screen.width/2)-(800/2);
	var top = (screen.height/2)-(400/2);
		
	
	window.open("addemp.html","","width=500,height=300,left="+left+",top="+top);

}  
</script> 
 
<script>
	function update()
	{
    	var row = $('#dg').datagrid('getSelected');
    	
    	if (row){
    		
         /* window.location.href="updateemp.html?id="+row.id;  */ 
    		var left = (screen.width/2)-(800/2);
    		var top = (screen.height/2)-(400/2);
    			
    	
    		window.open("updateemp.html?id="+row.id,"","width=800,height=400,left="+left+",top="+top);
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
    	 
			ids.push(rows[i].id);
		}
      	ids=ids.toString();
      
    	$.messager.confirm('My Title', 'Are you sure you want to delete this user?', function(r){
        if (r){
            	  
         			 window.location.href="deleteemp.html?id="+ids;

            	  
              }
          });
       }
       else
    	   {
    	  	 $.messager.alert('Warning','Please select atleast one row!');
    	   }
}
 
</script>

<script>

$('#dg').datagrid('reload'); 

</script>




<body onload="gridRefresh()">

<sec:authorize ifAllGranted="ROLE_ADMIN">
<center>			



<div id="toolbar">
    
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">Add New</a>&nbsp;&nbsp;&nbsp;
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="update()">Edit</a> &nbsp;&nbsp;&nbsp;
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">Delete</a>
       </div>
 <table id="dg" class="easyui-datagrid" title="Employee Details" style="width:1130px;height:250px"
    	
          singleSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="singleSelect:true,toolbar:'#toolbar',url:'EmpDisplayGrid.html',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'id',width:100"> Id</th>
                <th align="center" data-options="field:'name',width:100"> Name</th>
                 
                <th align="center" data-options="field:'desig',width:90">Designation</th>
                 <th align="center" data-options="field:'dept',width:90">Department</th>
                 <th align="center" data-options="field:'email',width:200">Email</th>
                 <th align="center" data-options="field:'username',width:100">User Name</th>
                
                <th align="center" data-options="field:'password',width:100">Password</th>
                 <th align="center" data-options="field:'confirmpassword',width:120">Confirm Password</th>
                 <th align="center" data-options="field:'mobile',width:100">Mobile</th>
                 <th align="center" data-options="field:'address',width:200">Address</th>
                
       </tr>    </thead> 
    </table>	
</center>
<!-- <div style="margin:20px 0;"  align="center"> 
    
        <input type="button" name="Add" value="Add" onclick="add()" class="button">&nbsp;&nbsp;&nbsp; 
         <input type="button" name="Edit" value="Edit" onclick="update()" class="button">&nbsp;&nbsp;&nbsp; 
        <input type="button" name="Delete" value="Delete" onclick="del()" class="button">&nbsp;&nbsp;&nbsp; 
       </div> -->
</sec:authorize>
</body>
</html>