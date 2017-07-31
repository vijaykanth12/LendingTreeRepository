<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Display Grid</title>
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
    	
         window.location.href="personalresponse.html?id="+row.id;  
    	}
    	else if (row.loantype=="Education Loan"){
        	
            window.location.href="educationresponse.html?id="+row.id;  
       	}
		else if (row.loantype=="Home Loan"){
        	
            window.location.href="homeresponse.html?id="+row.id;  
       	}
		else if (row.loantype=="Business Loan"){
        	
            window.location.href="businessresponse.html?id="+row.id;  
       	}
    	else
     	{
        	$.messager.alert('Warning','Please select atleast one customer');
     	}
     
    }

</script>
<script>
        function doSearch(value){
        	
            alert('Your input: ' + value);
         
           $('#dg').datagrid({
        	   url:"search.html?statustype="+value
           });
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
  <script>
      	function refreshPage()
      	{
      		
      		$('#dg').datagrid({url:'loanADisplayGrid.html'});
      
      		
      		
      		
      	}
	</script>


<body>
<center>			

     
	 <div style="margin:20px 0;"></div>
    <div class="easyui-panel" style="width:100%;max-width:200px;padding:0px 0px;">
        <input class="easyui-searchbox" data-options="prompt:'Enter Status Type',searcher:doSearch" style="width:100%">
    </div>
<br>
<br>

   
    <input type="button" value="Refresh" onclick="refreshPage();" />
   <br>
<br> 
 <table id="dg" class="easyui-datagrid" title="Customers are" style="width:700px;height:250px"
    	
          singleSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="singleSelect:true,url:'loanADisplayGrid.html',onDblClickRow:function(index,row){update()},method:'get'">
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
                <th align="center" data-options="field:'loantype',width:100">Loan Type</th>
                <th align="center" data-options="field:'banktype',width:90">Bank Type</th>
                <th align="center" data-options="field:'interestrate',width:90">Interest </th>
           <!--   <th align="center" data-options="field:'country',width:90">Country</th>
                <th align="center" data-options="field:'state',width:90">State</th>
                <th align="center" data-options="field:'city',width:90">City</th>
                <th align="center" data-options="field:'pincode',width:90">Pin Code</th>
                <th align="center" data-options="field:'address',width:200">Address</th> -->
                 <th align="center" data-options="field:'status',width:150,formatter:statusColor">Status</th>
                                   
                
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
<div style="margin:20px 0;"  align="center"> 
    
        
         <input type="button" name="Take Action" value="Response" onclick="update()" class="button">&nbsp;&nbsp;&nbsp; 
         
       </div>
</body>
</html>