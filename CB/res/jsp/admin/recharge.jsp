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
	String rcode="",cost="",status="";
	if(no==1)
	{
%>	

<form action="<%=request.getContextPath()%>/RechargeList">
<div align="right" style="position:absolute;top:30px;left:450px">
	<input type="submit" name="submit" value="Add" class="button button5"/>&nbsp;&nbsp;&nbsp;&nbsp;
	
	<input type="submit" name="submit" value="Delete" class="button button5"/>&nbsp;&nbsp;&nbsp;&nbsp;
</div>

<div id="a3" align="right" style="position:absolute;top:75px;left:11px;width: 650px;height: 300px;">
			
<p>

	<table id="results" class="tab" border="1" cellpadding="5px" cellspacing="4px" width="550px">
		
		<tr>
			
			<td colspan="5" align="center">
			<font color="#000000" style="font-style: bold" size="5">Recharge Details</font>
			</td>
									
		</tr>
							
		
		<tr>
			<th>Select</th>
			<th>Voucher Code</th>
			<th>Vourcher Cost</th>
			<th>Voucher Status</th>
		</tr>

<% 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			rcode=rs.getString(2);
			cost=rs.getString(3);
			status=rs.getString(4);
			
		    
%>
			<tr align="center">
				<td><input name="chk" type="checkbox" value="<%=id%>"></td>
						<td><%=rcode%></td>
						<td><%=cost%></td>
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
				<p>Recharge Details Added successfully ..!</p>
			</div>
		<%
	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		%>
			<div class="success" id="message" style="position:absolute;top:5px;left:50px">	
				<p>Recharge Details Updated successfully ..!</p>
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
				<p>Recharge Details Deleted successfully ..!</p>
			</div>
		<%
	}
}
	if(no == 2)
	{
%>
		
		<div id="a2" align="right" style="position:absolute;top:50px;left:25px">
						
		 <p>
			<table id="login" align="center">
					
				<form action="<%=request.getContextPath()%>/RechargeList">
				<input type="hidden" name="submit" value="Add"></input>
				<input type="hidden" name="add1" value="YES"></input>
					
					<tr>
							<td colspan="3" align="center">
							<font color="#000000" style="font-style: bold" size="5">Add Recharge Details</font>
							</td>
					</tr>
					
					<tr>
							<td colspan="3" align="center"><hr></hr></td>
					</tr>
					
					<tr>
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td width="175px">Voucher code</td>
							<td width="75px">:</td>
							<td width="200px"><input class="field" type="text" name="code" required="yes"></input></td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
					<tr align="center">
							<td>Voucher cost</td>
							<td >:</td>
							<td> 
								<input class="field" type="text" name="cost" required="yes"></input>
							</td>
					</tr>
					
					<tr align="center">
							<td>&nbsp;</td>
					</tr>
					
							
					<tr align="center">
							<td colspan="3" align="center">
								<input class="button button5" type="submit"  value="Add Voucher"></input>
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
					<p>Sorry,This host is already exists  !</p>
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


}%>

</body>
</html>


