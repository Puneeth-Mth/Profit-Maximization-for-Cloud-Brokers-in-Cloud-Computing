

<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- for popup message start -->
<link href="<%=request.getContextPath() %>/js/message.css" rel="stylesheet" type="text/css" /> 

<script type="text/javascript" src="<%=request.getContextPath() %>/js/style.js"></script>	
<!-- for popup message end-->



<%
String uid=session.getAttribute("uid").toString();


int no=Integer.parseInt(request.getParameter("no"));

%>




</head>
<body onload="startTimer();">
<form name="changepass" action="<%=request.getContextPath() %>/Changepass"  method="post">
<center>
<h1>CHANGE PASSWORD</h1>

<table border="1">
<tr><td><label>User ID :</label></td>
<td><input type="text" name="uid" value="<%=uid%>"readonly="readonly"></td></tr>

<tr><td><label>Old Password :</label></td>
<td><input type="password" name="oldpass"  required="yes"></td></tr>

<tr><td><label>New Password :</label></td>
<td><input type="password" name="npass"  ></td></tr>

<tr><td><label>Re Password :</label></td>
<td><input type="password" name="rpass"  required="yes"></td></tr>


</table>
<% 

%><br>
<input type="hidden"name="no"value="5">
<input type="submit" value="Update Password" style="color: green" >
</center>

<%
if(no==2)
{
%>
<div class="error" id="message" >	
	<p> Old Password Incorrect.....!</p>
</div>
<%}else if(no==3)
{
%>
<div class="error" id="message" >	
	<p> New and Re Passwords are mismatch.....!</p>
</div>

<%} else
	if(no==4)
	{
		%>
		<div class="success" id="message" >	
			<p> Password Changed Successfully.....!</p>
		</div>

		<%
	}else
{%>


<%} %>
</form>
</body>
</html>