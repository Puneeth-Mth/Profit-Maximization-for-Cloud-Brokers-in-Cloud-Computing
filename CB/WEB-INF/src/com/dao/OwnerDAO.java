package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import servicelocator.ServerConnector;

import com.mysql.jdbc.*;

public class OwnerDAO 
{
	public static boolean LoginCHCK(String uname,String upass)
	{
		boolean flag=false;
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		try 
		{
			Statement st=(Statement) con.createStatement();
			String sql="select * from m_owner where ownerid='"+uname+"' and password='"+upass+"'";
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

	public static ResultSet getClouds() 
	{
		ResultSet rs=null;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs=(ResultSet) st.executeQuery("select * from m_spconfig where s_size>1024 and s_status='Active' order by s_cost,s_qty desc limit 1");
			
		}
		catch(Exception e)
		{
		System.out.println("Exception in UserProcess-->getCost(): "+ e);
		}
			
		return rs;
	}

	public static int getcloudId() 
	{
		ResultSet rs=null;
		int id=0;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs=(ResultSet) st.executeQuery("select * from m_spconfig where s_size>1024 and s_status='Active' order by s_cost,s_qty desc limit 1");
			while(rs.next())
			{
				id=rs.getInt(2);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;

	}
	public static int getCredit(int id) 
	{
		ResultSet rs=null;
		int credit=0;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs=(ResultSet) st.executeQuery("select u_credit from m_owner where id='"+id+"' ");
			//ResultSet rs;
			while(rs.next())
			{
				credit=rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return credit;
	}
	
	public static String getIP(int s_id) 
	{
		ResultSet rs=null;
		String ip="";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs=(ResultSet) st.executeQuery("select c_ip from m_cloud where c_id='"+s_id+"'");
			while(rs.next())
			{
				ip=rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ip;
	}
	public static String getUser(int s_id) 
	{
		ResultSet rs=null;
		String ip="";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs=(ResultSet) st.executeQuery("select c_username from m_cloud where c_id='"+s_id+"'");
			while(rs.next())
			{
				ip=rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ip;
	}

	public static String getPass(int s_id) 
	{
		ResultSet rs=null;
		String ip="";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			rs=(ResultSet) st.executeQuery("select c_password from m_cloud where c_id='"+s_id+"'");
			while(rs.next())
			{
				ip=rs.getString(1);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ip;
	}

	public static boolean updateSConfig(int s_id, double size) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			
				int j=st.executeUpdate("update m_spconfig set s_size=s_size-'"+size+"' where s_id='"+s_id+"'");
				if(j!=0)
					flag=true;
//				System.out.println("User update updateSConfig Status : "+flag);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
		
	}

	public static boolean updateCredit(int id, int credit) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			int i=st.executeUpdate("update m_owner set u_credit='"+credit+"' where id='"+id+"'");
			if(i!=0)
				flag=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
		// TODO Auto-generated method stub
		
	}

	public static int getCredit(String id) 
	{
		int credit=0;
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		try 
		{
			Statement st=(Statement) con.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery("select u_credit from m_owner where ownerid='"+id+"' ");
			//ResultSet rs;
			while(rs.next())
			{
				credit=rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			
		}
		return credit;
	}
	
	public static boolean checkVoucher(String code) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			ResultSet rs = (ResultSet) st.executeQuery("select * from m_recharge where r_code='"+code+"'");
			while(rs.next())
			{
				flag=true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in OwnerDAO-->checkVoucher(String code): "+ e);
		}
		
		return flag;
	}

public static boolean checkVoucherStatus(String code) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			ResultSet rs =(ResultSet) st.executeQuery("select * from m_recharge where r_code='"+code+"' and r_status='Invalid'");
			while(rs.next())
			{
				flag=true;
			}

			
		}
		catch(Exception e)
		{
			System.out.println("Exception in ownerdao-->checkVoucherStatus(String code): "+ e);
		}
		
		return flag;
	}

	public static int getCredit(String code, String string) 
	{
		int credit=0;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			ResultSet rs =(ResultSet) st.executeQuery("select r_cost from m_recharge where r_code='"+code+"'");
			while(rs.next())
			{
				credit=rs.getInt(1);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in ownerdao-->getCredit(String id): "+ e);
		}
		// TODO Auto-generated method stub
		return credit;
	}

	public static boolean addCredit(String u_user, int credit, String code) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			int i =st.executeUpdate("update m_owner set u_credit='"+credit+"' where ownerid='"+u_user+"'");
			if(i!=0)
			{	
				flag=true;
				makeInvalid(code);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in ownerdao-->addCredit(String code): "+ e);
		}
		return flag;
	}

	
	private static boolean makeInvalid(String code) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			int i=st.executeUpdate("update m_recharge set r_status='Invalid' where r_code='"+code+"'");
			if(i!=0)
				flag=true;
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in ownerdao-->makeInvalid(String code): "+ e);
		}
		return flag;
		// TODO Auto-generated method stub
		
	}

}
