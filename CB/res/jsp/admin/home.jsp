<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Project</title>
<script src="assets/js/jquery-1.11.1.min.js"></script>
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
    <body>
    
    
    
        <div class="container">
       
           <img alt="" src="<%=request.getContextPath()%>/Files/Images/Title copy.png">

			<div class="header">
               
                <span class="right">
                    <a href="#" target="_blank">Welcome....!</a>
                    <a href="#"><strong>Admin</strong></a>
                </span>
                <div class="clr"></div>
            </div>
            
            
   <nav>
    <div class='nav-container'>
      <div>
        <input id='slider1' name='slider1' type='checkbox'>
        <label class='slide has-child' for='slider1'>
          <span class='element'>Profile</span>
          <span class='name'>User Profile</span>
        </label>
        <div class='child-menu'>
           <a href="<%=request.getContextPath()%>/Profile" target="f">View Profile</a>         
        </div>
      </div>
       <div>   
        <a class='slide' href="<%=request.getContextPath()%>/ServerList?submit=get" target="f">
          <span class='element'>Service Providers</span>
          <span class='name'>Service Providers</span>
        </a>
      </div>
       <div>   
        <a class='slide' href="<%=request.getContextPath()%>/RechargeList?submit=get" target="f">
          <span class='element'>Recharge Details</span>
          <span class='name'>Recharge Details</span>
        </a>
      </div>
      <div>   
        <a class='slide' href="<%=request.getContextPath()%>/SPconfigList?submit=get" target="f">
          <span class='element'>SP Configuration</span>
          <span class='name'>SP Configuration</span>
        </a>
      </div>
      <div>   
        <a class='slide' href="<%=request.getContextPath()%>/newDataOwners?submit=get" target="f">
          <span class='element'>New Data Owner Details</span>
          <span class='name'>Data Owner Details</span>
        </a>
      </div>
      <div>   
        <a class='slide' href="<%=request.getContextPath()%>/ListDataOwners?submit=get" target="f">
          <span class='element'>Data Owner Details</span>
          <span class='name'>Data Owner Details</span>
        </a>
      </div>
      <div>   
        <a class='slide' href="<%=request.getContextPath()%>/res/jsp/admin/generate_key.jsp" target="f">
          <span class='element'>Key Generation</span>
          <span class='name'>Key Generation</span>
        </a>
      </div>
       <div>   
        <a class='slide' href="<%=request.getContextPath()%>/DepartmentList?submit=get" target="f">
          <span class='element'>Department</span>
          <span class='name'>Department</span>
        </a>
      </div>
      <div>   
        <a class='slide' href="<%=request.getContextPath()%>/DesignationList?submit=get" target="f">
          <span class='element'>Designation</span>
          <span class='name'>Designation</span>
        </a>
      </div>
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
            
            
            
            
                     
            
           <div style="position: absolute;top: 160px;left: 300px;"><iframe  width="950px;" height="520px;" name="f"  frameborder="0" scrolling="auto"></iframe></div>
            
        
        
        
        
    </body>
    
</html>