package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import servicelocator.ServerConnector;

import com.mysql.jdbc.*;
import com.util.Utility;

public class AdminDAO 
{
	private static ResultSet resultSet = null;
public static boolean LoginCHCK(String uname,String upass)
{
	boolean flag=false;
	Connection con=null;
	con=(Connection) ServerConnector.ServerConnector();
	try {
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_admin where adminid='"+uname+"' and password='"+upass+"' ";
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


public static boolean AddDataOwners(String uname){
	
	
	boolean flag=false;
	Connection con=null;
	con=(Connection) ServerConnector.ServerConnector();
	String name=new String();
	String username=new String();
	String password=new String();
	//String name=new String();
	String address=new String();
	String email=new String();
	String phone=new String();
	boolean result=false;
	try {
		Statement st=(Statement) con.createStatement();
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"+uname);
		String sql="select * from m_dataowner where id='"+uname+"'";
		ResultSet rs=(ResultSet) st.executeQuery(sql);
		
		while(rs.next())
		{	
			result=true;
			name=rs.getString(2);
			username=rs.getString(4);
			password=rs.getString(3);
			address=rs.getString(5);
			email=rs.getString(7);
			phone=rs.getString(6);
		}
		st.executeUpdate("delete from m_dataowner where id='"+uname+"'");

		result = AdminDAO.addDataOwnerDetails(username, password, name, address, email, phone);
		 	
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return result;
	
	
}







public static boolean Changepass(String aname,String x_new_pass)
{
	
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="update m_admin set apass='"+x_new_pass+"' where aname='"+aname+"'";
		System.out.println("Sql....."+sql);
		int i=st.executeUpdate(sql);
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return true;
}
public static ResultSet profile(String uid)
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_admin where aname='"+uid+"'";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getClassifications() 
{
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		rs = (ResultSet) st.executeQuery("select * from m_classification");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getClassifications() : ");
		e.printStackTrace();
	}
	return rs;
}

public static boolean checkClassificationExistance(String classificationName)
{
	boolean flag=false;
	String sql = "";
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_classification where c_name='"+classificationName+"'";
		System.out.println("********** Check Classification Existance Info **********");
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			flag=true;
		}
		System.out.println("Classification Existance Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>checkgetClassificationExistance(String classificationName) : ");
		e.printStackTrace();
	}
	return flag;
}


public static boolean addClassificationDetails(String classificationName,String remarks)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "insert into m_classification(c_name,c_remark) values('"+classificationName+"','"+remarks+"')";
		System.out.println("********** Add Classification Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Add Classification Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>addClassificationDetails(String classificationName,String remarks) : ");
		e.printStackTrace();
	}
	return flag;
}


public static ResultSet getClassification(int classificationId) 
{
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		rs = (ResultSet) st.executeQuery("select * from m_classification where c_id='"+classificationId+"'");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO-getClassification(int classificationId) : ");
		e.printStackTrace();
	}
	return rs;
}

public static String getClassificationName(String classificationId) 
{
	ResultSet rs=null;
	String cname=null,day=null;
	float day_theshold=0.0f,night_theshold=0.0f;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		rs = (ResultSet) st.executeQuery("select * from m_classification where c_id='"+classificationId+"'");
	while(rs.next())
	{
		cname=rs.getString(2);
		day=rs.getString(3);
		day_theshold=rs.getFloat(4);
		night_theshold=rs.getFloat(5);
	}
	
	
	if(day.equalsIgnoreCase("DAY"))
	{
		
	}
	else
	{
		
	}
	
	
	
	
	
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO-getClassification(int classificationId) : ");
		e.printStackTrace();
	}
	return cname;
}



public static boolean updatClassificationDetails(int classificationId,String classificationName,String remarks)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_classification set c_name='"+classificationName+"',c_remark='"+remarks+"' where c_id='"+classificationId+"'";
		System.out.println("********** Update Classification Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Update Classification Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updatClassificationDetails(): ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean deleteClassificationDetails(int classificationId)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{

		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "delete from m_classification where c_id='"+classificationId+"'";
		System.out.println("********** Delete Classification Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Delete Classification Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>deleteClassificationDetails(int classificationId): ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateprofile(String uid,String uname,String umail,String uphone,String addr)
{
	String name1="";
	ResultSet rs=null;
	boolean flag=false;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="update m_admin set name='"+uname+"',email='"+umail+"',pno='"+uphone+"',addr='"+addr+"' where aname='"+uid+"'";
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

public static boolean imgUpdate(String fname)
{
	boolean flag=false;
	Connection con=null;
	con=(Connection) ServerConnector.ServerConnector();
	try {
		Statement st=(Statement) con.createStatement();
		String sql="insert into Tcount (fname) value('"+fname+"') ";
		int k=st.executeUpdate(sql);
		System.out.println("K :"+k);
		if(k>0)
		{
			flag=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return flag;
	
}


public static ResultSet getImgcount()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from Tcount";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getImgcat()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_imgclasification";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}




public static int getImageCount1LastUpdate()
{
	String sql="";
    int name=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select img_id from m_image order by IMG_ID DESC limit 1";
		System.out.println("********** Get Image count Info **********");
		System.out.println(sql);
		ResultSet rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			name = rs.getInt(1);
		}
		System.out.println("image count is ++++"+name);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO==>getAdminName(String username) : ");
		e.printStackTrace();
	}
	return name;
}




public static boolean addImageDetailsUnTrained(String imageFileName)
{
	boolean flag=false;
	String sql = "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		//sql = "insert into m_image(img_name,cid) values('"+imageFileName+"','"+cid+"')";
		sql = "insert into m_image(img_name) values('"+imageFileName+"')";
		System.out.println("********** Add Image Details Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag=true;
		}
		System.out.println("Add Image Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>addImageDetails(String imageFileName,String remarks) : ");
		e.printStackTrace();
	}
	return flag;

	
	
}

public static ResultSet getUsers()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_user";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}


public static ResultSet getImage()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_image";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getImage1()
{
	
	ResultSet rs=null;
	try{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String sql="select * from m_image";
		rs=(ResultSet) st.executeQuery(sql);
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return rs;
}



public static boolean updateImgFeature2(int imageId,double imgFeature2)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set feature2='"+imgFeature2+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Feature2 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Feature2 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgFeature2(int imageId,double imgFeature2) : ");
		e.printStackTrace();
	}
	return flag;
}





//Resetting (ENDS)

public static boolean updateImgFeature1(int imageId,String imgFeature1)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set feature1='"+imgFeature1+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Feature1 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Feature1 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgFeature1(int imageId,String imgFeature1): ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateImgFeature2(int imageId,String imgFeature2)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set feature2='"+imgFeature2+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Feature2 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Feature2 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgFeature2(int imageId,String imgFeature2): ");
		e.printStackTrace();
	}
	return flag;
}






public static ResultSet getTopNimg4Feature1Comparision(int noOfRecords) 
{
	String sql="";
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image order by f1_dist asc limit 0,"+noOfRecords;
		System.out.println("******* Getting The Images For Feature1 Processing *******");
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getImageTopNimg(int noOfRecords) : ");
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getTopNimg4Feature2Comparision(int noOfRecords) 
{
	String sql="";
	double defaultValue = -1;
	ResultSet rs=null;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image where f2_dist !='"+defaultValue+"' order by f2_dist asc limit 0,"+noOfRecords;
		System.out.println("******* Getting The Images For Feature2 Processing *******");
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getTopNimg4Feature2Comparision(int noOfRecords) : ");
		e.printStackTrace();
	}
	return rs;
}

public static ResultSet getTopNimg4Feature3Comparision() 
{
	String sql="";
	double defaultValue = -1;
	ResultSet rs=null;
	try
	{
		int threshold=Integer.parseInt(Utility.getPro("threshold"));
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		//sql = "select * from m_image where cid=1 order by f2_dist desc ";
		sql = "select img_id,img_name,avg_dist from m_image where avg_dist>'"+threshold+"' order by  avg_dist  desc   ";
		
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
		
	}
	catch(Exception e)
	{
		System.out.println("Opp's Exception is in AdminDAO==>getTopNimg4Feature3Comparision(int noOfRecords) : ");
		e.printStackTrace();
	}
	return rs;
}


public static String getClasificationId() 
{
	String sql="";
	double defaultValue = -1,avg_dist=0.0;
	ResultSet rs=null;
	String cid=null,status=null;
	String cname=null,day=null,daytotalavg=null,nighttotalavg=null;
	float f1_theshold=0.0f,f2_theshold=0.0f;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_image order by f1_dist limit 1";
		
		System.out.println(sql);
		rs = (ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			cid=rs.getString(5);
		}
		System.out.println("+++++++++++cid++++++++++ "+cid);
		
		Connection con1=null;
		con1=(Connection) ServerConnector.ServerConnector();
		Statement st2=(Statement) con1.createStatement();
		rs = (ResultSet) st2.executeQuery("select * from m_classification where c_id='"+cid+"'");
		while(rs.next())
		{
			cname=rs.getString(2);
			day=rs.getString(3);
			f1_theshold=rs.getFloat(4);
			f2_theshold=rs.getFloat(5);
		}
		System.out.println("++++cname++++"+cname);
		System.out.println("++++day++++"+day);
		System.out.println("++++F1_theshold++++"+f1_theshold);
		System.out.println("++++F2_theshold++++"+f2_theshold);
		
		//# Getting Avg DIstance from m_image table...[START]
		Connection con2=null;
		con2=(Connection) ServerConnector.ServerConnector();
			Statement st3=(Statement) con2.createStatement();
			String sql1="select avg(f2_dist),avg(f1_dist) from m_image where cid='"+cid+"'";
			System.out.println("sql:"+sql1);
			rs = (ResultSet) st3.executeQuery(sql1);
			while(rs.next())
			{
				daytotalavg=rs.getString(1);
				nighttotalavg=rs.getString(2);
			}
			System.out.println("++++++ DAY totalavg++++++"+daytotalavg);
			System.out.println("++++++ NIGHT totalavg++++++"+daytotalavg);
		if(day.equalsIgnoreCase("DAY"))
		{
			float dayavg_dist=Float.parseFloat(daytotalavg);
			if(dayavg_dist<f2_theshold)
			{
				System.out.println("Animal Found");
				status="Animal Found";
			}
			else
			{
				System.out.println("No Animal Found");
				status="Animal Not Found";
			}
			
			
		}else if(day.equalsIgnoreCase("NIGHT"))
		{
			float nightavg_dist=Float.parseFloat(nighttotalavg);
			if(nightavg_dist<f1_theshold)
			{
				System.out.println("No Animal Found");
				status="Animal Not Found";
				
			}
			else
			{
				System.out.println("Animal Found");
				status="Animal Found";
			}
		}
		
		
		
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return cid+"~~"+status;
}


public static boolean updateImgDistance(int imageId,double distance)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set f1_dist='"+distance+"' where img_id='"+imageId+"'";
		
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateF2Distance()
{
	boolean flag=false;
	String sql= "";
	double defaultValue = -1;
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set f2_dist='"+defaultValue+"'";
		System.out.println("********** Update F2 Distance(f2_dist) Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update F2_Dist Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateF2Distance() : ");
		e.printStackTrace();
	}
	return flag;
}



public static boolean updateImgDist4Feature2(int imageId,double distance2)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set f2_dist='"+distance2+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Distance For Feature2 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Distance2 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgDist4Feature2(int imageId,double distance2) : ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateImgDist4Feature3(int imageId,int distance3,int r)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set Rot"+r+"_dist='"+distance3+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Distance For Feature3 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Distance3 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgDist4Feature3(int imageId,double distance3) : ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean updateAvgImgDist(int imageId,double avg)
{
	boolean flag=false;
	String sql= "";
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_image set avg_dist='"+avg+"' where img_id='"+imageId+"'";
		System.out.println("********** Update Image Distance For Feature3 Info **********");
		System.out.println(sql);
		i = st.executeUpdate(sql);
		if(i>0)
		{
			flag = true;
		}
		System.out.println("Update Image Distance3 : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO==>updateImgDist4Feature3(int imageId,double distance3) : ");
		e.printStackTrace();
	}
	return flag;
}

public static ResultSet getProfile(String username)
{
	String sql="";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql="select * from m_admin where adminid='"+username+"'";
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-getProfile(): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static ResultSet getServerDetails()
	{
		String sql="";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			sql="select * from m_cloud";
			System.out.println("******* Server Info *********\n");
			System.out.println(sql);
			resultSet = (ResultSet) st.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getServerDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
	}

public static boolean checkServerHostExistence(String hostName) 
{
	boolean flag=false;
	String sql = "";
	String url = "";
	try
	{
        url = "ftp://"+hostName;
		
        Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_cloud where c_url='"+url+"'";
		System.out.println("******* Check Server Existence *********\n");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			flag=true;
		}
		System.out.println("Check Server Existence Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-checkServerHostExistence : ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean addServerDetails(String hostName, String username,
		String password, String status, String remarks) 
{
	boolean flag=false;
	String sql = "";
	String url="";
	try
	{
		url = "ftp://"+hostName;
		
		if(remarks.equals(""))
		{
			remarks = "";
		}
		
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "insert into m_cloud (c_url,c_username,c_password,c_status,c_remarks) values('"+url+"','"+username+"','"+password+"','"+status+"','"+remarks+"')";
		System.out.println("******* Add Server Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Add Server Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-addServerDetails() :");
		e.printStackTrace();
	}
	return flag;
}

public static boolean editServerDetails(String[] s) 
{
	boolean flag=false;
	String sql = "";
	String url = "";
	try
	{   
		url = "ftp://"+s[1];
		
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_cloud set c_url='"+url+"',c_username='"+s[2]+"',c_password='"+s[3]+"',c_status='"+s[4]+"',c_remarks='"+s[5]+"' where c_id='"+s[0]+"'";
		System.out.println("******* Edit Server Details Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Admin Edit Server Details Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-editServerDetails(String [] s)  :");
		e.printStackTrace();
	}
	return flag;
	
}

public static ResultSet getServerSpecificDetails(int serverId)
	{
		String sql="";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			sql="select * from m_cloud where c_id='"+serverId+"'";
			System.out.println("******* Get Specific Server Info *********\n");
			System.out.println(sql);
			resultSet = (ResultSet) st.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getServerSpecificDetails(int serverId): ");
			e.printStackTrace();
		}
		return resultSet;
	}

public static boolean deleteServerDetails(int serverId) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "delete from m_cloud where c_id='"+serverId+"'";
		System.out.println("******* Delete Server Details Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Delete Server Details Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in deleteServerDetails(int serverId) :" );
		e.printStackTrace();
	}
	return flag;
	
}

public static boolean checkUserExistence(String username) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_user where username='"+username.trim()+"'";
		System.out.println("******* Check User Existence *********\n");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			flag=true;
		}
		System.out.println("Check User Existence Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-checkUserExistence(String username) : ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean addUserDetails(String username, String password, String name, String email,int department1,int designation1,String address,String city,String phone,String mobile) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "insert into m_user (username,password,u_name,dept_code,design_code,u_address,u_city,u_cell,u_phone,u_email) values('"+username+"','"+password+"','"+name+"','"+department1+"','"+designation1+"','"+address+"','"+city+"','"+phone+"','"+mobile+"','"+email+"')";
		System.out.println("******* Add User Details *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("User Registeration Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-addUserDetails : ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean editUserDetails(String[] s) 
{
	boolean flag=false;
	String sql = "";
	try
	{   
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_user set username='"+s[1]+"',password='"+s[2]+"',u_name='"+s[3]+"',dept_code='"+s[4]+"',design_code='"+s[5]+"',u_address='"+s[6]+"',u_city='"+s[7]+"',u_cell='"+s[8]+"',u_phone='"+s[9]+"',u_email='"+s[10]+"' where u_code='"+s[0]+"'";
		System.out.println("******* Edit User Details *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Edit User Details Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-editUserDetail(String [] s): ");
		e.printStackTrace();
	}
	return flag;
}

public static ResultSet getSpecificUserDetails(int id)
{
	String name="";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select * from m_user where u_code='"+id+"'");
		
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getSpecificUserDetails(): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean deleteUserDetails(int userId)
{
	{
		boolean flag=false;
		String sql = "";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			sql = "delete from m_user where u_code='"+userId+"'";
			System.out.println("******* Delete User Details Info *********\n");
			System.out.println(sql);
			int i=st.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Delete User Details Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in Admin-deleteUserDetails(int userId) :" );
			e.printStackTrace();
		}
		return flag;
	}
	
}

public static ResultSet getDataOwners()
{
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select * from m_owner");
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getDataOwners(): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean checkOwner(String username, String password) 
{
	boolean flag=false;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select * from m_owner where ownerid='"+username+"' and password='"+password+"'");
		while(resultSet.next())
		{
			flag=true;
		}
		System.out.println("Data Owner Existence Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminrDAO-->checkOwner(String username,String password): ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean addDataOwnerDetails(String username, String password,
		String name, String address, String email, String phone) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "insert into m_owner (name,password,ownerid,address,phone,email) values('"+name+"','"+password+"','"+username+"','"+address+"','"+phone+"','"+email+"')";
		System.out.println("******* Add Data Owner Details *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Data Owner Registeration Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-addDataOwnerDetails() : ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean editDataOwnerDetails(String [] s) 
{
	boolean flag=false;
	String sql = "";
	try
	{   
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_owner set name='"+s[1]+"',address='"+s[2]+"',phone='"+s[3]+"',email='"+s[4]+"' where id='"+s[0]+"'";
		System.out.println("******* Update Data Owner Info *********");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Update Data Owner Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-editDataOwnerDetails(String [] s) :");
		e.printStackTrace();
	}
	return flag;
}

public static ResultSet getSpecificDataOwnerDetails(int id)
{
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select * from m_owner where id='"+id+"'");
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getSpecificDataOwnerDetails(int id): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean deleteDataOwnerDetails(int dataWonerId) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "delete from m_owner where id='"+dataWonerId+"'";
		System.out.println("******* Delete Data Owner Details Info *********");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Delete Data Owner Details Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in Admin-deleteDataOwnerDetails(int userId) :" );
		e.printStackTrace();
	}
	return flag;
}

public static String getLastKeyUpdatedDate()
{
	String date="";
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select key_date from m_config";
		System.out.println("****** Last Key Updation Date *******");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			date=resultSet.getString(1);
		}
		
		System.out.println("Key Updated On : " + date);
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getLastKeyUpdatedDate(): ");
		e.printStackTrace();
	}
	return date;
}

public static ResultSet getDepartmentDetails()
{
	String sql="";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql="select * from m_department";
		System.out.println("******* Department Info *********\n");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-getDepartmentDetails(): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static ResultSet getDesignationDetails()
	{
		String sql="";
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			sql="select * from m_designation";
			System.out.println("******* Designation Info *********\n");
			System.out.println(sql);
			resultSet = (ResultSet) st.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in UserDAO-getDesignationDetails(): ");
			e.printStackTrace();
		}
		return resultSet;
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
		sql = "update m_admin set name='"+s[1]+"',address='"+s[2]+"',phone='"+s[3]+"',email='"+s[4]+"' where id='"+s[0]+"'";
		System.out.println("******* Edit Profile Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Admin Edit Profile Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-editProfile() :");
		e.printStackTrace();
	}
	return flag;
}

public static boolean checkAdmin(String admin,String pass)
	{
		boolean flag=false;
		try
		{
			Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();
			resultSet = (ResultSet) st.executeQuery("select * from m_admin where adminid='"+admin+"' and password='"+pass+"'");
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminrDAO-->checkAdmin(String admin,String pass): "+ e);
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
		sql = "update m_admin set password='"+cpass+"' where id='"+id+"'";
		System.out.println("******* Change Password Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Admin Change Pass Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-chnagePass() : ");
		e.printStackTrace();
	}
	return flag;
}

public static ResultSet getOwnerProfile(String username)
{
	String sql="";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql="select * from m_owner where ownerid='"+username+"'";
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-getOwnerProfile(): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean editOwnerProfile(String[] s)
{
	boolean flag=false;
	String sql = "";
	try
	{   
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_owner set name='"+s[1]+"',address='"+s[2]+"',phone='"+s[3]+"',email='"+s[4]+"' where id='"+s[0]+"'";
		System.out.println("******* Edit Data Owner Profile Info *********");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Admin Edit Data Owner Profile Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-editOwnerProfile() :");
		e.printStackTrace();
	}
	return flag;
}

public static boolean chnageOwnerPass(int id,String cpass) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_owner set password='"+cpass+"' where id='"+id+"'";
		System.out.println("******* Change Data Owner Password Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Change Data Owner Password Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-chnageOwnerPass(int id,String cpass)  : ");
		e.printStackTrace();
	}
	return flag;
}
	
public static String getDepartmentName(int id)
{
	String name="";
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select dept_name from m_department where dept_code='"+id+"'";
		System.out.println("****** Get Department Name By Id *******");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			name=resultSet.getString(1);
		}
		
		System.out.println("Department Name : " + name);
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getDepartmentName(int id): ");
		e.printStackTrace();
	}
	return name;
}
public static String getDesignationName(int id)
{
	String name="";
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select desig_name from m_designation where desig_code='"+id+"'";
		System.out.println("****** Get Designation Name By Id *******");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			name=resultSet.getString(1);
		}
		
		System.out.println("Designation Name : " + name);
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getDesignationName(int id): ");
		e.printStackTrace();
	}
	return name;
}

public static int getMaxUserID() 
{
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select max(u_code) from m_user");
		while(resultSet.next())
		{
			i=resultSet.getInt(1);
		}
		System.out.println("Max User ID is : "+i);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO--> getMaxUserID(): ");
		e.printStackTrace();
	}
	return i;
}

public static int getTotalNumberOfClouds() 
{
	int clouds=0;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "SELECT COUNT(*) FROM m_cloud";
		System.out.println("****** Total Number Of Clouds *******");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			clouds = resultSet.getInt(1);
		}
		
		System.out.println("Total Number Of Clouds : " + clouds);
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getTotalNumberOfClouds():");
		e.printStackTrace();
	}
	return clouds;
}

public static int getDataOwnerId(String username) 
{
	int id=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select id from m_owner where ownerid='"+username+"'");
		while(resultSet.next())
		{
			id=resultSet.getInt(1);
		}
		System.out.println("Data OwnerId["+username+"] : "+id);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminDAO-->getDataOwnerId(String username): ");
		e.printStackTrace();
	}
	return id;
}

public static boolean addUploadTransaction(String ufileName, String fileType,
		String date, String uploadSubject, int cloudId, int ownerId) 
{
	boolean flag=false;
	String sql="";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql="insert into m_file_upload (f_name,f_type,f_upload_date,f_subject,cloud_id,owner_id) values('"+ufileName+"','"+fileType+"','"+date+"','"+uploadSubject+"','"+cloudId+"','"+ownerId+"')";
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Upload Transaction Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-addUploadTransaction.....");
		e.printStackTrace();
	}
	return flag;
}

public static ResultSet getUploadFiles()
{
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select * from m_file_upload");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-getUploadedFiles(int ownerId) : ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean deleteUploadedFiles(int uploadId) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "delete from m_file_upload where f_code='"+uploadId+"'";
		System.out.println("******* Delete Uploaded File Details Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Delete UploadedFile Details Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-deleteUploadedFiles(int uploadId) :" );
		e.printStackTrace();
	}
	return flag;
}
public static ResultSet getUploadedFiles(int ownerId)
{
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select * from m_file_upload where owner_id='"+ownerId+"'");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-getUploadedFiles(int ownerId) : ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean addAcessControl(int fileCode, int deptCode, int designationCode)
{
	boolean flag=false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "insert into m_acess_control(f_code,dept_code,desig_code) values('"+fileCode+"','"+deptCode+"','"+designationCode+"')";
		System.out.println("******* Add AcessControl Details *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Add AcessControl Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-addAcessControl() : ");
		e.printStackTrace();
	}
	return flag;
}

public static ResultSet getAccessControls()
{
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select * from m_acess_control");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-getAccessControls() : ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean editAccessControls(int[] s) 
{
	boolean flag=false;
	String sql = "";
	try
	{   
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_acess_control set f_code='"+s[1]+"',dept_code='"+s[2]+"',desig_code='"+s[3]+"' where ac_code='"+s[0]+"'";
		System.out.println("******* Edit Access Controls Details Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Admin Access Controls Details Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-editAccessControls(int [] s)  :");
		e.printStackTrace();
	}
	return flag;
	
}

public static ResultSet getFileAccessControlInfo(int accessId)
{
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select * from m_acess_control where ac_code='"+accessId+"'");
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-getFileAccessControlInfo : ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean deleteAccessControls(int acId) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "delete from m_acess_control where ac_code='"+acId+"'";
		System.out.println("******* Delete Server Details Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Access Control Details Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-deleteAccessControls(int acId) :" );
		e.printStackTrace();
	}
	return flag;
}

public static String getFileName(int fileId)
{
	String fileName="";
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select f_name from m_file_upload where f_code='"+fileId+"'";
		System.out.println("****** Get File Name By Id *******");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			fileName=resultSet.getString(1);
		}
		
		System.out.println("File Id : "+fileId+"\nFile Name : " + fileName);
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getLastKeyUpdatedDate(): ");
		e.printStackTrace();
	}
	return fileName;
}

public static boolean downloadAuthentication1(int fileId, int deptId1,
		int designationId1) 
{
	boolean flag = false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_acess_control where f_code='"+fileId+"' and dept_code='"+deptId1+"' and desig_code='"+designationId1+"'";
		System.out.println("*********** Login Authentication Info **************");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			flag = true;
		}
		
		System.out.println("Download Authentication1 Status : " + flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-downloadAuthentication1() : ");
		e.printStackTrace();
	}
	return flag;
}

public static ResultSet getUploadFiles(int fileId)
{
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_file_upload where f_code='"+fileId+"'";
		System.out.println("@@@@@@@@@@@ Upload Info @@@@@@@@@@@@@@@");
		resultSet = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-getUploadFiles() : ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean addrnskey(int ownerid,String pubkey,String privatekey) 
{
	ResultSet rs=null;
	boolean flag=false;
	boolean flag1=false;
	String sql = "";
	try
	{
		
		
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_rnskey where userid='"+ownerid+"'";
		rs=(ResultSet) st.executeQuery(sql);
		while(rs.next())
		{
			
			flag=true;
			
		}
		if(flag)
		{
			flag1=false;
			
		}
		
		else
		{
			con=(Connection) ServerConnector.ServerConnector();
			Statement st1=(Statement) con.createStatement();
			sql = "insert into m_rnskey(userid,key1,key2) values('"+ownerid+"','"+pubkey+"','"+privatekey+"')";
		
			System.out.println(sql);
			int i=st1.executeUpdate(sql);
			if(i!=0)
			{
				flag1=true;
			}
			System.out.println("Add AcessControl Status : "+flag1);	
			
		}
		
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	return flag1;
}

public static ResultSet getid()
{
	String sql="";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql="select * from m_owner";
		System.out.println("******* Department Info *********\n");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-getDepartmentDetails(): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static int getUserID() 
{
	int i=0;
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select u_code from m_user");
		while(resultSet.next())
		{
			i=resultSet.getInt(1);
		}
		System.out.println(" User ID is : "+i);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserDAO--> getUserID(): ");
		e.printStackTrace();
	}
	return i;
}

public static boolean inserthascode(int id, String str) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_user set u_hashcode='"+str+"' where u_code='"+id+"'";
		System.out.println("******* Userhashcode *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Change Data Owner Password Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-hasecode(int id,String cpass)  : ");
		e.printStackTrace();
	}
	return flag;

}

public static boolean downauthe(String username, String data, int dept_code,int design_code)
{
	System.out.println("hashcod eis >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+data);
	boolean flag=false;
	try
	{
		

		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		String	sql="select * from m_user where username='"+username+"' and u_hashcode='"+data+"' and dept_code='"+dept_code+"' and design_code='"+design_code+"'";
		System.out.println("sanu sql is >>>>>>>>>>>"+sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			flag=true;
		}
		System.out.println("data authentication : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in AdminrDAO-->checkAdmin(String admin,String pass): "+ e);
	}
	return flag;

}

public static ResultSet getrechargeDetails() 
{
	String sql="";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql="select * from m_recharge";
		System.out.println("******* Server Info *********\n");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-getServerDetails(): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean checkVouchercode(String code) 
{
	boolean flag=false;
	String sql = "";
	
	try
	{
        
        Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "select * from m_recharge where r_code='"+code+"'";
		System.out.println("******* Check Voucher Code Existence *********\n");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			flag=true;
		}
		System.out.println("Check Server Existence Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-checkServerHostExistence : ");
		e.printStackTrace();
	}
	return flag;
}

public static boolean addRechargeDetails(String code, String cost) 
{
	boolean flag=false;
	try
	{
		 Connection con=null;
			con=(Connection) ServerConnector.ServerConnector();
			Statement st=(Statement) con.createStatement();

		int i=st.executeUpdate("insert into m_recharge (r_code,r_cost,r_status)values('"+code+"','"+cost+"','Valid')");
		if(i!=0)
		{
			flag=true;
		}
//		System.out.println("Add Recharge status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Exception in UserProcess-->addRecharge(String code,String cost): "+ e);
	}
	return flag;
}

public static boolean deleterechargeDetails(int id) 
{
	boolean flag=false;
	String sql = "";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "delete from m_recharge where r_id='"+id+"'";
		System.out.println("******* Delete recharge Details Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Delete Server Details Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in deleterechargeDetails(int serverId) :" );
		e.printStackTrace();
	}
	return flag;
	
}

public static ResultSet getConfigDetails()
{
	String sql="";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql="select * from m_spconfig";
		System.out.println("******* Server Info *********\n");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-getServerDetails(): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static boolean editConfigDetails(String[] s) 
{
	boolean flag=false;
	String sql = "";
	String url = "";
	try
	{   
		
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql = "update m_spconfig set s_size='"+s[1]+"',s_cost='"+s[2]+"',s_qty='"+s[3]+"',s_status='"+s[4]+"' where s_code='"+s[0]+"'";
		System.out.println("******* Edit Server Details Info *********\n");
		System.out.println(sql);
		int i=st.executeUpdate(sql);
		if(i!=0)
		{
			flag=true;
		}
		System.out.println("Admin Edit Server Details Status : "+flag);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in AdminDAO-editServerDetails(String [] s)  :");
		e.printStackTrace();
	}
	return flag;
	
}

public static ResultSet getConfigDetails(int serverId)
{
	String sql="";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql="select * from m_spconfig where s_code='"+serverId+"'";
		System.out.println("******* Get Specific Server Info *********\n");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-getServerSpecificDetails(int serverId): ");
		e.printStackTrace();
	}
	return resultSet;
}

public static String geturl(int url)
{
	String sql="";
	String name="";
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		sql="select c_ip from m_cloud where c_id='"+url+"'";
		System.out.println("******* Server Info *********\n");
		System.out.println(sql);
		resultSet = (ResultSet) st.executeQuery(sql);
		while(resultSet.next())
		{
			name=resultSet.getString(1);
		}
	}
	catch(Exception e)
	{
		System.out.println("Opp's Error is in UserDAO-getServerDetails(): ");
		e.printStackTrace();
	}
	return name;
}

public static ResultSet getNewDataOwners()
{
	try
	{
		Connection con=null;
		con=(Connection) ServerConnector.ServerConnector();
		Statement st=(Statement) con.createStatement();
		resultSet = (ResultSet) st.executeQuery("select * from m_dataowner");
		System.out.println(resultSet);
	}
	catch(Exception e)
	{
		System.out.println("Exception in adminDAO-->getDataOwners(): ");
		e.printStackTrace();
	}
	return resultSet;
}


}
