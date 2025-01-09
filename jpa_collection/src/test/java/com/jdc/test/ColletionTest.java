package com.jdc.test;

import static java.lang.StringTemplate.STR;

import org.junit.jupiter.api.Test;

import com.jdc.ms.collect.Account;
import com.jdc.ms.collect.Account.Role;
import com.jdc.ms.collect.Address;

import jakarta.persistence.Persistence;

public class ColletionTest {
	 @Test
	 void test() {
		 try(var emf = Persistence.createEntityManagerFactory("jpa_collection");
				 var em = emf.createEntityManager()){
			 
			 var acc = new Account();
			 acc.setName("Myat Swe");
			 acc.setLoginId("Myat");
			 acc.setPassword("1998");
			 acc.setRole(Role.STUDENT);
			 
			 var addr = new Address();
			 addr.setAddress("Hlaing");
			 addr.setEmail("myatswe10@gmail.com");
			 addr.setPhone("09884804843");
			 addr.setAccount(acc);
			 
			 em.getTransaction().begin();
			 
			 em.persist(acc);
			 em.persist(addr);
			 
			 em.getTransaction().commit();
		 }
	 }

}
