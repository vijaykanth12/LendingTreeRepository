<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function woindowclos() {
	window.close();
}

</script>
<body>

<form:form action="gettingexcel.html" enctype="multipart/form-data" method="post">
<h1>import the word file only and only support .xls(windowsExcel2003)</h1>
<input type="file" name="excelfile" value="Uploadefile"><br/>
<br/>
<input type="submit" value="submit"> <input type="button" value="close" onclick="woindowclos()">
</form:form>
</body>
</html>