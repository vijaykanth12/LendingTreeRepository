<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Interest Page</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
    
 <script type="text/javascript" src="jquery.js"></script>
<script>
function displayLoan()
{
	 var loan=document.getElementById("loandisplay").value;
	 $.ajax({
	   	 
	    url: 'displayloan.html',   
	   	data:"loans="+loan,
	    success: function(response){
	   
	      		var k=response.split(",");
	      		
	      		//alert(k);
	      		/* var pl=document.getElementById("loandisplay").valueOf();
	      		alert(pl);
	      	    for(var j=0;j<=k.length+1;j++)
	      		{
	      	    	var x=document.getElementById("loandisplay").valueOf();
	      		    var option=document.createElement("option");
	      		    option.text=pl[j];
	      		    x.remove(option);
	      		}  */
	   			for(var i=0;i<k.length-1;i++)
	   			 {
		 			var x=document.getElementById("loandisplay");
	   				var option=document.createElement("option");
	   				// k[0]="Select Loan Type";
	   				option.text=k[i];
	   				x.add(option);
				 }
	   			
	    },
	    error: function(e){
	   		 alert('Error: ' + e);
	    }
	    });
} 

</script>

<script>
function displayLoanss()
{
	 var loan=document.getElementById("loandisplay").value;
	 $.ajax({
	   	 
	    url: 'displayloan.html',   
	   	data:"loans="+loan,
	    success: function(response){
	   
	      		var k=response.split(",");
	      		alert(k);
	      		//var opts = $('#loandisplay')[0].options;

	      		/* var array = $.map(opts, function(elem) {
	      		    return (elem.value || elem.text);
	      		   });
 */
	      		 for(var j=0;j<k.length+1;j++){
		      			
		      			var x=document.getElementById("loandisplay");
		      			//alert(d[i]);
		      			var option=document.createElement("option");
		      			
		      			option.text=k[i];
		      			//x.add(option);
		      			x.remove(option);
		      		 }

	      		 for(var i=0;i<k.length-1;i++){
	      			
	      			var x=document.getElementById("loandisplay");
	      			//alert(d[i]);
	      			var option=document.createElement("option");
	      			
	      			option.text=k[i];
	      			x.add(option);
	      			//x.remove(option);
	      		 }
	    	},
	   			
	  
	    error: function(e){
	   		 alert('Error: ' + e);
	    }
	    });
} 

</script>

<style>
body {  
   
}  
.error{
     color:red;font-weight: bold;
}
</style>
</head>
<body>
<center>
<form:form method="GET" action="getinterestrates.html">
    
    
     <h2>View Interest Rates</h2>
	<table>
		<tr>
				<td>Loan Type</td>
				<td><form:select path="loantype" style="width:149px" onclick="displayLoan();" id="loandisplay">
				<option value="">Select Loan Type</option>
				
				
				</form:select>
				</td>
				<td ><form:errors path="loantype" cssClass="error"></form:errors></td>
	
			
				<%-- <td>Bank Name</td>
				<td><form:select path="bname" style="width:149px"  onclick="displayBank();" id="bankdisplay">
				<option value="">Select Bank Type</option>
			
				</form:select>
		
				</td>
					<td ><form:errors path="bname" cssClass="error"></form:errors></td> --%>
		
		
			<td><input type="submit" value="GET Interest Rates"/></td>
		</tr>
					
				
</table>
</form:form>
	
</center>
</body>
</html>