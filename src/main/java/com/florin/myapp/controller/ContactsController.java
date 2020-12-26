package com.florin.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.florin.myapp.MyappApplication;
import com.florin.myapp.contacts.Contacts;
import com.florin.myapp.repository.ContactsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Florin
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactsController {
	
	private static final Logger log = LoggerFactory.getLogger(MyappApplication.class);
	
	@Autowired
	ContactsRepository contactsRepository; 
	//CREATE / INSERT / POST
	
	/*
	 * @GetMapping(path="/helloworld") public String helloWorld() { return
	 * "Helloworld againada"; }
	 */
	
	@PostMapping(path="/add")
	public Contacts createContact(@RequestBody String firstName, @RequestBody String lastName){
		
		Contacts contact = new Contacts();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		return contactsRepository.save(contact);
		
	}
	
	//RETRIEVE/READ / SELECT /GET
	@GetMapping(path="/contacts")
	public List<Contacts> getAllContacts(){
		
		return contactsRepository.findAll();
	}
	//UPDATE / UPDATE/ REPLACE PUT
	
	@PutMapping(path="/contacts/{id}")
	public ResponseEntity<Contacts> updateContact(@PathVariable long id, @RequestBody String firstName, @RequestBody String lastName){
		
		
		Contacts contact = contactsRepository.findById(id);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		
		return new ResponseEntity<Contacts>(contact, HttpStatus.OK);
		
	}
	
	//DELETE / DELETE / DEleteW
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable long id) {
		
		contactsRepository.deleteById(id);
		
		return ResponseEntity.notFound().build();
	}
	
}
