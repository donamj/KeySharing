/**
 * The class Decryption has all the necessary function to perform AES-128 decryption. 
 */

package com.keysharing;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Decryption 
{
    private String plaintext; //Decrypted text
    private String ciphertext; //Data to be decrypted
    private String password; //Key
    private SecretKeySpec key; //128 bit key
    
    // Function to convert key to 128 bit format
    public void keyGeneration() throws InvalidKeySpecException, NoSuchAlgorithmException
    {
    	SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec x = new PBEKeySpec(password.toCharArray(), new byte[16], 65536, 128);
        SecretKey secretkey = factory.generateSecret(x);

        key = new SecretKeySpec(secretkey.getEncoded(), "AES");
       
    }

    //Performs decryption
    public void decrypt()	throws Exception 
	{
    	keyGeneration();
    	Cipher cipher = Cipher.getInstance("AES");
    	//Converts the dcipehr text from string format to byte array
    	byte[] cipherByte = Base64.getDecoder().decode(ciphertext);
    	//Initialises the cipher instance to decrypt mode
		cipher.init(Cipher.DECRYPT_MODE, key);
		// Decrypt the data and obtain the output in byte array
		byte[] dec = cipher.doFinal(cipherByte);
		plaintext = new String(dec);
		
}
    
    /* Getters and setters for all the variables */
    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SecretKeySpec getKey() {
        return key;
    }

    public void setKey(SecretKeySpec key) {
        this.key = key;
    }
    
}
