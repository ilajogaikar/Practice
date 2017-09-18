package com.ebay.dss.PracticeStuff;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
	private String name;
	private Integer myValue;
	public static Integer temp=0;
	public static Integer temp2=0;
	public static Integer incNumber;
	private static ConcurrentHashMap<String,Integer> mapForNow = new ConcurrentHashMap<String,Integer>();

	public Task(String name,Integer myValue) 
	{
		this.name = name;
		this.myValue = myValue;
		//this.mapForNow = mapForNow;

	}

	public ConcurrentHashMap<String,Integer> getHashmap() {
		return mapForNow;
	}


	public String getName() {
		return name;
	}
	public Integer getValue() {
		return myValue;
	}

	public void run() 
	{
		try
		{
			
			temp2=temp2+3;
			mapForNow.put(name, myValue);
			name = name+":" +(++temp).toString()+":"+temp2.toString();
			System.out.println("Name : " +name);
			TimeUnit.SECONDS.sleep(1);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}