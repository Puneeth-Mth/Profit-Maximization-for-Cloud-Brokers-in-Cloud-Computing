/**
 @Author :  Menaka
 Date : Nov 19, 2016
 File : GetDNAProperty.java
 Package : com.util
*/
package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class GetDNAProperty {
	public static String getProperty(String str) 
	{
		String pro="";
		try
		{
			java.security.ProtectionDomain pd =	GetDNAProperty.class.getProtectionDomain();
			
			java.security.CodeSource cs = pd.getCodeSource();
			java.net.URL url = cs.getLocation();
			java.io.File f = new File( url.getFile());
			String path=f.getParent();
			Properties property = new Properties();
			FileInputStream in=null;
			in = new FileInputStream(path+"\\dna.properties");
			property.load(in);
			pro=property.getProperty(str);
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's error is in Utility getPro(String str) "+e);
		}
		return pro;
	}


}
