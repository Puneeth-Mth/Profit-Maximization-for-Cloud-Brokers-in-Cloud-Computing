/**
 * 
 */
package com.admin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.RNS.Encryption_RNS;
import com.dao.AdminDAO;
import com.dao.CommonDAO;
import com.sun.org.apache.xml.internal.serializer.SerializerTrace;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.util.*;


/**
 * @author Munna Kumar Singh
 *Dec 6, 2011 4:28:43 PM
 *Project:-DNA
 *File:-FTPUpload.java
 */
public class LogicalblockAddress extends HttpServlet
{
	private static String username="";
	private static int userid=0;

	public static long endtime;
	public static double seconds;
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		   RequestDispatcher rd = null;
		   String uploadSubject = "";
		   int cloudId =0,ownerId=0;
		   int totalNumberOfClouds = 0;
		   File uploadedFile1=null;
		   String srcFilePath = "";
		   String destFilePath = "";
		   boolean flag = false;
			boolean flag_upload = false;
		   
		   ResultSet rs = null;
			Random random = new Random();
			int num, num1 = 0;
			 endtime=System.nanoTime();
			 long time=(LogicalblockAddress.endtime-UploadToCloud.startTime);
				double seconds = (double)time / 1000000000.0;
		   HttpSession session = req.getSession();  
		   String name1=	(String) session.getAttribute("username");
		   if(session != null)
			{
			  username = (String) session.getAttribute("username");
			  //uploadSubject = session.getAttribute("subject").toString();
			}
		   
		   
	       if ( session.getAttribute( "waitPage" ) == null ) 
	       {  
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   PrintWriter out = res.getWriter();  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );  
	    	   out.println( "<br><br><br>" );
	    	   out.print( "<center><img src='res/Images/giphy.gif'></img><br><br>");
	    	   
	    	   out.println("<font color='white' size='5'>");
	    	   out.println( "Block Uploading Completed .......<br>" );
	    	   out.println( "LBA Blocks .......<br>  "+Packet1.hash_blk_nos );
	    	   out.println("</font><br>");
	    	   out.println( "File Processing time ....... "+seconds );
	    	   out.println( "<br>Please Wait....</h1></center");  
	    	   out.close();  
	       }  
	       else 
	       { 
	    	    session.removeAttribute( "waitPage" );  
				try
				{
					PrintWriter out=res.getWriter();
					res.setContentType("text/html");
					// System.out.println("Packet1.hash_blk_nos:"+Packet1.hash_blk_nos);
					String root2=req.getParameter("root2");
					System.out.println("Source ::> "+root2);
					String fileName=req.getParameter("fileName");
					String dir=req.getParameter("dir");
					System.out.println("dir ::> "+dir);
					int id = Integer.parseInt(req.getParameter("id"));
					
						flag = Utility.writeOnFile(name1+ ".txt",
								"User has uploaded file (" + name1+"~"+fileName+ ") on date "+ Utility.getDate()+ " and time "+ Utility.getTime() + "",
								getServletContext().getRealPath("/"));
						rs = CommonDAO.getFiles((id), "uploaded");
						if (rs.next()) 
						{
							rs = CommonDAO.getFiles((id), "uploaded");
							req.setAttribute("rs", rs);
							Thread.sleep(1000);
							//long endTime = System.nanoTime();
							
							System.out.println("seconds>>>>"+seconds);
							//req.setAttribute("seconds", seconds);
							String s=String.valueOf(seconds);
							req.setAttribute("s", s);
							rd = req.getRequestDispatcher("/res/jsp/owner/files.jsp?no=2");
							/*&name="+name[0]
*/							rd.forward(req, res);

						
						
						}
					
					
					else
					{
						rd = req.getRequestDispatcher("/res/jsp/owner/files.jsp?no=5");
						rd.forward(req, res);
					}
					
				}
				catch(Exception e)
				{
					System.out.println("\n ******** Exception In FTPUpload Servlet : \n");
					e.printStackTrace();
				}
		
	}}
}
