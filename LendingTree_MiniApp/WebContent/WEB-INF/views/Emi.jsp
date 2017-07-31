<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.net.URL"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EMI Calculator Page</title>
<style type="text/css">
.subheading
{
font-size:13px;
font-family: arial, verdana, san-serif;
color: black;
}
</style>
<script type="text/javascript">

function checnum(as)
{
	var dd = as.value;
	if(isNaN(dd))
	{
		dd = dd.substring(0,(dd.length-1));
		as.value = dd;
	}
}  
function loan() {
		var a = document.first.amount.value;
		var b = document.first.interest.value;
		var c = document.first.duration.value;
		var n = c * 12;
		var r = b/(12*100);
		var p = (a * r *Math.pow((1+r),n))/(Math.pow((1+r),n)-1);
		var prin = Math.round(p*100)/100;
		document.first.r1.value = prin;
		var mon = Math.round(((n * prin) - a)*100)/100;
		document.first.r2.value = mon;
		var tot = Math.round((mon/n)*100)/100;
		document.first.r3.value = tot;
		for(var i=0;i<n;i++)
		{
			var z = a * r * 1;
			var q = Math.round(z*100)/100;
			var t = p - z;
			var w = Math.round(t*100)/100;
			var e = a-t;
			var l = Math.round(e*100)/100;
			a=e;
		}
	} 
</script>

</head>
<body>
<center>
		<h2>EMI Calculator</h2>

<table width=90% border=0 cellpadding=0 cellspacing=0 >
	<tr>
		<td align=center >
		<form name=first>
		<table class=subheading cellspacing=0 cellpadding=3>
			<tr>
				<td>Amount (Rs):</td>
				<td><input name=amount type=text size=15 onkeyup=checnum(this) ></td>
			</tr>
			<tr>
				<td>Interest Rate:</td>
				<td><input name=interest type=text size=15 onkeyup=checnum(this) ></td>
			</tr>
			<tr>
				<td>Duration(Years):</td>
				<td><input name=duration type=text size=15 onkeyup=checnum(this)></td>
		    </tr>
		</table>
		<br>
		<input type=button name=ss value=calculate onclick=loan() class=calc>&nbsp;&nbsp;&nbsp;
			<INPUT TYPE="RESET" value="Reset">
		<br>
		<br>
	<table class=subheading cellspacing=0 cellpadding=3>
		<tr align=center>
			<td class=inner colspan=2><b>Results:</b></td>
		</tr>
		<tr>
			<td>Monthly Payment(EMI):</td>
			<td> <input name=r1 type=text size=15 readonly > </td>
		</tr>
		<tr>
			<td>Total Interest:</td>
			<td> <input name=r2 type=text  size=15 readonly ></td>
		</tr>
		<tr>
			<td>Monthly Interest:</td>
			<td> <input name=r3 type=text size=15 readonly ></td>
		</tr>
	</table></form>
	</td></tr>

 </table>


</center>

</body>
</html>