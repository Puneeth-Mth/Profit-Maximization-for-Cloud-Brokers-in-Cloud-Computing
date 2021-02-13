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

import com.dao.OwnerDAO;
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
public class FileBlockCreation extends HttpServlet
{
	private static String username="";
	private static int userid=0;

	
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
	    	   out.println( "File hashcode Generation Completed.......<br>  " );
	    	   out.println( "Logical Block Addressing...... <br> " );
	    	   out.println("<font color='white' size='5'>");
	    	   out.println( "Blocks uploading started ......  " );
	    	   out.println("</font><br>");
	    	   out.println( "Please Wait....</h1></center");  
	    	   out.close();  
	       }  
	       else 
	       { 
	    	    session.removeAttribute( "waitPage" );  
				try
				{
					PrintWriter out=res.getWriter();
					res.setContentType("text/html");
					
					String root2=req.getParameter("root2");
					System.out.println("Source ::> "+root2);
					String fileName=req.getParameter("fileName");
					String dir=req.getParameter("dir");
					System.out.println("dir ::> "+dir);
					//long startTime = Long.parseLong(req.getParameter("startTime"));
					num = (random.nextInt((2 - 1) + 1)) + 1;
					int id = Integer.parseInt(req.getParameter("id"));
					String hash_blk_nos=CommonDAO.gethashblocknos(fileName,name1);
					System.out.println("hash_blk_nos number is >>>>>>>>>>>>>>>>>>>>>>"+hash_blk_nos);	
					
					 for (String retval: hash_blk_nos.split("-"))
					 {
				          int k=Integer.parseInt(retval);
						 System.out.println("=======RETURN VALUE AFTER SPLITTING======"+retval);
				         String blk_name=CommonDAO.gethashblockname(k);
				         if (blk_name==null)
				         {
				        	continue; 
				         }
				         else
				         {
				        	 ResultSet rs1=OwnerDAO.getClouds();
						        int s_id=OwnerDAO.getcloudId();
						         uploadedFile1 = new File(root2 +"/"+blk_name);
						         long fileSize=uploadedFile1.length();
						         Double size=(double)fileSize/1024;
						         int credit=OwnerDAO.getCredit(id);
						         double cost=0;
						         while(rs1.next())
						         {
						        	 cost+=size*rs1.getInt(4);
						         }
						         flag_upload=Utility.uploadFile(OwnerDAO.getIP(s_id),OwnerDAO.getUser(s_id), OwnerDAO.getPass(s_id),blk_name,uploadedFile1, "cloud1"); 
						       // System.out.println("flag_upload"+flag_upload);
				         if(flag_upload)
				         {
				        	 credit=(int) (credit-cost);
				        	 OwnerDAO.updateSConfig(s_id, size);
				        	 OwnerDAO.updateCredit(id, credit);
				        	int m= CommonDAO.m_upload_status(blk_name);
				        	System.out.println("=======Uploaded Status in m_hash_code======="+m);
				         }
				       }
					      
					 }
					 
					 Thread.sleep(1000);
					 res.sendRedirect(req.getContextPath()+"/LogicalblockAddress?id="+id);
					
					
					
				}
				catch(Exception e)
				{
					System.out.println("\n ******** Exception In FTPUpload Servlet : \n");
					e.printStackTrace();
				}
		
	}}
}
