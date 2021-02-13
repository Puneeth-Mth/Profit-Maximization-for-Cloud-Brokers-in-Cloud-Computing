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
public class RechargeList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		
		try
		{
			String submit=request.getParameter("submit").trim();
			
			
			rs = AdminDAO.getrechargeDetails();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/jsp/admin/recharge.jsp?no=1");
				rd.forward(request, response);
			}
			if(submit.equals("Add"))
			{
				if(Utility.parse1(request.getParameter("add1")).equals("YES"))
				{
					String code = request.getParameter("code");
					String cost = request.getParameter("cost");
					
					boolean result=AdminDAO.checkVouchercode(code);
					if(!result)
					{
						result = AdminDAO.addRechargeDetails(code,cost) ;
						if(result)
						{
							rs = AdminDAO.getrechargeDetails();
							request.setAttribute("rs", rs);
							rd=request.getRequestDispatcher("/res/jsp/admin/recharge.jsp?no=1&no1=1");
							rd.forward(request, response);
						}
						else
						{
							rd=request.getRequestDispatcher("/res/jsp/admin/recharge.jsp?no=2&no1=2");
							rd.forward(request, response);
						}
							
					}
					else
					{
						rd=request.getRequestDispatcher("/res/jsp/admin/recharge.jsp?no=2&no1=1");
						rd.forward(request, response);
					}
				}
				else
				{
					rd=request.getRequestDispatcher("/res/jsp/admin/recharge.jsp?no=2");
					rd.forward(request, response);
				}
			}
			
			
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs = AdminDAO.getrechargeDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/recharge.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						AdminDAO.deleterechargeDetails(Integer.parseInt(chk[i]));
					}
					rs = AdminDAO.getrechargeDetails();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/recharge.jsp?no=1&no1=5");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin rechargeList Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin rechargeList Servlet......"+e);
		}
	}
}
