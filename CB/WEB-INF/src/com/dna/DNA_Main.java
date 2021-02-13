package com.dna;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class DNA_Main {
	public static int DNA_Encrypt_Main(String inFile, String outFile)throws IOException {

	
    FileInputStream in = null;
    FileWriter out = null;
    
    dnaStream yy  = new dnaStream();
    
    try {
        in = new FileInputStream(inFile);
        out =  new FileWriter(outFile);
        int c;

        while ((c = in.read()) != -1) {
        //System.out.println("Value -->" +c);
            
            
            String by = Integer.toBinaryString(c);
            //System.out.println("Binary -->" +by);
    		for (int i = by.length(); i < 8; i++)  
        	{
    			by = "0" + by;
        	}
    		//System.out.println("Binary Full -->" +by);
    		
    		String xcheck;
    		
    		xcheck =yy.DNA_Encrypt_Call(by);
    		
    		//System.out.println("After Encryption -->" +xcheck);
    		
    		out.write(xcheck);
    		
        }

    } finally {
        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }
    }
    return 1;
}
		
        
    
    public static int DNA_Decrypt_Main(String inFile, String outFile)
    throws IOException {

	dnaStream yy  = new dnaStream();
	
    FileReader inputStream = null;
    FileOutputStream out = null;
    
    

    try {
        inputStream = new FileReader(inFile);
                   
        out = new FileOutputStream(outFile);
        
        

        int c,c1,c2,c3;
        char[]x = new char[4];
        while ((c = inputStream.read(x)) != -1) {
        	
        	System.out.println("*********Character Set ********* ");
        	System.out.println("display " +x[0]);
        	System.out.println("display " +x[1]);
        	System.out.println("display " +x[2]);
        	System.out.println("display " +x[3]);
        	
        	
        	int j;
        	j= yy.DNA_Decrypt_Call(x);
        	
           	out.write((char)j);
           
        }
    } finally {
        if (inputStream != null) {
            inputStream.close();
        }
              
        if (out != null) {
            out.close();
        }
    }
    
    return 1;
}
    
    public static void main(String[] args)
    throws IOException {

	DNA_Main obj1 = new DNA_Main();
	int zValue;
///zValue = obj1.DNA_Encrypt_Main("outpng.png","xhand.dat");
	
zValue= obj1.DNA_Decrypt_Main("privateKey.txt","privateKeyd.txt");
    }
}
