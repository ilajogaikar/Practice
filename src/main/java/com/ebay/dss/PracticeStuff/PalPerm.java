package com.ebay.dss.PracticeStuff;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PalPerm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "tacocot";
		PalPerm PP = new PalPerm();
		PP.checkPalindrome(a);

	}


	public void checkPalindrome(String b){
		HashMap<Character, Integer> pal = new HashMap<Character, Integer>();
		char[] cb = b.toCharArray();
		boolean even = true;
		if(b.length()%2!=0){
			even=false;
		}

		for(int i=0;i<cb.length;i++){
			if(pal.get(cb[i])==null){
				pal.put(cb[i],1);
			}
			else{
				int x= pal.get(cb[i]);
				pal.put(cb[i],++x);
			}
		}



		Iterator<Map.Entry<Character, Integer>> entries = pal.entrySet().iterator();

		if(even==true){
			while(entries.hasNext()){
				Map.Entry<Character, Integer> entry = entries.next();
				if(entry.getValue()%2!=0){
					System.out.println("Not a palindrome");
					return;
				}
				else{
					System.out.println("Yes palindrome");
				}
			}

		}else{
			int checkodd=0;
			while(entries.hasNext()){
				Map.Entry<Character, Integer> entry = entries.next();

				if(entry.getValue()%2!=0){
					if(checkodd==1)
					{
						System.out.println("Not a valid palindrome");
						return;
					}
				
					checkodd++;
				}else{
					if(entry.getValue()%2!=0){
						System.out.println("Not a valid palindrome");
					}
				}
			}


		}


	}

}