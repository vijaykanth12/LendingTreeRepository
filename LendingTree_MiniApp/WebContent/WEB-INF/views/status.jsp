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
	function add()
	{
		window.location.href="addbanks.html";
	}  
</script> 
<script>
	function update()
	{
    	var row = $('#dg').datagrid('getSelected');
    
    	if (row){
    	
         window.location.href="responsecust.html?id="+row.id;  
    	}
    	else
     	{
        	$.messager.alert('Warning','Please select atleast one customer');
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
            	  
         			 window.location.href="deletebank.html?id="+ids;

            	  
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




 <table id="dg" class="easyui-datagrid" title="Your Status is" style="width:750px;height:250px"
    	
          singleSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="multiSelect:true,url:'statusgrid.html',method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'id',width:80">Loan Id</th>
                 <th align="center" data-options="field:'regid',width:80">User Id</th>
                <th align="center" data-options="field:'firstname',width:90">First Name</th>
                
               <th align="center" data-options="field:'loantype',width:120">Loan Type</th>
                <th align="center" data-options="field:'banktype',width:140">Bank Type</th>
                <th align="center" data-options="field:'interestrate',width:90">Interest </th>
             
                <th align="center" data-options="field:'status',width:90,formatter:statusColor">Status Type</th>
                
                                   
                
       </tr>    </thead> 
    </table>	
    <script>
        function statusColor(val,row){
            if (val=="Sanction"){
                return '<span style="color:green;">'+val+'</span>';
            }
            else if (val=="Rejected"){
                return '<span style="color:red;">'+val+'</span>';
            }
            else if (val=="Applied"){
                return '<span style="color:blue;">'+val+'</span>';
            }
            else if (val=="Verification"){
                return '<span style="color:indigo;">'+val+'</span>';
            }
            else if (val=="Verification Success"){
                return '<span style="color:orange;">'+val+'</span>';
            }
            
            else if (val=="Verification Failure"){
                return '<span style="color:Amaranth Red;">'+val+'</span>';
            }
            
            
            
            
            else {
                return val;
            }
        }
    </script>
</center>
</sec:authorize>
</body>
</html>