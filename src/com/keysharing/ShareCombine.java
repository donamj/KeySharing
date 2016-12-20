/*
 * Class that has functions to regenerate the key from the shares
 * This implements Shamir's secret data regeneration using the computationally efficient 
 * Lagrange's interpolation method
 */
package com.keysharing;

import java.math.BigInteger;

public class ShareCombine 
{
	public int n; //Total number of shares
	public int level; // Security level
	public BigInteger password; //Key
	public Share[] shares; // Stores the available shares
	private int threshold; // Threshold k
	BigInteger primeNo;
	
	/*
	 * Function to calculate the threshold based on the security level
	 * Level 1 : threshold = all the shares
	 * Level 2 : threshold = 75% of the shares
	 * Level 3 : threshold = 50% of the shares
	 */
	public void setThreshold()
	{
		int val;
		switch(level)
		{
			case 1:	val=n;
				break;
			case 2:	val=(int)(.75*n);
				break;
			case 3:	val=(int)(.5*n);
				break;
			default:val=n;
				break;
		}
		threshold = val;
	}
		
	//Function to perform the key regeration operation, from the available  key shares
	public void combineShare()
	{
		setThreshold();
		// Checking whether there is threshold number of key shares available.
		if(shares.length < threshold)
		{
			return;
		}
		int i,j,mval,nval;
		
		BigInteger sum = BigInteger.valueOf(0); //Accumulates the values from keu shares
		for (i=0;i<shares.length;i++)
		{
			BigInteger x = BigInteger.valueOf(1); // Stores the numerator in the equation
			BigInteger y = BigInteger.valueOf(1); // Stores the denominator in the equation
			 
			/* Implements the equation :
			 *  L(0) = ∑ f(x[j])∏(x[m] /(x[m]-x[j])
			 *  where j = 0 to k,
			 *  	  m = 0 to k
			 *  
			 */
			
			for (j=0;j<shares.length;j++) 
			{
                if (i != j) 
                {
                	//Gets the identification number of share
                	mval = shares[i].id; 
                	nval = shares[j].id;
                	//Calculates the numerator and denominator of the equation and limit its to finite field 
                    x = x.multiply((BigInteger.valueOf(-nval))).mod(primeNo);
                    y = y.multiply(BigInteger.valueOf(mval-nval)).mod(primeNo);
                    
                }
               
            }
			BigInteger s = shares[i].share; // Gets the share value
			//Calculates (numerator/denominator0 mod p
			BigInteger z = s.multiply(x).multiply(y.modInverse(primeNo));
			//Accumulates the value at each step
            sum = primeNo.add(sum).add(z).mod(primeNo);
          	
		}
				
		// Sets the password to the value obtained
		password = sum;
		
	}

		
}
