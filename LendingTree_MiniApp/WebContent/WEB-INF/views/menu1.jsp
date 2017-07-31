<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Menu Page</title>
   

<!-- <style>
ul {
 	    list-style-type: none;
  	    margin: 0;
  	    padding: 0;
   	    overflow: hidden;
    	background-color: #333;
	}

li {
        float: left;
        border-right:1px solid #bbb;
}

li:last-child {
    border-right: none;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}
</style>-->
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #008000;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: blue;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>
<body>
<ul>
<li><a  href="adhomee.html">Home</a></li>
  <li><a  href="bank.html">Banks</a></li>
  <li><a href="loan.html">Loans</a></li>
  <li><a href="dept.html">Departments</a></li>
  <li><a href="emp.html">Employee Details</a></li>
  <li><a href="cust.html">Customer Management</a></li>
   <li class="dropdown">
    <a href="#" class="dropbtn">Reports</a>
    <div class="dropdown-content">
      <a href="sanction.html">Sanction Loans</a>
    </div></li> 
   <!--  
    <li class="dropdown">
    <a href="#" class="dropbtn">Loans</a>
    <div class="dropdown-content">
      <a href="loanapplied.html">Loan Applied Customers</a>
      <a href="loansanction.html">Loan Sanction Customers</a>
       <a href="loanrejected.html">Loan Rejected  Customers</a>
        <a href="loanverified.html">Loan Verified  Customers</a>
      </div></li> -->
  
<li><a href="adminmsg.html">Messages</a></li>
  <li class="dropdown">
    <a href="#" class="dropbtn">Profile</a>
    <div class="dropdown-content">
      <a href="adminupdate.html">Update Profile</a>
      <a href="adminchpwd.html">Change Password</a>
      </div></li>
     <li class="dropdown">
    <a href="#" class="dropbtn">DB</a>
    <div class="dropdown-content">
      <a href="exportdb.html">Export</a>
      <a href="importdb.html">Import</a>
      </div></li> 
  <li style="float:right"><a href="adminlogout.html">LOG OUT</a></li>
</ul>

</body>
</html>