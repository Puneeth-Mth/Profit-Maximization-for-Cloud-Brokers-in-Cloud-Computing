package com.user.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.Utility;

public class DownloadToClient extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		
		
		HttpSession session = req.getSession( true );  
	       if ( session.getAttribute( "waitPage" ) == null ) 
	       {  
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   PrintWriter out = res.getWriter();  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">");  
	    	   out.println( "</head><body bgcolor=''>" );  
	    	   out.println( "<br><br><br>" );
	    	   out.println( "<center><br><br>" );
	    	   out.println("<font color=white size=5>");
	    	   out.println( "File Has been Decrypted & Downloaded to your system successfully......<br>  " );
	    	   out.println( "Thank You....</h1></center"); 
	    	   out.println("</font>");
	    	   out.close();  
	       }  
	       else
	       {
	    	   session.removeAttribute( "waitPage" ); 
		try
		{
		String Des=req.getParameter("Des");
		File ofile1 = new File(Des);
		
		 ServletContext context = getServletContext();
		    String mimeType = context.getMimeType(Des);
		    if (mimeType == null) 
		    {
		    	//session.setAttribute( "waitPage", Boolean.FALSE );  
		    // set to binary type if MIME mapping not found
		    mimeType = "application/octet-stream";
		    }
		    System.out.println("MIME type: " + mimeType);
		 //   session.setAttribute( "waitPage", Boolean.FALSE );  											
		    // modifies response
		    res.setContentType(mimeType);
		    res.setContentLength((int) ofile1.length());

		    System.out.println("=======lenghthhhhh========="+(int) ofile1.length());
		    FileInputStream inStream = new FileInputStream(ofile1);												
		    // forces download
		    String headerKey = "Content-Disposition";
		    String headerValue = String.format("attachment; filename=\"%s\"", ofile1.getName());
		  
		    res.setHeader(headerKey, headerValue);
		    // obtains response's output stream
		    OutputStream outStream = res.getOutputStream();
		    												
		    byte[] buffer = new byte[100096];
		    int bytesRead1 = -1;
		    												
		    while ((bytesRead1 = inStream.read(buffer)) != -1) 
		    {
		    outStream.write(buffer, 0, bytesRead1);
		    }
		    inStream.close();
		    outStream.close();
	       }  
		catch (Exception e) {
			// TODO: handle exception
		}
	       }
	}
}
