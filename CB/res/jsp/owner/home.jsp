<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Project</title>

        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style1.css" />
        <link href="<%=request.getContextPath() %>/css/fontstyle.css" rel='stylesheet' type='text/css' />
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/menu.css" />
    <script type="text/javascript">
window.history.forward();
function noBack() { window.history.forward(); }
</script>





    </head>
    
     <%
  
  HttpSession ss=request.getSession();
  String userid=(String)ss.getAttribute("username"); %>  
   
    <body>
    
    
    
        <div class="container">
       
          <!--  <h1>Attribute-Based Storage Supporting Secure <span> Deduplication of Encrypted Data in Cloud</span></h1> -->
          <img alt="" src="<%=request.getContextPath()%>/Files/Images/Title copy.png">

			<div class="header">
               
                <span class="right">
                    <a href="#" target="_blank">Welcome....!</a>
                    
                </span>
                <div class="clr"></div>
            </div>
            
            
   <nav>
    <div class='nav-container'>
     <%--  <div>
        <input id='slider1' name='slider1' type='checkbox'>
        <label class='slide has-child' for='slider1'>
          <span class='element'>Profile</span>
          <span class='name'>User Profile</span>
        </label>
        <div class='child-menu'>
           <a href="<%=request.getContextPath()%>/OwnerProfile" target="f">View Profile</a>         
        </div>
      </div> --%>
       <div>   
        <a class='slide' href="<%=request.getContextPath()%>/OwnerProfile" target="f">
          <span class='element'>Profile</span>
          <span class='name'>View Profile</span>
        </a>
      </div>
       <div>   
        <a class='slide' href="<%=request.getContextPath()%>/ListUser?submit=get" target="f">
          <span class='element'>User Details</span>
          <span class='name'>User Details</span>
        </a>
      </div>
       <div>   
        <a class='slide' href="<%=request.getContextPath()%>/UploadFile?submit=get" target="f">
          <span class='element'>Upload File</span>
          <span class='name'>Upload File</span>
        </a>
      </div>
      
      <div>   
        <a class='slide' href="<%=request.getContextPath()%>/RechargeLists?submit=get" target="f">
          <span class='element'>Recharge Details</span>
          <span class='name'>Recharge Details</span>
        </a>
      </div>
        <div>   
        <a class='slide' href="<%=request.getContextPath()%>/CreditDetails?id=<%=userid %>" target="f">
          <span class='element'>Credit Details</span>
          <span class='name'>Credit Details</span>
        </a>
      </div> 
       <div>   
        <a class='slide' href="<%=request.getContextPath()%>/res/jsp/admin/access_control.jsp" target="f">
          <span class='element'>File Access Control </span>
          <span class='name'>File Access Control</span>
        </a>
      </div>
       <div>   
        <a class='slide' href="<%=request.getContextPath()%>/AccessFileControlList?submit=get" target="f">
          <span class='element'>View Access Control</span>
          <span class='name'>View Access Control</span>
        </a>
      </div>
       <%-- <div>   
        <a class='slide' href="<%=request.getContextPath()%>/UploadFileList?submit=get" target="f">
          <span class='element'>View Transaction</span>
          <span class='name'>View Transaction</span>
        </a>
      </div> --%>
     
      <div>
        <a class='slide' href="<%=request.getContextPath()%>/index.jsp?no=6">
          <span class='element'>Logout</span>
          <span class='name'>Logout</span>
        </a>
      </div>
    </div>
  </nav>
  </div>
  <div class='social-container'>
    <span>
      <a class='social-roll github' href='#'></a>
    </span>
    <span>
      <a class='social-roll twitter' href='#'></a>
    </span>
    <span>
      <a class='social-roll linkedin' href='#'></a>
    </span>
    <span>
      <a class='social-roll rss' href='#'></a>
    </span>
  </div>
            
            
            
            
                     
            
           <div style="position: absolute;top: 160px;left: 230px;"><iframe width="750px;" height="520px;" name="f"  frameborder="0" scrolling="auto"></iframe></div>
            
        
        
        
        
    </body>
</html>