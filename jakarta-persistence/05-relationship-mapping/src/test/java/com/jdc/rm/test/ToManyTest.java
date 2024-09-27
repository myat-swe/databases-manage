package com.jdc.rm.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jdc.rm.entity.Category;
import com.jdc.rm.entity.Product;

import jakarta.persistence.Persistence;

public class ToManyTest {

	@Test
	void test() {
		try(var emf = Persistence.createEntityManagerFactory("rm");
				var em = emf.createEntityManager()){
			
			var vodka = new Product();
			vodka.setName("Vodka");
			vodka.setPrice(new BigDecimal(1000_000d));
			vodka.setStock(3);
			
			var jd = new Product();
			jd.setName("Jack Daniel");
			jd.setPrice(new BigDecimal(50_000d));
			jd.setStock(10);
			
			var pChips = new Product();
			pChips.setName("Potato Chip");
			pChips.setPrice(new BigDecimal(20_000d));
			pChips.setStock(5);
			
			var sfSeed = new Product();
			sfSeed.setName("Sunflower Seed");
			sfSeed.setPrice(new BigDecimal(20_000d));
			sfSeed.setStock(29);
			
			
			var drink = new Category();
			drink.setName("Drink");
			
			var food = new Category();
			food.setName("Food");
			
			drink.setProduct(List.of(vodka,jd));
			food.setProduct(List.of(sfSeed,pChips));
			
			
			var tx = em.getTransaction();
			tx.begin();
			
			em.persist(drink);
			em.persist(food);
			
//			em.persist(pChips);
//			em.persist(sfSeed);
//			em.persist(vodka);
//			em.persist(jd);
			
			tx.commit();
			
		}
	}
}
