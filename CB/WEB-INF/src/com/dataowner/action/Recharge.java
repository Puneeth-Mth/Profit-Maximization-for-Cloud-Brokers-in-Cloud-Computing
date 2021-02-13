package com.dataowner.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OwnerDAO;

public class Recharge extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			String u_user=request.getParameter("u_user");
			int credit=Integer.parseInt(request.getParameter("credit"));
			String code=request.getParameter("code");
			request.setAttribute("u_user",u_user);
			request.setAttribute("credit",credit);
			
			boolean result=OwnerDAO.checkVoucher(code);
		   
			//ResultSet rs=userProcess.getvoucher(code1);
			//result=userProcess.getvoucher(code1);
			
			RequestDispatcher rd=null;
			if(result)
			{
				result=OwnerDAO.checkVoucherStatus(code);
				if(result)
				{
					rd=request.getRequestDispatcher("/res/jsp/owner/creditdetails.jsp?no=1");
					rd.forward(request, response);
				}
				else
				{
					int creditx = OwnerDAO.getCredit(code,"");
					credit=credit+creditx;
					result=OwnerDAO.addCredit(u_user, credit ,code);
					if(result)
					{
						request.setAttribute("credit",credit);
						rd=request.getRequestDispatcher("/res/jsp/owner/creditdetails.jsp?no=3");
						rd.forward(request, response);
					}
					else
					{
						rd=request.getRequestDispatcher("/res/jsp/owner/creditdetails.jsp?no=4");
						rd.forward(request, response);
					}
				}
			}
			else
			{
				rd=request.getRequestDispatcher("/res/jsp/owner/creditdetails.jsp?no=2");
				rd.forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in Recharge Servlet...."+e);
			out.println("Opp's Error is in Recharge Servlet...."+e);
		}

	}

}
