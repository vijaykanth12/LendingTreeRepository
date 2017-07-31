<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Display Grid</title>

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
      		
      		$('#dg').datagrid({url:'CusDisplayGrid.html'});
      
      		
      		
      		
      	}
	</script>


<body>
<center>			
	 <div align="center">Enter Status Type
      <div align="center"  class="easyui-panel" style="width:200%;max-width:200px;" >
        <input class="easyui-searchbox" data-options="prompt:'Enter Name',searcher:doSearch" style="width:200%">
    </div></div>

<br>
<br>

   
    <input type="button" value="Refresh" onclick="refreshPage();" />
   <br>
<br> 
 <table id="dg" class="easyui-datagrid" title="Personal loan applied customers are" style="width:1000px;height:250px"
    	
          singleSelect="true"  rownumbers="true" pagination="true" fitColumns="false" data-options="multiSelect:true,url:'PersonalDisplayGrid.html',onDblClickRow:function(index,row){update()},method:'get'">
        <thead> 
        
	           <tr>
                <th align="center" data-options="field:'id',width:50"> Loan Id</th>
                 <th align="center" data-options="field:'regid',width:80"> User Id</th>
                <th align="center" data-options="field:'firstname',width:90">First Name</th>
            	<th align="center" data-options="field:'lastname',width:90">Last Name</th>
            	 <th align="center" data-options="field:'email',width:90">Email</th>
            	 <th align="center" data-options="field:'loanamount',width:90">Loan Amount</th>
            	  <th align="center" data-options="field:'banktype',width:90">Bank Type</th>
            	   <th align="center" data-options="field:'loantype',width:90">Loan Type</th>
            	    <th align="center" data-options="field:'interestrate',width:90">Interest</th>
                 <th align="center" data-options="field:'status',width:120">Status</th>
                 
                                   
                
       </tr>    </thead> 
    </table>	
</center>
<div style="margin:20px 0;"  align="center"> 
    
        
         <input type="button" name="Take Action" value="Response" onclick="update()" class="button">&nbsp;&nbsp;&nbsp; 
         
       </div>
</body>
</html>