<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reports Page</title>
   <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.5/demo/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.5/jquery.easyui.min.js"></script>
    
    
<script type="text/javascript">
function printReports() {
	window.print();
}
</script>



</head>
<body>

<sec:authorize ifAllGranted="ROLE_ADMIN">
<form:form action="print.html" method="post">


<c:if test="${!empty reports}">
	<table align="center" border="1">
		<tr>
			<th>Loan Id</th>
			<th>User Id</th>
			<th>Name</th>
			<th>Loan Type</th>
			<th>Bank Type</th>
			<th>Interest</th>
			<th>Status</th>

		</tr>

		<c:forEach items="${reports}" var="bean">
			<tr>
				<td><c:out value="${bean.id}"/></td>
				<td><c:out value="${bean.regid}"/></td>
				<td><c:out value="${bean.firstname}"/></td>
				<td><c:out value="${bean.loantype}"/></td>
				<td><c:out value="${bean.banktype}"/></td>
				<td><c:out value="${bean.interestrate}"/></td>
				<td><c:out value="${bean.status}"/></td>
			
				
			
			</tr>
		
			
		</c:forEach>
		
	</table>
</c:if>
<br>
<div align="center"><input type="button" onclick="printReports();" value="Print"> </div>	 
</form:form>
</sec:authorize>
</body>
</html>