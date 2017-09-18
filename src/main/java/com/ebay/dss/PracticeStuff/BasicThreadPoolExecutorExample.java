package com.ebay.dss.PracticeStuff;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class BasicThreadPoolExecutorExample 
{
	
	
	

    public static void main(String[] args) throws InterruptedException 
    {
    	Set <Integer> sellerIdList = new HashSet <Integer>();
    	sellerIdList.add(1);
     	sellerIdList.add(2);
     	sellerIdList.add(3);
     	sellerIdList.add(4);
     	sellerIdList.add(5);
     	sellerIdList.add(6);
     	sellerIdList.add(7);
    	ConcurrentHashMap<String,Integer> mapForNow2 = new ConcurrentHashMap<String,Integer>();
     	
    	ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
    	//executor.setMaximumPoolSize(3);
        Integer x=5;
        for(Integer i : sellerIdList){
            Task task = new Task("Task " + i, x);
            
            executor.execute(task);
            System.out.println("Printing i : " +i + ", A new task has been added : " + task.getName() + " : " +task.getValue());
            mapForNow2 = task.getHashmap();
               
        }
        executor.shutdown();   
     // Wait for all the threads to complete work
        while(!executor.isTerminated()){
            Thread.sleep(100);
        }
        
        
        
        System.out.println("set size : " +mapForNow2.entrySet().size());
        
        for (Map.Entry<String,Integer> entry: mapForNow2.entrySet()) {
			System.out.println("Printing map :  " + entry.getKey() + " : " + entry.getValue());

		}
        System.out.println("Map size: " +mapForNow2.size());       
      
    }
    
    
    
}