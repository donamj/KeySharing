/*
 * This is a class created for the storage of shares
 * It is the format to store a share
 * Each share will have the share itself and an id to recognize the share
 */
package com.keysharing;

import java.math.BigInteger;

public class Share
{
	public Share(int i, BigInteger sum) 
	{
		this.id = i;
		this.share = sum;
	}
	public Share() {
		// TODO Auto-generated constructor stub
	}
	int id;
	BigInteger share;
	
	//Function to print the share details
	public void printShare()
	{
		System.out.println("SecretShare [num=" + id + ", share=" + share + "]");
	}
	
}
