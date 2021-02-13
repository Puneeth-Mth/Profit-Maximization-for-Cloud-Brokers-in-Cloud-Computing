package com.RNS;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class StoreKeyToDatabase
{
  static int id;
  public static Connection connection = null;
  public static boolean storeKeyToDB(String RNSkey) throws ClassNotFoundException 
  {
	  System.out.println("-----------------------------"+RNSkey);
	  try {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/key_storage","root","admin");
		Statement stmt=conn.createStatement();
		String sql="insert into digkey_rns(RNSkey)values('"+RNSkey+"')";
		int k=stmt.executeUpdate(sql);
		System.out.println("------k-----"+k);
	    conn.close();
	}
	catch (SQLException e)
	{
		e.printStackTrace();
	}
      return true;
  }
  public static void main(String args[]) throws ClassNotFoundException,SQLException, IOException, NoSuchAlgorithmException 
  {
	String RNSkey="aaa";
	storeKeyToDB(RNSkey); 
  }
}
