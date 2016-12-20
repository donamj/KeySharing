/*
 *	Class that implements functions to generate the key shares from the key 
 */
package com.keysharing;

import java.math.BigInteger;
import java.util.Random;

public class ShareGenerate {

	public int n; //Total number of users
	public int level; //Security level
	private int threshold; //Thrshold value, k
	private BigInteger password; //Key 
	public Share shares[]; //Generated shares
	private BigInteger primeNo;
	
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

	//Getter and setter of password
	public void setPassword(String pwd)
	{
		password = new BigInteger(pwd);
	}
	
	private BigInteger getPassword() 
	{
		return password;
	}

	//Getter and setter for prime number
	public void setPrimeNo(BigInteger primeNo) {
		this.primeNo = primeNo;
	}

	public BigInteger getPrimeNo() {
		return primeNo;
	}

	//Function to generate share from the key
	public void generateShares()
	{
		setThreshold();
		Random rand = new Random();
		int len = getPassword().bitLength()+1;
		setPrimeNo(new BigInteger(len, 50 , rand)); //Generating the prime number
		BigInteger coefficients[] = new BigInteger[threshold];
		BigInteger temp;
		int i,j;
		//Setting constant term as the key itself
		coefficients[0] = password;
		
		//Choosing the coefficients of the polynomial
		for (i =1;i<threshold;i++)
		{	
			while(true)
			{
				temp = new BigInteger(len,rand);
				if ((temp.compareTo(BigInteger.valueOf(1)) > 0) && (temp.compareTo(getPrimeNo()) < 0))
				{
					coefficients[i] = temp;
					break;
					
				}
				
			}
			
		}
		shares = new Share[n];
		
		//Evaluating the key shares
		for (i=1;i<=n;i++) 
		{
			BigInteger sum = password;
            BigInteger a,b;

            //Generating the key shares by evaluating the polynomial
            for (j=1;j<threshold;j++) 
            {
            	//Evalauting any single term of the polynomial : x^i
                a = BigInteger.valueOf(i).pow(j).mod(getPrimeNo());
                //Mutiplying x term with coefficient
                b = coefficients[j].multiply(a);

                //Adding each of the terms
                sum = sum.add(b).mod(getPrimeNo());
            }
            //Setting the share in the array
            shares[i - 1] = new Share(i, sum);
            
        }
		
	}		
}
