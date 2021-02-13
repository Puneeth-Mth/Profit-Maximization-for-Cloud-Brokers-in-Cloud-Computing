<%@page import="com.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.AdminDAO"%><html>
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
<body onload="startTimer()">

<%
    int no=Utility.parse(request.getParameter("no"));
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0,deptId=0,designId=0;
	String username="",name="",add="",email="",phone="";
	
	AdminDAO adminDAO = null;
	
	while(rs.next())
	{
		id=rs.getInt(1);
		username=rs.getString(2);
		name=rs.getString(4);
		deptId=rs.getInt(5);
		designId=rs.getInt(6);
		add = rs.getString(7);
		phone = rs.getString(9);
		email = rs.getString(11);
	}

	if(no==1)
	{
%>
			<div class="error" id="message" style="position:absolute;top:225px;left:300px">		
				<p>Opp's,Seems something went wrong ..!</p>
			</div>
<%
	}
	else if(no==0)
	{
%>
			<br>
			<div align="right" style="position:absolute;top:15px;left:350px">
				<a class="button button5" href="<%=request.getContextPath() %>/EditUserProfile?username=<%=username %>&no=1">Edit Profile</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="button button5" href="<%=request.getContextPath() %>/ChangeUserPassword?username=<%=username %>&no=1&id=<%=id %>">Change Password</a>
			</div>
			<br>
			<div id="a2" align="right" style="position:absolute;top:45px;left:11px">
			
				<p>
				
					<table>
							<tr>
									<td colspan="3" align="center">
									<font color="#000000" style="font-style: bold" size="5">User Profile Details</font>
									</td>
									
							</tr>
							
							
							<tr>
									<td colspan="3" align="center"><hr></hr></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td width="200px">Your ID No</td>
									<td width="50px">:</td>
									<td> <%=id %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Name</td>
									<td >:</td>
									<td> <%=name %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your User ID</td>
									<td>:</td>
									<td> <%=username %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Department</td>
									<td>:</td>
									<td> <%=adminDAO.getDepartmentName(deptId)%></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Designation</td>
									<td>:</td>
									<td> <%=adminDAO.getDesignationName(designId)%></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Mail ID </td>
									<td>:</td>
									<td> <%=email %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Cell N0  </td>
									<td>:</td>
									<td> <%=phone %></td>
							</tr>
							
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Address  </td>
									<td>:</td>
									<td>  <%=add %></td>
							</tr>
					</table>
				</p>
				
				
			</div>
		<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Your profile updated successfully ..!</p>
				</div>
			<%
		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			%>
				<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Your Password updated successfully ..!</p>
				</div>
			<%
		}
	}
	else if(no==2)
	{
%>


<!-- Display Contents (Starts) -->

					<form id="login" action="<%=request.getContextPath() %>/EditUserProfile?no=2">
					<input type="hidden" name="admin" value="<%=username %>"></input>
					<input type="hidden" name="no" value="2"></input>
					<input type="hidden" name="id" value="<%=id %>"></input>
					<div align="right" style="position:absolute;top:0px;left:375px">
						<input type="submit" value="Save Updates" class="button button5"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="button button5" href="<%=request.getContextPath() %>/ChangeUserPassword?username=<%=username %>&no=1&id=<%=id %>" target="myIframe">Change Password</a>
					</div>
					<br></br>
					<div id="a2" align="right" style="position:absolute;top:35px;left:25px">
						
						<p>
					<table>
							<tr>
									<td colspan="3" align="center">
									<font color="#000000" style="font-style: bold" size="5">Edit User Profile Details</font>
									</td>
							</tr>
							
							<tr>
									<td colspan="3" align="center"><hr></hr></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td width="200px">Your ID No</td>
									<td width="50px">:</td>
									<td> <%=id %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Name</td>
									<td >:</td>
									<td> 
										<input class="field" type="text" name="name" value="<%=name %>"></input>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your User ID</td>
									<td>:</td>
									<td> <%=username %></td>
							</tr>
							
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Department</td>
									<td>:</td>
									<td> <%=adminDAO.getDepartmentName(deptId)%></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Designation</td>
									<td>:</td>
									<td> <%=adminDAO.getDesignationName(designId)%></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Mail ID </td>
									<td>:</td>
									<td>
										<input class="field" type="text" name="email" value="<%=email %>"></input>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Cell No  </td>
									<td>:</td>
									<td> 
										<input class="field" type="text" name="phone" value="<%=phone %>"></input>
									</td>
							</tr>
							
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Your Address  </td>
									<td>:</td>
									<td>
										<input class="field" type="text" name="add" value="<%=add %>"></input>
									</td>
							</tr>
					</table>
				</p>
						
		</div>
</form>

<!-- Display Contents (Ends) -->
<%
}
	else if(no==3)
	{
%>
      <form id="login" action="<%=request.getContextPath() %>/ChangeUserPassword?no=2">
		<input type="hidden" name="admin" value="<%=username %>"></input>
		<input type="hidden" name="id" value="<%=id %>"></input>
		<input type="hidden" name="no" value="2"></input>
		<div align="right" style="position:absolute;top:40px;left:375px">
			<a class="button button5" href="<%=request.getContextPath() %>/EditUserProfile?username=<%=username%>&no=1">Edit Profile</a>
			<input type="submit" value="Save Updates" class="button button5"/>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<br></br>
		
		<div id="a2" align="right" style="position:absolute;top:80px;left:25px">
				<p>
					<table>
							<tr>
									<td colspan="3" align="center">
									<font color="#000000" style="font-style: bold" size="5">Change Password</font>
									</td>
							</tr>
							
							<tr>
									<td colspan="3" align="center"><hr></hr></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td width="200px">Your ID No</td>
									<td width="50px">:</td>
									<td> <%=id %></td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Current Password</td>
									<td >:</td>
									<td> 
										<input class="field" type="password" name="pass"/>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>New Password</td>
									<td>:</td>
									<td>
										<input class="field" type="password" name="npass" required="yes"></input>
									</td>
							</tr>
							
							<tr>
									<td>&nbsp;</td>
							</tr>
							
							<tr>
									<td>Confirm new password   </td>
									<td>:</td>
									<td> 
										<input class="field" type="password" name="cpass"></input>
									</td>
							</tr>
							
					</table>
				</p>
		</div>
	</form>

<%
	if(Utility.parse(request.getParameter("no1"))==1)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opp's,your current password is wrong ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opp's,your new password do not match with confirm password ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==3)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opp's,Seems something went wrong....!</p>
			</div>
		<%
	}
}
%>
</body>
</html>


