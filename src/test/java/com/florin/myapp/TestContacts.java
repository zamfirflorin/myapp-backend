package com.florin.myapp;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

import com.florin.myapp.contacts.Contacts;

public class TestContacts {

	Contacts c = new Contacts(1, "asdasd", "prenume"); 
	 
	@Test
	public void testAdd() {
		assertEquals(4, c.add(2, 3));
	}

}
