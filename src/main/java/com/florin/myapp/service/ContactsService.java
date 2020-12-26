package com.florin.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florin.myapp.contacts.Contacts;
import com.florin.myapp.repository.ContactsRepository;


@Service
public class ContactsService implements IContactsService {

	
	@Autowired
	private ContactsRepository contactsRepository;
	

	
	
	public List<Contacts> findAll(){
		return (List<Contacts>) contactsRepository.findAll();
	}
	
	
	public ContactsService(ContactsRepository contactsRepository) {
		this.contactsRepository = contactsRepository;
	}
	
	public Contacts deleteById(long id) {
		List<Contacts> contacts = (List<Contacts>) contactsRepository.findAll();
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
		List<Contacts> contacts = (List<Contacts>) contactsRepository.findAll();
		for(Contacts contact:contacts) {
			if(contact.getId() == id) {
				return contact;
			}
		}
		
		return null; 
	}


	public Contacts save(Contacts contact) {
		List<Contacts> contacts = (List<Contacts>) contactsRepository.findAll();
		if(contact.getId()==-1 || contact.getId()==0) {
			contacts.add(contact);
		} else {
			deleteById(contact.getId());
			contacts.add(contact);
		}
		return contact;
	}
	
	

	
	
	
	
}
