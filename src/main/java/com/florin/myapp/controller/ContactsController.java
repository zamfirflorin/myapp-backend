package com.florin.myapp.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.florin.myapp.contacts.Contacts;
import com.florin.myapp.repository.ContactsRepository;



/**
 * @author Florin
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactsController {

	@Autowired
	ContactsRepository contactsRepository;
	
	//CREATE / INSERT / POST
	
	@PostMapping("/post/{contacts}")
	public ResponseEntity<Void> createContact(@PathVariable String contacts, @RequestBody Contacts contact){
		
		Contacts createdContact = contactsRepository.save(contact);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdContact.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	//RETRIEVE/READ / SELECT /GET
	@GetMapping("/contacts")
	public List<Contacts> getAllContacts(){
		List<Contacts> contacts = contactsRepository.findAll();
		return contacts;
	}
	//UPDATE / UPDATE/ REPLACE PUT
	
	@PutMapping("/contacts/{id}")
	public ResponseEntity<Contacts> updateContact(@PathVariable int id, @RequestBody Contacts contact){
		
		
		Contacts updatedContact = contactsRepository.save(contact);
		
		return new ResponseEntity<Contacts>(contact, HttpStatus.OK);
		
	}
	
	//DELETE / DELETE / DElete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable long id) {
		
		contactsRepository.deleteById(id);
		
		return ResponseEntity.notFound().build();
	}
	
}
