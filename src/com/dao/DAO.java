package com.dao;

import java.util.HashMap;
import com.bean.Customer;

public class DAO {
	
	//Creating a HashMap object with Account no. as Key and Customer object as Value.
	HashMap<Long,Customer> hm = new HashMap<Long,Customer>();
	
	HashMap<String,Long> al = new HashMap<String,Long>();
	
	public void create(Customer c) {	
	        
		hm.put(c.getAccountNo(),c);  // add all customer object in hashmap.
	
	}
	
	// Create a method to return the HashMap object.
	public HashMap<Long,Customer> getHash() {
		return hm;
	}

	public void trans(String t, Long acc) {	
		al.put(t, acc);
	}

	public HashMap<String,Long> getTrans() {
		//System.out.println(al);
		return al;
	}
	
}