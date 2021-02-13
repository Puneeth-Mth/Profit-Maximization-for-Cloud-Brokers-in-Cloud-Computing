/**
 * 
 */
package com.dataowner.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.OwnerDAO;
public class CreditDetails extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		try
		{
			
			String u_user=request.getParameter("id");
			
			//int vouch=userProcess.getVocher(Invalid);
			int credit=OwnerDAO.getCredit(u_user);
			//ResultSet rs=userProcess.voucher();
			
			request.setAttribute("u_user",u_user);
			request.setAttribute("credit",credit);
			//request.setAttribute("code", rs);
			//request.setAttribute("code", rs);
			RequestDispatcher rd=request.getRequestDispatcher("/res/jsp/owner/creditdetails.jsp");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in CreditDetails Servlet...."+e);
			out.println("Opp's Error is in CreditDetails Servlet...."+e);
		}
	}
}
