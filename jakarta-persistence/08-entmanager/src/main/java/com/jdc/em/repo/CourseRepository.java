package com.jdc.em.repo;

import jakarta.persistence.EntityManager;

public class CourseRepository {

	@SuppressWarnings("unused")
	private EntityManager em;
	private static CourseRepository INSTANCE;
	
	public CourseRepository(EntityManager em) {
		this.em = em;
		
	}
	
	public static CourseRepository getInstance(EntityManager em) {
		if(null == INSTANCE) 
			INSTANCE = new CourseRepository(em);
		return INSTANCE;
	}
}
