package com.jdc.bm.test;

import org.junit.jupiter.api.Test;

import com.jdc.bm.entity.Course;
import com.jdc.bm.entity.Student;

import jakarta.persistence.Persistence;

public class ManyToManyTest {
	
	@Test
	void test() {
		try (var emf = Persistence.createEntityManagerFactory("bm");
				var em = emf.createEntityManager()) {
			
			var stu1 = new Student();
			stu1.setName("Mg Mg");
			
			var stu2 = new Student();
			stu2.setName("Kyaw Kyaw");
			
			var spring = new Course("Spring");
			spring.setFees(500000);
			
			var oop = new Course("OOP");
			oop.setFees(300000);

			stu1.addCourse(spring);
			stu1.addCourse(oop);
			
			stu2.addCourse(spring);
			
			em.getTransaction().begin();
			em.persist(stu1);
			em.persist(stu2);
			em.getTransaction().commit();
			
		}
	}
}
