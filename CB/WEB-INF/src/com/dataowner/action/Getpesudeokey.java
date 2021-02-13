/**
 @Author : Menaka s o
 Date : Sep 23, 2016
 File : Getpesudeokey.java
 Package : com.action.dataowner
*/
package com.dataowner.action;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;
import com.dao.CommonDAO;
import com.util.*;
public class Getpesudeokey extends HttpServlet
{
	// Send Mail Paarameters Starts 
	//private static String toEmailId="testmycvsprojects@gmail.com";
	//private static String toEmailId="";
	//private static String toMobileNo="";
	//private static  String subject="";
	//private static  String message="";
	//private static  String attachedFilePath="";
	//private static  String fromEmailId="dhsinfoblr1@gmail.com";
	//private static  String password="dhsinfoblr2014";
	//private static  String hostname="smtp.gmail.com";
	//private static  String portnumber="465";
	// Send Mail Paarameters Ends
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		int no=0,UserId = 0,no1Value=0;
		int deptCode1 = 0;
		int designCode1 = 0;
		int userId = 0;
		String userEmail = "";
		boolean flag = false;
		RequestDispatcher rd = null;
		HttpSession session = null;
		ResultSet rs = null;
		String secreteKeyInfo = "";
		//AdminDAO adminDAO = AdminDAO.getInstance();
		//String privateKeyFilePath = req.getRealPath("")+"\\Files\\Keys\\privateKey.txt";
		
		//String srcFilePath = "";
		//String destFilePath ="";
		
		try
		{
			no = Utility.parse(req.getParameter("user_id"));
			if(no == 0)
			{
				UserId = AdminDAO.getUserID();
				
				System.out.println("<<<<<???????????>>>>>>>>"+UserId);
				no1Value=1;
			}
			else
			{
				UserId = no;
				no1Value=2;
			}
			
			rs = AdminDAO.getSpecificUserDetails(UserId);
			while(rs.next())
			{
				userId = rs.getInt(1);
				deptCode1 = rs.getInt(5);
				//deptCode2 = rs.getInt(6);
				designCode1 = rs.getInt(6);
				//designCode2 = rs.getInt(8);
				userEmail = rs.getString(13);
				//toMobileNo=rs.getString(11);
			}
			
			secreteKeyInfo = userId+"-"+deptCode1+"-"+designCode1;
			
			String name1=req.getParameter("name1");
			System.out.println("username.."+name1);
			String key1=CommonDAO.getkey1(name1);
			System.out.println(""+key1);
        	String key2=CommonDAO.getkey2(name1);
        	System.out.println(""+key2);
			
			//secreteKeyInfo = userId+","+deptCode+","+designCode;
			System.out.println("Secrete Key Info : " + secreteKeyInfo);
			
			String pseoudkey=key1+"-"+key2;
			
			//Object pseoudkey=SerializeToDatabase.getPublicKey();
			
			
			
			System.out.println("<<<<<<<<<Pseoudkey>>>>>>"+pseoudkey);
			
			String str="";
			str=Hashing.md5(secreteKeyInfo+"_"+pseoudkey);
			
			System.out.println("/////////strpseoudkeyMd5/////////////"+str);
			
			
			
			
				
			
			
			boolean flag1=false;
			flag1=AdminDAO.inserthascode(userId,str);
			
			//file write
			//Thread.sleep(1000);
			FileOutputStream fos=null;
			File file=new File(req.getRealPath("")+"\\temp\\"+userId+"_psuynom.txt");
			
			 fos = new FileOutputStream(file);
			 
			 if (!file.exists()) {
			     file.createNewFile();
			  }
			 
			 byte[] bytesArray = str.getBytes();

			  fos.write(bytesArray);
			  fos.flush();
			  System.out.println("File Written Successfully");

			/*FileOutputStream  f=new FileOutputStream(new File(req.getRealPath("")+"\\temp\\"+userId+"_psuynom.txt"));
			
			
			 ObjectOutputStream oos = new ObjectOutputStream(f);
			 byte b[]=str.getBytes();
			 oos.write(b);
		     oos.writeObject(str.trim());
		     oos.flush();
		     oos.close();
		     */
/*		     if ( session.getAttribute( "waitPage" ) == null ) 
		       {  
		    	   System.out.println("<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		    	   session.setAttribute( "waitPage", Boolean.TRUE );  
		    	   
		    	   out.println( "<html><head>" );  
		    	   out.println( "<title>Please Wait...</title>" );  
		       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
		    	   out.println( "</head><body bgcolor=''>" );  
		    	   out.println( "<br>" );
		    	   out.println( "<center>" );
		    	   out.print("<font color='red'>");
		    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
		    	   out.println("</font>");
		    	   out.print("<font color='green'>");
		    	   out.println( "Please,Wait..........<br>  " );
		    	   out.println( "Download Athentication In Process..." );
		    	   out.println( "<br>" );
		    	   out.println("</font>");
		    	   out.println( "<br>" );
		    	  
		    	   out.print("<font color='geen'>");
		    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
		    	   out.println( "<br>" );
		    	   out.println( "Downloading is in process..." );
		    	   out.println( "<br>" );
		    	   
		    	   
		    	   
		    	   out.println("</font>");
		    	   
		    	 
		    	   out.println( "<br>" );
		    	  
		    	   out.println( "Please wait....</h1></center");  
		    	 
		    	   out.println( "</head>");
		    	   out.println( "</html>");
		    	   out.close();
		    	   
		       }  
		       else 
		       { 
			    	
		    	   System.out.println("[[[[[[[[[[[[[]]]]]]]]]");
					
		    	   try
					{
					
						session.removeAttribute( "waitPage" ); */
		     
						resp.setContentType("APPLICATION/OCTET-STREAM");   
		     
						resp.setHeader("Content-Disposition","attachment; filename=\"" +userId+"_psuynom.txt"+"\"");
		     
						FileInputStream fileInputStream1= new FileInputStream(req.getRealPath("")+"\\temp\\"+userId+"_psuynom.txt");
		          
						int i;   
		
						while ((i=fileInputStream1.read()) != -1)
						{ 
			
							out.write(i);  
		 
						}   
						fileInputStream1.close();   
		
		
		
		     
					}  
		    	   
		     
		     
		    	   catch(Exception e)
					{
						System.out.println(e);
						e.printStackTrace();
					}
		    	   
		       }
		
		   
	
	}
		     
		

		
	
