package com.florin.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.florin.myapp.contacts.Contacts;
import com.florin.myapp.repository.ContactsRepository;
import java.net.URI;
import java.net.URISyntaxException;
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
	
	//RETRIEVE/READ / SELECT /GET
	@GetMapping(path="/contacts")
	public ResponseEntity<List<Contacts>> getAllContacts(){

		return ResponseEntity.ok(contactsRepository.findAll());
	}
	
	@GetMapping(path="/contacts/{contactId}")
	public ResponseEntity<Contacts> getContactById(@PathVariable long contactId){

		try {
			Contacts contact = contactsRepository.findById(contactId);
			return ResponseEntity.ok(contact);
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}
	}
	
	//CREATE / INSERT / POST	
	@PostMapping(path="/contacts/add")
	public ResponseEntity<Contacts> createContact(@RequestBody Contacts contact){

		Contacts newContact = contactsRepository.save(contact);

		try {
			return ResponseEntity.created(new URI("/contacts/add" + newContact.getId())).body(contact);
		} catch (URISyntaxException ex) {
	        // log exception first, then return Conflict (409)
	        logger.error(ex.getMessage());
	        return ResponseEntity.status(HttpStatus.CONFLICT).build();
	    } 

	}
	

	//UPDATE / UPDATE/ REPLACE PUT
	
	@PutMapping(path="/contacts/update/{id}")
	public ResponseEntity<Contacts> updateContact(@PathVariable long id, @RequestBody String firstName, @RequestBody String lastName){

		Contacts contact = contactsRepository.findById(id);
		contact.setId(id);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		return  ResponseEntity.ok().build();

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
