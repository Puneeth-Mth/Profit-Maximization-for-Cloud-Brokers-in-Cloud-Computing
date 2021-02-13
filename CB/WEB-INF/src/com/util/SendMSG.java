package com.util;
/**
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SendMSG
{
	
    public SendMSG()
	    {
	    }

	    public static boolean sendSMS(String mobilenumber, String message)
	    {
	        boolean flag = true;
	        try
	        {
	            String postData = "";
	            String retval = "";
	            String User = "dhs";
	            String passwd = "niki1011";
	            String sid = "dhs";
	            String mtype = "N";
	            String DR = "Y";
	            postData = (new StringBuilder(String.valueOf(postData))).append("User=").append(URLEncoder.encode(User, "UTF-8")).append("&passwd=").append(passwd).append("&mobilenumber=").append(mobilenumber).append("&message=").append(URLEncoder.encode(message, "UTF-8")).append("&sid=").append(sid).append("&mtype=").append(mtype).append("&DR=").append(DR).toString();
	            URL url = new URL("http://smscountry.com/SMSCwebservice.asp");
	            HttpURLConnection urlconnection = (HttpURLConnection)url.openConnection();
	            urlconnection.setRequestMethod("POST");
	            urlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	            urlconnection.setDoOutput(true);
	            OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());
	            out.write(postData);
	            out.close();
	            BufferedReader in = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
	            String odedString;
	            while((odedString = in.readLine()) != null) 
	                retval = (new StringBuilder(String.valueOf(retval))).append(odedString).toString();
	            in.close();
	            System.out.println(retval);
	        }
	        catch(Exception e)
	        {
	            System.out.println(e);
	            flag = false;
	        }
	        return flag;
	    }
	    public static void main(String ad[])
	    {
	    	SendMSG.sendSMS("7204612360", "This is testing Message from Admin............");
	    }
	}

