package com.florin.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.florin.myapp.contacts.Contacts;
import com.florin.myapp.contacts.ContactsService;

@RestController
public class MyAppController {
	
	@Autowired
	public List<Contacts> contacts;

	@GetMapping("/hello")
	public List<Contacts> helloWorld() {
		return contacts;
	}
	
	
	
}
