<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>


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
<style>
 .active {
    background-color: 5833FF;</style>
</head>
<body>
<ul>
  <li><a href="baseLayout.html">Home</a></li>
  <li><a href="aboutus.html">About Us</a></li>
 
  
<li><a href="viewinterest.html">View Interest Rates</a></li> 
  <li><a href="emi.html">EMI Calculator</a></li>

  <li style="float:right"><a class="active"  href="login.html">Sign In</a></li>
   <li style="float:right"><a class="active"  href="signup.html">Sign Up</a></li>
 
</ul>

</body>
</html>