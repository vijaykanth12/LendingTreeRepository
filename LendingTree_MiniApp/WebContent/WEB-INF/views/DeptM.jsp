<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department Management Page</title>
<meta charset="UTF-8">
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

</head>

<script>
	function add()
	{
		var left = (screen.width/2)-(800/2);
		var top = (screen.height/2)-(400/2);
		window.open("adddept.html","","width=500,height=300,left="+left+",top="+top);
	}  
</script> 
<script>
	function update()
	{
    	var row = $('#dg').datagrid('getSelected');
    	
    	if (row){
    		var left = (screen.width/2)-(800/2);
    		var top = (screen.height/2)-(400/2);
    			
    	
    		window.open("updatedept.html?deptid="+row.deptid,"","width=800,height=400,left="+left+",top="+top);
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
	 	
	 	var rows= $('#dg').datagrid('getSelections');
  	 	alert(rows);
       if(rows)
       { 
    	   var ids =[];
    	   for(var i=0; i<rows.length; i++){
    	  
			ids.push(rows[i].deptid);
			}
      		ids=ids.toString();
      		$.messager.confirm('My Title', 'Are you sure you want to delete this user?', function(r){
       			 if (r){
            	  
         			 window.location.href="deletedept.html?deptid="+ids;
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
<sec:authorize ifAllGranted="ROLE_ADMIN">
<center>			




 <table id="dg" class="easyui-datagrid" title="Department Management" style="width:380px;height:250px"
    	
          multiSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="singleSelect:true,url:'DeptDisplayGrid.html', toolbar:'#toolbar',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'deptid',width:150">Department Id</th>
                <th align="center" data-options="field:'dname',width:200">Department Name</th>
                 
                
       </tr>   
        </thead> 
    </table>	
</center>
<div id="toolbar">
    
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">Add New</a>&nbsp;&nbsp;&nbsp;
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="update()">Edit</a> &nbsp;&nbsp;&nbsp;
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del()">Delete</a>
       </div>
   <div id="dlg" class="easyui-dialog" style="width:400px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">Department Information</div>
            <div style="margin-bottom:10px">
                <label for="dname" class="label-top">Bank Name:</label>
           			 <input id="dname" name="dname" class="easyui-validatebox tb" data-options="required:true,validType:['isCharacter','length[3,30]'],validateOnCreate:true,err:err">
            </div>
           
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>  
    
         
<script type="text/javascript">
  var url;
  function newUser(){
  $('#dlg').dialog('open').dialog('center').dialog('setTitle','Add Department');
  $('#fm').form('clear');
  url = 'deptsave.html';
 
  } 
  function saveUser(){
      $('#fm').form('submit',{
          url: url,
          onSubmit: function(){
        	  
              return $(this).form('validate');
          },
          success: function(result){
        	 /*  
              var result = eval('('+result+')');
              if (result.hasErrors(){
                  $.messager.show({
                      title: 'Error',
                      msg: result.hasErrors()
                  });
              } else { */
                  $('#dlg').dialog('close');        // close the dialog
                  $('#dg').datagrid('reload');    // reload the user data
              }
      
      });
  }
  function editUser(){
      var row = $('#dg').datagrid('getSelected');
     
      if (row){
          $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit Department');
          $('#fm').form('load',row);
          url = "deptupdatesave.html?id="+row.id;
      }
      else{
    	  $.messager.alert('Warning','Please select atleast one row!');
      }
      }
  function deleteUser(){
      var rows = $('#dg').datagrid('getSelections');
      alert(rows);
      if (rows){
    	 	var ids =[];
   	   		for(var i=0; i<rows.length; i++){
   	  
			ids.push(rows[i].deptid);
			}
     		ids=ids.toString();
   			
      			
         	 	$.messager.confirm('Confirm','Are you sure you want to delete this department?',function(r)
         		{
              		if (r){
                  			$.post('deletedept.html',{deptid:ids},function(result){
                	  		$('#dlg').dialog('close');        // close the dialog
                      		$('#dg').datagrid('reload');    // reload the user data
                 			});
      					  }
          		});
      }
      else{
    	  $.messager.alert('Warning','Please select atleast one row!');
      }
     
  }
 
</script>
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
 
  $.extend($.fn.validatebox.defaults.rules, {
	      isCharacter: {
	          validator: function (value, param) {
	             return /^[A-Z a-z]+$/.test(value);
	         },
	         message: 'Please enter alphabets only'
	     }
	  });
</script>
 </sec:authorize>
</body>
</html>