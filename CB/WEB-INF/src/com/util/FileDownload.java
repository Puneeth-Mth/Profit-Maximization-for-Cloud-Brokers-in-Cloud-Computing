/**
 * 
 */
package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.crypto.SecretKey;



/**
 * @author Munna Kumar Singh
 *Nov 11, 2011 5:06:42 PM
 *Project:-WebSer
 *Package:-com.resource.util
 *File:-FileDownload.java
 */
public class FileDownload 
{
	public static boolean download( String ftpServer, String ftpuser, String ftppassword,String fileName,String dest) throws MalformedURLException,
	         IOException
	   {
		   boolean flag=false;
	      if (ftpServer != null && fileName != null )
	      {
	         StringBuffer sb = new StringBuffer( "ftp://" );
	         // check for authentication else assume its anonymous access.
	         if (ftpuser != null && ftppassword != null)
	         {
	            sb.append( ftpuser );
	            sb.append( ':' );
	            sb.append( ftppassword );
	            sb.append( '@' );
	         }
	         sb.append( ftpServer );
	         sb.append( '/' );
	         String a="cloud1/";
	         sb.append( a );
	         sb.append( '/' );
	         sb.append( fileName );
	         
	         /*
	          * type ==> a=ASCII mode, i=image (binary) mode, d= file directory
	          * listing
	          */
	         sb.append( ";type=i" );
	         BufferedInputStream bis = null;
	         BufferedOutputStream bos = null;
	         try
	         {
	            URL url = new URL( sb.toString() );
	            URLConnection urlc = url.openConnection();
	            /* Download Location */
	            
	            
	            String dir =dest;
	            File f = new File(dir);
	             
	            if(!f.exists())
	            {
	            	f.mkdir();
	            }
	            bis = new BufferedInputStream( urlc.getInputStream());
	            bos = new BufferedOutputStream( new FileOutputStream(f+"\\"+fileName) );
	            System.out.println("File Dounloaded Sucessfully..");
	            
	            System.out.println("Url : " + url);

	           int i;
	            while ((i = bis.read()) != -1)
	            {
	               bos.write( i );
	               flag=true;
	            }
	          }
	         catch (Exception e)
	         {
				System.out.println("Opps,Exception in FileDownload Servlet :");
				e.printStackTrace();
			 }
	         finally
	         {
	            if (bis != null)
	               try
	               {
	                  bis.close();
	               }
	               catch (IOException ioe)
	               {
	                  ioe.printStackTrace();
	               }
	            if (bos != null)
	               try
	               {
	                  bos.close();
	               }
	               catch (IOException ioe)
	               {
	                  ioe.printStackTrace();
	               }
	         }
	      }
	      else
	      {
	         System.out.println( "Input not available" );
	      }
	      return flag;
	   }
}
