<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lending Tree System</title>
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="3" cellspacing="0" align="center" >
            <tr>
                <td height="100" colspan="2">
                    <tiles:insertAttribute name="header" ignore="true"/>
                </td>
            </tr>
           
           <tr>
                 <td valign="baseline" height="50" colspan="2">
                    <tiles:insertAttribute name="menu" ignore="true"/>
                </td>
            </tr>
           
           <tr>
                    <td  height="500">
                    <tiles:insertAttribute name="body" ignore="true"/>
                </td>
            </tr>
           <tr>
                   <td height="20" colspan="2">
                    <tiles:insertAttribute name="footer" ignore="true"/>
                </td>
            </tr>
        </table>
</body>
</html>