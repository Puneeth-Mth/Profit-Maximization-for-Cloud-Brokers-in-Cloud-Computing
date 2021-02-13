/**
 @Author : Munna Kumar Singh
 Date : Aug 8, 2012
 File : DesFileEncrypter_Decrypter.java
 Package : com.kumar
*/
package com.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DesFileEncrypter_Decrypter 
{
    //byte[] buf = new byte[1024];
    byte[] buf = new byte[2048];
    Cipher ecipher;
    Cipher dcipher;
    
    public DesFileEncrypter_Decrypter(SecretKey key) throws Exception
    {
	    byte[] iv = new byte[] { (byte) 0x8E, 0x12, 0x39, (byte) 0x9C, 0x07, 0x72, 0x6F, 0x5A };
	    AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
	    ecipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
	    dcipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
	
	    ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
	    dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
    }


  public void encrypt(InputStream in, OutputStream out)  throws Exception
  {
	    out = new CipherOutputStream(out, ecipher);
	
	    int numRead = 0;
	    while ((numRead = in.read(buf)) >= 0) 
	    {
	      out.write(buf, 0, numRead);
	    }
	      out.close();
  }

  public void decrypt(InputStream in, OutputStream out)  throws Exception
  {
	    in = new CipherInputStream(in, dcipher);
	
	    int numRead = 0;
	    while ((numRead = in.read(buf)) >= 0) 
	    {
	       out.write(buf, 0, numRead);
	    }
	       out.close();
  }

  /* Testing The Algorithm */
  
  public static void main(String[] argv) throws Exception 
  {
  	
	    SecretKey key = KeyGenerator.getInstance("DES").generateKey();
	    DesFileEncrypter_Decrypter encrypter = new DesFileEncrypter_Decrypter(key);
	    
	    encrypter.encrypt(new FileInputStream("C:\\a.txt"), new FileOutputStream("C:\\b.txt"));
	    encrypter.decrypt(new FileInputStream("C:\\b.txt"), new FileOutputStream("C:\\c.txt"));
	    
	    System.out.println("Encription Decreption Process Done Sucessfully.....");
  }

}


