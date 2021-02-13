
package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dao.CommonDAO;
import com.util.Utility;

public class UploadFile extends HttpServlet 
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			
			HttpSession session = request.getSession(true);
			
		String ownername=	(String) session.getAttribute("username");
		
		System.out.println("ownername is >>>>>>>>>>>>>>>>>>>>>>>"+ownername);
			String submit=request.getParameter("submit");
			System.out.println("submit is >>>>>>>>>>>>>>>>>>>>>>>"+submit);
			boolean result=false;
			ResultSet rs=CommonDAO.getFiles(CommonDAO.getownerID(ownername),"uploaded");
			RequestDispatcher rd=null;
			if(submit.equals("get"))
			{
				
				System.out.println("its came indide if");
				if(rs.next())
				{
					System.out.println("its came indide if");
					rs=CommonDAO.getFiles(CommonDAO.getownerID(ownername),"uploaded");
					request.setAttribute("rs", rs);
					request.setAttribute("name", ownername);
					rd=request.getRequestDispatcher("/res/jsp/owner/files.jsp");
					rd.forward(request, response);
				}
				else
				{
					
					System.out.println("its came indide else");
					rd=request.getRequestDispatcher("/res/jsp/owner/files.jsp?no=-1");
					rd.forward(request, response);
				}
			}
			else if(submit.equals("Upload"))
			{
				
				System.out.println("its came inisde upload");
				rs=CommonDAO.getFiles(CommonDAO.getownerID(ownername),"uploaded");
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/jsp/owner/files.jsp?no=1");
				rd.forward(request, response);
			}
			else if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				request.setAttribute("name", ownername);
				if(chk==null)
				{
					rs=CommonDAO.getFiles(CommonDAO.getownerID(ownername),"uploaded");
				    request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/owner/files.jsp?no=3");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						
						String fname=CommonDAO.getFileName(chk[i]);
						String hashblocks=CommonDAO.gethashblknos(fname,ownername);
						
						
						
						
						 String[] temp;
						 
						  /* delimiter */
						  String delimiter = "-";
						  /* given string will be split by the argument delimiter provided. */
						  temp = hashblocks.split(delimiter);
						  /* print substrings */
						  System.out.println("======== "+hashblocks);
						  String blockname="";
						// String dest=request.getRealPath("") + "/MergedFile/"+fname;
						 // File fin = new File(Merged);
						  
						  System.out.println("-----Temp Size--"+temp.length);
						  for(int j =0; j < temp.length ; j++)
						  {
							  System.out.println("--===-======-= "+temp[j]);
							    //int id2=Integer.parseInt(temp[i]);
							    blockname=CommonDAO.getblocks(temp[j]); 
							    System.out.println("-----BLOCK NAME------"+blockname);
							    boolean flag=false;
							    flag=CommonDAO.getInstance(temp[j]);
							    if(flag==true)
							    {
							    	result=Utility.deleteFile(Utility.getPro("server"),Utility.getPro("user"),Utility.getPro("pass"), blockname);	
							    	 result=CommonDAO. Updatehashtable(temp[j]);
							    }
							  
						  }
						
						 result=CommonDAO.UpdateTrans(chk[i], "uploaded");
						 
						 boolean flagr=CommonDAO.m_file_uploaddelete(fname,ownername);
						Utility.writeOnFile(ownername+".txt", "User has deleted file ("+fname+") on date "+Utility.getDate()+" and time "+Utility.getTime()+"", getServletContext().getRealPath("/"));
					
					}
						rs=CommonDAO.getFiles(CommonDAO.getownerID(ownername),"uploaded");
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/jsp/owner/files.jsp?no=4");
						rd.forward(request,response);
					}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User UploadFile Servlet......"+e);
			out.println("Opps's Error is in User UploadFile Servlet......"+e);
			e.printStackTrace();
		}
	}
}
