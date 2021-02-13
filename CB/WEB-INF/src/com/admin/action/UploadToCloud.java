
package com.admin.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.RNS.ConversionProcess;
import com.RNS.Encryption_RNS;

import com.dao.CommonDAO;
import com.util.Utility;

@SuppressWarnings("serial")
public class UploadToCloud extends HttpServlet 
{
	public static long startTime;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException 
			{
		PrintWriter out = response.getWriter();
		try {
			startTime= System.nanoTime();
			File file = null;
			String	encryptpath="";
			String fileName = "", root = "", md = "", dir = "cloud1",root1 = "",root2="";
			String status; 
			String[] name = new String[2];
			int i = 0;
			File uploadedFile = null;
			File uploadedFile1=null;
			ResultSet rs = null;
			boolean flag = false;
			boolean flag_upload = false;
			RequestDispatcher rd = null;
			Random random = new Random();
			int num, num1 = 0;
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			HttpSession session = request.getSession(true);
			String returnPage="";
			String name1=	(String) session.getAttribute("username");
			
			System.out.println("value of name1 is  "+name1);
			//String grpname=CommonDAO.getGroupName(name1);
			
			if (isMultipart)
			{
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				try 
				{
					
					List items = upload.parseRequest(request);
					Iterator iterator = items.iterator();
					while (iterator.hasNext())
					{
						FileItem item = (FileItem) iterator.next();
						if (item.isFormField())
						{
							name[i] = item.getString();
							i++;
						} 
						else 
						{
							
							
							String key1=CommonDAO.getkey1(name1);
							System.out.println(""+key1);
	                    	String key2=CommonDAO.getkey2(name1);
	                    	System.out.println(""+key2);
							
	                    	String data=		request.getRealPath("");
							System.out.println("project path is >>>>>>>>>>>>>>>>>"+data);
							
							fileName = item.getName();
							System.out.println("filename iss" + fileName);
							
						    
						    
						    Calendar currentDate = Calendar.getInstance();
							SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
							SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
							String date = formatter.format(currentDate.getTime());
							String time = formatter1.format(currentDate.getTime());
							
							date = date + "  " + time;
							root = getServletContext().getRealPath("/CLOUD_PROJECT");
							root1 = getServletContext().getRealPath("/OUT");
							root2 = getServletContext().getRealPath("/OUT2");
							
							num1 = random.nextInt(12345) + 1;
							uploadedFile = new File(root +"/"+fileName);
							
							System.out.println("Directory name iss" + uploadedFile);
							
								
							item.write(uploadedFile);
							
							
							
							int id=	CommonDAO.getownerID(name1);
					
					
					
							
							encryptpath=data+"/CLOUD_PROJECT/encryption/"+fileName;
						      file=new File(encryptpath);
						
	                    	byte[] odata_by = ConversionProcess.toByteArray(new File(root+"/"+fileName));
	                    	
	                    	String enc_Data = Encryption_RNS.encryptMessage1(odata_by, key1, key2,encryptpath);
	                    	
	                    	System.out.println("enc_Data data is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+enc_Data);
	                    	
	                    	
							String fileupload=String.valueOf(uploadedFile.length());
							
							System.out.println("FileUpload Length");
	              
	                    	response.sendRedirect(request.getContextPath()+"/FileUpload?root2="+root2+"&fileName="+fileName+"&dir="+dir+"&root1="+root1+"&fileupload="+fileupload+"&file="+file);
	                 
						}
					}
					//String maindirectory=dir+"/"+grpname;
					/*int id = CommonDAO.getownerID(name1);
			
					boolean flag_packet=Packet1.formPacket(id,file,root1,root2,dir,String.valueOf(uploadedFile.length()));
					
					
					System.out.println("UserId :"+id);
					num = (random.nextInt((2 - 1) + 1)) + 1;
					
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
				         uploadedFile1 = new File(root2 +"/"+blk_name);
				         flag_upload=Utility.uploadFile(Utility.getPro("server"), Utility.getPro("user"), Utility.getPro("pass"),blk_name,uploadedFile1, dir); 
				        // System.out.println("flag_upload"+flag_upload);
				         if(flag_upload)
				         {
				        	int m= CommonDAO.m_upload_status(blk_name);
				        	//System.out.println("=======Uploaded Status in m_hash_code======="+m);
				         }
				       }
					      
					 }
					 
					
					
						//CommonDAO.makeTrans(id,fileName, "uploaded");
						flag = Utility.writeOnFile(name1+ ".txt",
								"User has uploaded file (" + name1+"~"+fileName+ ") on date "+ Utility.getDate()+ " and time "+ Utility.getTime() + "",
								getServletContext().getRealPath("/"));
						rs = CommonDAO.getFiles((id), "uploaded");
						if (rs.next()) 
						{
							rs = CommonDAO.getFiles((id), "uploaded");
							request.setAttribute("rs", rs);
							rd = request.getRequestDispatcher("/res/jsp/owner/files.jsp?no=2");
							&name="+name[0]
						rd.forward(request, response);

						
						
					}
					
					
					else
					{
						rd = request.getRequestDispatcher("/res/jsp/owner/files.jsp?no=5");
						rd.forward(request, response);
					}*/
					//boolean b = uploadedFile.delete();
				}
			
                  catch (Exception e1)
                  {
					System.out.println("Opps's Error is in User UploadToCloud isMultipart Servlet......"
									+ e1);
					out.println("Opps's Error is in User UploadToCloud Servlet isMultipart......"
							+ e1);
					e1.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out
					.println("Opps's Error is in User UploadToCloud Servlet......"
							+ e);
			out.println("Opps's Error is in User UploadToCloud Servlet......"
					+ e);
			e.printStackTrace();
		}
	}
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		      doPost(request, response);
		   }
	
}
