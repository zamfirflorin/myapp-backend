package com.florin.myapp.contacts;

import org.springframework.stereotype.Component;


public class Contacts {
	
	private int id;
	private String name;
	
	public int add( int i , int j ) {
			return i + j; 
	}

	
	public Contacts(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	

}
