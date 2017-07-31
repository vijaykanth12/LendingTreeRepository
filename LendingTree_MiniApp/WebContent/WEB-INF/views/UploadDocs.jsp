<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.net.URL"%>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <div align="center">
	 <form:form action="doUpload.html" enctype="multipart/form-data">
	 <table>
	 	<tr>
       			<td>Upload Documents </td>
				<td>:</td>
				<td> <input type="file"  name="file" id="fileToUpload"  multiple="multiple"></input> </td>
		</tr>
		<tr>
				<td><input type="submit" value="Submit"></td>
		</tr>
		</table>
		</form:form>
    </div>
</body>
</html>
