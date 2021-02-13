/**
 * 
 */
package com.dao;

import java.sql.Connection;

import java.sql.DriverManager;

import servicelocator.*;

/**
 * @author Munna Kumar Singh
 */
public class DAO 
{
	private static DAO dao=null;
	private DAO()
	{
		
	}
	public static DAO getInstance()
	{
		if(dao==null)
		{
			dao=new DAO();
		}
		return dao;
	}
	
	public Connection connector()
	{
		Connection con=null;
		try {

			
			con=(Connection) ServerConnector.ServerConnector();
			System.out.println("Connected" + con);

		} catch (Exception e) {
			System.out.println("Exception in serverconnector-->connector(): "+ e);
		}
		return con;
	}
}
