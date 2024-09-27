package com.jdc.ml.ep2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.ml.ep2.ConnectionManagerOne;
import com.jdc.ml.ep2.DbInitializerOne;
import com.jdc.ml.ep2.statement.dao.MemberDao;

class MemberDaoTest {

	@SuppressWarnings("unused")
	private MemberDao memDao;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	
			DbInitializerOne.drop("message","member");
			DbInitializerOne.create();
	
	}

	@BeforeEach
	void setUp() throws Exception {
	
		memDao = new MemberDao(ConnectionManagerOne.getIstance());
	}

	@Test
	void testCreateMember() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testChagePassword() {
		fail("Not yet implemented");
	}

}
