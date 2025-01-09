package com.jdc.cl.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.cl.entity.Account;
import com.jdc.cl.entity.Contact;

@TestMethodOrder(OrderAnnotation.class)
public class ListenerTest extends BaseTest{

	@ParameterizedTest
	@DisplayName("test for inserting account")
	@CsvFileSource(resources = "/data/account.txt")
	@Order(1)
	void test(String name, int amount) {
		Account acc = new Account();
		acc.setName(name);
		acc.setAmount(amount);
		
		em.getTransaction().begin();
		em.persist(acc);
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@CsvSource({
		"1, 500_000"		
	})
	@DisplayName("test for update account")
	@Order(2)
	void test2(int id, int amountToUpdate) {
		var account = em.getReference(Account.class, 1);
		account.setAmount(amountToUpdate);
		
		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();
		
	}
	
	@Order(3)
	@ParameterizedTest
	@DisplayName("test for delete account")
	@ValueSource(ints = 1)
	void test(int idForDelete) {
		var account = em.find(Account.class,idForDelete);
	
		em.getTransaction().begin();
		em.remove(account);
		em.getTransaction().commit();
	}
	
	@Order(4)
	@DisplayName("Test for create contact")
	@ParameterizedTest
	@CsvSource({
		"someone@gmail.com, 0944433333",
		"anyon@gmail.com, 094433888"
	})
	void test4(String email, String phone) {
		
		Contact  c = new Contact();
		c.setEmail(email);
		c.setPhone(phone);
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		
	
	}
}
