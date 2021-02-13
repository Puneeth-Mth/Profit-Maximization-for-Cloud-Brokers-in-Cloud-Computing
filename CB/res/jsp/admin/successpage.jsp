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

</head>
<body onload="startTimer();">


<%

String k=null;
k=request.getParameter("no");
 int no=0;
 if(k!=null)
 {
	 no=Integer.parseInt(k); 
 }



%>
 
 <%
if(no==1)
{
%>
<div style="position: absolute;top: 150px;">
<div class="success" id="message" >	
	<p> Image Added Successfully.....!</p>
</div>
</div>
<%}else if(no==2)
{
%>
<div style="position: absolute;top: 150px;">
<div class="error" id="message" >	
	<p> OOP'S Something Went Wrong.....!</p>
</div>
</div>

<%} else
{%>


<%} %>

</body>
</html>