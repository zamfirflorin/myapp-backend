package com.florin.myapp;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

import com.florin.myapp.contacts.Contacts;

class TestContacts {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	Contacts c = new Contacts(1, "asdasd"); 
	
	@Test
	public void testAdd() {
		assertEquals(5, c.add(2, 3));
	}

}
