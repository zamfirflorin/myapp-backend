package com.florin.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.florin.myapp.contacts.Contacts;

@RestController
public class MyAppController {
	
	
	private static List<Contacts> contacts;

	@GetMapping("/hello")
	public List<Contacts> helloWorld() {
		return contacts;
	}
	
	
	
}
