package com.user.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;
import com.dao.UserDAO;

public class Singup extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
		{
	String uname=req.getParameter("userid");
	String upass=req.getParameter("password");
	String rpassword=req.getParameter("rpassword");
	String username=req.getParameter("username");
	String addr=req.getParameter("addr");
	String pno=req.getParameter("pno");
	String email=req.getParameter("email");
	if(upass.equals(rpassword))
	{
		
		boolean flag1=AdminDAO.checkOwner(username, upass);
		if(flag1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/index1.jsp?no=3");
			rd.forward(req, resp);
			
		}else
		{
			boolean flag=UserDAO.ownerRegister(username, upass, uname, addr, email, pno);
			if(flag)
			{
				RequestDispatcher rd=req.getRequestDispatcher("/index1.jsp?no=2");
				rd.forward(req, resp);
			}else
			{
				RequestDispatcher rd=req.getRequestDispatcher("/signup.jsp?no=2");
				rd.forward(req, resp);
				
			}	
		}
		
		
		
	}else
	{
		RequestDispatcher rd=req.getRequestDispatcher("/signup.jsp?no=1");
		rd.forward(req, resp);
		
	}
	
}
}
