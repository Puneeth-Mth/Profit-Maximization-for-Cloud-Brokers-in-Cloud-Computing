/**
 @Author : Munna Kumar Singh
 Date : Sep 5, 2012
 File : ControlFileAcess.java
 Package : com.action.admin
*/
package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;


public class ControlFileAcess extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		int fileCode = 0;
		int deptCode = 0;
		int designCode = 0;
		boolean flag = false;
		RequestDispatcher rd = null;
		
		
		
		fileCode = Integer.parseInt(req.getParameter("file").toString());
		deptCode = Integer.parseInt(req.getParameter("dept").toString());
		designCode = Integer.parseInt(req.getParameter("designation").toString());
		
		try 
		{
			flag = AdminDAO.addAcessControl(fileCode, deptCode, designCode);
			if(flag)
			{
				System.out.println("Acess Control Details Inserted Sucessfully...");
				rd = req.getRequestDispatcher("/res/jsp/admin/access_control.jsp?no=1");
				rd.forward(req, resp);
			}
			else
			{
				rd = req.getRequestDispatcher("/res/jsp/admin/access_control.jsp?no=2");
				rd.forward(req, resp);
			}
		}
		catch (Exception e)
		{
			System.out.println("Opps,Exception In ControlFileAcess Servlet :");
			e.printStackTrace();
		}
		
	}
}