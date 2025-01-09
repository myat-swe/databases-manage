package com.jdc.lear.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class LearnerTest {

	@Test
	void test() {
		try(var emf = Persistence.createEntityManagerFactory("leaner")){}
		
	}

	}
	