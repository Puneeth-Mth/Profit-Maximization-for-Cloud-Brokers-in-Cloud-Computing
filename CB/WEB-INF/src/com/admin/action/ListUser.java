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
import javax.servlet.http.HttpSession;


import com.dao.AdminDAO;
import com.util.Utility;

/**
 * @author Munna Kumar Singh
 
 */
public class ListUser extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out=response.getWriter();
		ResultSet rs = null;
		RequestDispatcher rd=null;
		HttpSession session = null;
		boolean result = false;
		
		try
		{
			session=request.getSession(true);
			String submit=request.getParameter("submit").trim();
			String name1=(String)session.getAttribute("username");
			System.out.println("name1.."+name1);
			
			rs = AdminDAO.getUsers();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=1");
				rd.forward(request, response);
			}
			if(submit.equals("Add"))
			{
				if(Utility.parse1(request.getParameter("add1")).equals("YES"))
				{
					String username = request.getParameter("username");
					String password= request.getParameter("password");
					String name = request.getParameter("name");
					String email = request.getParameter("email");
					String dept1 = request.getParameter("dept");
					//String dept2 = request.getParameter("dept1");
					String designation1 = request.getParameter("designation");
					//String designation2 = request.getParameter("designation1");
					String address = request.getParameter("address");
					String city = request.getParameter("city");
					String phone = request.getParameter("phone");
					String mobile = request.getParameter("mobile");
					
					result=AdminDAO.checkUserExistence(username);
					if(!result)
					{
						session = request.getSession();
						
						 if( session.getAttribute( "waitPage" ) == null ) 
					     {  
					    	   session.setAttribute( "waitPage", Boolean.TRUE );  
					    	   out.println( "<html><head>" );  
					    	   out.println( "<title>Please Wait...</title>" );  
					       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
					    	   out.println( "</head><body bgcolor=''>" );
					    	   out.println("<center>");
					    	   out.println("<font color='green' size='5'>");
					    	   out.println( "Wait Please...,Key Generation In Process... " );
					    	   out.println( "<br><br>" );
					    	   out.print( "<img src='Resources/Images/status_processing.gif'></img><br><br>");
					    	   out.println("<font color='red' size='5'>");
					    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
					    	   out.println("</font><br>");
					    	   out.println("<font color='green' size='5'>");
					    	   out.println( "Sending mail.......  " );
					    	   out.println("</font><br>");
					    	   out.println( "Please wait....</h1>");  
					    	   out.println("</center>");
					    	   out.close();  
					     }
						 else
						 {
							 session.removeAttribute( "waitPage" ); 
							 result = AdminDAO.addUserDetails(username,password,name,email,Integer.parseInt(dept1),Integer.parseInt(designation1),address,city,phone,mobile);
							 if(result)
							 {
								 rd=request.getRequestDispatcher("/DistributeKey");
								 rd.forward(request, response);
							 }
							else
							{
								rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=2&no1=2");
								rd.forward(request, response);
							}
							 
						 }
						
					}
					else
					{
						rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=2&no1=1");
						rd.forward(request, response);
					}
				}
				else
				{
					rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=2");
					rd.forward(request, response);
				}
			}
			
			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("edit1")).equals("YES"))
				{
					String s[]=new String[13];
					s[0]=request.getParameter("id");
					s[1]=request.getParameter("username");
					s[2]=request.getParameter("password");
					s[3]=request.getParameter("name");
					s[4]=request.getParameter("dept");
					//s[5]=request.getParameter("dept1");
					s[5]=request.getParameter("designation");
					//s[7]=request.getParameter("designation1");
					s[6]=request.getParameter("address");
					s[7]=request.getParameter("city");
					s[8]=request.getParameter("phone");
					s[9]=request.getParameter("mobile");
					s[10]=request.getParameter("email");
					
					
					 session = request.getSession();
					
					 if( session.getAttribute( "waitPage" ) == null ) 
				     {  
				    	   session.setAttribute( "waitPage", Boolean.TRUE );  
				    	   out.println( "<html><head>" );  
				    	   out.println( "<title>Please Wait...</title>" );  
				       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
				    	   out.println( "</head><body bgcolor=''>" );
				    	   out.println("<center>");
				    	   out.println("<font color='green' size='5'>");
				    	   out.println( "Wait Please...,Key Generation In Process... " );
				    	   out.println( "<br><br>" );
				    	   out.print( "<img src='res/Images/status_processing.gif'></img><br><br>");
				    	   out.println("<font color='red' size='5'>");
				    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
				    	   out.println("</font><br>");
				    	   out.println("<font color='green' size='5'>");
				    	   out.println( "Sending mail.......  " );
				    	   out.println("</font><br>");
				    	   out.println( "Please wait....</h1>");  
				    	   out.println("</center>");
				    	   out.close();  
				     }
					 else
					 {
						 session.removeAttribute( "waitPage" ); 
						 result = AdminDAO.editUserDetails(s);
						 if(result)
						 {
							 String userId = s[0];
							 rd=request.getRequestDispatcher("/DistributeKey?user_id="+userId);
							 rd.forward(request, response);
						 }
						else
						{
							rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=2&no1=2");
							rd.forward(request, response);
						}
						 
					 }
					
					
				}
				else if(chk==null)
				{
					rs = AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else if(chk.length!=1)
				{
					rs = AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=1&no1=4");
					rd.forward(request, response);
				}
				else if(chk.length==1)
				{
					rs = AdminDAO.getSpecificUserDetails(Integer.parseInt(chk[0]));
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=3");
					rd.forward(request, response);
				}
			}
			
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs = AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=1&no1=3");
					rd.forward(request, response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						AdminDAO.deleteUserDetails(Integer.parseInt(chk[i]));
					}
					rs = AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=1&no1=5");
					rd.forward(request, response);
				}
			}
			if(submit.equals("LightWeight_Key"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs = AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/jsp/admin/users.jsp?no=1&no1=3");
					rd.forward(request, response);
					
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						 System.out.println("-----------------"+chk[0]);
						String userid=chk[0];
						System.out.println("userid.."+userid);
						rd=request.getRequestDispatcher("/Getpesudeokey?user_id="+userid+"&name1="+name1);
						
						rd.forward(request, response);
					}
					
				}
				
			}

		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin ListUser Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin ListUser Servlet......"+e);
		}
	}
}
