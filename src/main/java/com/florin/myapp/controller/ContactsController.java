package com.florin.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import com.florin.myapp.contacts.Contacts;
import com.florin.myapp.repository.ContactsRepository;

/**
 * @author Florin
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactsController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ContactsRepository contactsRepository; 
	//CREATE / INSERT / POST
	
	/*
	 * @GetMapping(path="/helloworld") public String helloWorld() { return
	 * "Helloworld againada"; }
	 */
	
	
	//RETRIEVE/READ / SELECT /GET
	@GetMapping(path="/contacts")
	public ResponseEntity<List<Contacts>> getAllContacts(){
		
		return ResponseEntity.ok(contactsRepository.findAll());
	}
	
	@PostMapping(path="/add")
	public Contacts createContact(@RequestBody String firstName, @RequestBody String lastName){
		
		Contacts contact = new Contacts();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		return contactsRepository.save(contact);
		
	}
	

	//UPDATE / UPDATE/ REPLACE PUT
	
	@PutMapping(path="/update/{id}")
	public ResponseEntity<Contacts> updateContact(@PathVariable long id, @RequestBody String firstName, @RequestBody String lastName){
		
		
		Contacts contact = contactsRepository.findById(id);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		
		return new ResponseEntity<Contacts>(contact, HttpStatus.OK);
		
	}
	
	//DELETE / DELETE / DEleteW
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable long id) {
		
		try {
		contactsRepository.deleteById(id);
		return ResponseEntity.ok().build();
		} catch(ResourceNotFoundException ex) {
			 logger.error(ex.getMessage());
		    return ResponseEntity.notFound().build();
		}

	}
	
}
