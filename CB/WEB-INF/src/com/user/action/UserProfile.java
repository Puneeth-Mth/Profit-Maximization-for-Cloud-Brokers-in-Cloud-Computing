/**
 * 
 */
package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;

/**
 * @author Munna Kumar Singh
 *Apr 9, 2012 3:20:41 PM
 *Project:-Cloud_Computing(RC4)
 *Package:-com.nitin.action.User
 *File:-Profile.java
 */
public class UserProfile extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		String username = "";
		HttpSession session = null;
		try
		{
			session = request.getSession();

		    if(session != null)
		    {
		    	username = session.getAttribute("username").toString();
		    	
		    }
			
		   
			rs = UserDAO.getProfile(username);
			if(rs.next())
			{   
				rs = UserDAO.getProfile(username);
				request.setAttribute("rs",rs);
				RequestDispatcher rd=request.getRequestDispatcher("/res/jsp/user/profile.jsp?no=0");
				rd.forward(request, response);
			}
			else
				response.sendRedirect(request.getContextPath()+"/res/jsp/user/profile.jsp?no=1");
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in UserProfile Servlet :");
			e.printStackTrace();
			out.println("Opps's Error is in UserProfile Servlet......"+e);
		}
	}
}
