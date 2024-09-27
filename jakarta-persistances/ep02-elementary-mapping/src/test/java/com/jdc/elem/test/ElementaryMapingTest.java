package com.jdc.elem.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class ElementaryMapingTest {

	@Test
	void test() {
		try(var emf = Persistence.createEntityManagerFactory("em");
				var em = emf.createEntityManager()){
			
			
		}
	}
}
