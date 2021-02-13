<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap Login Form Template</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

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
<script type="text/javascript">
alert("Password and Re Password Incorrect.....!");
</script>
	
<%}else if(no==2)
{
%>
<script type="text/javascript">

alert("Some thing Went wrong.........!");
</script>


<%}else if(no==3)
{%>
<script type="text/javascript">

alert("User ID is Already Exist.....!");
</script>

<%}else
	{%>
	
	<%
	}%>


       <!-- Top content -->
        <div class="top-content">
        	
            
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Project Title</strong></h1>
                            <div class="description">
                            	
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Registration Form</h3>
                            		<p>Fill the details to Signup:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="<%=request.getContextPath()%>/Singup" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Name</label>
			                        	<input type="text" name="userid" placeholder="Name..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-username">Password</label>
			                        	<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
			                        </div>
			                         <div class="form-group">
			                        	<label class="sr-only" for="form-username">Repassword</label>
			                        	<input type="password" name="rpassword" placeholder="Re-Password..." class="form-password form-control" id="form-password">
			                        </div>
			                         <div class="form-group">
			                        	<label class="sr-only" for="form-username">Owner Name</label>
			                        	<input type="text" name="username" placeholder="Owner Name..." class="form-password form-control" id="form-password">
			                        </div>
			                         <div class="form-group">
			                        	<label class="sr-only" for="form-username">Address</label>
			                        	<input type="text" name="addr" placeholder="Address..." class="form-password form-control" id="form-password">
			                        </div>
			                         <div class="form-group">
			                        	<label class="sr-only" for="form-username">Phone</label>
			                        	<input type="text" name="pno" placeholder="Phone..." class="form-password form-control" id="form-password">
			                        </div>
			                         <div class="form-group">
			                        	<label class="sr-only" for="form-username">Email</label>
			                        	<input type="text" name="email" placeholder="Email..." class="form-password form-control" id="form-password">
			                        </div>
			                        <button type="submit" value="Log in" class="btn">Sign in!</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
                        	<h3>...or login with:</h3>
                        	<div class="social-login-buttons">
	                        	<a class="btn btn-link-2" href="<%=request.getContextPath()%>/index.jsp">
	                        		<i class="fa fa-twitter"></i> Admin
	                        	</a>
	                        	<a class="btn btn-link-2" href="<%=request.getContextPath()%>/index1.jsp">
	                        		<i class="fa fa-twitter"></i> User
	                        	</a>
	                        	<a class="btn btn-link-2" href="<%=request.getContextPath()%>/signup.jsp">
	                        		<i class="fa fa-twitter"></i> SignUp
	                        	</a>
                        	</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>