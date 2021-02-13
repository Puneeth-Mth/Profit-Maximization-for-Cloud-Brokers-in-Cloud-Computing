<%@page import="com.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.AdminDAO"%><html>
<head>
	<link href="<%=request.getContextPath() %>/Resources/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/button.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/Resources/CSS/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Resources/JS/pagination.js"></script>

 <link rel="stylesheet" href="css/style_table.css">
<script language="javascript">
	function check()
	{
		if(document.f1.dept.value==0)
		{
			alert("Please,Select Your Department1.");
			document.f1.dept.focus();
			return false
		}
		if(document.f1.designation.value==0)
		{
			alert("Please,Select Your Designation1.");
			document.f1.designation.focus();
			return false
		}
		/* if(document.f1.dept1.value==0)
		{
			alert("Please,Select Your Department2.");
			document.f1.dept1.focus();
			return false
		}
		if(document.f1.designation1.value==0)
		{
			alert("Please,Select Your Designation2.");
			document.f1.designation1.focus();
			return false
		} */
		if(document.f1.dept.value==document.f1.dept1.value)
		{
			alert("Both The Departments Are Same,Select Different One.");
			document.f1.dept.focus();
			return false
		}
		if(document.f1.designation.value==document.f1.designation1.value)
		{
			alert("Both The Designations Are Same,Select Different One.");
			document.f1.designation.focus();
			return false
		}
	}


	function check1()
	{
		if(document.f.dept.value==0)
		{
			alert("Please,Select Your Department1.");
			document.f.dept.focus();
			return false
		}
		if(document.f.designation.value==0)
		{
			alert("Please,Select Your Designation1.");
			document.f.designation.focus();
			return false
		}
		if(document.f.dept1.value==0)
		{
			alert("Please,Select Your Department2.");
			document.f.dept1.focus();
			return false
		}
		if(document.f.designation1.value==0)
		{
			alert("Please,Select Your Designation2.");
			document.f.designation1.focus();
			return false
		}
		if(document.f.dept.value==document.f.dept1.value)
		{
			alert("Both The Departments Are Same,Select Different One.");
			document.f.dept.focus();
			return false
		}
		if(document.f.designation.value==document.f.designation1.value)
		{
			alert("Both The Designations Are Same,Select Different One.");
			document.f.designation.focus();
			return false
		}
	}
	
</script>
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
    AdminDAO adminDAO = null;
   
    int no=Utility.parse(request.getParameter("no"));
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    int id=0,deptId1=0,designId1=0;
	String username="",password="",name="",city="",mobile="",phone="",address="",email="";
	if(no==1)
	{
%>	

<form action="<%=request.getContextPath()%>/ListUser">
<div align="right" style="position:absolute;top:20px;left:150px">
	<input type="submit" name="submit" value="Add" class="button button5"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="Edit" class="button button5"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="Delete" class="button button5"/>&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="submit" value="LightWeight_Key" class="button button5"/>&nbsp;&nbsp;&nbsp;&nbsp;
	
</div>

<div id="a3" align="right" style="position:absolute;top:60px;left:2px;width: 650px;height: 350px;">
			
<p>

	<table id="results" class="tab" border="1" cellpadding="5px" cellspacing="4px" width="650px">
		
		<tr>
			
			<td colspan="6" align="center">
			<font color="#000000" style="font-style: bold" size="5">User Details</font>
			</td>
									
		</tr>
							
		
		<tr>
			<th>Select</th>
			<th>Username</th>
			<th>Name</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Contact</th>
		</tr>

<% 
	
    if(rs != null)
    {
	    while(rs.next())
		{
	    	id=rs.getInt(1);
			username=rs.getString(2);
			name=rs.getString(4);
			deptId1=rs.getInt(5);
			designId1=rs.getInt(6);
			city=rs.getString(8);
			mobile=rs.getString(9);
			email = rs.getString(12);
		    
%>
			<tr align="center">
				<td><input name="chk" type="checkbox" value="<%=id%>"></td>
						<td><%=username%></td>
						<td><%=name%></td>
						<td><%=adminDAO.getDepartmentName(deptId1)%></td>
						<td><%=adminDAO.getDesignationName(designId1)%></td>
						<td><%=mobile%></td>
						
			</tr>
<%
		}
    }

%>
  	 </table>
  	 </p>
   </div>
 </form>
   

<div id="pageNavPosition" style="position:absolute;top:420px;left:550px"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results',5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>

<%-- Adding The Server Details --%>

<%
	if(Utility.parse(request.getParameter("no1"))==1)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>User Details Added successfully ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>User Details Updated successfully ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==3)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Select atleast one checkbox !</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==4)
	{
		%>
			<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Opps,Select only one checkbox to edit!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==5)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>User Details Deleted successfully ..!</p>
			</div>
		<%
	}
	
}
	if(no == 2)
	{
%>
		
		<div id="a3" align="right" style="position:absolute;top:11px;left:11px">
						
		 <p>
			<table id="login" align="center">
					
				<form name="f1" action="<%=request.getContextPath()%>/ListUser">
				<input type="hidden" name="submit" value="Add"></input>
				<input type="hidden" name="add1" value="YES"></input>
					
					<tr>
							<td colspan="7" align="center">
								<font color="#000000" style="font-style: bold" size="5">Add User Details</font>
							</td>
					</tr>
					
					<tr>
							<td colspan="7" align="center"><hr></hr></td>
					</tr>
					
					<tr>
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td width="175px">Username</td>
							<td width="75px">:</td>
							<td width="200px">
								<input class="field" type="text" name="username" required="yes"></input>
							</td>
							
							<td width="50px"></td>
							
							<td>Password</td>
							<td >:</td>
							<td> 
								<input class="field" type="password" name="password" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Name</td>
							<td>:</td>
							<td> 
									<input class="field" type="text" name="name" required="yes"></input>
							</td>
							
							<td width="50px"></td>
							
							<td>Email</td>
							<td>:</td>
							<td> 
									<input class="field" type="text" name="email" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Department1</td>
							<td>:</td>
							<td> 
									
									<select name="dept" class="field1">
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
							
							<td width="50px"></td>
							
							<td>Designation1</td>
							<td>:</td>
							<td> 
									<select name="designation" class="field1" >
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
					
					
					<%-- <tr align="center">
							<td>Department2</td>
							<td>:</td>
							<td> 
									
									<select name="dept1" class="field1">
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
							
							<td width="50px"></td>
							
							<td>Designation2</td>
							<td>:</td>
							<td> 
									<select name="designation1" class="field1" required="no">
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
					</tr> --%>
					
					<tr align="center">
					        
					        <td>Address</td>
							<td>:</td>
							<td> 
									<input class="field" type="text" name="address" required="yes"></input>
							</td>
					        
					        <td width="50px"></td>
					        
							<td>City</td>
							<td>:</td>
							<td> 
									<input class="field" type="text" name="city" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Phone</td>
							<td>:</td>
							<td> 
								<input class="field" type="text" name="phone"></input>
							</td>
							
							<td width="50px"></td>
							
							<td>Mobile</td>
							<td>:</td>
							<td> 
								<input class="field" type="text" name="mobile" required="yes"></input>
							</td>
					</tr>
					
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td colspan="7" align="center">
								<input class="button button5" type="submit" onclick="return check();" value="Register"></input>
							</td>
					</tr>
			</form>
			</table>
		</p>
						
</div>
<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Sorry,This user is already exists  !</p>
				</div>
			<%
		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Sorry, Somthing went wrong try again!</p>
				</div>
			<%
		}
		if(Utility.parse(request.getParameter("no1"))==3)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Please,Select Your Department1.</p>
				</div>
			<%
		}


}

if(no == 3)
{
	/* Adding The User Details */
	
	String hostName="";
	
	
	 if(rs != null)
    {
	    while(rs.next())
		{
	    	id=rs.getInt(1);
			username=rs.getString(2);
			password=rs.getString(3);
			name=rs.getString(4);
			deptId1=rs.getInt(5);
			//deptId2=rs.getInt(6);
			designId1=rs.getInt(6);
			//designId2=rs.getInt(8);
			address=rs.getString(7);
			city=rs.getString(8);
			phone=rs.getString(9);
			mobile=rs.getString(10);
			email = rs.getString(11);
			
		}
    }   
	
%>
		
		<div id="a2" align="right"  style="position:absolute;top:11px;left:11px">
						
		 <p>
			<table id="login" align="center">
					
				<form name="f" action="<%=request.getContextPath()%>/ListUser">
				<input type="hidden" name="submit" value="Edit"></input>
			    <input type="hidden" name="edit1" value="YES"></input>
			    <input type="hidden" name="id" value="<%=id %>"></input>
					
					<tr>
							<td colspan="7" align="center">
								<font color="#000000" style="font-style: bold" size="5">Edit User Details</font>
							</td>
					</tr>
					
					<tr>
							<td colspan="7" align="center"><hr></hr></td>
					</tr>
					
					<tr>
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td width="175px">Username</td>
							<td width="75px">:</td>
							<td width="200px">
								<input class="field" type="text" name="username" value="<%=username %>" readonly="readonly"></input>
							</td>
							
							<td width="50px"></td>
							
							<td>Password</td>
							<td >:</td>
							<td> 
								<input class="field" type="password" name="password" value="<%=password%>" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Name</td>
							<td>:</td>
							<td> 
									<input class="field" type="text" name="name" value="<%=name %>" required="yes"></input>
							</td>
							
							<td width="50px"></td>
							
							<td>Email</td>
							<td>:</td>
							<td> 
									<input class="field" type="text" name="email" value="<%=email%>" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Department1</td>
							<td>:</td>
							<td> 
									<select name="dept" class="field1" required="yes">
									<option value="<%=deptId1%>" selected="selected"><%=adminDAO.getDepartmentName(deptId1) %></option>
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
							
							<td width="50px"></td>
							
							<td>Designation1</td>
							<td>:</td>
							<td> 
									<select name="designation" class="field1" required="yes">
								    <option value="<%=designId1%>" selected="selected"><%=adminDAO.getDesignationName(designId1) %></option>
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
					
					<%-- <tr align="center">
							<td>Department2</td>
							<td>:</td>
							<td> 
									
									<select name="dept1" class="field1">
								    <option value="<%=deptId2%>" selected="selected"><%=adminDAO.getDepartmentName(deptId2) %></option>
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
							
							<td width="50px"></td>
							
							<td>Designation2</td>
							<td>:</td>
							<td> 
									<select name="designation1" class="field1" required="yes">
								    <option value="<%=designId2%>" selected="selected"><%=adminDAO.getDesignationName(designId2) %></option>
								    	    
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
					</tr> --%>
					
					<tr align="center">
					        
					        <td>Address</td>
							<td>:</td>
							<td> 
									<input class="field" type="text" name="address" value="<%=address %>" required="yes"></input>
							</td>
					        
					        <td width="50px"></td>
					        
							<td>City</td>
							<td>:</td>
							<td> 
									<input class="field" type="text" name="city" value="<%=city %>" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Phone</td>
							<td>:</td>
							<td> 
								<input class="field" type="text" name="phone" value="<%=phone%>"></input>
							</td>
							
							<td width="50px"></td>
							
							<td>Mobile</td>
							<td>:</td>
							<td> 
								<input class="field" type="text" name="mobile" value="<%=mobile%>" required="yes"></input>
							</td>
					</tr>
					
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td colspan="7" align="center">
								<input class="button button5" type="submit" onclick="return check1();" value="Update"></input>
							</td>
					</tr>
			</form>
			</table>
		</p>
						
</div>
<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:200px;left:200px">	
					<p>Sorry, Somthing went wrong try again!</p>
				</div>
			<%
		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			%>
				<div class="error" id="message" style="position:absolute;top:5px;left:50px">	
					<p>Sorry, Somthing went wrong try again!</p>
				</div>
			<%
		}


}
%>
</body>
</html>


