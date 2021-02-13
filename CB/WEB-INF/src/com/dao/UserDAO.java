package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import servicelocator.ServerConnector;

import com.mysql.jdbc.*;

public class UserDAO
{

	public static boolean userRegister(String uname,String upass,String uid,String addr,String email,String pno)
	{
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="insert into m_user (u_id,u_pass,uname,addr,pno,email) values ('"+uid+"','"+upass+"','"+uname+"','"+addr+"','"+pno+"','"+email+"')";
			System.out.println("Sql....."+sql);
			int i=st.executeUpdate(sql);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
		
	}
	
	public static boolean LoginCHCK(String uname,String upass)
	{
		boolean flag=false;
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		try 
		{
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_user where username='"+uname+"' and password='"+upass+"' ";
			ResultSet rs=(ResultSet) st.executeQuery(sql);
			
			while(rs.next())
			{
				flag=true;
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
		
	}
	
	public static boolean uidCHCK(String uname,String upass)
	{
		boolean flag=false;
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		try {
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_user where u_id='"+uname+"' and u_pass='"+upass+"' ";
			ResultSet rs=(ResultSet) st.executeQuery(sql);
			
			while(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
		
	}
	public static String getuid2(String uid) throws SQLException
	{
		System.out.println("vhvhv vhvbbv"+uid);
		String uname=null;
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		//try {
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_user where u_id='"+uid+"' ";
			System.out.println("sql :"+sql);
			
			ResultSet rs=(ResultSet) st.executeQuery(sql);
			
			while(rs.next())
			{
				uname=rs.getString(4);
			}
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		
		
		return uname;
		
	}
	
	public static ResultSet userProfile(String uid)
	{
		ResultSet rs=null;
		try{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_user where u_id='"+uid+"'";
			rs=(ResultSet) st.executeQuery(sql);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public static boolean userChangepass(String aname,String x_new_pass)
	{
		
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_user set u_pass='"+x_new_pass+"' where u_id='"+aname+"'";
			System.out.println("Sql....."+sql);
			int i=st.executeUpdate(sql);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	
	public static boolean userUpdateprofile(String uid,String uname,String umail,String uphone,String addr)
	{
		String name1="";
		ResultSet rs=null;
		boolean flag=false;
		try{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_user set uname='"+uname+"',email='"+umail+"',pno='"+uphone+"',addr='"+addr+"' where u_id='"+uid+"'";
			int k=st.executeUpdate(sql);
			if(k>0)
			{
				flag=true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static ResultSet getImageByDistAsc() 
	{
		ResultSet rs=null;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_image order by f1_dist asc ");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return rs;
	}
	
	

	public static ResultSet getFirstNameImage(String imgName) 
	{
		ResultSet rs=null;
		try
		{
			System.out.println("came to sql first search");
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_image where remarks='"+imgName+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet getsecondNameImage(String imgName) 
	{
		ResultSet rs=null;
		try
		{
			System.out.println("came to sql second search");
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_image where secondName='"+imgName+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static ResultSet getthirdNameImage(String imgName) 
	{
		ResultSet rs=null;
		try
		{
			System.out.println("came to sql second search");
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_image where thirdName='"+imgName+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	public static boolean updateFirstImageName(String imgName, String lable) 
	{
		boolean flag=false;
		try
		{
			//System.out.println("came to sql third search");
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_image set remarks='"+lable+"' where img_name='"+imgName+"'";
			//rs = (ResultSet) st.executeQuery("select * from m_image where thirdName='"+imgName+"'");
			
			int k=st.executeUpdate(sql);
			if(k>0)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateSecondImageName(String imgName, String lable) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_image set secondName='"+lable+"' where img_name='"+imgName+"'";
			//rs = (ResultSet) st.executeQuery("select * from m_image where thirdName='"+imgName+"'");
			
			int k=st.executeUpdate(sql);
			if(k>0)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateThirdImageName(String imgName, String lable) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_image set thirdName='"+lable+"' where img_name='"+imgName+"'";
			//rs = (ResultSet) st.executeQuery("select * from m_image where thirdName='"+imgName+"'");
			
			int k=st.executeUpdate(sql);
			if(k>0)
			{
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static ResultSet getallNameImage(String imgName) 
	{
		ResultSet rs=null;
		try
		{
			System.out.println("came to sql...");
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_image where remarks='"+imgName+"' or secondName='"+imgName+"' or thirdName='"+imgName+"'";
			System.out.println("sql :"+sql);
			rs = (ResultSet) st.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return rs;
	}

	public static int getID(String username)
	{
		int i=0;
		ResultSet rs=null;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select u_code from m_user where username='"+username+"'");
			while(rs.next())
			{
				i=rs.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getID(String userid): ");
			e.printStackTrace();
		}
		return i;
	}

	public static ResultSet getProfile(String username)
	{
		ResultSet rs=null;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_user where username='"+username+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getProfile()....."+e);
		}
		return rs;
	}

	public static boolean editProfile(String[] s) 
	{
		boolean flag=false;
		String sql = "";
		try
		{   
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			sql = "update m_user set u_name='"+s[1]+"',u_email='"+s[2]+"',u_phone='"+s[3]+"',u_address='"+s[4]+"' where u_code='"+s[0]+"'";
			System.out.println("******* Edit User Profile Info *********\n");
			System.out.println(sql);
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Edit Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-editProfile() :");
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean checkUser(String username, String password) 
	{
		ResultSet rs=null;
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_user where username='"+username+"' and password='"+password+"'");
			while(rs.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->checkUser(String userid,String pass): "+ e);
		}
		return flag;
	}

	public static boolean chnagePass(int id, String cpass) 
	{
		boolean flag=false;
		String sql = "";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			sql = "update m_user set password='"+cpass+"' where u_code='"+id+"'";
			System.out.println("******* Change User Password Info *********\n");
			System.out.println(sql);
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("User Change Pass Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-chnagePass() : ");
			e.printStackTrace();
		}
		return flag;
	}

	public static int getDepartmentID(String username) {
		int i=0;
		ResultSet rs=null;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select dept_code from m_user where username='"+username+"'");
			while(rs.next())
			{
				i=rs.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDepartmentID(String username): ");
			e.printStackTrace();
		}
		return i;
	}

	public static int getDesignationID(String username) 
	{
		int i=0;
		ResultSet rs=null;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select design_code from m_user where username='"+username+"'");
			while(rs.next())
			{
				i=rs.getInt(1);
			}
			System.out.println("User ID is : "+i);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDesignationID(String username): ");
			e.printStackTrace();
		}
		return i;
	}

	public static boolean addDownloadTransaction(String date, String time,
			int userId, int fileId, int deptId, int designationId,
			String transactionStatus) 
	{
		boolean flag=false;
		String sql="";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			sql="insert into m_transaction(t_date,t_time,u_code,f_code,dept_code,design_code,t_status) values('"+date+"','"+time+"','"+userId+"','"+fileId+"','"+deptId+"','"+designationId+"','"+transactionStatus+"')";
			System.out.println(sql);
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Download Transaction Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-addDownloadTransaction(): ");
			e.printStackTrace();
		}
		return flag;
		
	}

	public static ResultSet getDownloadTransaction(int userId)
	{
		ResultSet rs=null;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select * from m_transaction where u_code='"+userId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getDownloadTransaction() : ");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static String getFileName(int fileId)
	{
		ResultSet rs=null;
		String fileName = "";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs = (ResultSet) st.executeQuery("select f_name from m_file_Upload where f_code='"+fileId+"'");
			while(rs.next())
			{
				fileName=rs.getString(1);
			}
			System.out.println("File Name : "+fileName);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getFileName(int fileId): ");
			e.printStackTrace();
		}
		return fileName;
	}
	
	public static boolean ownerRegister(String uname,String upass,String uid,String addr,String email,String pno)
	{
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="insert into m_dataowner (name,password,ownerid,address,phone,email) values ('"+uid+"','"+upass+"','"+uname+"','"+addr+"','"+pno+"','"+email+"')";
			System.out.println("Sql....."+sql);
			int i=st.executeUpdate(sql);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
		
	}
	
}
