package com.ebay.dss.PracticeStuff;

import java.util.HashSet;

public class IsHappy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Happy or not : " + isHappy(19));
	}
	
	public static boolean isHappy(Integer n){
		HashSet<Integer> sequence = new HashSet<Integer>();
	      while (!sequence.contains(n)) {
	    	  sequence.add(n);
	            n = sumOfSquare(n);
	            if (n == 1) {
	                return true;
	            }
	      }
		if(n==1)
			return true;
		
		 return false;
		
	}
	
	public static Integer sumOfSquare(Integer x){
		if (x==0)
				return 0;
		
		Integer temp = x%10;
		return temp * temp + sumOfSquare(x/10);
		
	}

}
