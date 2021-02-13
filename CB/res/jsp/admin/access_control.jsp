
<%@page import="com.dao.AdminDAO"%>
<%@page import="com.util.Utility"%>
<%@page import="java.sql.ResultSet"%><html>
<head>
<title>Generate Key</title>

	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/pagination.js"></script>
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

<script language="javascript">
	function check()
	{
		if(document.f1.file.value==0)
		{
			alert("Please Select a File");
			document.f1.file.focus();
			return false
		}
		if(document.f1.dept.value==0)
		{
			alert("Please Select the department");
			document.f1.dept.focus();
			return false
		}
		if(document.f1.designation.value==0)
		{
			alert("Please Select the designation");
			document.f1.designation.focus();
			return false
		}
		
	   return true;
		
	}
</script>
 <link rel="stylesheet" href="css/style_table.css">
<body onload="startTimer()">

<%
	AdminDAO adminDAO = null;
	ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
%>

<div id="a3" align="right" style="position:absolute;top:50px;left:50px">
						
		 <p>
			
					
				<form name="f1" action="<%=request.getContextPath()%>/ControlFileAcess" method="post">
					
					<table id="login" align="center">
					<tr>
							<td colspan="7" align="center">
								<font color="#000000" style="font-style: bold" size="5">File Access Control</font>
							</td>
					</tr>
					
					<tr>
							<td colspan="3" align="center"><hr></hr></td>
					</tr>
					
					<tr>
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td width="200px">File </td>
							<td width="75px">:</td>
							<td width="200px">
								<select name="file" class="field1" required="yes">
								    	<option value="0">--Select--</option>
								    	<%
								    	      String username = (String) session.getAttribute("username");
								    	      int ownerId = adminDAO.getDataOwnerId(username);
								    	      rs = adminDAO.getUploadedFiles(ownerId);
								    	      
								    		  while(rs.next())
								    	      {
								    	%>
								    	 
								    	<option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>
								    	<%
								    	      }
								    	%>
								    	 
									</select>
							</td>
							
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td width="200px">Department</td>
							<td width="75px">:</td>
							<td width="200px">
								<select name="dept" class="field1" required="yes">
								    	<option value="0">--Select--</option>
								    	<%
								    		rs1 = adminDAO.getDepartmentDetails();
								    	      
								    		  while(rs1.next())
								    	      {
								    	%>
								    	 
								    	<option value="<%=rs1.getInt(1)%>"><%=rs1.getString(2)%></option>
								    	<%
								    	      }
								    	%>
								    	 
									</select>
							</td>
							
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					
					<tr align="center">
							<td width="200px">Designation</td>
							<td width="75px">:</td>
							<td width="200px">
								<select name="designation" class="field1" required="yes">
								    	<option value="0">--Select--</option>
								    	    
								    	<%
								    	      rs2 = adminDAO.getDesignationDetails();
								    	      while(rs2.next())
								    	      {
								    	%>
								    	 
								    	<option value="<%=rs2.getInt(1)%>"><%=rs2.getString(2)%></option>
								    	<%
								    	      }
								    	%>
								    	
									</select>
							</td>
							
					</tr>
					
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td colspan="7" align="center">
								<input class="button button5" type="submit"  value="Provide Access" onclick="return check()"></input>
							</td>
					</tr>
					
					</table>
			</form>
			
		</p>
						
</div>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>File Access Information Added Successfully.....</p>
			</div>
		<%
	}

	if(Utility.parse(request.getParameter("no"))==2)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Something Went Wrong,Try It Again...</p>
			</div>
		<%
	}
%>

</body>
</html>