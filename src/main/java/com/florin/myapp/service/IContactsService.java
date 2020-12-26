package com.florin.myapp.service;

import java.util.List;

import com.florin.myapp.contacts.Contacts;



public interface IContactsService {

	Contacts save(Contacts contact);
	  List<Contacts> findAll();
	  
}
