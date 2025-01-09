package com.jdc.im.test;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class IdMappingPSQLTest {
	
	@Test
	void test() {
		Persistence.createEntityManagerFactory("im-postgres").close();
	}
}
