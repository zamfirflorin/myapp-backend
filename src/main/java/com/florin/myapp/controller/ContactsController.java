package com.florin.myapp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("")
	public ResponseEntity<Void> updateContact(@PathVariable String contacts, @RequestBody Contacts contact){
		
		Contacts createdContact = contactsRepository.save(contact);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdContact.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	//RETRIEVE/READ / SELECT /GET
	
	//UPDATE / UPDATE/ REPLACE PUT
	
	//DELETE / DELETE / DElete
	
	
}
