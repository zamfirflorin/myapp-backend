package com.florin.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.florin.myapp.contacts.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts, Long>{

	List<Contacts> findById(int id);   
	List<Contacts> findByFirstName(String firstName); 
	List<Contacts> findBySurName(String surName);
	
	
}
