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

import com.florin.myapp.contacts.Contacts;
import com.florin.myapp.repository.ContactsRepository;
import com.florin.myapp.service.ContactsService;



/**
 * @author Florin
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactsController {

	@Autowired
	ContactsRepository contactsRepository;
	
	
	@Autowired
	ContactsService contactsService; 
	//CREATE / INSERT / POST
	
	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "Helloworld";
	}
	
	@PostMapping(path="/post/{contacts}")
	public Contacts createContact(@RequestBody Contacts contact){
		
		return contactsRepository.save(contact);
		
	}
	
	//RETRIEVE/READ / SELECT /GET
	@GetMapping(path="/contacts")
	public List<Contacts> getAllContacts(){
		List<Contacts> contacts = contactsRepository.findAll();
		return contacts;
	}
	//UPDATE / UPDATE/ REPLACE PUT
	
	@PutMapping(path="/contacts/{id}")
	public ResponseEntity<Contacts> updateContact(@PathVariable int id, @RequestBody Contacts updateContact){
		
		
		Contacts contact = contactsService.findById(id);
		contact.setFirstName(updateContact.getFirstName());
		contact.setSurName(updateContact.getSurName());
		
		return new ResponseEntity<Contacts>(contact, HttpStatus.OK);
		
	}
	
	//DELETE / DELETE / DEleteW
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable long id) {
		
		contactsRepository.deleteById(id);
		
		return ResponseEntity.notFound().build();
	}
	
}
