/**
 @Author : Munna Kumar Singh
 Date : Aug 31, 2012
 File : RSA_File_EncryptionDecryption.java
 Package : com.util
*/
package com.util;
//RSA_File_EncryptionDecryption 

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.sql.SQLException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


import com.dao.AdminDAO;
import com.util.SerializeToDatabase;

public class RSA_File_EncryptionDecryption  
{
protected static final String ALGORITHM = "RSA";
static PrivateKey privKey;
static PublicKey pubKey;
/* public static KeyPair generateKey() throws NoSuchAlgorithmException
{
	KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
	keyGen.initialize(1024);
	KeyPair key = keyGen.generateKeyPair();
	return key;
}
*/

/* Saving The Key In The DB */
public static boolean generateRSAKey(String publicKeyFilePath,String privateKeyFilePath)
{
	    boolean flag = false;
	    String date = "";
	    int totalNumberOfClouds =0;
	   
	   
	    try 
	    {
	    	KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(1024);
			KeyPair keyPair = kpg.generateKeyPair();
			PrivateKey privKey = keyPair.getPrivate();
			PublicKey pubKey = keyPair.getPublic();
			
			/* Storing the keyPair objects(public key and private key) in DB (Starts)*/
			  
			 totalNumberOfClouds = AdminDAO.getTotalNumberOfClouds();
			 date = Utility.getDate();
			 
			 /* Getting DES Secrete Key (Starts) [for DES File Encryption and Decryption Purpose ]*/
			 SecretKey key = KeyGenerator.getInstance("DES").generateKey();
			 /* Getting DES Secrete Key (Ends) */
			 SerializeToDatabase.serializeJavaObjectToDB(date,pubKey,privKey,key,totalNumberOfClouds);
			 
			
			
			 /* Storing the keyPair objects(public key and private key) in DB (Ends)*/
			 
			 /* Storing the keyPair objects(public key and private key) in Text File (Starts)*/
			       SaveKeyToFile(pubKey,publicKeyFilePath,privKey,privateKeyFilePath);
			 /* Storing the keyPair objects(public key and private key) in Text File (Ends)*/
			       
			flag = true;     
			  
			System.out.println("******** RSA Key Info *************");
			System.out.println("Private Key : \n"+privKey);
			System.out.println(" Public Key : \n"+pubKey);
			
			System.out.println("RSA Key Generated Sucessfully.....");
			
		}
	    catch (Exception e)
	    {
			System.out.println("Opps Exception in RSA_File_EncNdecr-generateRSAKey():");
	    	e.printStackTrace();
		}
	    
	return flag;
}

/* Saving The Key In The Text File */
public static boolean SaveKeyToFile(PublicKey publicKey,String publicKeyfilePath,PrivateKey privateKey,String privateKeyFilePath)
{
	boolean flag = false;
	
    try
    {
    	/* Write Object in file */
		
		FileOutputStream fos = new FileOutputStream(publicKeyfilePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(publicKey);
        oos.flush();
        oos.close();
        
        FileOutputStream fos1 = new FileOutputStream(privateKeyFilePath);
        ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
        oos1.writeObject(privateKey);
        oos1.flush();
        oos1.close();
        
      /*  
	      //Reading Object From File(Starts) 
	    	
	    	FileInputStream fis1 = new FileInputStream("C:/publicKey.txt");
	        ObjectInputStream ois1 = new ObjectInputStream(fis1);
	        PublicKey pubKey = (PublicKey) ois1.readObject();
	    
	     //Reading Object From File(Ends)
      */
	} 
    catch (Exception e) 
    {
		System.out.println("Opps,Exception in RSA_File_EncryptionDecryption-SaveKeyToFile()");
		e.printStackTrace();
	}
	
	return flag;
	
}

/* Reading Key From File(Starts) */

public static PublicKey readPublicKey(String publicKeyFilePath)
{
	PublicKey publicKey = null;
	
	try 
	{
		FileInputStream fis = new FileInputStream(publicKeyFilePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        publicKey = (PublicKey) ois.readObject();
	} catch (Exception e) 
	{
		System.out.println("Opps,Exception in RSA_File_EncryptionDecryption-readPublicKey()");
		e.printStackTrace();
	}
	
	return publicKey;
}

/* Reading Key From File(Ends) */

/* Reading Key From File(Starts) */

public static PrivateKey readPrivateKey(String privateKeyFilePath)
{
	PrivateKey privateKey = null;
	
	try 
	{
		FileInputStream fis = new FileInputStream(privateKeyFilePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        privateKey = (PrivateKey) ois.readObject();
	} catch (Exception e) 
	{
		System.out.println("Opps,Exception in RSA_File_EncryptionDecryption-readPrivateKey");
		e.printStackTrace();
	}
	
	return privateKey;
}

/* Reading Key From File(Ends) */

public static void encryptFile(String srcFileName, String destFileName, PublicKey key) throws Exception
{
	encryptDecryptFile(srcFileName,destFileName, key, Cipher.ENCRYPT_MODE);
}
/**
* Decrypt file using 1024 RSA encryption
*
* @param srcFileName Source file name
* @param destFileName Destination file name
* @param key The key. For encryption this is the Private Key and for decryption this is the public key
* @param cipherMode Cipher Mode
* @throws Exception
*/

public static void decryptFile(String srcFileName, String destFileName, PrivateKey key) throws Exception
{
	encryptDecryptFile(srcFileName,destFileName, key, Cipher.DECRYPT_MODE);
}
/**
* Encrypt and Decrypt files using 1024 RSA encryption
*
* @param srcFileName Source file name
* @param destFileName Destination file name
* @param key The key. For encryption this is the Private Key and for decryption this is the public key
* @param cipherMode Cipher Mode
* @throws Exception
*/

public static void encryptDecryptFile(String srcFileName, String destFileName, Key key, int cipherMode) throws Exception
{
	OutputStream outputWriter = null;
	InputStream inputReader = null;
	System.out.println("srcFileName ----- "+srcFileName);
	System.out.println("destFileName ----- "+destFileName);
	try
	{
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		String textLine = null;
		
		byte[] buf = cipherMode == Cipher.ENCRYPT_MODE? new byte[100] : new byte[128];
		int bufl;
		// init the Cipher object for Encryption...
		cipher.init(cipherMode, key);
		
		// start FileIO
		outputWriter = new FileOutputStream(destFileName);
		inputReader = new FileInputStream(srcFileName);
		while ( (bufl = inputReader.read(buf)) != -1)
		{
			System.out.println("Hi,Mr. Kumar");
			byte[] encText = null;
			if (cipherMode == Cipher.ENCRYPT_MODE)
				encText = encrypt(copyBytes(buf,bufl),(PublicKey)key);
			else
				encText = decrypt(copyBytes(buf,bufl),(PrivateKey)key);
			System.out.println("encText ----------- "+encText);
			outputWriter.write(encText);
		}
		outputWriter.flush();
	}
	catch (Exception e)
	{
		throw e;
	}
	finally
	{
		try
		{
			if (outputWriter != null)
				outputWriter.close();
			if (inputReader != null)
				inputReader.close();
		}
		catch (Exception e)
		{} 
	}
}
public static byte[] copyBytes(byte[] arr, int length)
{
	byte[] newArr = null;
	if (arr.length == length)
		newArr = arr;
	else
	{
		newArr = new byte[length];
		for (int i = 0; i < length; i++)
		{
			newArr[i] = (byte) arr[i];
		}
	}
	System.out.println("newArr -- "+new String(newArr));
	return newArr;
}
public static byte[] encrypt(byte[] text, PublicKey key) throws Exception
{
	byte[] cipherText = null;
	try
	{
		// get an RSA cipher object and print the provider
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		
		// encrypt the plaintext using the public key
		cipher.init(Cipher.ENCRYPT_MODE, key );
		cipherText = cipher.doFinal(text);
	}
	catch (Exception e)
	{
		throw e;
	}
	return cipherText;
}
public static byte[] decrypt(byte[] text, PrivateKey key) throws Exception
{
	byte[] dectyptedText = null;
	try
	{
		// decrypt the text using the private key
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.DECRYPT_MODE, key);
		try {
			dectyptedText = cipher.doFinal(text);
		} catch (Exception e) {
			System.out.println("Exception ======== "+e);
			e.printStackTrace();
		}
		
		System.out.println("dectyptedText ----------- "+dectyptedText);
	}
	catch (Exception e)
	{
		throw e;
	}
	return dectyptedText;
}

/* Testing The Developement */

public static void main(String args[]) throws NoSuchProviderException, SQLException, IOException, ClassNotFoundException
{
	String userName = "kumar";
	String srcFileName = "C:\\RSA\\b.txt";
	String destFileName = "C:\\RSA\\c.txt";
	try {
	KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
	SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
	keyGen.initialize(1024, random);
	//keyGen.initialize(1024);
	//KeyPair key = keyGen.generateKeyPair();
	KeyPair key = null;
	/* Getting the keyPair object from DB (Starts)*/
	   	//key = (KeyPair) SerializeToDatabase.deSerializeJavaObjectFromDB(userName);
	/* Getting the keyPair object from DB (Ends)*/
	privKey = key.getPrivate(); 
	pubKey = key.getPublic();
	} 
	catch (NoSuchAlgorithmException nsae){}
	try{
		System.out.println("in try block of main");
	//encryptFile(srcFileName, destFileName, pubKey);
	decryptFile(srcFileName,destFileName,privKey);
	}catch (Exception e){
}
	} 
}
