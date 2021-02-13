<%@ page import="java.sql.*" %>
<%@ page import="com.util.*" %>
<html>
<%
	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	String name=Utility.parse1(request.getParameter("name")); 
	
	System.out.print("name in jsp page"+name);
	int count=1;
	
	
%>

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

<head>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/pagination.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
function Validate()
{
     var image =document.getElementById("image").value;
     if(image!='')
     {
           var checkimg = image.toLowerCase();
          if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG|\.xls|\.xlsx|\.docx|\.doc|\.txt)$/)){ // validation of file extension using regular expression before file upload
              document.getElementById("image").focus();
              document.getElementById("errorName5").innerHTML="File Format support oly(.jpg|.png|.JPG|.PNG|.jpeg|.JPEG|.xls|.xlsx|.docx|.doc|.txt)"; 
              return false;
           }
            var img = document.getElementById("image"); 
            alert(img.files[0].size);
            if(img.files[0].size >  1048576)  // validation according to file size
            {
            document.getElementById("errorName5").innerHTML="Image size too large";
            return false;
             }
             return true;
      }
}
</script>
	
	
</head>
<body onload="startTimer()">

<form action="<%=request.getContextPath() %>/UploadFile">
<button class="button button5" type="submit" name="submit"   value="Upload" id="a1">Upload</button>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="hidden" name="name" value="<%=name %>"/>
<button class="button button5" type="submit"   name="submit"  value="Delete"  id="a1">Delete</button>


	<table id="results"  style="top: 1000 ; right:100; width: 800 ; color: black";>
	<tr>
		<th><font color="#000" style="font-style: bold" size="4">Select</font></th>
		<th><font color="#000" style="font-style: bold" size="4">FileId</font></th>
		<!-- <th><font color="#000" style="font-style: bold" size="4">UserId</font></th> -->
		<th><font color="#000" style="font-style: bold" size="4">File_Name</font></th>
		<th><font color="#000" style="font-style: bold" size="4">Date</font></th>
		<th><font color="#000" style="font-style: bold" size="4">Time</font></th>
		<!-- <th><font color="#000" style="font-style: bold" size="4">Day</font></th> -->
	</tr>
	<%
	if(rs!=null)
		while(rs.next())
		{%>
			<tr>
				<td><%=count++ %>&nbsp;&nbsp;&nbsp;
					<input name="chk" type="checkbox" value="<%=rs.getInt(1) %>"></td>
				<td><font color="#000" style="font-style: bold" size="4"><%=rs.getInt(1) %></font></td>
				<%-- <td><font color="#000" style="font-style: bold" size="4"><%=rs.getInt(8) %></font></td> --%>
				<td><font color="#000" style="font-style: bold" size="4"><%=rs.getString(2) %></font></td>
				<td><font color="#000" style="font-style: bold" size="4"><%=rs.getString(9) %></font></td>
				<td><font color="#000" style="font-style: bold" size="4"><%=rs.getString(10) %></font></td>
				<%-- <td><font color="#000" style="font-style: bold" size="4"><%=rs.getString(11) %></font></td> --%>
				</tr>
		<%}
	%>
</table>
</form>
<div id="pageNavPosition" style="cursor:hand;color: white"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results', 5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>
<%




	if(Utility.parse(request.getParameter("no"))==2)
    {
    
		
		
    
    %>
    
      <script type="text/javascript">
     
      			
    			alert('File Uploaded Successfully.....!'+x);
    			</script>	
    			
    			
    		
    <%}
	if(Utility.parse(request.getParameter("no"))==1)
	{
	
		
	
	%>
		<div class="tab1" style="position:absolute;top:250px;left:350px">	
			<%-- <form name="form1" id="login" action="<%=request.getContextPath() %>/UploadToCloud?name=<%=name %>" enctype="multipart/form-data" method="post" onSubmit="return OnUploadCheck();">
				
				<input type="file" name="file" class="field" required="true"></input><br></br>
				<button class="button button5" type="submit" name="Upload File" value="Upload" id="a1">Upload File</button>
			
				
			</form> --%>
			
			<form action="<%=request.getContextPath() %>/UploadToCloud?name=<%=name %>" method="post"  enctype="multipart/form-data" onSubmit="return Validate()";>
<input type="file" name="file" id="image"/>
<span id="errorName5" style="color: red;"></span>
<input type="submit" value="Upload" name="Upload File"/>
</form>
			
			
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==3)
    {%>
    
       <script type="text/javascript">
    			alert('Opps select atleast one to delete.....!');
    			</script>	
    		
    		
    <%}
	if(Utility.parse(request.getParameter("no"))==4)
    {%>
    
          <script type="text/javascript">
    			alert('File Deleted Successfully.....!');
    			</script>	
    		
    
    <%}
	
	if(Utility.parse(request.getParameter("no"))==5)
    {%>
    
          <script type="text/javascript">
    			alert('Network problem.....!');
    			</script>	
    		
    <%}
	
	if(Utility.parse(request.getParameter("no"))==6)
    {%>
    
      <script type="text/javascript">
    			alert('Downloaded Successfully');
    			</script>	
    		
    <%}
	if(Utility.parse(request.getParameter("no"))==7)
    {%>
    
    <script type="text/javascript">
    			alert('Some blocks of file are already exists in the cloud');
    			</script>	
    		
    <%}
	
%>		
</body>
</html>