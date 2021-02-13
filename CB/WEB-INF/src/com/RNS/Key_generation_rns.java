package com.RNS;

import java.math.BigInteger;

import com.dao.AdminDAO;



import sun.security.util.BigInt;



public class Key_generation_rns 
{
public static 	boolean flag=false;
	static BigInteger m1;
	static  BigInteger m2;
	static String RNSkey;
	static BigInteger M = new BigInteger("1", 10);
	static BigInteger a1;
	static BigInteger a2;
	static BigInteger one = new BigInteger("1", 10);
	static BigInteger t1;
	static BigInteger t2;
	

	public static boolean Generation(int id) throws ClassNotFoundException
	{
		System.out.println("id is >>>>>>>>>>>>>>>>>>"+id);
		Random_Values r = new Random_Values();
		m1 = r.KeyValue();
		m2= r.KeyValue();
		System.out.println("----m1----m2"+m1+m2);
		RNSkey=""+m1+"~"+m2;

		
		flag = AdminDAO.addrnskey(id,m1.toString(),m2.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		return flag;
		
	}
	
	
}
