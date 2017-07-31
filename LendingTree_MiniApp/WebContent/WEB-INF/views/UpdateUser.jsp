<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>admin account</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

     <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script>
function add()
{
window.location.href="add.html";
}  
</script> 
<script>
function update(){
    
    var row = $('#dg').datagrid('getSelected');
    
        if (row){
         window.location.href="updateuserk.html?id="+row.id;

/*         window.open('ahms_admin_EditEmployee.htm?id='+row.employeeid,'EditCustomerDeatiles','height=500,width=550,left=200,top=100,overflow: scroll');                              
*/                     }
                   else
                 {
                $.messager.alert('Warning','Please select atleast one row!');
                 }
     
               }
/*function update(){
	var ids = [];
	var rows = $('#dg').datagrid('getSelections');
	for(var i=0; i<rows.length; i++){
		ids.push(rows[i].itemid);
	}
	
}*/

</script>


</head>
<body>
<h1 align="center">Welcome to Profile </h1>


<center>
    <table id="dg" class="easyui-datagrid" title="acount is" style="width:1000px;height:250px"
    	
          singleSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="multiSelect:true,url:'userDisplayGrid.html',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'id',width:80">Id</th>
                <th align="center" data-options="field:'firstname',width:90">First Name</th>
                <th align="center" data-options="field:'middlename',width:90,align:'right'">Middle Name</th>
                <th align="center" data-options="field:'lastname',width:90,align:'right'">Last Name</th>
                <th align="center" data-options="field:'username',width:250">User Name</th>
                 <th align="center" data-options="field:'password',width:80">Password</th>
                <th align="center" data-options="field:'conformpassword',width:90">Conform Password</th>
                 <th align="center" data-options="field:'emailid',width:250">Email Id</th>
                   <th align="center" data-options="field:'mobile',width:80">Mobile</th>
                    <th align="center" data-options="field:'gender',width:90,align:'right'">Gender</th>
                <th align="center" data-options="field:'dateofbirth',width:90,align:'right'">Date of birth</th>
               <th align="center" data-options="field:'languagesknown',width:250">Languages Known</th>
               <th align="center" data-options="field:'country',width:90,align:'right'">Country</th>
               <th align="center" data-options="field:'state',width:250">State</th>
                <th align="center" data-options="field:'city',width:250">City</th>
                  <th align="center" data-options="field:'pincode',width:90,align:'right'">Pin Code</th>
                <th align="center" data-options="field:'address',width:90">Address</th>
                <th align="center" data-options="field:'type',width:90">Type</th>
       </tr>    </thead> 
    </table></center>
    <div style="margin:20px 0;"  align="center"> 
    
        
         <input type="button" name="Edit" value="Update" onclick="update()" class="button"> 
      
       </div>
 </body>
</html>