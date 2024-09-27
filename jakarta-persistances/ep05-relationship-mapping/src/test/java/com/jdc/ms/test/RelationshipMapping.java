package com.jdc.ms.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class RelationshipMapping {

	@Test
	void test() {
		try(var emf = Persistence.createEntityManagerFactory("ream"); 
				var em = emf.createEntityManager()){
			
		}
	}
}
