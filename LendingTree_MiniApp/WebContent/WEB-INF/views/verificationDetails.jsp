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
    
    	if (row.loantype=="Personal Loan"){
        	
            window.location.href="verpersonalresponse.html?id="+row.id;  
       	}
       	else if (row.loantype=="Education Loan"){
           	
               window.location.href="vereducationresponse.html?id="+row.id;  
          	}
   		else if (row.loantype=="Home Loan"){
           	
               window.location.href="verhomeresponse.html?id="+row.id;  
          	}
   		else if (row.loantype=="Business Loan"){
           	
               window.location.href="verbusinessresponse.html?id="+row.id;  
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
	<sec:authorize ifAllGranted="ROLE_DEPT">
	<center>			 <!-- <h2><font  color="red">Bank Management is under Maintenance</font></h2>
  						<a href='addbank.html'>Add New</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='updatebank.html'>Update</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='deletebank.html'>Delete</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  -->




 <table id="dg" class="easyui-datagrid" title="Customers under verifcation details are" style="width:800px;height:200px"
    	
          singleSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="multiSelect:true,url:'VericationDisplayGrid.html',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'id',width:50"> Loan Id</th>
                 <th align="center" data-options="field:'regid',width:80"> User Id</th>
                <th align="center" data-options="field:'firstname',width:90">First Name</th>
            	<!-- <th align="center" data-options="field:'lastname',width:90">Last Name</th>
                <th align="center" data-options="field:'emailid',width:200">Email Id</th>
                <th align="center" data-options="field:'mobile',width:90">Mobile</th>
                <th align="center" data-options="field:'gender',width:90">Gender</th>
                <th align="center" data-options="field:'dateofbirth',width:90">Date Of Birth</th>
                <th align="center" data-options="field:'pan',width:90">Pan No</th>
                <th align="center" data-options="field:'qualification',width:90">Qualification</th>
                <th align="center" data-options="field:'occupation',width:90">Occupation</th>
                <th align="center" data-options="field:'company',width:90">Company</th>
                <th align="center" data-options="field:'workmail',width:180">Work Mail</th>
                <th align="center" data-options="field:'ofccontact',width:100">Office Contact No</th>
                <th align="center" data-options="field:'ofcaddress',width:200">Office Address</th>
                <th align="center" data-options="field:'salary',width:90">Salary</th>  -->
                <th align="center" data-options="field:'loantype',width:110">Loan Type</th>
                <th align="center" data-options="field:'banktype',width:110">Bank Type</th>
                 <th align="center" data-options="field:'loanamount',width:90">Amount </th>
                <th align="center" data-options="field:'interestrate',width:90">Interest Rate </th>
           <!--   <th align="center" data-options="field:'country',width:90">Country</th>
                <th align="center" data-options="field:'state',width:90">State</th>
                <th align="center" data-options="field:'city',width:90">City</th>
                <th align="center" data-options="field:'pincode',width:90">Pin Code</th>
                <th align="center" data-options="field:'address',width:200">Address</th> -->
                 <th align="center" data-options="field:'status',width:120">Status</th>
                                   
                
       </tr>    </thead> 
    </table>	
</center>
<div style="margin:20px 0;"  align="center"> 
    
        
         <input type="button" name="Take Action" value="Response" onclick="update()" class="button">&nbsp;&nbsp;&nbsp; 
         
       </div>
       </sec:authorize>
</body>

</html>