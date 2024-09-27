package com.jdc.idm.test;

import org.junit.jupiter.api.Test;

import com.jdc.idmapping.Person;
import com.jdc.idmapping.Sale;

import jakarta.persistence.Persistence;

public class IdMappingTest {

	@Test
	void test() {
		try(var emf = Persistence.createEntityManagerFactory("id-mysql");
				var em = emf.createEntityManager()){
		
			em.getTransaction().begin();
			var person = new Person();
			person.setName("asdasd");
			
//			var salePk = new SalePk();
//			salePk.setSaleId(1);
//			salePk.setSaleDate(LocalDateTime.now());
//			
			var sale = new Sale();
			//sale.setSalePk(salePk);
			sale.setTaxPer(1.3f);
			sale.setTotal(300000);
			
			em.persist(person);
			em.persist(sale);
			
		}
				
	}

}