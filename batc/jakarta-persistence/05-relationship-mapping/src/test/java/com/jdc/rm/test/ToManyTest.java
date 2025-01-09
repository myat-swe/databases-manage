package com.jdc.rm.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jdc.rm.entity.Category;
import com.jdc.rm.entity.Product;

import jakarta.persistence.Persistence;

public class ToManyTest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Test
	void test() {
		try (var emf = Persistence.createEntityManagerFactory("rm");
				var em = emf.createEntityManager()) {

			em.getTransaction().begin();			
			
			Category drinks = new Category();
			drinks.setName("Drink");
			
			Category foods = new Category();
			foods.setName("Foods");
			
			Product pChip = new Product();
			pChip.setName("Potato Chip");
			pChip.setPrice(new BigDecimal(1000d));
			pChip.setStock(20);
			
			Product sfSeeds = new Product();
			sfSeeds.setName("Sunflower Seeds");
			sfSeeds.setPrice(new BigDecimal(1500d));
			sfSeeds.setStock(30);
			
			Product vodka = new Product();
			vodka.setName("Vodka");
			vodka.setPrice(new BigDecimal(100_000d));
			vodka.setStock(5);
			
			Product jd = new Product();
			jd.setName("Jack Daniel");
			jd.setPrice(new BigDecimal(60_000d));
			jd.setStock(10);
			
			drinks.setProducts(List.of(vodka, jd));
			foods.setProducts(List.of(pChip, sfSeeds));
						
			em.persist(drinks);
			em.persist(foods);
			
//			em.persist(vodka);
//			em.persist(jd);
//			em.persist(sfSeeds);
//			em.persist(pChip);
			
			em.getTransaction().commit();
		}
	}

}
