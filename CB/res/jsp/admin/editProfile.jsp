<%@page import="com.dao.AdminDAO"%>


<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%
String uid=session.getAttribute("uid").toString();
ResultSet rs=AdminDAO.profile(uid);

%>
</head>
<body>
<form action="<%=request.getContextPath()%>/UpdateProfile" method="post">
<center>
<h1>EDIT PROFILE</h1>
<%
while(rs.next())
{
	%>
<table border="1">
<tr><td><label>Phone No :</label></td>
<td><input type="text" name="uid" value="<%=uid%>"readonly="readonly"></td></tr>

<tr><td><label>Name :</label></td>
<td><input type="text" name="uname" value="<%=rs.getString(6)%>" required="yes"></td></tr>


<tr><td><label>Address :</label></td>
<td><input type="text" name="addr" value="<%=rs.getString(3)%>" required="yes"></td></tr>

<tr><td><label>Email ID :</label></td>
<td><input type="text" name="umail" value="<%=rs.getString(5)%>" required="yes" pattern="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></td></tr>

<tr><td><label>Phone NO :</label></td>
<td><input type="text" name="uphone" value="<%=rs.getString(4)%>" required="yes" pattern="[7-9]{1}[0-9]{9}"></td></tr>
</table>
<% 
}
%><br>
<input type="hidden"name="no"value="5">
<input type="submit" value="Update Profile" style="color: green">
</center>
</form>
</body>
</html>