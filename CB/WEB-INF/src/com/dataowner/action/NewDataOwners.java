package com.dataowner.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;
import com.util.Utility;

public class NewDataOwners extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		HttpSession session = null;
		
		try
		{
			String submit=request.getParameter("submit").trim();
			
			
			rs = AdminDAO.getNewDataOwners();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/jsp/owner/newowners.jsp?no=1");
				rd.forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Data Owner==>ListDataOwners Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Data Owner==>ListDataOwners Servlet......"+e);
		}
	}
}
