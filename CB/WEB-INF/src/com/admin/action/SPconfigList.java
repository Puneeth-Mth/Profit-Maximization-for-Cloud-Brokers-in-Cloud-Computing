package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;
import com.util.Utility;

public class SPconfigList extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		try
		{
			String submit=request.getParameter("submit").trim();
			rs = AdminDAO.getConfigDetails();
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/jsp/admin/Config.jsp?no=1");
				rd.forward(request, response);
			}

			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("edit1")).equals("YES"))
				{
					String s[]=new String[6];
					s[0]=request.getParameter("s_code");
					s[1]=request.getParameter("s_size");
					s[2]=request.getParameter("s_cost");
					s[3]=request.getParameter("s_qty");
					s[4]=request.getParameter("status");
					
					AdminDAO.editConfigDetails(s);
					rs = AdminDAO.getConfigDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/Config.jsp?no=1&no1=2");
					rd.forward(request, response);
				}
				else if(chk==null)
				{
					rs = AdminDAO.getConfigDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/Config.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else if(chk.length!=1)
				{
					rs = AdminDAO.getConfigDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/Config.jsp?no=1&no1=4");
					rd.forward(request, response);
				}
				else if(chk.length==1)
				{
					rs = AdminDAO.getConfigDetails(Integer.parseInt(chk[0]));
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/Config.jsp?no=3");
					rd.forward(request, response);
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
