package com.jdc.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.ms.entity.Member;
import com.jdc.ms.entity.MyApp;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MemberTest {

	static EntityManagerFactory emf;
	@BeforeAll
	static void beforeAllSetUp() {
		emf = Persistence.createEntityManagerFactory("getting-jpa");
	}
	
	@AfterAll
	static void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void test() {
		var member  = new Member();
		
	 	System.out.println("Member Id is :" + member.getId());
		var app = new MyApp();
		System.out.println("App id :" + app.getId());
		
	}
}
