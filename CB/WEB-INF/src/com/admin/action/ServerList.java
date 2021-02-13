/**
 * 
 */
package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.AdminDAO;
import com.util.Utility;

/**
 * @author Munna Kumar Singh
 *Apr 10, 2012 3:33:14 PM
 *Project:-Cloud_Computing(RC4)
 *Package:-com.nitin.action.admin
 *File:-UserList.java
 */
public class ServerList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		
		try
		{
			String submit=request.getParameter("submit").trim();
			
			
			rs = AdminDAO.getServerDetails();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=1");
				rd.forward(request, response);
			}
			if(submit.equals("Add"))
			{
				if(Utility.parse1(request.getParameter("add1")).equals("YES"))
				{
					String hostName = request.getParameter("host");
					String username = request.getParameter("username");
					String password= request.getParameter("password");
					String status = request.getParameter("status");
					String remarks = request.getParameter("remarks");
					
					boolean result=AdminDAO.checkServerHostExistence(hostName);
					if(!result)
					{
						result = AdminDAO.addServerDetails(hostName,username,password,status,remarks) ;
						if(result)
						{
							rs = AdminDAO.getServerDetails();
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=1&no1=1");
							rd.forward(request, response);
						}
						else
						{
							rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=2&no1=2");
							rd.forward(request, response);
						}
							
					}
					else
					{
						rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=2&no1=1");
						rd.forward(request, response);
					}
				}
				else
				{
					rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=2");
					rd.forward(request, response);
				}
			}
			
			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("edit1")).equals("YES"))
				{
					String s[]=new String[6];
					s[0]=request.getParameter("id");
					s[1]=request.getParameter("host");
					s[2]=request.getParameter("username");
					s[3]=request.getParameter("password");
					s[4]=request.getParameter("status");
					s[5]=request.getParameter("remarks");;
					AdminDAO.editServerDetails(s);
					rs = AdminDAO.getServerDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=1&no1=2");
					rd.forward(request, response);
				}
				else if(chk==null)
				{
					rs = AdminDAO.getServerDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else if(chk.length!=1)
				{
					rs = AdminDAO.getServerDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=1&no1=4");
					rd.forward(request, response);
				}
				else if(chk.length==1)
				{
					rs = AdminDAO.getServerSpecificDetails(Integer.parseInt(chk[0]));
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=3");
					rd.forward(request, response);
				}
			}
			
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs = AdminDAO.getServerDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						AdminDAO.deleteServerDetails(Integer.parseInt(chk[i]));
					}
					rs = AdminDAO.getServerDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/servers.jsp?no=1&no1=5");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin ServerList Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin ServerList Servlet......"+e);
		}
	}
}
