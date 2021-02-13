/**
 * 
 */
package com.upload.msg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PassFile extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		
	    	   PrintWriter out = response.getWriter();  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );  
	    	   out.println( "<br><br><br>" );
	    	   out.println( "<center><br><br>" );
	    	   out.println("<font color=black size=5>");
	    	   out.println( "File Transferred Completed to server<br>  " );
	    	   out.println( "Thank You....</h1></center"); 
	    	   out.println("</font>");
	    	   out.close();  
	    	   //return;
	      
	}
}
