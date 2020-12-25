package com.florin.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.florin.myapp.contacts.Contacts;
import com.florin.myapp.repository.ContactsRepository;

public class ContactsService {

	
	@Autowired
	public ContactsRepository contactsRepository;
	
	public List<Contacts> contacts = contactsRepository.findAll();
	
	
	public List<Contacts> findAll(){
		return contacts;
	}
	
	
	public Contacts deleteById(long id) {
		Contacts contact = findById(id);
		if(contact == null) {
			return null ; 
		}
		if(contacts.remove(contact)) {
			return contact;
		}
		return null; 
	}
	
	
	public Contacts findById(long id) {
		
		for(Contacts contact:contacts) {
			if(contact.getId() == id) {
				return contact;
			}
		}
		
		return null; 
	}
	
	

	
	
	
	
}
