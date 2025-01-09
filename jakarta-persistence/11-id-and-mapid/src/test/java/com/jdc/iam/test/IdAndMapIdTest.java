package com.jdc.iam.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class IdAndMapIdTest {

	@Test
	void test() {
		try(var emf = Persistence.createEntityManagerFactory("iam")){}
	}
}
