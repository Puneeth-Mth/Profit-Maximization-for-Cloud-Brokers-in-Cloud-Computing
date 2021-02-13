package com.dna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.util.GetDNAProperty;


public class dnaStream {
	
	public int getNum (String cmp) {
		int n;
		
		String ds[] = new String[21];
		
		
		String DNA_Key=GetDNAProperty.getProperty("DNAKey");
		
		int j=1;
		
		int i=0;
		for( j=1; j<=16; j++)
		{
			ds[j] = DNA_Key.substring(i, i+2);
			
			i=i+2;
			//System.out.println("<<<<<<<ds>>>>>"+ds[j]);
			
		
		}
	for (n = 1; n < 20; n++)
	{
	if (ds[n].equals(cmp))
	{
		//System.out.println("test a>>>>>>>>>>> :" + ds[n]);
	    //System.out.println("test n >>>>>>>>>>>:" + n);
		break;
	}
	 }
	
	return n;
	}

	public String getSeq(int inV) {
		
		
		// DNA Sequence Key
		// AAACAGATCACCCGCTGAGCGGGTTATCTGTT
		String ds[] = new String[21];
		
		String DNA_Key=GetDNAProperty.getProperty("DNAKey");
		int j=1;
		
		int i=0;
		for( j=1; j<=16; j++)
		{
			ds[j] = DNA_Key.substring(i, i+2);
			
			i=i+2;
			//System.out.println("<<<<<<<ds>>>>>"+ds[j]);
			
		
		}
		
				
	return ds[inV];
	}
	public String DNA_Encrypt_Call(String by) {
		
		//System.out.println("Byte: " + by);
		                             
		 String a[] = new String[4];
		
		 // Phase 1
		a[0]=(by.substring(0, 2));
		a[1]=(by.substring(2, 4));
		a[2]=(by.substring(4, 6));
		a[3]=(by.substring(6, 8));

		String x = "";
		 for (int i = 0; i<=3; i++)
   		{   
		       if (a[i].equals("00")) 
			{ 
			x = x + "A";
 			}

		     else if (a[i].equals("01")) 
			{
			 x = x + "T";
			}
		    else if (a[i].equals("10"))
			{
			 x = x + "C";
			}
		     else if (a[i].equals("11"))
			 {
			 x = x + "G";
			}
		}
		//System.out.println("Output Phase 1 :" + x);
		
		//Phase 2
		String y = "";
		for (int i = 0; i<=3; i++)
   		{   
			String k = x.substring(i, i+1);
			
			if (k.equals("A")) 
			{ 
			y = y + "C";
 			}

		     else if (k.equals("C")) 
			{
			 y = y + "G";
			}
		    else if (k.equals("G"))
			{
			 y = y + "T";
			}
		     else if (k.equals("T"))
			 {
			 y = y + "A";
			}
		}
		//System.out.println("Output Phase 2:" + y);
		
		// Phase 3
		dnaStream xx  = new dnaStream();
		
		/*System.out.println("First 2:" + y.substring(0, 2));
		System.out.println("Second 2:" + y.substring(2, 4));
		
		System.out.println("Output 1 :" + xx.getNum(y.substring(0, 2)));
		System.out.println("Output 2 :" + xx.getNum(y.substring(2, 4)));
	*/
		String rr = "";
		
		int a1,b1;
		a1 = xx.getNum(y.substring(0, 2));
		b1 = xx.getNum(y.substring(2, 4));
		
		if (a1 <= 9)
		{  rr = "0" + Integer.toString(a1); }
		else
		{  rr =  Integer.toString(a1); }
		
		if (b1 <= 9)
		{  rr = rr + "0" + Integer.toString(b1); }
		else
		{  rr =  rr +  Integer.toString(b1); }
		
		return  rr;
	
	}
	
	
public int DNA_Decrypt_Call(char[]x) {
		
		System.out.println("1: " + x[0]);
		System.out.println("2: " + x[1]);
		System.out.println("3: " + x[2]);
		System.out.println("4: " + x[3]);
		
		String t ="";
		
		t = String.valueOf(x);
			
		String a ="";
		String b="";
		
		a = (t.substring(0, 2));
		b = (t.substring(2, 4));
		System.out.println("a--> " + Integer.valueOf(a));
		System.out.println("b--> " + Integer.valueOf(b));
		
		dnaStream xx  = new dnaStream();
		
		System.out.println("a--> " + xx.getSeq(Integer.valueOf(a)));
		System.out.println("b--> " + xx.getSeq(Integer.valueOf(b)));
		
		a = xx.getSeq(Integer.valueOf(a));
		b = xx.getSeq(Integer.valueOf(b));
		
		  
		  
		  String c = a+b;
		  String y ="";
		  
		  for (int i = 0; i<=3; i++)
	   		{   
				String k = c.substring(i, i+1);
				
				if (k.equals("C")) 
				{ 
				y = y + "A";
	 			}

			     else if (k.equals("G")) 
				{
				 y = y + "C";
				}
			    else if (k.equals("T"))
				{
				 y = y + "G";
				}
			     else if (k.equals("A"))
				 {
				 y = y + "T";
				}
			}
		  System.out.println("Y--> " + y);
		  
		  String zBinary = "";  
		  for (int i = 0; i<=3; i++)
	   		{   
				String k = y.substring(i, i+1);
				
				if (k.equals("A")) 
				{ 
				zBinary = zBinary + "00";
	 			}

			     else if (k.equals("T")) 
				{
			    	 zBinary = zBinary + "01";
				}
			    else if (k.equals("C"))
				{
			    	zBinary = zBinary + "10";
				}
			     else if (k.equals("G"))
				 {
			    	 zBinary = zBinary + "11";
				}
			}
		  System.out.println("zBinary --> " + zBinary);
		  
		
		  String zz1 = xx.BinaryToHex(zBinary);
		  System.out.println("zBinary Byte --> " + xx.BinaryToHex(zBinary));
		 
		  String zz2 = xx.convertHexToString(zz1);
		  int j;
		  j = Binary2ASCII(zBinary);
		  System.out.println("ASCII : " + j);
		  
		  //******************
		  
		  //System.out.println("Byte : " + Byte.valueOf(zBinary));
		  //byte xb;
		  //xb = Byte.valueOf(zBinary);
		  
		return j;
		
	
	}

public String convertStringToHex(String str){
	 
	  char[] chars = str.toCharArray();

	  StringBuffer hex = new StringBuffer();
	  for(int i = 0; i < chars.length; i++){
	    hex.append(Integer.toHexString((int)chars[i]));
	  }

	  return hex.toString();
}

public String convertHexToString(String hex){

	  StringBuilder sb = new StringBuilder();
	  StringBuilder temp = new StringBuilder();

	  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
	  for( int i=0; i<hex.length()-1; i+=2 ){

	      //grab the hex in pairs
	      String output = hex.substring(i, (i + 2));
	      //convert hex to decimal
	      int decimal = Integer.parseInt(output, 16);
	      //convert the decimal to character
	      sb.append((char)decimal);

	      temp.append(decimal);
	  }
	  System.out.println("Decimal : " + temp.toString());

	  return sb.toString();
}

public String BinaryToHex(String hex){
	  
	  System.out.println("Enter the Binary number:");
	  
	  long num = Long.parseLong(hex);
	  long rem;
	  while(num > 0){
	  rem = num % 10;
	  num = num / 10;
	  if(rem != 0 && rem != 1){
	  System.out.println("This is not a binary number.");
	  System.out.println("Please try once again.");
	  System.exit(0);
	  }
	  }
	  int i= Integer.parseInt(hex,2);
	  String hexString = Integer.toHexString(i);
	  System.out.println("Hexa decimal: " + hexString);
	  return hexString;
	  }


public static int Binary2ASCII(String str) {
	  long num = Long.parseLong(str);
	  long rem;
	  while(num > 0){
	  rem = num % 10;
	  num = num / 10;
	  if(rem != 0 && rem != 1){
	  System.out.println("This is not a binary number.");
	  System.out.println("Please try once again.");
	  System.exit(0);
	  }
	  }
	  int i= Integer.parseInt(str,2);
	  System.out.println("Decimal:="+ i);
	  return i;
	  }
      

}
