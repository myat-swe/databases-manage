package com.jdc.rm.test;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

import com.jdc.rm.entity.Address;
import com.jdc.rm.entity.Customer;

import jakarta.persistence.Persistence;

public class ToOneTest {
	
	@Test
	void test() {
		try (var emf = Persistence.createEntityManagerFactory("rm");
		var em = emf.createEntityManager() ) {
			
			var customer = new Customer();
			customer.setName("Thidar Aung");
			customer.setDob(LocalDate.of(1998, Month.APRIL, 20));
			
			var add = new Address();
			add.setCustomer(customer);
			add.setTownship("Myaing");
			add.setState("Yangon");
			
			var tx = em.getTransaction();
			tx.begin();
			em.persist(customer);
			em.persist(add);
			tx.commit();
		}
	}

}
