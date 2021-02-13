/**
 * 
 */
package com.action.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import com.FPgrowth.AlgoFPGrowth;
import com.FPgrowth.Test;
import com.Fidoop.DAOFactory.PoolingDAO;

import com.util.Utility;



public class ReadFileFromHadoop extends HttpServlet 
{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		try
		{
			String submit=request.getParameter("submit");
			//String name=request.getParameter("name");
			System.out.println("submit---"+submit);
			//System.out.println("name----"+name);
			boolean result=false;
		
			RequestDispatcher rd=null;
			 if(submit.equals("get"))
			{
				  
				rd=request.getRequestDispatcher("/Files/JSP/User/recievefromhadoop.jsp");
				rd.forward(request, response);
			}
			 if(submit.equals("fetch"))
				{
				 
				int noofrecords=Integer.parseInt(request.getParameter("noofrecords"));
				 double support=Double.parseDouble(request.getParameter("support"));
				 
				 int counter=0;
				 int counter2=0;
				 System.out.println("=====counter========"+counter);
				 System.out.println("=====noofrecords========"+noofrecords);
				 System.out.println("=====support========"+support);
				 
				 String filePath = request.getRealPath("") + "/" + "config.properties";
					
					filePath = request.getRealPath("") + "/" + "config.properties";
					System.out.println("fielpath is download >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+filePath);
					FileInputStream fileInputStream = new FileInputStream(new File(
							filePath));
					Properties properties = new Properties();
					properties.load(fileInputStream);

					Configuration conf = new Configuration();
					conf.addResource(new Path(properties.getProperty("hadoopLoc")));
					FileSystem fs = FileSystem.get(conf);
					Path pt = new Path(properties.getProperty("hdfsLoc")+"/test1.txt");

					//===================================
					 FSDataInputStream in = fs.open(pt);
					 FSDataInputStream in2 = fs.open(pt);

					    BufferedReader br = new BufferedReader(new InputStreamReader(in));
					    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
					    String line = null;
					    while((line = br2.readLine())!= null)
					    {
					    	
					    	
					    	counter2++;
					        
					    }
					    if(noofrecords>counter2)
						{
							rd=request.getRequestDispatcher("/Files/JSP/User/recievefromhadoop.jsp?no=1");
							rd.forward(request, response);	
						}
					    else
					    {
					    	boolean flag=PoolingDAO.truncatembill();
					    	
					    while((line = br.readLine())!= null)
					    {
					    	
					    	if(counter<noofrecords)
					    	{
					    		System.out.println(counter+"===="+line);
					    		String arr[]=line.split("~~");
					    		boolean flag1=PoolingDAO.insert_to_mbill(arr[0].trim(),arr[1].trim(),arr[2].trim(),arr[3].trim()); 
					    		
					    		
					    	}
					    	
					    	
					    	counter++;
					        
					    }
					    
					    HashMap<Integer, ArrayList<String>> map_tclaim=new HashMap<Integer, ArrayList<String>>();
			         	map_tclaim=PoolingDAO.getItemCodes();
			         	
			         	File f=new File(request.getRealPath("") +"/"+"freset.txt");
				           if(f.exists())
				           {
				        	  f.delete();
				           }
				           if(!f.exists())
				           {
				        	  f.createNewFile(); 
				           }
				          
				           StringBuffer sb=new StringBuffer();
			         	if(map_tclaim.size()>0)
			           	{
			            	  
			               for(Map.Entry m4:map_tclaim.entrySet())  
			               {
			             	  m4.getKey();
			             	  String values = m4.getValue().toString();

			             	  String first=values.replace("[", "").replace("]", "");
			             	 String a[]=first.split("~~");
			             	
			            
			            
			            String item=a[2].trim();
			            
			            String item2=item.replaceAll("-", " ");
			            
			            String item3=Test.countWords(item2);
			            sb.append(item3);
			            sb.append(System.getProperty("line.separator"));
			            
			            System.out.println("===============item================="+item);
			            
			            
			            
			            
			            
			           
			            
			            
			          
			            
			           
			           
                   	 
			            
			          
			             }
			           	}
			         	
			         	
			         	String mm=sb.toString();
			         	BufferedWriter writer = null;
			         	try
			         	{
			         	    writer = new BufferedWriter( new FileWriter(request.getRealPath("") +"/"+"freset.txt"));
			         	    writer.write(mm);

			         	}
			         	catch ( IOException e)
			         	{
			         	}
			         	finally
			         	{
			         	    try
			         	    {
			         	        if ( writer != null)
			         	        writer.close( );
			         	    }
			         	    catch ( IOException e)
			         	    {
			         	    }
			         	}
			         	
			         	
			         	
			         	
			         	
			         	
			         	
			         	
			         	
			         	
			         	 
			         	
			         	System.out.println("========MMMM=========="+mm);
			         	FileOutputStream fos=new FileOutputStream(f);
			         	byte[] contentInBytes =mm.getBytes();
			         	fos.write(contentInBytes );
			         	fos.flush();
			         	fos.close();
				          
					    
					   // String startTimestamp1=Utility.getTime();
		         	 long startTimestamp;
			     		long endTimestamp = 0;
			     		startTimestamp = System.currentTimeMillis();
			     	//	double min=0.6;
					   
					    AlgoFPGrowth algo = new AlgoFPGrowth();
						//algo.runAlgorithm(request.getRealPath("") +"/"+"freset.txt",request.getRealPath("") +"/"+"fresetout.txt",min); 
						algo.runAlgorithm(request.getRealPath("") +"/"+"freset.txt",request.getRealPath("") +"/"+"fresetout.txt",support); 
					    
						try
						{
						    Thread.sleep(100000);
						    endTimestamp = System.currentTimeMillis();
						}
						catch(InterruptedException ex)
						{
						    Thread.currentThread().interrupt();
						}
						
						 
							algo.printStats();
						   float tottime=endTimestamp-startTimestamp;
						   tottime=tottime/1000;
						   
					    
						   boolean flag77=PoolingDAO.insertom_graph_data("FP-Growth",noofrecords,support,tottime);
						   
						   
						   
						   
					    rd=request.getRequestDispatcher("/Files/JSP/User/viewalgo.jsp");
						rd.forward(request, response);
					    
					    }
					   
					    
			//	 System.out.println("=============Counter 2==========="+counter2);
				 
					
					
				}
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User UploadFile Servlet......"+e);
			out.println("Opps's Error is in User UploadFile Servlet......"+e);
		}
	}
}
