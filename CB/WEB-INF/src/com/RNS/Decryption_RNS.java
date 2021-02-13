package com.RNS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;



public class Decryption_RNS 
{
	static int r1=0;
	  static int r2=0;
	  static int r3=0;
	  public static boolean decryptMessage(String val,String key1,String key2,String dest) throws IOException
		{
			 int i;
		        String t_val = val.substring(0, val.length()-1);
		     
		     
		        String[] s = t_val.split("#");
		        System.out.println("  S length :"+s.length);
		        
		        byte[] va = new byte[s.length];

		        int cc;

		        for (i = 0; i < s.length; i++)
		        {
	                 cc = Decrypt(s[i],key1,key2);
		             va[i] =( byte) cc;
		        }
		    	
		        try
				{ 
		        	
					FileOutputStream fileOut1 = new FileOutputStream(dest);
					fileOut1.write(va);
					fileOut1.flush();
					fileOut1.close();
					
				}
				catch(Exception e)
				{
					System.out.println("Opp's error is in Utility getPro(String str) "+e);
				}
		       
		     return true;
		}
	
	public static Integer Decrypt(String a,String key1,String key2)
	  {
		  String n[]=a.split("_");
		
		  r1=Integer.parseInt(n[0]);
		  r2=Integer.parseInt(n[1]);
		  int m1=Integer.parseInt(key1);
		  int m2=Integer.parseInt(key2);
		  int N=m1*m2;
		  int A1=N/m1;
		  int A2=N/m2;
		  int t1=0;
		  int t2=0;
		  for (int i = 0; i<i+1; i++)
        {
           int t=i;
            if ((A1*(t))%(m1) == 1) 
            {
              t1 = t;
            
              break;
            }
        }
     
        for (int i = 0; i<i+1; i++)
        {
           int t=i;
            if ((A2*(t))%(m2) == 1) 
            {
             t2 = t;
            
              break;
            }
        }
        
        System.out.println("00000000000"+A1+" "+t1+" "+r1+" "+A2+" "+t2+" "+r2);
        int e=(A1*t1*r1)+(A2*t2*r2);
        System.out.println("00000000000"+e);
		  int e1=e%N;
		  
		  System.out.println("00000000000"+e1);
		  
		return e1;
		  
	  }
	
	
public static void main(String[] args)
{
		
}

}
