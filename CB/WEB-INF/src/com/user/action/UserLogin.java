package com.user.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dao.UserDAO;

public class UserLogin extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException 
		{
	
	
	String uname=req.getParameter("username");
	String upass=req.getParameter("password");
	//System.out.println("got Value :"+uname+" "+upass);
	HttpSession session=req.getSession();
	
	
	boolean flag=UserDAO.LoginCHCK(uname, upass);
	
	if(flag)
	{
		
		int uid = UserDAO.getID(uname);
		HttpSession hs=req.getSession();
		hs.setAttribute("username", uname);
		hs.setAttribute("userid",uid);
		
		System.out.println("******** User Login Info ********");
		System.out.println("  Userid : " + uid);
		System.out.println("Username : " + uname);
		System.out.println("Password : " + upass);
		session.setAttribute("uid", uname);
		RequestDispatcher rd=req.getRequestDispatcher("/res/jsp/user/home.jsp");
		rd.forward(req, resp);
	}else
	{
		RequestDispatcher rd=req.getRequestDispatcher("/index1.jsp?no=1");
		rd.forward(req, resp);
	}
}
}
