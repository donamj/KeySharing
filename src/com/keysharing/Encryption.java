/*
 * The class Encryption has all the necessary function to perform AES-128 encryption.
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


public class Encryption 
{
    private String plaintext; //Data to be encrypted
    private String ciphertext; //Encrypted text
    private String password; //Key from user
    private SecretKeySpec key; //128 bit key
    
    // Function to convert key to 128 bit format
    public void keyGeneration() throws InvalidKeySpecException, NoSuchAlgorithmException
    {
    	SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec x = new PBEKeySpec(password.toCharArray(), new byte[16], 65536, 128);
        SecretKey secretkey = factory.generateSecret(x);

        key = new SecretKeySpec(secretkey.getEncoded(), "AES");
      
    }
    
    //Performs encryption
    public void encrypt() throws Exception 
	{
    	keyGeneration();
		Cipher cipher = Cipher.getInstance("AES");
		// Initalizes cipher instance to encrypt mode
		cipher.init(Cipher.ENCRYPT_MODE, key);
		// Converts plain text in string format to  byte array
		byte[] encryptedByte = cipher.doFinal(plaintext.getBytes());
		// Performs encryption operation and converts cipher text in byte form to string 
		ciphertext = Base64.getEncoder().encodeToString(encryptedByte);
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
