package com.jdc.ms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.ms.bm.entity.Role;
import com.jdc.ms.bm.entity.Staff;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestMethodOrder(OrderAnnotation.class)
public final class BiDirectionalMappingTest extends BaseTest{

	static EntityManagerFactory emf;
	EntityManager em;
	
	@BeforeAll
	static void setUpBeforeClass() {
		emf = Persistence.createEntityManagerFactory("bm");
	}
	
	@BeforeEach
	void setUp() {
		em = emf.createEntityManager();
	}
	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"Admin,Christopher Neo,400_00"
	})
	void test(String roleName,String staffName,double salary) {
		
			var tx = em.getTransaction();
			tx.begin();
			
			Role admin = new Role();
			admin.setName(roleName);
			
			Staff christopher = new Staff();
			christopher.setName(staffName);
			christopher.setSalary(salary);
			
			//set bi directional mapping
			admin.setStaff(christopher);
			
			//christopher.setRole(admin);//use bridge method
			
			//em.persist(christopher);
		//	em.persist(admin);
			em.persist(christopher);
			tx.commit();
		
	}
	
	@Order(2)
	@ParameterizedTest
	@CsvSource({
		"1, Admin, Christopher Neo,400_00"
	})
	void test_for_find(int id, String roleName, String staffName, double salary) {
		var role = em.find(Role.class, id);
		
		assertNotNull(role);
		assertEquals(roleName, role.getName());
		assertEquals(staffName, role.getStaff().getName());
		assertEquals(salary, role.getStaff().getSalary());
		assertEquals(LocalDate.now(), role.getStaff().getAssignAt());
	}
	
	@AfterEach
	void tearDown() {
		if(em != null & em.isOpen()) {
			em.close();
		}
	}
	
	@AfterAll
	static void tearDownAfter() {
		if(emf != null & emf.isOpen()) {
			emf.close();
		}
	}
}