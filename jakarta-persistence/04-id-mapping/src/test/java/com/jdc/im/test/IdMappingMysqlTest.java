package com.jdc.im.test;

import org.junit.jupiter.api.Test;

import com.jdc.im.Person;
import com.jdc.im.Sale;

import jakarta.persistence.Persistence;

public class IdMappingMysqlTest {

	@Test
	void test() {
		try (var emf = Persistence.createEntityManagerFactory("im-mysql");
				var em = emf.createEntityManager()) {
			
			em.getTransaction().begin();
			
			var person1 = new Person();			
			person1.setName("Tin Win");
			
			var person2 = new Person();			
			person2.setName("Hla Win");
		
			
//			var salePk = new SalePk();
//			salePk.setSaleId(1);
//			salePk.setSaleDate(LocalDateTime.now());
//			
			var sale = new Sale();
			sale.setTaxInPercent(1.3f);
			sale.setTotal(300000);
			
			em.persist(person1);
			em.persist(person2);
			em.persist(sale);
			
			em.getTransaction().commit();
		}
		
	}
}
