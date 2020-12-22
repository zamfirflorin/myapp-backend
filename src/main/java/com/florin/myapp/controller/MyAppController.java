package com.florin.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.florin.myapp.contacts.Contacts;
import com.florin.myapp.repository.ContactsRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MyAppController {
	
	@Autowired
	public ContactsRepository contactsRepository; 

	public List<Contacts> contacts;
	
	@GetMapping("/hello")
	public List<Contacts> helloWorld() {
		return contacts;
	}
	
	
	
}
