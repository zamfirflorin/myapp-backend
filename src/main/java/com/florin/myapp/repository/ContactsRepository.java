package com.florin.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.florin.myapp.contacts.Contacts;



public interface ContactsRepository extends CrudRepository<Contacts, Long>{

	Contacts findById(long id);

	List<Contacts> findAll();
	
	List<Contacts> findByFirstName(String firstName);
	List<Contacts> findByLastName(String lastName);
	

	
	
}
