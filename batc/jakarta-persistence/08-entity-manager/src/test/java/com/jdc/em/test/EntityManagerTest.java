package com.jdc.em.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.em.entity.Course;
import com.jdc.em.entity.Course.Level;
import com.jdc.em.entity.Outline;

@TestMethodOrder(OrderAnnotation.class)
public class EntityManagerTest extends BaseTest{

	@Test
	@Order(2)
	void testTwo() {
		
		var foundedCourse = em.find(Course.class, 1);
		assertTrue(em.contains(foundedCourse));
		
		em.getTransaction().begin();
		var outlines = foundedCourse.getOutlines();
		if(outlines.size() >= 4)
			outlines.remove(3);
		em.getTransaction().commit();
		
//		em.getTransaction().begin();
//		em.remove(foundedCourse);
//		em.getTransaction().commit();
	}
	
	@Test
	@Order(1)
	void testOne() {
		
		/**
		 * Transient or new state
		 */
		var course = new Course();
		course.setName("Angular Framework");
		course.setFees(new BigDecimal(450000));
		course.setLevel(Level.INTERMEDIATE);
		course.setDuration(4);
		course.setStartDate(LocalDate.of(2024, 07, 02));
		//course.setOutlines(outlines);

		
		var intro = new Outline("angular Introduction");
		course.addOutlin(intro);
		
		var comp = new Outline("About Component");
		course.addOutlin(comp);
		
		var db = new Outline("Databinding");
		course.addOutlin(db);
		
		var af = new Outline("Angular Forms");
		course.addOutlin(af);
		
		var di = new Outline("Dependency Injection");
		course.addOutlin(di);
		
		var as = new Outline("Angular Signal");
		course.addOutlin(as);
		
		em.getTransaction().begin();
		
		em.persist(course);

		em.getTransaction().commit();

//		
//		em.getTransaction().begin();
//		
//		assertFalse(em.contains(course));
//		em.persist(course);
//		assertTrue(em.contains(course));
//		
//		course.setFees(new BigDecimal(500_000));
//		
//		em.detach(course);
//		assertFalse(em.contains(course));
//		
//		course.setDuration(5);
//		
////		em.merge(course);
////		assertFalse(em.contains(course));
//		
//		var mergeCourse = em.merge(course);
//		assertTrue(em.contains(mergeCourse));
//		
//		em.getTransaction().commit();
		
	}
}










