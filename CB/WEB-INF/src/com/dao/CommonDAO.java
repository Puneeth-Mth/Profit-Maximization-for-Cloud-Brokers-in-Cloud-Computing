package com.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import servicelocator.ServerConnector;


import com.util.ConvertArrayToString;
import com.util.Utility;

public class CommonDAO {
	
	
	private static ResultSet resultSet = null;
	 static int upload_flag;

	public static ResultSet getFiles(int id, String type) {
		try {
			//String status="yes";
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			
			resultSet = st.executeQuery("select * from m_file_one where user_id='" +id+ "'");
			System.out.println("=====================");
			} 
		catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUsers()....."
					+ e);
		}
		return resultSet;
	}

	public static int getUserID(String userid) {
		int id = 0;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();

			String sql = "select u_code from m_user where username='" + userid
					+ "'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("User ID to return : " + id);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."
					+ e);
		}
		return id;
	}
	
	public static int getownerID(int uid) {
		int id = 0;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();

			String sql = "select id from m_owner where ownerid='" + uid
					+ "'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("User ID to return : " + id);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getownerID()....."
					+ e);
		}
		return id;
	}
	public static int getownerID(String uid) {
		int id = 0;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();

			String sql = "select id from m_owner where ownerid='" + uid
					+ "'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("User ID to return : " + id);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getownerID()....."
					+ e);
		}
		return id;
	}
	public static String getkey1(String userid)
	{
		int id=0;
		String key1 = "";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();

			String sql = "select id from m_owner where ownerid='" + userid+ "'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("User ID to return : " + id);
			
			con=(Connection) ServerConnector.ServerConnector();
			Statement st1=(Statement) con.createStatement();
			resultSet = st1.executeQuery("select key1 from m_rnskey where userid='"+id +"'");
			while(resultSet.next())
			{
				key1=resultSet.getString(1);
			}
			System.out.println("KEY1-- : "+key1);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getUploadMsgDigest(String fileName): ");
			e.printStackTrace();
		}
		return key1;
	}
	
	public static String getkey2(String userid)
	{
		int id=0;
		String key2 = "";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();

			String sql = "select id from m_owner where ownerid='" + userid
					+ "'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("User ID to return : " + id);
			
			con=(Connection) ServerConnector.ServerConnector();
			Statement st1=(Statement) con.createStatement();
			resultSet = st1.executeQuery("select key2 from m_rnskey where userid='"+id+"'");
			while(resultSet.next())
			{
				key2=resultSet.getString(1);
			}
			System.out.println("KEY2-- : "+key2);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getUploadMsgDigest(String fileName): ");
			e.printStackTrace();
		}
		return key2;
	}
	
	public static int m_file(String fname, int blocks) 
	{
		boolean flag=false;
		int fno=0;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="insert into m_file (file_name,Blocks) values('"+fname+"','"+blocks+"')";
			String sql2="select * from m_file";
			System.out.println(sql);
			System.out.println(sql2);
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert to database  Status : "+flag);
			resultSet=st.executeQuery(sql2);
			while(resultSet.next())
			{
				fno=resultSet.getInt(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return fno;
	}
	
	
	
	public static String gethashblocknos(String fname,String ownername) 
	{
		//boolean flag=false;
		String hashblknos=null;;
		try
		{
			
			int id=0;
			
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
		
			String sql2="select id from m_owner where ownerid='"+ownername+"'  ";
		
			resultSet=st.executeQuery(sql2);
			
			while(resultSet.next())
			{
				
				
			id=	resultSet.getInt(1);
				
				
			}
			
			
			
			Statement st1=(Statement) con.createStatement();
		
			String sql3="select * from m_file_one where file_name='"+fname+"' and user_id='"+id+"' ";
		
			resultSet=st1.executeQuery(sql3);
			while(resultSet.next())
			{
				hashblknos=resultSet.getString(7);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return hashblknos;
	}
	
	public static String gethashblockname(int hash_id) 
	{
		//boolean flag=false;
		String blkname=null;;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
		    String status="no";
			String sql2="select * from m_hash_code where hash_unique_code='"+hash_id+"' and uploaded_status='"+status+"'";
		
			resultSet=st.executeQuery(sql2);
			while(resultSet.next())
			{
				blkname=resultSet.getString(3);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return blkname;
	}
	
	
	
	
	
	
	
	public static int m_hash_code_insert_getid(String hash,String blockname,long len) 
	{
		
		boolean flag=false;
		boolean flag2=false;
		int id=0;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			
			String sql="insert into m_hash_code (hash_code,no_instnce,block_size) values('"+hash+"','"+1+"','"+Long.toString(len)+"')";
			String sql3="select * from m_hash_code where hash_code='"+hash+"'";
			String sql2="select * from m_hash_code  where hash_code='"+hash+"'";
			String status2="no";
			String sql4="select hash_unique_code from m_hash_code where hash_code='"+hash+"' and uploaded_status='"+status2+"'";
			int unique_id=0;
			System.out.println(sql);
			System.out.println(sql3);
			System.out.println(sql2);
			resultSet=st.executeQuery(sql3);
			while(resultSet.next())
			{
				flag2=true;
			}
			if(flag2==false)
			{
				int i=st.executeUpdate(sql);
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("Insert hash and instance to database  Status : "+flag); 
				
				
			resultSet=st.executeQuery(sql4);
			while(resultSet.next())
			{
				unique_id=resultSet.getInt(1);
			}
			//String blk_name1=unique_id+blockname;
			
			String blk_name1=blockname;
			int k=st.executeUpdate("update m_hash_code set blk_name='"+blk_name1+"' where hash_code='"+hash+"' and hash_unique_code='"+unique_id+"'");
			
		if(k!=0)
		{
			flag=true;
		}
		System.out.println("Insert to database  Status : "+flag);
		
	}
			
			if(flag2==true)
			{
				int instance=0;
				resultSet=st.executeQuery("select * from m_hash_code where hash_code='"+hash+"'");
				while(resultSet.next())
				{
					instance=resultSet.getInt(4);
				}
				instance=instance+1;
			    System.out.println("--------INSTANCE-----"+instance);
				int i=st.executeUpdate("update m_hash_code set no_instnce='"+instance+"' where hash_code='"+hash+"'");
				System.out.println("-----UPDATE INSTANCE-----"+instance);
				upload_flag=2;
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("update no_instance in database  Status : "+flag);
			}
			resultSet=st.executeQuery(sql2);
			while(resultSet.next())
			{
				id=resultSet.getInt(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in m_hash_code_insert....."+e);
			}
			return id;
	}
	
	
	
	
	
	
	
	
	
	
	public static int m_upload_status(String blk_name) 
	{
		
		boolean flag=false;
		int i=0;
		//String status=null;
		//String status="yes";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			
			
				String status1="yes";
				
				 i=st.executeUpdate("update m_hash_code set uploaded_status='"+status1+"'where blk_name='"+blk_name+"'");
				
				if(i!=0)
				{
					flag=true;
				}
				System.out.println("update uploaded status in database  Status : "+flag);
			
		}
		    catch(Exception e)
			{
				System.out.println("Opp's Error is in m_hash_code_insert....."+e);
			}
			return i;
	}
	
	
	
	
	public static boolean m_file_hash(int F_no,int block_no, String HashCode) 
	{
		boolean flag=false;
		try
		{
			
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="insert into m_file_hash (file_no,block_no,hash_code) values('"+F_no+"','"+block_no+"','"+HashCode+"')";
			System.out.println(sql);
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert to database  Status : "+flag);
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return flag;
	}
	
	public static int m_file_byteone(String substr) 
	{
		int id=0;
		try
		{
			 
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql2="select * from m_level1 where m_l1_byte='"+substr+"' ";
			System.out.println(sql2);
			resultSet=st.executeQuery(sql2);
			while(resultSet.next())
			{
				id=resultSet.getInt(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return id;
	}
	
	public static boolean addUploadTransaction(String fileName,
			String fileType, String date, int id, String valueOf,
			int originalfilesize) {
		boolean flag=false;
		String sql="";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			sql="insert into m_file_upload (f_name,f_type,f_upload_date,owner_id,f_size,f_encrpted_size) values('"+fileName+"','"+fileType+"','"+date+"','"+id+"','"+valueOf+"','"+originalfilesize+"')";
			System.out.println(sql);
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Upload Transaction Status : "+flag);
			con.close();
			st.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-addUploadTransaction.....");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean m_file_one(String file_name,int file_size1,int file_size2,int no_padding,int no_blocks, String hash_blk_no,int userid,String date,String time,String day) 
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="insert into m_file_one (file_name,file_size1,file_size2,padding,no_blocks,hash_blk_nos,user_id,date,time,day) values('"+file_name+"','"+file_size1+"','"+file_size2+"','"+no_padding+"','"+no_blocks+"','"+hash_blk_no+"','"+userid+"','"+date+"','"+time+"','"+day+"')";
			System.out.println(sql);
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Insert to database  Status : "+flag);
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return flag;
	}
	
	
	public static int m_file_level2_insert_getid(int id , String ss1) 
	{
		boolean flag=false;
		
		boolean flag2=false;
		int id2=0;
		try
		{
			
			
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql3="select * from m_level2 where m_l1_code='"+id+"' and m_l2_byte='"+ss1+"'";
			resultSet=st.executeQuery(sql3);
			while(resultSet.next())
			{
				flag2=true;
			}
			if(!flag2)
			{
			
			
			
			String sql="insert into m_level2(m_l1_code,m_l2_byte) values('"+id+"','"+ss1+"')";
			System.out.println(sql);
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			String sql1="select m_l2_code from m_level2 where m_l1_code='"+id+"' and m_l2_byte='"+ss1+"'";
			
			System.out.println("===============================SQL++++++++++++++++++++++++++++++++"+sql1);
			resultSet=st.executeQuery(sql1);
			while(resultSet.next())
			{
				id2=resultSet.getInt(1);
			}
			
			
			System.out.println("Insert to database  Status : "+flag);
		}
			else
			{
				String sql4="select m_l2_code from m_level2 where m_l1_code='"+id+"' and m_l2_byte='"+ss1+"' ";
				
				System.out.println("===============================SQL++++++++++++++++++++++++++++++++"+sql4);
				resultSet=st.executeQuery(sql4);
				while(resultSet.next())
				{
					id2=resultSet.getInt(1);
				}
			
			}
			
		
	
	}
	
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-register()....."+e);
		}
		return id2;
	}
	
	
	
	
	
	public static int m_block_name_insert(String hash, int id2,String blk_name) 
	{
		
		//boolean flag=false;
		int i=0;
		String blk_name1=id2+blk_name;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="update m_hash_code set blk_name='"+blk_name1+"' where hash_code='"+hash+"' and hash_unique_code='"+id2+"'";
			System.out.println("===============Block insertion======="+sql);
		    i =st.executeUpdate(sql);
		    con.close();
		    st.close();
					
		}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("======Error in block_name insertion======="+e);
			}
			return i;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String m_file_level3_insert(int m_l2_code,String m_l3_bytes,int hash_uniq_code) 
	{
		boolean flag=false;
		boolean flag2=false;
		String id=null;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql3="select * from m_level3 where m_l2_code='"+m_l2_code+"' and m_l3_bytes='"+m_l3_bytes+"'";
			resultSet=st.executeQuery(sql3);
			while(resultSet.next())
			{
				flag2=true;
			}
			if(!flag2)
			{
			
			
			
			String sql="insert into m_level3(m_l2_code,m_l3_bytes,hash_uniq_code) values('"+m_l2_code+"','"+m_l3_bytes+"','"+hash_uniq_code+"')";
			System.out.println(sql);
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			String sql1="select m_l3_code from m_level3 where m_l2_code='"+m_l2_code+"' and m_l3_bytes='"+m_l3_bytes+"'";
			
			System.out.println("===============================SQL++++++++++++++++++++++++++++++++"+sql1);
			resultSet=st.executeQuery(sql1);
			while(resultSet.next())
			{
				id=resultSet.getString(1);
			}
			
			
			System.out.println("Insert to database  Status : "+flag);
		}
			else
			{
				String sql4="select m_l3_code from m_level3 where m_l2_code='"+m_l2_code+"' and m_l3_bytes='"+m_l3_bytes+"' ";
				
				System.out.println("===============================SQL++++++++++++++++++++++++++++++++"+sql4);
				resultSet=st.executeQuery(sql4);
				while(resultSet.next())
				{
					id=resultSet.getString(1);
				}
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return id;
	}
	public static int m_file_get_hash_id(String hashcode) 
	{
		int hash_no=0;
		try
		{ 
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql2="select min(hash_unique_code)from m_hash_code where hash_code='"+hashcode+"' group by hash_code";
			System.out.println(sql2);
			resultSet=st.executeQuery(sql2);
			while(resultSet.next())
			{
				hash_no=resultSet.getInt(1);
			}
		}
			catch(Exception e)
			{
				System.out.println("Opp's Error is in AdminDAO-register()....."+e);
			}
			return hash_no;
	}
	
	//
	//
	//
	//
	//
	//
	//

	
	
	
	
	
	
	
	public static int getMd(String mdid) {
		int id = 0;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();

			String sql = "select id from m_trans where file_md='" + mdid
					+ "'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("File ID to return : " + id);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."
					+ e);
		}
		return id;
	}
	
	
	
	
	
	
	
	
	
	public static ResultSet getFilesByGrpName(String name, String type) {
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select * from m_trans where trans_type='" + type + "'");
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUsers()....."
					+ e);
		}
		return resultSet;
	}
	
	
	
	
	
	public static ResultSet getDel(int rs2) {
		try {
			String sql="Delete from m_audit_request where File_id='"+ rs2 + "'";
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			System.out.println("---------<<<<<>>>><<>>"+sql);
			
			System.out.println("---------<<<<<>>>><<>>"+sql);
			System.out.println("---------<<<<<>>>><<>>"+sql);
		
			boolean res = st.execute(sql);
		
			System.out.println("-------->>>><<<<<>>>><<>>"+res);
			System.out.println("-------->>>><<<<<>>>><<>>"+res);
			System.out.println("-------->>>><<<<<>>>><<>>"+res);
			System.out.println("-------->>>><<<<<>>>><<>>"+res);
			
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUsers()....."
					+ e);
		}
		return resultSet;
	}
	
	
	

	public static String getGrpName(String userid) {
		String grp_name = "";
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();

			String sql = "select groups from userlogin where userid='" + userid
					+ "'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				grp_name = resultSet.getString(1);
			}
			System.out.println("User Group name to return : " + grp_name);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserID()....."
					+ e);
		}
		return grp_name;
	}

	public static int getTransID() {
		int id = 1000;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st.executeQuery("select id from m_trans");
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("Trans ID to return : " + id);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getTransID()....."
					+ e);
		}
		return id;
	}

	public static boolean makeTrans(int id, String fileName, String type) {
		boolean flag = false;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql2="update m_file_one set status1='"+type+"' where file_name='"+fileName+"'";
			/*String sql = "insert into m_trans values (?,?,?,?,?,?,?)";
			String status="no";
			// System.out.println("trans value is"+sql);
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, getTransID() + 1);
			ps.setInt(2, id);
			ps.setString(3, fileName);
			ps.setString(4, type);
			ps.setString(5, Utility.getDate());
			ps.setString(6, Utility.getTime());
			ps.setString(7, Utility.getDay());
			
			int i = ps.executeUpdate();*/
			int i=st.executeUpdate(sql2);
			if (i != 0) {
				flag = true;
			}
			System.out.println("Upload File Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-makeTrans()....."
					+ e);
		}
		return flag;
	}

	public static boolean UpdateTrans(String id, String type) {
		boolean flag = false;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			int i = st.executeUpdate("delete from m_file_one where file_no='"
					+ id + "'");
			if (i != 0) {
				flag = true;
			}
			System.out.println("UpdateTrans  Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-UpdateTrans()....."
					+ e);
		}
		return flag;
	}
	
	
	
	public static boolean Updatehashtable(String id) {
		boolean flag = false;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			int i = st.executeUpdate("delete from m_hash_code where hash_unique_code='"
					+ id + "'");
			if (i != 0) {
				flag = true;
			}
			System.out.println("Updatehashtable  Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-UpdateTrans()....."
					+ e);
		}
		return flag;
	}
	
	public static boolean m_file_uploaddelete(String fmae,String ownerid) {
		boolean flag = false;
		try {
			int id=0;
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();

			String sql = "select id from m_owner where ownerid='" + ownerid
					+ "'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			System.out.println("User ID to return : " + id);
			
			con=(Connection) ServerConnector.ServerConnector();
			Statement st1=(Statement) con.createStatement();
			int i = st1.executeUpdate("delete from m_file_upload where f_name='"
					+ fmae + "'  and owner_id='"+id+"'");
			if (i != 0) {
				flag = true;
			}
			System.out.println("Updatehashtable  Status : " + flag);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-UpdateTrans()....."
					+ e);
		}
		return flag;
	}
	
	
	public static boolean UpdateInstance(String blkname) {
		boolean flag = false;
		boolean flag1=false;
		int instnce=0;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql1="select no_instnce from m_hash_code where blk_name='"+blkname+"'";
			
			resultSet = st.executeQuery(sql1);
			while (resultSet.next()) 
			{
				instnce = resultSet.getInt(1);
				System.out.println("====INSTANCE++++++"+instnce);
			}
			//String sql2="update m_hash_code set no_instnce='"+instnce+"' where blk_name='"+blkname+"'";
			if(instnce==1)
			{
			flag=Utility.deleteFile(Utility.getPro("server"),Utility.getPro("user"),Utility.getPro("pass"), blkname);
			int i = st.executeUpdate("delete from m_hash_code where blk_name='"+blkname+"'");
			System.out.println("--------DELETE from m_hash_code table-----"+i);
			}
			else 
			{   
				
				int instnce1=instnce-1;
				String sql2="update m_hash_code set no_instnce='"+instnce1+"' where blk_name='"+blkname+"'";
				System.out.println("----------UPDATE INSTANCE AFTER DELETION OF BLOCK----------"+sql2);
				int i2=st.executeUpdate("update m_hash_code set no_instnce='"+instnce1+"'where blk_name='"+blkname+"'");
			
			if (i2 != 0) 
			{
				flag1 = true;
			}
			}
			System.out.println("UpdateTrans  Status : " + flag1);
		} catch (Exception e) 
		{
			System.out.println("Opp's+=++++++====+++++ Error is in CommonDAO-UpdateTrans()....."
					+ e);
		}
		return flag;
	}
	
	

	public static int getCloudNo(String id) {
		int num = 0;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select cloud from m_trans where id='" + id
							+ "'");
			while (resultSet.next()) {
				num = resultSet.getInt(1);
			}
			System.out.println("Cloud Number to return : " + num);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getCloudNo()....."
					+ e);
		}
		return num;
	}

	public static String getGroupName(String userid) {
		String name = "";
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql = "select groups from userlogin where userid='" + userid
					+ "'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				name = resultSet.getString(1);
			}
			System.out.println("Group name to return : " + name);
		} catch (Exception e) {
			System.out
					.println("Opp's Error is in CommonDAO-getGroupName()....."
							+ e);
		}
		return name;
	}

	public static String getFileName(String id)
	{
		//String fileid= ConvertArrayToString.convertToString(id);
		String fname = "";
		int id2=Integer.parseInt(id);
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st.executeQuery("select * from m_file_one where file_no='"+id2+"'");
			while (resultSet.next()) 
			{
				fname = resultSet.getString(2);
			}
			System.out.println("File Name to return : " +fname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getFileName()....."
					+ e);
		}
		return fname;
	}
	public static int getFileName11(String filename,int fileid)
	{
		//String fileid= ConvertArrayToString.convertToString(id);
		String fname = "";
	int ownid=0;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st.executeQuery("select owner_id from m_file_upload where f_name='"+filename+"' and f_code='"+fileid+"' ");
			while(resultSet.next())
			{
				
				
			ownid=resultSet.getInt(1);	
				
			}
			
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getFileName()....."
					+ e);
		}
		return ownid;
	}
	public static String gethashblknos(String fname,int uis)
	{
		int id=0;
		String hashblknos=null;
		String sq="select hash_blk_nos from m_file_one where file_name='"+ fname + "' and user_id='"+uis+"'";
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery(sq);
			
			System.out.println("shanu isquery>>>>>>>>>>>>>>>>>>>>>"+sq);
			while (resultSet.next()) {
				hashblknos = resultSet.getString(1);
			}
			System.out.println("File Name to return : " +fname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getHashBlocksName()....."
					+ e);
		}
		return hashblknos;
	}
	
	public static String gethashblknosdown(String fname,int uis)
	{
		int id=0;
		String hashblknos=null;
		String sq="select hash_blk_nos from m_file_one where file_name='"+ fname + "' and user_id='"+uis+"'";
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery(sq);
			
			System.out.println("shanu isquery>>>>>>>>>>>>>>>>>>>>>"+sq);
			while (resultSet.next()) {
				hashblknos = resultSet.getString(1);
			}
			System.out.println("File Name to return : " +fname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getHashBlocksName()....."
					+ e);
		}
		return hashblknos;
	}
	
	
	
	public static String gethashblknos(String fname,String uis)
	{
		int id=0;
		String hashblknos=null;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();

			String sql = "select id from m_owner where ownerid='" + uis
					+ "'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			
			con=(Connection) ServerConnector.ServerConnector();
			Statement st1=(Statement) con.createStatement();
			resultSet = st1
					.executeQuery("select hash_blk_nos from m_file_one where file_name='"+ fname + "' and user_id='"+id+"'");
			while (resultSet.next()) {
				hashblknos = resultSet.getString(1);
			}
			System.out.println("File Name to return : " +fname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getHashBlocksName()....."
					+ e);
		}
		return hashblknos;
	}
	
	
	
	
	
	
	
	
	
	
	public static String gettotalblocks(String fname)
	{
		//String fileid= ConvertArrayToString.convertToString(id);
		String hashblknos=null;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select no_blocks from m_file_one where file_name='"+ fname + "'");
			while (resultSet.next()) {
				hashblknos = resultSet.getString(1);
			}
			System.out.println("File Name to return : " +fname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getHashBlocksName()....."
					+ e);
		}
		return hashblknos;
	}
	
	
	public static String getblocks(String hashid)
	{
		//String fileid= ConvertArrayToString.convertToString(id);
		String hashblkname=null;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select blk_name from m_hash_code where hash_unique_code='"
							+ hashid + "'");
			while (resultSet.next()) {
				hashblkname = resultSet.getString(1);
			}
			System.out.println("Block Name to return : " +hashblkname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getFileName()....."
					+ e);
		}
		return hashblkname;
	}
	
	
	public static boolean getInstance(String hashid)
	{
		//String fileid= ConvertArrayToString.convertToString(id);
		String hashblkname=null;
		boolean flag=false;
		int instance=0;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select no_instnce from m_hash_code where hash_unique_code='"
							+ hashid + "'");
			while (resultSet.next())
			{
				instance = resultSet.getInt(1);
			}
			if(instance>1)
			{
			 int instance1=instance-1;	
			 
			 int i2=st.executeUpdate("update m_hash_code set no_instnce='"+instance1+"'where hash_unique_code='"+hashid+"'");
				
				if (i2 != 0) 
				{
					flag = false;
				}
			}
			 
			else if(instance==1)
			{
				flag=true;
			}
		
			//System.out.println("Block Name to return : " +hashblkname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getInstance()....."
					+ e);
		}
		return flag;
	}
	
	
	
	public static String getFileName2(String[] id)
	{
		String fileid= ConvertArrayToString.convertToString(id);
		String fname = "";
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select file_name from m_trans where id='"
							+ fileid + "'");
			while (resultSet.next()) {
				fname = resultSet.getString(3);
			}
			System.out.println("File Name to return : " +fname);
			System.out.println("File Name to return --->>><<<<>>>: " +fname);
			System.out.println("File Name to return --->>><<<<>>>: " +fname);
			System.out.println("File Name to return --->>><<<<>>>: " +fname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getFileName()....."
					+ e);
		}
		return fname;
	}

	public static String getMD(String id) {
		String md = "";
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select file_md from m_trans where id='" + id
							+ "'");
			while (resultSet.next()) {
				md = resultSet.getString(1);
			}
			System.out.println("File MD to return : " + md);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getMD()....." + e);
		}
		return md;
	}

	public static int getUserId(String id) {
		int id1 = 0;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select user_id from m_trans where id='" + id
							+ "'");
			while (resultSet.next()) {
				id1 = resultSet.getInt(1);
			}
			System.out.println("User ID to return : " + id1);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserId()....."
					+ e);
		}
		return id1;
	}

	public static String getUserName(int id) {
		String uname = "";
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select userid from userlogin where id='"
							+ id + "'");
			while (resultSet.next()) {
				uname = resultSet.getString(1);
			}
			System.out.println("User Name to return : " + uname);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getUserName()....."
					+ e);
		}
		return uname;
	}

	public static byte[] getPubKey(String userid) throws Exception {
		byte pubKey[] = null;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="select pubkey from digkey where userid='"
					+ userid + "'";
			System.out.println("==========pubkey======: "+sql);
			
			resultSet = st
					.executeQuery(sql);
			while (resultSet.next()) {
				pubKey = resultSet.getBytes(1);
			}
			System.out.println("User pubKey to return : " + pubKey);
		} catch (Exception e) {
			System.out.println("Unable to process file for getPubKey :" + e);
		}
		return pubKey;
	}

	public static byte[] getPvtKey(String userid) throws Exception {
		byte pvtKey[] = null;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="select pvtkey from digkey where userid='"
					+ userid + "'";
			System.out.println("sql :"+sql);
			resultSet = st
					.executeQuery(sql);
			while (resultSet.next()) {
				pvtKey = resultSet.getBytes(1);
			}
			System.out.println("User pvtKey to return : " + pvtKey);
		} catch (Exception e) {
			System.out.println("Unable to process file for getPvtKey :" + e);
		}
		return pvtKey;
	}

	public static byte[] getDS(int id) throws Exception {
		byte ds[] = null;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select file_ds from m_trans where user_id='"
							+ id + "'");
			while (resultSet.next()) {
				ds = resultSet.getBytes(1);
			}
			System.out.println("User getDS to return : " + ds);
		} catch (Exception e) {
			System.out.println("Unable to process file for getDS :" + e);
		}
		return ds;
	}
	
	public static byte[] getDS2(int id,String fname) throws Exception {
		byte ds[] = null;
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="select file_ds from m_trans where user_id='"
					+ id + "' and file_name='"+fname+"'";
			
			System.out.println("========================");
			System.out.println("sql  "+sql);
			resultSet = st
					.executeQuery(sql);
			while (resultSet.next()) {
				ds = resultSet.getBytes(1);
			}
			System.out.println("User getDS to return : " + ds);
		} catch (Exception e) {
			System.out.println("Unable to process file for getDS :" + e);
		}
		return ds;
	}

	public static String getMailID(String userid) {
		String email = "";
		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st
					.executeQuery("select email from userlogin where userid='"
							+ userid + "'");
			while (resultSet.next()) {
				email = resultSet.getString(1);
			}
			System.out.println("email to return : " + email);
		} catch (Exception e) {
			System.out.println("Opp's Error is in CommonDAO-getMailID()....."
					+ e);
		}
		return email;
	}

	public static void delete(File file) {
		if (file.isDirectory()) {
			String fileList[] = file.list();
			if (fileList.length == 0) {
				System.out.println("Deleting Directory : " + file.getPath());
				file.delete();
			} else {
				int size = fileList.length;
				for (int i = 0; i < size; i++) {
					String fileName = fileList[i];
					System.out.println("File path : " + file.getPath()
							+ " and name :" + fileName);
					String fullPath = file.getPath() + "/" + fileName;
					File fileOrFolder = new File(fullPath);
					System.out.println("Full Path :" + fileOrFolder.getPath());
					delete(fileOrFolder);
				}
			}
		} else {
			System.out.println("Deleting file : " + file.getPath());
			file.delete();
		}
	}

	public static boolean checkRequest(String[] fileIdArr, String userId) {

		String query = "SELECT File_id FROM m_audit_request WHERE User_id='"
				+ userId + "'";
		ArrayList<String> x_list = new ArrayList<String>();
		ArrayList<String> existingFile = new ArrayList<String>();

		try {
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st.executeQuery(query);
			while (resultSet.next()) {
				x_list.add(resultSet.getString(1));
			}

			existingFile = getArrayList(x_list);

			for (String x_s : fileIdArr) {
				if (existingFile.contains(x_s)) {
					return true;
				}
			}

		} catch (Exception e) {
			System.out
					.println("Opp's Error is in CommonDAO-checkRequest()....."
							+ e);
		}

		return false;
	}

	private static ArrayList<String> getArrayList(ArrayList<String> x_ar) {

		ArrayList<String> x_list = new ArrayList<String>();

		for (String x : x_ar) {
			if (!(x.contains(","))) {
				x_list.add(x);
			} else {
				String[] x_array = x.split(",");
				for (String x_s : x_array) {
					x_list.add(x_s);
				}
			}
		}
		return x_list;
	}

	
	
	public static boolean isFilePresentServer(String fileName) 
	{
	  boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			String sql="select f_name from m_file_upload where f_name='"+fileName+"'";
			System.out.println(sql);
			resultSet = st.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("File Present Status--->"+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in isFilePresentOnIndiaServer....."+e);
		}
		return flag;
	}
	
	
	
	
	
	
	
	public static ArrayList<String> getCloudByServerID( int server_id)
	{
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = st.executeQuery("select * from m_cloud where c_id='"+server_id+"'");
		
			while(resultSet.next())
			{
				list.add(resultSet.getString(2));//ftp.drivehq.com
				list.add(resultSet.getString(3));//Cloud_user_name
				list.add(resultSet.getString(4));//Cloud_password
				//list.add(resultSet.getString(5));//cloud_directory
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserProcess-->getFiles(String userid): "+ e);
		}
		finally
		{
			try {
				resultSet.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	
	
	
	
	
	public static boolean  addDownloadTransaction(int userId,int fileId,String transactionStatus) 
	{
		boolean flag=false;
		String sql="";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			sql="insert into m_transaction(u_code,f_code,t_status) values('"+userId+"','"+fileId+"','"+transactionStatus+"')";
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


	
	
	
	
	
	
}
