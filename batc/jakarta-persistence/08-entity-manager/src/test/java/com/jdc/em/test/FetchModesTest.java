package com.jdc.em.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.em.entity.Course;
import com.jdc.em.entity.Course.Level;

public class FetchModesTest extends BaseTest{
	
	@Order(1)
	@ParameterizedTest
	@ValueSource(ints = 1)
	@DisplayName("test for find")
	void test1(int id) {
		
		var course = em.find(Course.class, id);
		assertNotNull(course);
		assertTrue(em.contains(course));
		
		em.detach(course);
		
		assertAll(() -> {
			assertEquals(id, course.getId());
			assertEquals("Java SE", course.getName());
			assertEquals(new BigDecimal(400000), course.getFees());
			assertEquals(LocalDate.of(2024, 8, 4), course.getStartDate());
			assertEquals(4, course.getDuration());
			assertEquals(Level.ENTRY, course.getLevel());
		});
	}
	
	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = 1)
	@DisplayName("test for getReference")
	void test2(int id) {
		
		var course = em.getReference(Course.class, id);
		assertNotNull(course);
		assertTrue(em.contains(course));
		var fees = course.getFees();
		System.out.println(fees);
		
		assertAll(() -> {
			assertEquals(id, course.getId());
			assertEquals("Java SE", course.getName());
			assertEquals(new BigDecimal(400000), course.getFees());
			assertEquals(LocalDate.of(2024, 8, 4), course.getStartDate());
			assertEquals(4, course.getDuration());
			assertEquals(Level.ENTRY, course.getLevel());
		});
	}


}
