package com.user.action;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.sql.ResultSet;
import java.util.Random;

import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.util.DesFileEncrypter_Decrypter;
import com.util.RSA_File_EncryptionDecryption;
import com.util.SerializeToDatabase;

/**
 * @author Munna Kumar Singh
 *Dec 6, 2011 4:05:45 PM
 *Project:-DNA
 *Package:-com.nitin.action.user
 *File:-UploadFile.java
 */
public class ReadFile extends HttpServlet
{
	String ftpserver = "ftp.drivehq.com";
    String ftpusername = "menakaamu";
    String ftppassword = "iimca2012";
    String username = "";
    String dirToUploadFile="";
    ServletInputStream sis=null;
    
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	  {
		
		String path="";
		String fileName = "";
		String fName = "";
		String extension="";
		int fileId = 0;
		int ownerid=0;
		ResultSet rs = null;
		
		fileId = Integer.parseInt(request.getParameter("fileId").toString());
		ownerid=Integer.parseInt(request.getParameter("ownerid").toString());
		HttpSession hs = request.getSession(true);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache");
    
        String err = "";
        String lastFileName = "";
        
       String contentType = request.getContentType();
       String boundary = "";
       
       int BOUNDARY_WORD_SIZE = "boundary=".length();
       if ((contentType == null) || (!contentType.startsWith("multipart/form-data")))
       {
	         err = "Ilegal ENCTYPE : must be multipart/form-data\n";
	         err = err + "ENCTYPE set = " + contentType;
       }
       else
       {
          boundary = contentType.substring(contentType.indexOf("boundary=") + BOUNDARY_WORD_SIZE);
          boundary = "--" + boundary;
            
          try
          {
        	/* Enhancements(Starts) */
        	  DataInputStream in = new DataInputStream(request.getInputStream());
        	  int dataLength = request.getContentLength();
        	/* Enhancements(Ends) */
            sis = request.getInputStream();
            //byte[] b = new byte[2048];
            byte[] b = new byte[dataLength];
            int x = 0;
            int state = 0;
            String name = null; String contentType2 = null;
            FileOutputStream buffer = null;
            
            while ((x = sis.readLine(b, 0,dataLength)) > -1)
            {
	             String s = new String(b, 0, x);
	             if (s.startsWith(boundary))
	             {
		               state = 0;
		               name = null;
		               contentType2 = null;
		               fileName = null;
	             }
	             else if ((s.startsWith("Content-Disposition")) && (state == 0))
	             {
		               state = 1;
		                if (s.indexOf("filename=") == -1)
		                {
		                	name = s.substring(s.indexOf("name=") + "name=".length(), s.length() - 2);
		                }
		                else
		                {
		                	name = s.substring(s.indexOf("name=") + "name=".length(), s.lastIndexOf(";"));
		                	fileName = s.substring(s.indexOf("filename=") + "filename=".length(), s.length() - 2);
		                	if (fileName.equals("\"\""))
		                    {
		                		fileName = null;
		                    }
		                    else
		                    {
		                    	String userAgent = request.getHeader("User-Agent");
		                    	String userSeparator = "/";
		                    	if (userAgent.indexOf("Windows") != -1)
		                    	{
		                    		userSeparator = "\\";
		                    	}
		                    	if (userAgent.indexOf("Linux") != -1)
			                    {
		                    		userSeparator = "/";
			                    }
		                   
		                    	fileName = fileName.substring(fileName.lastIndexOf(userSeparator) + 1, fileName.length() - 1);
		                    	if (fileName.startsWith("\""))
			                    {
		                    		fileName = fileName.substring(1);
			                    }
		                    }
				                 
		                	name = name.substring(1, name.length() - 1);
				            if (!name.equals("file")&&!name.equals("file2"))
				                      continue;
				            if (buffer != null)
				            {
				                buffer.close();
				            }
			                lastFileName = fileName;
							fName=fileName;
							int dotPos = fName.lastIndexOf(".");
							extension = fName.substring(dotPos);
			                System.out.println("File Name : " + fileName);
			               path = request.getRealPath("") +"\\Files\\ReadKey\\" + fileName;
			               hs.setAttribute("fileName", fileName);
			               hs.setAttribute("filepath", path);
			               hs.setAttribute("filepathh", path);
			              
				           System.out.println("Path : " + path);
				           System.out.println("File Name : " + fileName);
				           buffer = new FileOutputStream(path);
		               }
	      
	            }
	            else if ((s.startsWith("Content-Type")) && (state == 1))
	            {
	            	state = 2;
	            	contentType2 = s.substring(s.indexOf(":") + 2, s.length() - 2);
	            }
	           else if ((s.equals("\r\n")) && (state != 3))
	           {
	        	   	state = 3;
	           }
	           else
	           {
		          if (!name.equals("file")&&!name.equals("file2"))
		                    continue;
		            buffer.write(b, 0, x);
	           }
	     }
      
       sis.close();
      buffer.close();
      }
      catch (IOException e)
      {
    	  err = e.toString();
      } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
    
     boolean ok = err.equals("");
     if (!ok)
     {
        out.println(err);
     }
  
     System.out.println("****** Done.......");
    
     /* Forwarding For Key Verification */
     //response.sendRedirect(request.getContextPath()+"/Download?fileid="+fileId+"");
     response.sendRedirect(request.getContextPath()+"/VerifyKey?fileid="+fileId+"&ownerid="+ownerid+"");
    
    
	}
					
}

