package com.jdc.hello.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HelloTest {

	@Test
	void test() {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("ep01-hello-jpa" )){
			
		}
	}
}
