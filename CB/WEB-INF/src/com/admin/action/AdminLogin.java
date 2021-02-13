package com.admin.action;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;

public class AdminLogin extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
		{
	
	String uname=req.getParameter("username");
	String upass=req.getParameter("password");
	System.out.println("got Value :"+uname+" "+upass);
	HttpSession session = req.getSession(true);
	session.setAttribute("username",uname);
	
	
	boolean flag=AdminDAO.LoginCHCK(uname, upass);
	
	if(flag)
	{
		HttpSession hs=req.getSession();
		hs.setAttribute("admin", uname);
		RequestDispatcher rd=req.getRequestDispatcher("/res/jsp/admin/home.jsp");
		rd.forward(req, resp);
	}else
	{
		RequestDispatcher rd=req.getRequestDispatcher("/index.jsp?no=1");
		rd.forward(req, resp);
	}
}
}
