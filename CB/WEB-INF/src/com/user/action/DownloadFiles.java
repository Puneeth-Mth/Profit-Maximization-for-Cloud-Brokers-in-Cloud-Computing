/**
 @Author : Munna Kumar Singh
 Date : Aug 25, 2012
 File : DownloadFiles.java
 Package : com.action.admin
*/
package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;
import com.dao.UserDAO;



public class DownloadFiles extends HttpServlet 
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		PrintWriter out=resp.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		
		
		
		String username = "";
		int userid = 0;
		HttpSession session = null;
	
		session = req.getSession();

	    if(session != null)
	    {
	    	username = session.getAttribute("username").toString();
	    }
		
	    userid = UserDAO.getID(username);
		
		try 
		{
			rs = AdminDAO.getUploadFiles();
			
			if(rs != null)
			{
				req.setAttribute("rs", rs);
				rd=req.getRequestDispatcher("/res/jsp/user/download_file.jsp?no=0");
				rd.forward(req, resp);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Opps,Error in DownloadFiles Servlet : ");
			e.printStackTrace();
		}
		
		
		
	}
}
