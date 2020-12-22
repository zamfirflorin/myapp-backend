package com.florin.myapp.contacts;

import javax.persistence.*;

@Entity
@Table(name="Contacts")
public class Contacts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "surName")
	private String surName;
	
	public int add( int i , int j ) {
			return i + j; 
	}

	
	public Contacts(int id, String firstName, String surName) {
		this.id = id;
		this.firstName = firstName;
		this.surName = surName; 
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	} 
	
}
