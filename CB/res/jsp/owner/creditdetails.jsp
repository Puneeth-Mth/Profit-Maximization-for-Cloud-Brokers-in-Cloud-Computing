<%@ page import="com.dao.OwnerDAO" %>
<%@ page import="com.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
<style>
.button {
    background-color: #ffba4d; 
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}


.button5 {background-color: #ffba4d;} 
</style>
</head>

<body>
<%
	String u_user=request.getAttribute("u_user").toString();
	String credit=request.getAttribute("credit").toString();
	int no=Utility.parse(request.getParameter("no"));
	
%>

         
	<form class="warning" action="<%=request.getContextPath() %>/Recharge">
			<p>
				<center><pre>welcome user [<%=u_user %>]</pre></center><br>
				Your current balance is [<%=credit %>]<br>
				If you want to recharge and get more balance<br>
				then enter 10 digit code of recharge voucher<br>
				in the text field below........
			</p> 
			<input type="hidden" name="u_user" value="<%=u_user %>"></input>
			<input type="hidden" name="credit" value="<%=credit %>"></input>
			Voucher Code :- <input class="ff" type="text" name="code" required="yes"><br><br></br>
			<input type="submit" class="button" value="Recharge Account"></input>
						
	</form>
	            
			<div class="info">
				Please Note
				<li>Do not enter wrong code ...... </li>
				<li>If you do not have recharge voucher , get it from your nearest retailer...... </li>
			</div>
<%
if(no==2)
	{%><div class="error" id="message">OOP's Voucher code is incorrect.....</div><%}
if(no==1)
	{%><div class="error" id="message">OOP's This Voucher Has Been Expired.....</div><%}
if(no==3)
	{%><div class="success" id="message">You account has been credited successfully.....</div><%}
if(no==4)
	{%><div class="error" id="message">OOP's Something Went Wrong.....</div><%}
%>
</body>
</html>