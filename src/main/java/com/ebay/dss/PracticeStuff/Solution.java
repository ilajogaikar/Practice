package com.ebay.dss.PracticeStuff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
    * Choosing a lunch spot is always a pain, but luckily we have you to
    * help out. 2 friends, Darwin and Hammy, want to find a lunch spot and
    * both of them have a list of favorite places ordered by decreasing
    * preference. They agree that they will select the restaurant with the
    * least combined rank in the 2 lists.
    * Example:
    * Input:
    *     restaurants_1: ['El Farolito', 'Japa Curry', 'Eatsa']
    *     restaurants_2: ['Japa Curry', 'Eatsa', 'Ayola', 'Working Girls']
    * Output:
    *     'Japa Curry'. Because it has the least combined rank  of 3
    *     (2 in restaurants_1 and 1 in restaurants_2).
    * The selected restaurant should be in both the lists.
    * The input provided will not have 2 restaurants with the same combined rank. So you don't have to factor that in.
    * Darwin and Hammy will eat a 'Yelpwich' if there are no common favorite restaurants.
    * Input:
    *     restaurants_1: ['El Farolito', 'Japa Curry']
    *     restaurants_2: ['Ayola', 'Working Girls']
    * Output:
    *     'Yelpwich'
    * @param resautants_1 List<String>
    * @param resautants_2 List<String>
    * @return String
    */
	public static String favoriteRestaurant(List<String> restaurants_1, List<String> restaurants_2) {
	    //TODO: COMPLETE ME
	      List<String> restaurants_compare = new ArrayList<String>(restaurants_1);
	      
	       if(restaurants_1.size() >= restaurants_2.size()){
	           if(!restaurants_1.containsAll(restaurants_2)){
	        	   return "Yelpwich";
	           }
               else{
                   restaurants_compare.retainAll(restaurants_2);
                   System.out.println(restaurants_compare);
               }
	           }else if(restaurants_2.size() > restaurants_1.size()){
	        	   if(!restaurants_2.containsAll(restaurants_1)){
	        	   return "Yelpwich";
	        	   }
	           }else{
	        	   
	           }
	       
	      return "0";
	  }

  


  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<String> restaurants_1 = new ArrayList<String>();
    restaurants_1.add("A");
    restaurants_1.add("B");
    restaurants_1.add("C");
    List<String> restaurants_2 = new ArrayList<String>();
    restaurants_2.add("D");
    restaurants_2.add("E");
    restaurants_2.add("B");
    System.out.println(favoriteRestaurant(restaurants_1, restaurants_2));
  }
}
