package com.jdc.idm.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class IdMappingTe {

	@Test
	void test() {
		Persistence.createEntityManagerFactory("").close();
	}
}
