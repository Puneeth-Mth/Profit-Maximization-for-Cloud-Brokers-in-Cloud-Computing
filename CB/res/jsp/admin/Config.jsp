<%@page import="com.util.Utility"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.*"%><html>
<head>
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
 <link rel="stylesheet" href="css/style_table.css">
</head>
<body onload="startTimer()">
<%
    int no=Utility.parse(request.getParameter("no"));
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0;
	String status="";
	int quality=0,url=0,size=0,cost=0;
	if(no==1)
	{
%>	

<form action="<%=request.getContextPath()%>/SPconfigList">
<div align="right" style="position:absolute;top:30px;left:450px">
	
	<input type="submit" name="submit" value="Edit" class="button button5"/>
	
</div>

<div id="a3" align="right" style="position:absolute;top:75px;left:11px;width: 650px;height: 300px;">
			
<p>

	<table id="results" class="tab" border="1" cellpadding="5px" cellspacing="4px" width="550px">
		
		<tr>
			
			<td colspan="8" align="center">
			<font color="#000000" style="font-style: bold" size="5">Cloud Service Provider Configuration Details</font>
			</td>
									
		</tr>
							
		
		<tr>
			<th>Select</th>
			<th>Service Provider</th>
			<th>Cloud Size</th>
			<th>Cloud Cost</th>
			<th>Cloud Quality</th>
			<th>Cloud Status</th>
		</tr>

<% 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			url=rs.getInt(2);
			size=rs.getInt(3);
			cost=rs.getInt(4);
			quality=rs.getInt(5);
			status=rs.getString(6);
		    
%>
			<tr align="center">
				<td><input name="chk" type="checkbox" value="<%=id%>"></td>
						<td><%=AdminDAO.geturl(url)%></td>
						<td><%=size%></td>
						<td><%=cost%></td>
						<td><%
				int qty=quality;
				String qty1="";
				if(qty==0)
					qty1="Low";
				if(qty==1)
					qty1="Good";
				if(qty==2)
					qty1="Very Good";
				if(qty==3)
					qty1="Excellent";
			%><%=qty1 %></td>
			<td><%=status%></td>	
			</tr>
<%
		}
    }

%>
  	 </table>
  	 </p>
   </div>
 </form>
   

<div id="pageNavPosition" style="position:absolute;top:380px;left:575px"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results',6); 
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
				<p>Server Details Added successfully ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Server Details Updated successfully ..!</p>
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
				<p>Server Details Deleted successfully ..!</p>
			</div>
		<%
	}
}
	if(no == 3)
	{
		/* Adding The Server Details */
		
		int s_code=0,s_id=0,s_size=0,s_cost=0,s_qty=0;
		String s_status="";
		
		 if(rs != null)
	    {
		    while(rs.next())
			{
		    	s_code=rs.getInt(1);
				s_id=rs.getInt(2);
				s_size=rs.getInt(3);
				s_cost=rs.getInt(4);
				s_qty=rs.getInt(5);
				s_status=rs.getString(6);
				
				
			}
	    }   
	%>
			
			<div id="a2" align="right" style="position:absolute;top:50px;left:25px">
							
			 <p>
				<table id="login" align="center">
						
					<form action="<%=request.getContextPath()%>/SPconfigList">
					<input type="hidden" name="submit" value="Edit"></input>
				    <input type="hidden" name="edit1" value="YES"></input>
				    <input type="hidden" name="id" value="<%=id %>"></input>
						
						<tr>
								<td colspan="3" align="center">
								<font color="#000000" style="font-style: bold" size="5">Edit Cloud Service Provider Configuration Details</font>
								</td>
						</tr>
						
						<tr>
								<td colspan="3" align="center"><hr></hr></td>
						</tr>
						
						<tr>
								<td>&nbsp;</td>
						</tr>
						
						<tr align="center">
								<td width="175px">Service Provider Name</td>
								<td width="75px">:</td>
								<td width="200px"><input class="field" type="text" name="host" value="<%=AdminDAO.geturl(s_id)%>" readonly></input>
								<input type="hidden" name="s_code" value="<%=s_code %>"></input></td>
						</tr>
						
						<tr align="center">
								<td>&nbsp;</td>
						</tr>
						
						<tr align="center">
								<td>Cloud Size</td>
								<td >:</td>
								<td> 
									<select class="field" style="color:black" name="s_size">
									<option value="10">10 MB</option>
									<option value="20">20 MB</option>
									<option value="50">50 MB</option>
									<option value="100">100 MB</option>
									<option value="200">200 MB</option>
									<option value="300">300 MB</option>
									<option value="500">500 MB</option>
									<option value="1000">1000 MB</option>
									</select>
								</td>
						</tr>
						
						<tr align="center">
								<td>&nbsp;</td>
						</tr>
						
						<tr align="center">
								<td>Storage Cost (Per KB) </td>
								<td>:</td>
								<td> 
										<select class="field" style="color:black" name="s_cost">
										<option value="5">5 Rs</option>
										<option value="10">10 RS</option>
										<option value="15">15 Rs</option>
										<option value="20">20 Rs</option>
										<option value="25">25 Rs</option>
										<option value="30">30 Rs</option>
										<option value="35">35 Rs</option>
										<option value="40">40 Rs</option>
										<option value="50">50 Rs</option>
										<option value="75">75 Rs</option>
										<option value="100">100 Rs</option>
										</select>
								</td>
						</tr>
						
						<tr align="center">
								<td>&nbsp;</td>
						</tr>
						
						<tr align="center">
								<td>Storage Quality</td>
								<td>:</td>
								<td>
									 <select class="field1" name="s_qty" required="yes">
									 		<option value="0">Poor</option>
											<option value="1">Good</option>
											<option value="2">Very Good</option>
											<option value="3">Excellent</option>
									 </select>
								</td>
						</tr>
						
						
						
						
						<tr align="center">
								<td>&nbsp;</td>
						</tr>
						
						<tr align="center">
								<td>Status</td>
								<td>:</td>
								<td>
									 <select class="field1" name="status" required="yes">
									 		<option value="Active">Active</option>
											<option value="Deactive">Deactive</option>
											
									 </select>
								</td>
						</tr>
						
						<tr align="center">
								<td>&nbsp;</td>
						</tr>
						<tr align="center">
								<td colspan="3" align="center">
									<input class="button button5" type="submit"  value="Update Server"></input>
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


